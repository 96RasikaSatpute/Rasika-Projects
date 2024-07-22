package com.google.maps.android.clustering;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.clustering.algo.Algorithm;
import com.google.maps.android.clustering.algo.NonHierarchicalDistanceBasedAlgorithm;
import com.google.maps.android.clustering.algo.PreCachingAlgorithmDecorator;
import com.google.maps.android.clustering.algo.ScreenBasedAlgorithm;
import com.google.maps.android.clustering.algo.ScreenBasedAlgorithmAdapter;
import com.google.maps.android.clustering.view.ClusterRenderer;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;
import com.google.maps.android.collections.MarkerManager;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ClusterManager<T extends ClusterItem> implements GoogleMap.OnCameraIdleListener, GoogleMap.OnMarkerClickListener, GoogleMap.OnInfoWindowClickListener {
    /* access modifiers changed from: private */
    public ScreenBasedAlgorithm<T> mAlgorithm;
    private final MarkerManager.Collection mClusterMarkers;
    private ClusterManager<T>.ClusterTask mClusterTask;
    private final ReadWriteLock mClusterTaskLock;
    private GoogleMap mMap;
    private final MarkerManager mMarkerManager;
    private final MarkerManager.Collection mMarkers;
    private OnClusterClickListener<T> mOnClusterClickListener;
    private OnClusterInfoWindowClickListener<T> mOnClusterInfoWindowClickListener;
    private OnClusterItemClickListener<T> mOnClusterItemClickListener;
    private OnClusterItemInfoWindowClickListener<T> mOnClusterItemInfoWindowClickListener;
    private CameraPosition mPreviousCameraPosition;
    /* access modifiers changed from: private */
    public ClusterRenderer<T> mRenderer;

    public interface OnClusterClickListener<T extends ClusterItem> {
        boolean onClusterClick(Cluster<T> cluster);
    }

    public interface OnClusterInfoWindowClickListener<T extends ClusterItem> {
        void onClusterInfoWindowClick(Cluster<T> cluster);
    }

    public interface OnClusterItemClickListener<T extends ClusterItem> {
        boolean onClusterItemClick(T t);
    }

    public interface OnClusterItemInfoWindowClickListener<T extends ClusterItem> {
        void onClusterItemInfoWindowClick(T t);
    }

    public ClusterManager(Context context, GoogleMap map) {
        this(context, map, new MarkerManager(map));
    }

    public ClusterManager(Context context, GoogleMap map, MarkerManager markerManager) {
        this.mClusterTaskLock = new ReentrantReadWriteLock();
        this.mMap = map;
        this.mMarkerManager = markerManager;
        this.mClusterMarkers = markerManager.newCollection();
        this.mMarkers = markerManager.newCollection();
        this.mRenderer = new DefaultClusterRenderer(context, map, this);
        this.mAlgorithm = new ScreenBasedAlgorithmAdapter(new PreCachingAlgorithmDecorator(new NonHierarchicalDistanceBasedAlgorithm()));
        this.mClusterTask = new ClusterTask();
        this.mRenderer.onAdd();
    }

    public MarkerManager.Collection getMarkerCollection() {
        return this.mMarkers;
    }

    public MarkerManager.Collection getClusterMarkerCollection() {
        return this.mClusterMarkers;
    }

    public MarkerManager getMarkerManager() {
        return this.mMarkerManager;
    }

    public void setRenderer(ClusterRenderer<T> renderer) {
        this.mRenderer.setOnClusterClickListener((OnClusterClickListener) null);
        this.mRenderer.setOnClusterItemClickListener((OnClusterItemClickListener) null);
        this.mClusterMarkers.clear();
        this.mMarkers.clear();
        this.mRenderer.onRemove();
        this.mRenderer = renderer;
        renderer.onAdd();
        this.mRenderer.setOnClusterClickListener(this.mOnClusterClickListener);
        this.mRenderer.setOnClusterInfoWindowClickListener(this.mOnClusterInfoWindowClickListener);
        this.mRenderer.setOnClusterItemClickListener(this.mOnClusterItemClickListener);
        this.mRenderer.setOnClusterItemInfoWindowClickListener(this.mOnClusterItemInfoWindowClickListener);
        cluster();
    }

    public void setAlgorithm(Algorithm<T> algorithm) {
        if (algorithm instanceof ScreenBasedAlgorithm) {
            setAlgorithm((ScreenBasedAlgorithm) algorithm);
        } else {
            setAlgorithm(new ScreenBasedAlgorithmAdapter(algorithm));
        }
    }

    /* JADX INFO: finally extract failed */
    public void setAlgorithm(ScreenBasedAlgorithm<T> algorithm) {
        algorithm.lock();
        try {
            ScreenBasedAlgorithm<T> screenBasedAlgorithm = this.mAlgorithm;
            if (screenBasedAlgorithm != null) {
                algorithm.addItems(screenBasedAlgorithm.getItems());
            }
            this.mAlgorithm = algorithm;
            algorithm.unlock();
            if (this.mAlgorithm.shouldReclusterOnMapMovement()) {
                this.mAlgorithm.onCameraChange(this.mMap.getCameraPosition());
            }
            cluster();
        } catch (Throwable th) {
            algorithm.unlock();
            throw th;
        }
    }

    public void setAnimation(boolean animate) {
        this.mRenderer.setAnimation(animate);
    }

    public ClusterRenderer<T> getRenderer() {
        return this.mRenderer;
    }

    public Algorithm<T> getAlgorithm() {
        return this.mAlgorithm;
    }

    public void clearItems() {
        this.mAlgorithm.lock();
        try {
            this.mAlgorithm.clearItems();
        } finally {
            this.mAlgorithm.unlock();
        }
    }

    public boolean addItems(Collection<T> items) {
        this.mAlgorithm.lock();
        try {
            return this.mAlgorithm.addItems(items);
        } finally {
            this.mAlgorithm.unlock();
        }
    }

    public boolean addItem(T myItem) {
        this.mAlgorithm.lock();
        try {
            return this.mAlgorithm.addItem(myItem);
        } finally {
            this.mAlgorithm.unlock();
        }
    }

    public boolean removeItems(Collection<T> items) {
        this.mAlgorithm.lock();
        try {
            return this.mAlgorithm.removeItems(items);
        } finally {
            this.mAlgorithm.unlock();
        }
    }

    public boolean removeItem(T item) {
        this.mAlgorithm.lock();
        try {
            return this.mAlgorithm.removeItem(item);
        } finally {
            this.mAlgorithm.unlock();
        }
    }

    public boolean updateItem(T item) {
        this.mAlgorithm.lock();
        try {
            return this.mAlgorithm.updateItem(item);
        } finally {
            this.mAlgorithm.unlock();
        }
    }

    public void cluster() {
        this.mClusterTaskLock.writeLock().lock();
        try {
            this.mClusterTask.cancel(true);
            ClusterManager<T>.ClusterTask clusterTask = new ClusterTask();
            this.mClusterTask = clusterTask;
            clusterTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Float[]{Float.valueOf(this.mMap.getCameraPosition().zoom)});
        } finally {
            this.mClusterTaskLock.writeLock().unlock();
        }
    }

    public void onCameraIdle() {
        ClusterRenderer<T> clusterRenderer = this.mRenderer;
        if (clusterRenderer instanceof GoogleMap.OnCameraIdleListener) {
            ((GoogleMap.OnCameraIdleListener) clusterRenderer).onCameraIdle();
        }
        this.mAlgorithm.onCameraChange(this.mMap.getCameraPosition());
        if (this.mAlgorithm.shouldReclusterOnMapMovement()) {
            cluster();
            return;
        }
        CameraPosition cameraPosition = this.mPreviousCameraPosition;
        if (cameraPosition == null || cameraPosition.zoom != this.mMap.getCameraPosition().zoom) {
            this.mPreviousCameraPosition = this.mMap.getCameraPosition();
            cluster();
        }
    }

    public boolean onMarkerClick(Marker marker) {
        return getMarkerManager().onMarkerClick(marker);
    }

    public void onInfoWindowClick(Marker marker) {
        getMarkerManager().onInfoWindowClick(marker);
    }

    private class ClusterTask extends AsyncTask<Float, Void, Set<? extends Cluster<T>>> {
        private ClusterTask() {
        }

        /* access modifiers changed from: protected */
        public Set<? extends Cluster<T>> doInBackground(Float... zoom) {
            ClusterManager.this.mAlgorithm.lock();
            try {
                return ClusterManager.this.mAlgorithm.getClusters(zoom[0].floatValue());
            } finally {
                ClusterManager.this.mAlgorithm.unlock();
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Set<? extends Cluster<T>> clusters) {
            ClusterManager.this.mRenderer.onClustersChanged(clusters);
        }
    }

    public void setOnClusterClickListener(OnClusterClickListener<T> listener) {
        this.mOnClusterClickListener = listener;
        this.mRenderer.setOnClusterClickListener(listener);
    }

    public void setOnClusterInfoWindowClickListener(OnClusterInfoWindowClickListener<T> listener) {
        this.mOnClusterInfoWindowClickListener = listener;
        this.mRenderer.setOnClusterInfoWindowClickListener(listener);
    }

    public void setOnClusterItemClickListener(OnClusterItemClickListener<T> listener) {
        this.mOnClusterItemClickListener = listener;
        this.mRenderer.setOnClusterItemClickListener(listener);
    }

    public void setOnClusterItemInfoWindowClickListener(OnClusterItemInfoWindowClickListener<T> listener) {
        this.mOnClusterItemInfoWindowClickListener = listener;
        this.mRenderer.setOnClusterItemInfoWindowClickListener(listener);
    }
}
