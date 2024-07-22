package com.google.maps.android.data.geojson;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.data.Style;
import java.util.Arrays;

public class GeoJsonPointStyle extends Style implements GeoJsonStyle {
    private static final String[] GEOMETRY_TYPE = {"Point", "MultiPoint", "GeometryCollection"};

    public GeoJsonPointStyle() {
        this.mMarkerOptions = new MarkerOptions();
    }

    public String[] getGeometryType() {
        return GEOMETRY_TYPE;
    }

    public float getAlpha() {
        return this.mMarkerOptions.getAlpha();
    }

    public void setAlpha(float alpha) {
        this.mMarkerOptions.alpha(alpha);
        styleChanged();
    }

    public float getAnchorU() {
        return this.mMarkerOptions.getAnchorU();
    }

    public float getAnchorV() {
        return this.mMarkerOptions.getAnchorV();
    }

    public void setAnchor(float anchorU, float anchorV) {
        setMarkerHotSpot(anchorU, anchorV, "fraction", "fraction");
        styleChanged();
    }

    public boolean isDraggable() {
        return this.mMarkerOptions.isDraggable();
    }

    public void setDraggable(boolean draggable) {
        this.mMarkerOptions.draggable(draggable);
        styleChanged();
    }

    public boolean isFlat() {
        return this.mMarkerOptions.isFlat();
    }

    public void setFlat(boolean flat) {
        this.mMarkerOptions.flat(flat);
        styleChanged();
    }

    public BitmapDescriptor getIcon() {
        return this.mMarkerOptions.getIcon();
    }

    public void setIcon(BitmapDescriptor bitmap) {
        this.mMarkerOptions.icon(bitmap);
        styleChanged();
    }

    public float getInfoWindowAnchorU() {
        return this.mMarkerOptions.getInfoWindowAnchorU();
    }

    public float getInfoWindowAnchorV() {
        return this.mMarkerOptions.getInfoWindowAnchorV();
    }

    public void setInfoWindowAnchor(float infoWindowAnchorU, float infoWindowAnchorV) {
        this.mMarkerOptions.infoWindowAnchor(infoWindowAnchorU, infoWindowAnchorV);
        styleChanged();
    }

    public float getRotation() {
        return this.mMarkerOptions.getRotation();
    }

    public void setRotation(float rotation) {
        setMarkerRotation(rotation);
        styleChanged();
    }

    public String getSnippet() {
        return this.mMarkerOptions.getSnippet();
    }

    public void setSnippet(String snippet) {
        this.mMarkerOptions.snippet(snippet);
        styleChanged();
    }

    public String getTitle() {
        return this.mMarkerOptions.getTitle();
    }

    public void setTitle(String title) {
        this.mMarkerOptions.title(title);
        styleChanged();
    }

    public boolean isVisible() {
        return this.mMarkerOptions.isVisible();
    }

    public void setVisible(boolean visible) {
        this.mMarkerOptions.visible(visible);
        styleChanged();
    }

    private void styleChanged() {
        setChanged();
        notifyObservers();
    }

    public MarkerOptions toMarkerOptions() {
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.alpha(this.mMarkerOptions.getAlpha());
        markerOptions.anchor(this.mMarkerOptions.getAnchorU(), this.mMarkerOptions.getAnchorV());
        markerOptions.draggable(this.mMarkerOptions.isDraggable());
        markerOptions.flat(this.mMarkerOptions.isFlat());
        markerOptions.icon(this.mMarkerOptions.getIcon());
        markerOptions.infoWindowAnchor(this.mMarkerOptions.getInfoWindowAnchorU(), this.mMarkerOptions.getInfoWindowAnchorV());
        markerOptions.rotation(this.mMarkerOptions.getRotation());
        markerOptions.snippet(this.mMarkerOptions.getSnippet());
        markerOptions.title(this.mMarkerOptions.getTitle());
        markerOptions.visible(this.mMarkerOptions.isVisible());
        markerOptions.zIndex(this.mMarkerOptions.getZIndex());
        return markerOptions;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PointStyle{");
        sb.append("\n geometry type=").append(Arrays.toString(GEOMETRY_TYPE));
        sb.append(",\n alpha=").append(getAlpha());
        sb.append(",\n anchor U=").append(getAnchorU());
        sb.append(",\n anchor V=").append(getAnchorV());
        sb.append(",\n draggable=").append(isDraggable());
        sb.append(",\n flat=").append(isFlat());
        sb.append(",\n info window anchor U=").append(getInfoWindowAnchorU());
        sb.append(",\n info window anchor V=").append(getInfoWindowAnchorV());
        sb.append(",\n rotation=").append(getRotation());
        sb.append(",\n snippet=").append(getSnippet());
        sb.append(",\n title=").append(getTitle());
        sb.append(",\n visible=").append(isVisible());
        sb.append(",\n z index=").append(getZIndex());
        sb.append("\n}\n");
        return sb.toString();
    }

    public float getZIndex() {
        return this.mMarkerOptions.getZIndex();
    }

    public void setZIndex(float zIndex) {
        this.mMarkerOptions.zIndex(zIndex);
        styleChanged();
    }
}
