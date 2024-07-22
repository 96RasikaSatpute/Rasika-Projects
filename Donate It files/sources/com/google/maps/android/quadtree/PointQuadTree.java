package com.google.maps.android.quadtree;

import com.google.maps.android.geometry.Bounds;
import com.google.maps.android.geometry.Point;
import com.google.maps.android.quadtree.PointQuadTree.Item;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PointQuadTree<T extends Item> {
    private static final int MAX_DEPTH = 40;
    private static final int MAX_ELEMENTS = 50;
    private final Bounds mBounds;
    private List<PointQuadTree<T>> mChildren;
    private final int mDepth;
    private Set<T> mItems;

    public interface Item {
        Point getPoint();
    }

    public PointQuadTree(double minX, double maxX, double minY, double maxY) {
        this(new Bounds(minX, maxX, minY, maxY));
    }

    public PointQuadTree(Bounds bounds) {
        this(bounds, 0);
    }

    private PointQuadTree(double minX, double maxX, double minY, double maxY, int depth) {
        this(new Bounds(minX, maxX, minY, maxY), depth);
    }

    private PointQuadTree(Bounds bounds, int depth) {
        this.mChildren = null;
        this.mBounds = bounds;
        this.mDepth = depth;
    }

    public void add(T item) {
        Point point = item.getPoint();
        if (this.mBounds.contains(point.x, point.y)) {
            insert(point.x, point.y, item);
        }
    }

    private void insert(double x, double y, T item) {
        if (this.mChildren == null) {
            if (this.mItems == null) {
                this.mItems = new LinkedHashSet();
            }
            this.mItems.add(item);
            if (this.mItems.size() > 50 && this.mDepth < 40) {
                split();
            }
        } else if (y < this.mBounds.midY) {
            if (x < this.mBounds.midX) {
                this.mChildren.get(0).insert(x, y, item);
            } else {
                this.mChildren.get(1).insert(x, y, item);
            }
        } else if (x < this.mBounds.midX) {
            this.mChildren.get(2).insert(x, y, item);
        } else {
            this.mChildren.get(3).insert(x, y, item);
        }
    }

    private void split() {
        ArrayList arrayList = new ArrayList(4);
        this.mChildren = arrayList;
        arrayList.add(new PointQuadTree(this.mBounds.minX, this.mBounds.midX, this.mBounds.minY, this.mBounds.midY, this.mDepth + 1));
        this.mChildren.add(new PointQuadTree(this.mBounds.midX, this.mBounds.maxX, this.mBounds.minY, this.mBounds.midY, this.mDepth + 1));
        this.mChildren.add(new PointQuadTree(this.mBounds.minX, this.mBounds.midX, this.mBounds.midY, this.mBounds.maxY, this.mDepth + 1));
        this.mChildren.add(new PointQuadTree(this.mBounds.midX, this.mBounds.maxX, this.mBounds.midY, this.mBounds.maxY, this.mDepth + 1));
        Set<T> items = this.mItems;
        this.mItems = null;
        for (T item : items) {
            insert(item.getPoint().x, item.getPoint().y, item);
        }
    }

    public boolean remove(T item) {
        Point point = item.getPoint();
        if (!this.mBounds.contains(point.x, point.y)) {
            return false;
        }
        return remove(point.x, point.y, item);
    }

    private boolean remove(double x, double y, T item) {
        if (this.mChildren == null) {
            Set<T> set = this.mItems;
            if (set == null) {
                return false;
            }
            return set.remove(item);
        } else if (y < this.mBounds.midY) {
            if (x < this.mBounds.midX) {
                return this.mChildren.get(0).remove(x, y, item);
            }
            return this.mChildren.get(1).remove(x, y, item);
        } else if (x < this.mBounds.midX) {
            return this.mChildren.get(2).remove(x, y, item);
        } else {
            return this.mChildren.get(3).remove(x, y, item);
        }
    }

    public void clear() {
        this.mChildren = null;
        Set<T> set = this.mItems;
        if (set != null) {
            set.clear();
        }
    }

    public Collection<T> search(Bounds searchBounds) {
        List<T> results = new ArrayList<>();
        search(searchBounds, results);
        return results;
    }

    private void search(Bounds searchBounds, Collection<T> results) {
        if (this.mBounds.intersects(searchBounds)) {
            List<PointQuadTree<T>> list = this.mChildren;
            if (list != null) {
                for (PointQuadTree<T> quad : list) {
                    quad.search(searchBounds, results);
                }
            } else if (this.mItems == null) {
            } else {
                if (searchBounds.contains(this.mBounds)) {
                    results.addAll(this.mItems);
                    return;
                }
                for (T item : this.mItems) {
                    if (searchBounds.contains(item.getPoint())) {
                        results.add(item);
                    }
                }
            }
        }
    }
}
