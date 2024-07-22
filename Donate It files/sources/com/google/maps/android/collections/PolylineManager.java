package com.google.maps.android.collections;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.collections.MapObjectManager;

public class PolylineManager extends MapObjectManager<Polyline, Collection> implements GoogleMap.OnPolylineClickListener {
    public PolylineManager(GoogleMap map) {
        super(map);
    }

    /* access modifiers changed from: package-private */
    public void setListenersOnUiThread() {
        if (this.mMap != null) {
            this.mMap.setOnPolylineClickListener(this);
        }
    }

    public Collection newCollection() {
        return new Collection();
    }

    /* access modifiers changed from: protected */
    public void removeObjectFromMap(Polyline object) {
        object.remove();
    }

    public void onPolylineClick(Polyline polyline) {
        Collection collection = (Collection) this.mAllObjects.get(polyline);
        if (collection != null && collection.mPolylineClickListener != null) {
            collection.mPolylineClickListener.onPolylineClick(polyline);
        }
    }

    public class Collection extends MapObjectManager.Collection {
        /* access modifiers changed from: private */
        public GoogleMap.OnPolylineClickListener mPolylineClickListener;

        public Collection() {
            super();
        }

        public Polyline addPolyline(PolylineOptions opts) {
            Polyline polyline = PolylineManager.this.mMap.addPolyline(opts);
            super.add(polyline);
            return polyline;
        }

        public void addAll(java.util.Collection<PolylineOptions> opts) {
            for (PolylineOptions opt : opts) {
                addPolyline(opt);
            }
        }

        public void addAll(java.util.Collection<PolylineOptions> opts, boolean defaultVisible) {
            for (PolylineOptions opt : opts) {
                addPolyline(opt).setVisible(defaultVisible);
            }
        }

        public void showAll() {
            for (Polyline polyline : getPolylines()) {
                polyline.setVisible(true);
            }
        }

        public void hideAll() {
            for (Polyline polyline : getPolylines()) {
                polyline.setVisible(false);
            }
        }

        public boolean remove(Polyline polyline) {
            return super.remove(polyline);
        }

        public java.util.Collection<Polyline> getPolylines() {
            return getObjects();
        }

        public void setOnPolylineClickListener(GoogleMap.OnPolylineClickListener polylineClickListener) {
            this.mPolylineClickListener = polylineClickListener;
        }
    }
}
