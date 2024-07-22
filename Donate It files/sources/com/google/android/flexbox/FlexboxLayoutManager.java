package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxHelper;
import java.util.ArrayList;
import java.util.List;

public class FlexboxLayoutManager extends RecyclerView.LayoutManager implements FlexContainer, RecyclerView.SmoothScroller.ScrollVectorProvider {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean DEBUG = false;
    private static final String TAG = "FlexboxLayoutManager";
    private static final Rect TEMP_RECT = new Rect();
    private int mAlignItems;
    private AnchorInfo mAnchorInfo;
    private final Context mContext;
    private int mDirtyPosition;
    /* access modifiers changed from: private */
    public int mFlexDirection;
    /* access modifiers changed from: private */
    public List<FlexLine> mFlexLines;
    private FlexboxHelper.FlexLinesResult mFlexLinesResult;
    /* access modifiers changed from: private */
    public int mFlexWrap;
    /* access modifiers changed from: private */
    public final FlexboxHelper mFlexboxHelper;
    private boolean mFromBottomToTop;
    /* access modifiers changed from: private */
    public boolean mIsRtl;
    private int mJustifyContent;
    private int mLastHeight;
    private int mLastWidth;
    private LayoutState mLayoutState;
    private int mMaxLine;
    /* access modifiers changed from: private */
    public OrientationHelper mOrientationHelper;
    private View mParent;
    private SavedState mPendingSavedState;
    private int mPendingScrollPosition;
    private int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private RecyclerView.Recycler mRecycler;
    private RecyclerView.State mState;
    /* access modifiers changed from: private */
    public OrientationHelper mSubOrientationHelper;
    private SparseArray<View> mViewCache;

    public FlexboxLayoutManager(Context context) {
        this(context, 0, 1);
    }

    public FlexboxLayoutManager(Context context, int flexDirection) {
        this(context, flexDirection, 1);
    }

    public FlexboxLayoutManager(Context context, int flexDirection, int flexWrap) {
        this.mMaxLine = -1;
        this.mFlexLines = new ArrayList();
        this.mFlexboxHelper = new FlexboxHelper(this);
        this.mAnchorInfo = new AnchorInfo();
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mLastWidth = Integer.MIN_VALUE;
        this.mLastHeight = Integer.MIN_VALUE;
        this.mViewCache = new SparseArray<>();
        this.mDirtyPosition = -1;
        this.mFlexLinesResult = new FlexboxHelper.FlexLinesResult();
        setFlexDirection(flexDirection);
        setFlexWrap(flexWrap);
        setAlignItems(4);
        setAutoMeasureEnabled(true);
        this.mContext = context;
    }

    public FlexboxLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        this.mMaxLine = -1;
        this.mFlexLines = new ArrayList();
        this.mFlexboxHelper = new FlexboxHelper(this);
        this.mAnchorInfo = new AnchorInfo();
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mLastWidth = Integer.MIN_VALUE;
        this.mLastHeight = Integer.MIN_VALUE;
        this.mViewCache = new SparseArray<>();
        this.mDirtyPosition = -1;
        this.mFlexLinesResult = new FlexboxHelper.FlexLinesResult();
        RecyclerView.LayoutManager.Properties properties = getProperties(context, attrs, defStyleAttr, defStyleRes);
        int i = properties.orientation;
        if (i != 0) {
            if (i == 1) {
                if (properties.reverseLayout) {
                    setFlexDirection(3);
                } else {
                    setFlexDirection(2);
                }
            }
        } else if (properties.reverseLayout) {
            setFlexDirection(1);
        } else {
            setFlexDirection(0);
        }
        setFlexWrap(1);
        setAlignItems(4);
        setAutoMeasureEnabled(true);
        this.mContext = context;
    }

    public int getFlexDirection() {
        return this.mFlexDirection;
    }

    public void setFlexDirection(int flexDirection) {
        if (this.mFlexDirection != flexDirection) {
            removeAllViews();
            this.mFlexDirection = flexDirection;
            this.mOrientationHelper = null;
            this.mSubOrientationHelper = null;
            clearFlexLines();
            requestLayout();
        }
    }

    public int getFlexWrap() {
        return this.mFlexWrap;
    }

    public void setFlexWrap(int flexWrap) {
        if (flexWrap != 2) {
            int i = this.mFlexWrap;
            if (i != flexWrap) {
                if (i == 0 || flexWrap == 0) {
                    removeAllViews();
                    clearFlexLines();
                }
                this.mFlexWrap = flexWrap;
                this.mOrientationHelper = null;
                this.mSubOrientationHelper = null;
                requestLayout();
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
    }

    public int getJustifyContent() {
        return this.mJustifyContent;
    }

    public void setJustifyContent(int justifyContent) {
        if (this.mJustifyContent != justifyContent) {
            this.mJustifyContent = justifyContent;
            requestLayout();
        }
    }

    public int getAlignItems() {
        return this.mAlignItems;
    }

    public void setAlignItems(int alignItems) {
        int i = this.mAlignItems;
        if (i != alignItems) {
            if (i == 4 || alignItems == 4) {
                removeAllViews();
                clearFlexLines();
            }
            this.mAlignItems = alignItems;
            requestLayout();
        }
    }

    public int getAlignContent() {
        return 5;
    }

    public void setAlignContent(int alignContent) {
        throw new UnsupportedOperationException("Setting the alignContent in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to use this attribute.");
    }

    public int getMaxLine() {
        return this.mMaxLine;
    }

    public void setMaxLine(int maxLine) {
        if (this.mMaxLine != maxLine) {
            this.mMaxLine = maxLine;
            requestLayout();
        }
    }

    public List<FlexLine> getFlexLines() {
        List<FlexLine> result = new ArrayList<>(this.mFlexLines.size());
        int size = this.mFlexLines.size();
        for (int i = 0; i < size; i++) {
            FlexLine flexLine = this.mFlexLines.get(i);
            if (flexLine.getItemCount() != 0) {
                result.add(flexLine);
            }
        }
        return result;
    }

    public int getDecorationLengthMainAxis(View view, int index, int indexInFlexLine) {
        if (isMainAxisDirectionHorizontal()) {
            return getLeftDecorationWidth(view) + getRightDecorationWidth(view);
        }
        return getTopDecorationHeight(view) + getBottomDecorationHeight(view);
    }

    public int getDecorationLengthCrossAxis(View view) {
        if (isMainAxisDirectionHorizontal()) {
            return getTopDecorationHeight(view) + getBottomDecorationHeight(view);
        }
        return getLeftDecorationWidth(view) + getRightDecorationWidth(view);
    }

    public void onNewFlexItemAdded(View view, int index, int indexInFlexLine, FlexLine flexLine) {
        calculateItemDecorationsForChild(view, TEMP_RECT);
        if (isMainAxisDirectionHorizontal()) {
            int decorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            flexLine.mMainSize += decorationWidth;
            flexLine.mDividerLengthInMainSize += decorationWidth;
            return;
        }
        int decorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
        flexLine.mMainSize += decorationHeight;
        flexLine.mDividerLengthInMainSize += decorationHeight;
    }

    public int getFlexItemCount() {
        return this.mState.getItemCount();
    }

    public View getFlexItemAt(int index) {
        View cachedView = this.mViewCache.get(index);
        if (cachedView != null) {
            return cachedView;
        }
        return this.mRecycler.getViewForPosition(index);
    }

    public View getReorderedFlexItemAt(int index) {
        return getFlexItemAt(index);
    }

    public void onNewFlexLineAdded(FlexLine flexLine) {
    }

    public int getChildWidthMeasureSpec(int widthSpec, int padding, int childDimension) {
        return getChildMeasureSpec(getWidth(), getWidthMode(), padding, childDimension, canScrollHorizontally());
    }

    public int getChildHeightMeasureSpec(int heightSpec, int padding, int childDimension) {
        return getChildMeasureSpec(getHeight(), getHeightMode(), padding, childDimension, canScrollVertically());
    }

    public int getLargestMainSize() {
        if (this.mFlexLines.size() == 0) {
            return 0;
        }
        int largestSize = Integer.MIN_VALUE;
        int size = this.mFlexLines.size();
        for (int i = 0; i < size; i++) {
            largestSize = Math.max(largestSize, this.mFlexLines.get(i).mMainSize);
        }
        return largestSize;
    }

    public int getSumOfCrossSize() {
        int sum = 0;
        int size = this.mFlexLines.size();
        for (int i = 0; i < size; i++) {
            sum += this.mFlexLines.get(i).mCrossSize;
        }
        return sum;
    }

    public void setFlexLines(List<FlexLine> flexLines) {
        this.mFlexLines = flexLines;
    }

    public List<FlexLine> getFlexLinesInternal() {
        return this.mFlexLines;
    }

    public void updateViewCache(int position, View view) {
        this.mViewCache.put(position, view);
    }

    public PointF computeScrollVectorForPosition(int targetPosition) {
        if (getChildCount() == 0) {
            return null;
        }
        int direction = targetPosition < getPosition(getChildAt(0)) ? -1 : 1;
        if (isMainAxisDirectionHorizontal()) {
            return new PointF(0.0f, (float) direction);
        }
        return new PointF((float) direction, 0.0f);
    }

    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public RecyclerView.LayoutParams generateLayoutParams(Context c, AttributeSet attrs) {
        return new LayoutParams(c, attrs);
    }

    public boolean checkLayoutParams(RecyclerView.LayoutParams lp) {
        return lp instanceof LayoutParams;
    }

    public void onAdapterChanged(RecyclerView.Adapter oldAdapter, RecyclerView.Adapter newAdapter) {
        removeAllViews();
    }

    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            View firstView = getChildClosestToStart();
            int unused = savedState.mAnchorPosition = getPosition(firstView);
            int unused2 = savedState.mAnchorOffset = this.mOrientationHelper.getDecoratedStart(firstView) - this.mOrientationHelper.getStartAfterPadding();
        } else {
            savedState.invalidateAnchor();
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof SavedState) {
            this.mPendingSavedState = (SavedState) state;
            requestLayout();
        }
    }

    public void onItemsAdded(RecyclerView recyclerView, int positionStart, int itemCount) {
        super.onItemsAdded(recyclerView, positionStart, itemCount);
        updateDirtyPosition(positionStart);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int positionStart, int itemCount, Object payload) {
        super.onItemsUpdated(recyclerView, positionStart, itemCount, payload);
        updateDirtyPosition(positionStart);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int positionStart, int itemCount) {
        super.onItemsUpdated(recyclerView, positionStart, itemCount);
        updateDirtyPosition(positionStart);
    }

    public void onItemsRemoved(RecyclerView recyclerView, int positionStart, int itemCount) {
        super.onItemsRemoved(recyclerView, positionStart, itemCount);
        updateDirtyPosition(positionStart);
    }

    public void onItemsMoved(RecyclerView recyclerView, int from, int to, int itemCount) {
        super.onItemsMoved(recyclerView, from, to, itemCount);
        updateDirtyPosition(Math.min(from, to));
    }

    private void updateDirtyPosition(int positionStart) {
        if (positionStart < findLastVisibleItemPosition()) {
            int childCount = getChildCount();
            this.mFlexboxHelper.ensureMeasureSpecCache(childCount);
            this.mFlexboxHelper.ensureMeasuredSizeCache(childCount);
            this.mFlexboxHelper.ensureIndexToFlexLine(childCount);
            if (this.mFlexboxHelper.mIndexToFlexLine == null) {
                throw new AssertionError();
            } else if (positionStart < this.mFlexboxHelper.mIndexToFlexLine.length) {
                this.mDirtyPosition = positionStart;
                View firstView = getChildClosestToStart();
                if (firstView != null) {
                    this.mPendingScrollPosition = getPosition(firstView);
                    if (isMainAxisDirectionHorizontal() || !this.mIsRtl) {
                        this.mPendingScrollPositionOffset = this.mOrientationHelper.getDecoratedStart(firstView) - this.mOrientationHelper.getStartAfterPadding();
                    } else {
                        this.mPendingScrollPositionOffset = this.mOrientationHelper.getDecoratedEnd(firstView) + this.mOrientationHelper.getEndPadding();
                    }
                }
            }
        }
    }

    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int endOffset;
        int filledToEnd;
        this.mRecycler = recycler;
        this.mState = state;
        int childCount = state.getItemCount();
        if (childCount != 0 || !state.isPreLayout()) {
            resolveLayoutDirection();
            ensureOrientationHelper();
            ensureLayoutState();
            this.mFlexboxHelper.ensureMeasureSpecCache(childCount);
            this.mFlexboxHelper.ensureMeasuredSizeCache(childCount);
            this.mFlexboxHelper.ensureIndexToFlexLine(childCount);
            boolean unused = this.mLayoutState.mShouldRecycle = false;
            SavedState savedState = this.mPendingSavedState;
            if (savedState != null && savedState.hasValidAnchor(childCount)) {
                this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
            }
            if (!(this.mAnchorInfo.mValid && this.mPendingScrollPosition == -1 && this.mPendingSavedState == null)) {
                this.mAnchorInfo.reset();
                updateAnchorInfoForLayout(state, this.mAnchorInfo);
                boolean unused2 = this.mAnchorInfo.mValid = true;
            }
            detachAndScrapAttachedViews(recycler);
            if (this.mAnchorInfo.mLayoutFromEnd) {
                updateLayoutStateToFillStart(this.mAnchorInfo, false, true);
            } else {
                updateLayoutStateToFillEnd(this.mAnchorInfo, false, true);
            }
            updateFlexLines(childCount);
            if (this.mAnchorInfo.mLayoutFromEnd) {
                int fill = fill(recycler, state, this.mLayoutState);
                endOffset = this.mLayoutState.mOffset;
                updateLayoutStateToFillEnd(this.mAnchorInfo, true, false);
                int fill2 = fill(recycler, state, this.mLayoutState);
                filledToEnd = this.mLayoutState.mOffset;
            } else {
                int fill3 = fill(recycler, state, this.mLayoutState);
                int endOffset2 = this.mLayoutState.mOffset;
                updateLayoutStateToFillStart(this.mAnchorInfo, true, false);
                int fill4 = fill(recycler, state, this.mLayoutState);
                filledToEnd = endOffset2;
                endOffset = this.mLayoutState.mOffset;
            }
            if (getChildCount() <= 0) {
                return;
            }
            if (this.mAnchorInfo.mLayoutFromEnd) {
                fixLayoutStartGap(endOffset + fixLayoutEndGap(filledToEnd, recycler, state, true), recycler, state, false);
            } else {
                fixLayoutEndGap(filledToEnd + fixLayoutStartGap(endOffset, recycler, state, true), recycler, state, false);
            }
        }
    }

    private int fixLayoutStartGap(int startOffset, RecyclerView.Recycler recycler, RecyclerView.State state, boolean canOffsetChildren) {
        int fixOffset;
        int gap;
        if (isMainAxisDirectionHorizontal() || !this.mIsRtl) {
            int gap2 = startOffset - this.mOrientationHelper.getStartAfterPadding();
            if (gap2 <= 0) {
                return 0;
            }
            fixOffset = -handleScrollingMainOrientation(gap2, recycler, state);
        } else {
            int gap3 = this.mOrientationHelper.getEndAfterPadding() - startOffset;
            if (gap3 <= 0) {
                return 0;
            }
            fixOffset = handleScrollingMainOrientation(-gap3, recycler, state);
        }
        int startOffset2 = startOffset + fixOffset;
        if (!canOffsetChildren || (gap = startOffset2 - this.mOrientationHelper.getStartAfterPadding()) <= 0) {
            return fixOffset;
        }
        this.mOrientationHelper.offsetChildren(-gap);
        return fixOffset - gap;
    }

    private int fixLayoutEndGap(int endOffset, RecyclerView.Recycler recycler, RecyclerView.State state, boolean canOffsetChildren) {
        int fixOffset;
        int gap;
        if (!isMainAxisDirectionHorizontal() && this.mIsRtl) {
            int gap2 = endOffset - this.mOrientationHelper.getStartAfterPadding();
            if (gap2 <= 0) {
                return 0;
            }
            fixOffset = handleScrollingMainOrientation(gap2, recycler, state);
        } else {
            int gap3 = this.mOrientationHelper.getEndAfterPadding() - endOffset;
            if (gap3 <= 0) {
                return 0;
            }
            fixOffset = -handleScrollingMainOrientation(-gap3, recycler, state);
        }
        int endOffset2 = endOffset + fixOffset;
        if (!canOffsetChildren || (gap = this.mOrientationHelper.getEndAfterPadding() - endOffset2) <= 0) {
            return fixOffset;
        }
        this.mOrientationHelper.offsetChildren(gap);
        return gap + fixOffset;
    }

    private void updateFlexLines(int childCount) {
        int needsToFill;
        boolean isMainSizeChanged;
        int width;
        int i;
        int i2;
        int i3 = childCount;
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width2 = getWidth();
        int height = getHeight();
        boolean z = true;
        if (isMainAxisDirectionHorizontal()) {
            int i4 = this.mLastWidth;
            if (i4 == Integer.MIN_VALUE || i4 == width2) {
                z = false;
            }
            boolean isMainSizeChanged2 = z;
            if (this.mLayoutState.mInfinite) {
                i2 = this.mContext.getResources().getDisplayMetrics().heightPixels;
            } else {
                i2 = this.mLayoutState.mAvailable;
            }
            isMainSizeChanged = isMainSizeChanged2;
            needsToFill = i2;
        } else {
            int i5 = this.mLastHeight;
            if (i5 == Integer.MIN_VALUE || i5 == height) {
                z = false;
            }
            boolean isMainSizeChanged3 = z;
            if (this.mLayoutState.mInfinite) {
                i = this.mContext.getResources().getDisplayMetrics().widthPixels;
            } else {
                i = this.mLayoutState.mAvailable;
            }
            isMainSizeChanged = isMainSizeChanged3;
            needsToFill = i;
        }
        this.mLastWidth = width2;
        this.mLastHeight = height;
        int i6 = this.mDirtyPosition;
        if (i6 != -1 || (this.mPendingScrollPosition == -1 && !isMainSizeChanged)) {
            int fromIndex = i6 != -1 ? Math.min(i6, this.mAnchorInfo.mPosition) : this.mAnchorInfo.mPosition;
            this.mFlexLinesResult.reset();
            if (!isMainAxisDirectionHorizontal()) {
                width = fromIndex;
                if (this.mFlexLines.size() > 0) {
                    this.mFlexboxHelper.clearFlexLines(this.mFlexLines, width);
                    this.mFlexboxHelper.calculateFlexLines(this.mFlexLinesResult, heightMeasureSpec, widthMeasureSpec, needsToFill, width, this.mAnchorInfo.mPosition, this.mFlexLines);
                } else {
                    this.mFlexboxHelper.ensureIndexToFlexLine(i3);
                    this.mFlexboxHelper.calculateVerticalFlexLines(this.mFlexLinesResult, widthMeasureSpec, heightMeasureSpec, needsToFill, 0, this.mFlexLines);
                }
            } else if (this.mFlexLines.size() > 0) {
                this.mFlexboxHelper.clearFlexLines(this.mFlexLines, fromIndex);
                int i7 = width2;
                width = fromIndex;
                this.mFlexboxHelper.calculateFlexLines(this.mFlexLinesResult, widthMeasureSpec, heightMeasureSpec, needsToFill, fromIndex, this.mAnchorInfo.mPosition, this.mFlexLines);
            } else {
                width = fromIndex;
                this.mFlexboxHelper.ensureIndexToFlexLine(i3);
                this.mFlexboxHelper.calculateHorizontalFlexLines(this.mFlexLinesResult, widthMeasureSpec, heightMeasureSpec, needsToFill, 0, this.mFlexLines);
            }
            this.mFlexLines = this.mFlexLinesResult.mFlexLines;
            this.mFlexboxHelper.determineMainSize(widthMeasureSpec, heightMeasureSpec, width);
            this.mFlexboxHelper.stretchViews(width);
        } else if (!this.mAnchorInfo.mLayoutFromEnd) {
            this.mFlexLines.clear();
            if (this.mFlexboxHelper.mIndexToFlexLine != null) {
                this.mFlexLinesResult.reset();
                if (isMainAxisDirectionHorizontal()) {
                    this.mFlexboxHelper.calculateHorizontalFlexLinesToIndex(this.mFlexLinesResult, widthMeasureSpec, heightMeasureSpec, needsToFill, this.mAnchorInfo.mPosition, this.mFlexLines);
                } else {
                    this.mFlexboxHelper.calculateVerticalFlexLinesToIndex(this.mFlexLinesResult, widthMeasureSpec, heightMeasureSpec, needsToFill, this.mAnchorInfo.mPosition, this.mFlexLines);
                }
                this.mFlexLines = this.mFlexLinesResult.mFlexLines;
                this.mFlexboxHelper.determineMainSize(widthMeasureSpec, heightMeasureSpec);
                this.mFlexboxHelper.stretchViews();
                int unused = this.mAnchorInfo.mFlexLinePosition = this.mFlexboxHelper.mIndexToFlexLine[this.mAnchorInfo.mPosition];
                int unused2 = this.mLayoutState.mFlexLinePosition = this.mAnchorInfo.mFlexLinePosition;
                int i8 = width2;
                return;
            }
            throw new AssertionError();
        }
    }

    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mDirtyPosition = -1;
        this.mAnchorInfo.reset();
        this.mViewCache.clear();
    }

    /* access modifiers changed from: package-private */
    public boolean isLayoutRtl() {
        return this.mIsRtl;
    }

    private void resolveLayoutDirection() {
        int layoutDirection = getLayoutDirection();
        int i = this.mFlexDirection;
        boolean z = false;
        if (i == 0) {
            this.mIsRtl = layoutDirection == 1;
            if (this.mFlexWrap == 2) {
                z = true;
            }
            this.mFromBottomToTop = z;
        } else if (i == 1) {
            this.mIsRtl = layoutDirection != 1;
            if (this.mFlexWrap == 2) {
                z = true;
            }
            this.mFromBottomToTop = z;
        } else if (i == 2) {
            boolean z2 = layoutDirection == 1;
            this.mIsRtl = z2;
            if (this.mFlexWrap == 2) {
                this.mIsRtl = !z2;
            }
            this.mFromBottomToTop = false;
        } else if (i != 3) {
            this.mIsRtl = false;
            this.mFromBottomToTop = false;
        } else {
            if (layoutDirection == 1) {
                z = true;
            }
            this.mIsRtl = z;
            if (this.mFlexWrap == 2) {
                this.mIsRtl = !z;
            }
            this.mFromBottomToTop = true;
        }
    }

    private void updateAnchorInfoForLayout(RecyclerView.State state, AnchorInfo anchorInfo) {
        if (!updateAnchorFromPendingState(state, anchorInfo, this.mPendingSavedState) && !updateAnchorFromChildren(state, anchorInfo)) {
            anchorInfo.assignCoordinateFromPadding();
            int unused = anchorInfo.mPosition = 0;
            int unused2 = anchorInfo.mFlexLinePosition = 0;
        }
    }

    private boolean updateAnchorFromPendingState(RecyclerView.State state, AnchorInfo anchorInfo, SavedState savedState) {
        int i;
        int i2;
        if (this.mFlexboxHelper.mIndexToFlexLine != null) {
            boolean z = false;
            if (state.isPreLayout() || (i = this.mPendingScrollPosition) == -1) {
                return false;
            }
            if (i < 0 || i >= state.getItemCount()) {
                this.mPendingScrollPosition = -1;
                this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
                return false;
            }
            int unused = anchorInfo.mPosition = this.mPendingScrollPosition;
            int unused2 = anchorInfo.mFlexLinePosition = this.mFlexboxHelper.mIndexToFlexLine[anchorInfo.mPosition];
            SavedState savedState2 = this.mPendingSavedState;
            if (savedState2 != null && savedState2.hasValidAnchor(state.getItemCount())) {
                int unused3 = anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + savedState.mAnchorOffset;
                boolean unused4 = anchorInfo.mAssignedFromSavedState = true;
                int unused5 = anchorInfo.mFlexLinePosition = -1;
                return true;
            } else if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                View anchorView = findViewByPosition(this.mPendingScrollPosition);
                if (anchorView == null) {
                    if (getChildCount() > 0) {
                        if (this.mPendingScrollPosition < getPosition(getChildAt(0))) {
                            z = true;
                        }
                        boolean unused6 = anchorInfo.mLayoutFromEnd = z;
                    }
                    anchorInfo.assignCoordinateFromPadding();
                } else if (this.mOrientationHelper.getDecoratedMeasurement(anchorView) > this.mOrientationHelper.getTotalSpace()) {
                    anchorInfo.assignCoordinateFromPadding();
                    return true;
                } else if (this.mOrientationHelper.getDecoratedStart(anchorView) - this.mOrientationHelper.getStartAfterPadding() < 0) {
                    int unused7 = anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding();
                    boolean unused8 = anchorInfo.mLayoutFromEnd = false;
                    return true;
                } else if (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(anchorView) < 0) {
                    int unused9 = anchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
                    boolean unused10 = anchorInfo.mLayoutFromEnd = true;
                    return true;
                } else {
                    if (anchorInfo.mLayoutFromEnd) {
                        i2 = this.mOrientationHelper.getDecoratedEnd(anchorView) + this.mOrientationHelper.getTotalSpaceChange();
                    } else {
                        i2 = this.mOrientationHelper.getDecoratedStart(anchorView);
                    }
                    int unused11 = anchorInfo.mCoordinate = i2;
                }
                return true;
            } else {
                if (isMainAxisDirectionHorizontal() || !this.mIsRtl) {
                    int unused12 = anchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                } else {
                    int unused13 = anchorInfo.mCoordinate = this.mPendingScrollPositionOffset - this.mOrientationHelper.getEndPadding();
                }
                return true;
            }
        } else {
            throw new AssertionError();
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.State state, AnchorInfo anchorInfo) {
        View referenceChild;
        int i;
        boolean notVisible = false;
        if (getChildCount() == 0) {
            return false;
        }
        if (anchorInfo.mLayoutFromEnd) {
            referenceChild = findLastReferenceChild(state.getItemCount());
        } else {
            referenceChild = findFirstReferenceChild(state.getItemCount());
        }
        if (referenceChild == null) {
            return false;
        }
        anchorInfo.assignFromView(referenceChild);
        if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
            if (this.mOrientationHelper.getDecoratedStart(referenceChild) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(referenceChild) < this.mOrientationHelper.getStartAfterPadding()) {
                notVisible = true;
            }
            if (notVisible) {
                if (anchorInfo.mLayoutFromEnd) {
                    i = this.mOrientationHelper.getEndAfterPadding();
                } else {
                    i = this.mOrientationHelper.getStartAfterPadding();
                }
                int unused = anchorInfo.mCoordinate = i;
            }
        }
        return true;
    }

    private View findFirstReferenceChild(int itemCount) {
        int firstFoundLinePosition;
        if (this.mFlexboxHelper.mIndexToFlexLine != null) {
            View firstFound = findReferenceChild(0, getChildCount(), itemCount);
            if (firstFound == null || (firstFoundLinePosition = this.mFlexboxHelper.mIndexToFlexLine[getPosition(firstFound)]) == -1) {
                return null;
            }
            return findFirstReferenceViewInLine(firstFound, this.mFlexLines.get(firstFoundLinePosition));
        }
        throw new AssertionError();
    }

    private View findLastReferenceChild(int itemCount) {
        if (this.mFlexboxHelper.mIndexToFlexLine != null) {
            View lastFound = findReferenceChild(getChildCount() - 1, -1, itemCount);
            if (lastFound == null) {
                return null;
            }
            return findLastReferenceViewInLine(lastFound, this.mFlexLines.get(this.mFlexboxHelper.mIndexToFlexLine[getPosition(lastFound)]));
        }
        throw new AssertionError();
    }

    private View findReferenceChild(int start, int end, int itemCount) {
        ensureOrientationHelper();
        ensureLayoutState();
        View invalidMatch = null;
        View outOfBoundsMatch = null;
        int boundStart = this.mOrientationHelper.getStartAfterPadding();
        int boundEnd = this.mOrientationHelper.getEndAfterPadding();
        int diff = end > start ? 1 : -1;
        for (int i = start; i != end; i += diff) {
            View view = getChildAt(i);
            int position = getPosition(view);
            if (position >= 0 && position < itemCount) {
                if (((RecyclerView.LayoutParams) view.getLayoutParams()).isItemRemoved()) {
                    if (invalidMatch == null) {
                        invalidMatch = view;
                    }
                } else if (this.mOrientationHelper.getDecoratedStart(view) >= boundStart && this.mOrientationHelper.getDecoratedEnd(view) <= boundEnd) {
                    return view;
                } else {
                    if (outOfBoundsMatch == null) {
                        outOfBoundsMatch = view;
                    }
                }
            }
        }
        return outOfBoundsMatch != null ? outOfBoundsMatch : invalidMatch;
    }

    private View getChildClosestToStart() {
        return getChildAt(0);
    }

    private int fill(RecyclerView.Recycler recycler, RecyclerView.State state, LayoutState layoutState) {
        if (layoutState.mScrollingOffset != Integer.MIN_VALUE) {
            if (layoutState.mAvailable < 0) {
                int unused = layoutState.mScrollingOffset = layoutState.mScrollingOffset + layoutState.mAvailable;
            }
            recycleByLayoutState(recycler, layoutState);
        }
        int start = layoutState.mAvailable;
        int remainingSpace = layoutState.mAvailable;
        int consumed = 0;
        boolean mainAxisHorizontal = isMainAxisDirectionHorizontal();
        while (true) {
            if ((remainingSpace > 0 || this.mLayoutState.mInfinite) && layoutState.hasMore(state, this.mFlexLines)) {
                FlexLine flexLine = this.mFlexLines.get(layoutState.mFlexLinePosition);
                int unused2 = layoutState.mPosition = flexLine.mFirstIndex;
                consumed += layoutFlexLine(flexLine, layoutState);
                if (mainAxisHorizontal || !this.mIsRtl) {
                    int unused3 = layoutState.mOffset = layoutState.mOffset + (flexLine.getCrossSize() * layoutState.mLayoutDirection);
                } else {
                    int unused4 = layoutState.mOffset = layoutState.mOffset - (flexLine.getCrossSize() * layoutState.mLayoutDirection);
                }
                remainingSpace -= flexLine.getCrossSize();
            }
        }
        int unused5 = layoutState.mAvailable = layoutState.mAvailable - consumed;
        if (layoutState.mScrollingOffset != Integer.MIN_VALUE) {
            int unused6 = layoutState.mScrollingOffset = layoutState.mScrollingOffset + consumed;
            if (layoutState.mAvailable < 0) {
                int unused7 = layoutState.mScrollingOffset = layoutState.mScrollingOffset + layoutState.mAvailable;
            }
            recycleByLayoutState(recycler, layoutState);
        }
        return start - layoutState.mAvailable;
    }

    private void recycleByLayoutState(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (layoutState.mShouldRecycle) {
            if (layoutState.mLayoutDirection == -1) {
                recycleFlexLinesFromEnd(recycler, layoutState);
            } else {
                recycleFlexLinesFromStart(recycler, layoutState);
            }
        }
    }

    private void recycleFlexLinesFromStart(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (layoutState.mScrollingOffset >= 0) {
            if (this.mFlexboxHelper.mIndexToFlexLine != null) {
                int childCount = getChildCount();
                if (childCount != 0) {
                    int currentLineIndex = this.mFlexboxHelper.mIndexToFlexLine[getPosition(getChildAt(0))];
                    if (currentLineIndex != -1) {
                        FlexLine flexLine = this.mFlexLines.get(currentLineIndex);
                        int recycleTo = -1;
                        for (int i = 0; i < childCount; i++) {
                            View view = getChildAt(i);
                            if (!canViewBeRecycledFromStart(view, layoutState.mScrollingOffset)) {
                                break;
                            }
                            if (flexLine.mLastIndex == getPosition(view)) {
                                recycleTo = i;
                                if (currentLineIndex >= this.mFlexLines.size() - 1) {
                                    break;
                                }
                                currentLineIndex += layoutState.mLayoutDirection;
                                flexLine = this.mFlexLines.get(currentLineIndex);
                            }
                        }
                        recycleChildren(recycler, 0, recycleTo);
                        return;
                    }
                    return;
                }
                return;
            }
            throw new AssertionError();
        }
    }

    private boolean canViewBeRecycledFromStart(View view, int scrollingOffset) {
        if (isMainAxisDirectionHorizontal() || !this.mIsRtl) {
            if (this.mOrientationHelper.getDecoratedEnd(view) <= scrollingOffset) {
                return true;
            }
            return false;
        } else if (this.mOrientationHelper.getEnd() - this.mOrientationHelper.getDecoratedStart(view) <= scrollingOffset) {
            return true;
        } else {
            return false;
        }
    }

    private void recycleFlexLinesFromEnd(RecyclerView.Recycler recycler, LayoutState layoutState) {
        if (layoutState.mScrollingOffset >= 0) {
            if (this.mFlexboxHelper.mIndexToFlexLine != null) {
                int end = this.mOrientationHelper.getEnd() - layoutState.mScrollingOffset;
                int childCount = getChildCount();
                if (childCount != 0) {
                    int currentLineIndex = this.mFlexboxHelper.mIndexToFlexLine[getPosition(getChildAt(childCount - 1))];
                    if (currentLineIndex != -1) {
                        int recycleTo = childCount - 1;
                        int recycleFrom = childCount;
                        FlexLine flexLine = this.mFlexLines.get(currentLineIndex);
                        for (int i = childCount - 1; i >= 0; i--) {
                            View view = getChildAt(i);
                            if (!canViewBeRecycledFromEnd(view, layoutState.mScrollingOffset)) {
                                break;
                            }
                            if (flexLine.mFirstIndex == getPosition(view)) {
                                recycleFrom = i;
                                if (currentLineIndex <= 0) {
                                    break;
                                }
                                currentLineIndex += layoutState.mLayoutDirection;
                                flexLine = this.mFlexLines.get(currentLineIndex);
                            }
                        }
                        recycleChildren(recycler, recycleFrom, recycleTo);
                        return;
                    }
                    return;
                }
                return;
            }
            throw new AssertionError();
        }
    }

    private boolean canViewBeRecycledFromEnd(View view, int scrollingOffset) {
        if (isMainAxisDirectionHorizontal() || !this.mIsRtl) {
            if (this.mOrientationHelper.getDecoratedStart(view) >= this.mOrientationHelper.getEnd() - scrollingOffset) {
                return true;
            }
            return false;
        } else if (this.mOrientationHelper.getDecoratedEnd(view) <= scrollingOffset) {
            return true;
        } else {
            return false;
        }
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int startIndex, int endIndex) {
        for (int i = endIndex; i >= startIndex; i--) {
            removeAndRecycleViewAt(i, recycler);
        }
    }

    private int layoutFlexLine(FlexLine flexLine, LayoutState layoutState) {
        if (isMainAxisDirectionHorizontal()) {
            return layoutFlexLineMainAxisHorizontal(flexLine, layoutState);
        }
        return layoutFlexLineMainAxisVertical(flexLine, layoutState);
    }

    private int layoutFlexLineMainAxisHorizontal(FlexLine flexLine, LayoutState layoutState) {
        int childTop;
        float childRight;
        float childLeft;
        int i;
        int indexInFlexLine;
        View view;
        FlexLine flexLine2 = flexLine;
        if (this.mFlexboxHelper.mMeasureSpecCache != null) {
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int parentWidth = getWidth();
            int childTop2 = layoutState.mOffset;
            if (layoutState.mLayoutDirection == -1) {
                childTop = childTop2 - flexLine2.mCrossSize;
            } else {
                childTop = childTop2;
            }
            int startPosition = layoutState.mPosition;
            float spaceBetweenItem = 0.0f;
            int i2 = this.mJustifyContent;
            int i3 = 1;
            if (i2 == 0) {
                childLeft = (float) paddingLeft;
                childRight = (float) (parentWidth - paddingRight);
            } else if (i2 == 1) {
                childLeft = (float) ((parentWidth - flexLine2.mMainSize) + paddingRight);
                childRight = (float) (flexLine2.mMainSize - paddingLeft);
            } else if (i2 == 2) {
                childLeft = ((float) paddingLeft) + (((float) (parentWidth - flexLine2.mMainSize)) / 2.0f);
                childRight = ((float) (parentWidth - paddingRight)) - (((float) (parentWidth - flexLine2.mMainSize)) / 2.0f);
            } else if (i2 == 3) {
                childLeft = (float) paddingLeft;
                spaceBetweenItem = ((float) (parentWidth - flexLine2.mMainSize)) / (flexLine2.mItemCount != 1 ? (float) (flexLine2.mItemCount - 1) : 1.0f);
                childRight = (float) (parentWidth - paddingRight);
            } else if (i2 == 4) {
                if (flexLine2.mItemCount != 0) {
                    spaceBetweenItem = ((float) (parentWidth - flexLine2.mMainSize)) / ((float) flexLine2.mItemCount);
                }
                childLeft = ((float) paddingLeft) + (spaceBetweenItem / 2.0f);
                childRight = ((float) (parentWidth - paddingRight)) - (spaceBetweenItem / 2.0f);
            } else if (i2 == 5) {
                if (flexLine2.mItemCount != 0) {
                    spaceBetweenItem = ((float) (parentWidth - flexLine2.mMainSize)) / ((float) (flexLine2.mItemCount + 1));
                }
                childLeft = ((float) paddingLeft) + spaceBetweenItem;
                childRight = ((float) (parentWidth - paddingRight)) - spaceBetweenItem;
            } else {
                throw new IllegalStateException("Invalid justifyContent is set: " + this.mJustifyContent);
            }
            float childLeft2 = childLeft - ((float) this.mAnchorInfo.mPerpendicularCoordinate);
            float childRight2 = childRight - ((float) this.mAnchorInfo.mPerpendicularCoordinate);
            float spaceBetweenItem2 = Math.max(spaceBetweenItem, 0.0f);
            int indexInFlexLine2 = 0;
            int itemCount = flexLine.getItemCount();
            int i4 = startPosition;
            while (i4 < startPosition + itemCount) {
                View view2 = getFlexItemAt(i4);
                if (view2 == null) {
                    i = i4;
                } else {
                    if (layoutState.mLayoutDirection == i3) {
                        calculateItemDecorationsForChild(view2, TEMP_RECT);
                        addView(view2);
                        indexInFlexLine = indexInFlexLine2;
                    } else {
                        calculateItemDecorationsForChild(view2, TEMP_RECT);
                        addView(view2, indexInFlexLine2);
                        indexInFlexLine = indexInFlexLine2 + 1;
                    }
                    long measureSpec = this.mFlexboxHelper.mMeasureSpecCache[i4];
                    int widthSpec = this.mFlexboxHelper.extractLowerInt(measureSpec);
                    int heightSpec = this.mFlexboxHelper.extractHigherInt(measureSpec);
                    LayoutParams lp = (LayoutParams) view2.getLayoutParams();
                    if (shouldMeasureChild(view2, widthSpec, heightSpec, lp)) {
                        view2.measure(widthSpec, heightSpec);
                    }
                    int i5 = widthSpec;
                    float childLeft3 = childLeft2 + ((float) (lp.leftMargin + getLeftDecorationWidth(view2)));
                    float childRight3 = childRight2 - ((float) (lp.rightMargin + getRightDecorationWidth(view2)));
                    int topWithDecoration = childTop + getTopDecorationHeight(view2);
                    if (this.mIsRtl) {
                        FlexboxHelper flexboxHelper = this.mFlexboxHelper;
                        int round = Math.round(childRight3) - view2.getMeasuredWidth();
                        int round2 = Math.round(childRight3);
                        int i6 = topWithDecoration + view2.getMeasuredHeight();
                        long j = measureSpec;
                        view = view2;
                        int i7 = round2;
                        i = i4;
                        flexboxHelper.layoutSingleChildHorizontal(view2, flexLine, round, topWithDecoration, i7, i6);
                    } else {
                        view = view2;
                        i = i4;
                        this.mFlexboxHelper.layoutSingleChildHorizontal(view, flexLine, Math.round(childLeft3), topWithDecoration, Math.round(childLeft3) + view.getMeasuredWidth(), topWithDecoration + view.getMeasuredHeight());
                    }
                    View view3 = view;
                    float childLeft4 = childLeft3 + ((float) (view.getMeasuredWidth() + lp.rightMargin + getRightDecorationWidth(view3))) + spaceBetweenItem2;
                    float childRight4 = childRight3 - (((float) ((view3.getMeasuredWidth() + lp.leftMargin) + getLeftDecorationWidth(view3))) + spaceBetweenItem2);
                    indexInFlexLine2 = indexInFlexLine;
                    childLeft2 = childLeft4;
                    childRight2 = childRight4;
                }
                i4 = i + 1;
                FlexLine flexLine3 = flexLine;
                i3 = 1;
            }
            int unused = layoutState.mFlexLinePosition = layoutState.mFlexLinePosition + this.mLayoutState.mLayoutDirection;
            return flexLine.getCrossSize();
        }
        LayoutState layoutState2 = layoutState;
        throw new AssertionError();
    }

    private int layoutFlexLineMainAxisVertical(FlexLine flexLine, LayoutState layoutState) {
        int childRight;
        int childLeft;
        float childBottom;
        float childTop;
        boolean z;
        int i;
        int indexInFlexLine;
        View view;
        FlexLine flexLine2 = flexLine;
        if (this.mFlexboxHelper.mMeasureSpecCache != null) {
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int parentHeight = getHeight();
            int childLeft2 = layoutState.mOffset;
            int childRight2 = layoutState.mOffset;
            if (layoutState.mLayoutDirection == -1) {
                childLeft = childLeft2 - flexLine2.mCrossSize;
                childRight = childRight2 + flexLine2.mCrossSize;
            } else {
                childLeft = childLeft2;
                childRight = childRight2;
            }
            int startPosition = layoutState.mPosition;
            float spaceBetweenItem = 0.0f;
            int i2 = this.mJustifyContent;
            boolean z2 = true;
            if (i2 == 0) {
                childTop = (float) paddingTop;
                childBottom = (float) (parentHeight - paddingBottom);
            } else if (i2 == 1) {
                childTop = (float) ((parentHeight - flexLine2.mMainSize) + paddingBottom);
                childBottom = (float) (flexLine2.mMainSize - paddingTop);
            } else if (i2 == 2) {
                childTop = ((float) paddingTop) + (((float) (parentHeight - flexLine2.mMainSize)) / 2.0f);
                childBottom = ((float) (parentHeight - paddingBottom)) - (((float) (parentHeight - flexLine2.mMainSize)) / 2.0f);
            } else if (i2 == 3) {
                childTop = (float) paddingTop;
                spaceBetweenItem = ((float) (parentHeight - flexLine2.mMainSize)) / (flexLine2.mItemCount != 1 ? (float) (flexLine2.mItemCount - 1) : 1.0f);
                childBottom = (float) (parentHeight - paddingBottom);
            } else if (i2 == 4) {
                if (flexLine2.mItemCount != 0) {
                    spaceBetweenItem = ((float) (parentHeight - flexLine2.mMainSize)) / ((float) flexLine2.mItemCount);
                }
                childTop = ((float) paddingTop) + (spaceBetweenItem / 2.0f);
                childBottom = ((float) (parentHeight - paddingBottom)) - (spaceBetweenItem / 2.0f);
            } else if (i2 == 5) {
                if (flexLine2.mItemCount != 0) {
                    spaceBetweenItem = ((float) (parentHeight - flexLine2.mMainSize)) / ((float) (flexLine2.mItemCount + 1));
                }
                childTop = ((float) paddingTop) + spaceBetweenItem;
                childBottom = ((float) (parentHeight - paddingBottom)) - spaceBetweenItem;
            } else {
                throw new IllegalStateException("Invalid justifyContent is set: " + this.mJustifyContent);
            }
            float childTop2 = childTop - ((float) this.mAnchorInfo.mPerpendicularCoordinate);
            float childBottom2 = childBottom - ((float) this.mAnchorInfo.mPerpendicularCoordinate);
            float spaceBetweenItem2 = Math.max(spaceBetweenItem, 0.0f);
            int indexInFlexLine2 = 0;
            int itemCount = flexLine.getItemCount();
            int i3 = startPosition;
            while (i3 < startPosition + itemCount) {
                View view2 = getFlexItemAt(i3);
                if (view2 == null) {
                    i = i3;
                    z = z2;
                } else {
                    long measureSpec = this.mFlexboxHelper.mMeasureSpecCache[i3];
                    int widthSpec = this.mFlexboxHelper.extractLowerInt(measureSpec);
                    int heightSpec = this.mFlexboxHelper.extractHigherInt(measureSpec);
                    long j = measureSpec;
                    LayoutParams lp = (LayoutParams) view2.getLayoutParams();
                    if (shouldMeasureChild(view2, widthSpec, heightSpec, lp)) {
                        view2.measure(widthSpec, heightSpec);
                    }
                    float childTop3 = childTop2 + ((float) (lp.topMargin + getTopDecorationHeight(view2)));
                    float childBottom3 = childBottom2 - ((float) (lp.rightMargin + getBottomDecorationHeight(view2)));
                    if (layoutState.mLayoutDirection == 1) {
                        calculateItemDecorationsForChild(view2, TEMP_RECT);
                        addView(view2);
                        indexInFlexLine = indexInFlexLine2;
                    } else {
                        calculateItemDecorationsForChild(view2, TEMP_RECT);
                        addView(view2, indexInFlexLine2);
                        indexInFlexLine = indexInFlexLine2 + 1;
                    }
                    int leftWithDecoration = childLeft + getLeftDecorationWidth(view2);
                    int rightWithDecoration = childRight - getRightDecorationWidth(view2);
                    boolean z3 = this.mIsRtl;
                    if (!z3) {
                        boolean z4 = z3;
                        int i4 = heightSpec;
                        int i5 = widthSpec;
                        view = view2;
                        i = i3;
                        z = true;
                        if (this.mFromBottomToTop) {
                            this.mFlexboxHelper.layoutSingleChildVertical(view, flexLine, z4, leftWithDecoration, Math.round(childBottom3) - view.getMeasuredHeight(), leftWithDecoration + view.getMeasuredWidth(), Math.round(childBottom3));
                        } else {
                            this.mFlexboxHelper.layoutSingleChildVertical(view, flexLine, z4, leftWithDecoration, Math.round(childTop3), leftWithDecoration + view.getMeasuredWidth(), Math.round(childTop3) + view.getMeasuredHeight());
                        }
                    } else if (this.mFromBottomToTop) {
                        int i6 = heightSpec;
                        int i7 = widthSpec;
                        view = view2;
                        i = i3;
                        z = true;
                        this.mFlexboxHelper.layoutSingleChildVertical(view2, flexLine, z3, rightWithDecoration - view2.getMeasuredWidth(), Math.round(childBottom3) - view2.getMeasuredHeight(), rightWithDecoration, Math.round(childBottom3));
                    } else {
                        int i8 = heightSpec;
                        int i9 = widthSpec;
                        view = view2;
                        i = i3;
                        z = true;
                        this.mFlexboxHelper.layoutSingleChildVertical(view, flexLine, z3, rightWithDecoration - view.getMeasuredWidth(), Math.round(childTop3), rightWithDecoration, Math.round(childTop3) + view.getMeasuredHeight());
                    }
                    View view3 = view;
                    float childTop4 = childTop3 + ((float) (view.getMeasuredHeight() + lp.topMargin + getBottomDecorationHeight(view3))) + spaceBetweenItem2;
                    float childBottom4 = childBottom3 - (((float) ((view3.getMeasuredHeight() + lp.bottomMargin) + getTopDecorationHeight(view3))) + spaceBetweenItem2);
                    indexInFlexLine2 = indexInFlexLine;
                    childTop2 = childTop4;
                    childBottom2 = childBottom4;
                }
                i3 = i + 1;
                FlexLine flexLine3 = flexLine;
                z2 = z;
            }
            int unused = layoutState.mFlexLinePosition = layoutState.mFlexLinePosition + this.mLayoutState.mLayoutDirection;
            return flexLine.getCrossSize();
        }
        LayoutState layoutState2 = layoutState;
        throw new AssertionError();
    }

    public boolean isMainAxisDirectionHorizontal() {
        int i = this.mFlexDirection;
        return i == 0 || i == 1;
    }

    private void updateLayoutStateToFillEnd(AnchorInfo anchorInfo, boolean fromNextLine, boolean considerInfinite) {
        if (considerInfinite) {
            resolveInfiniteAmount();
        } else {
            boolean unused = this.mLayoutState.mInfinite = false;
        }
        if (isMainAxisDirectionHorizontal() || !this.mIsRtl) {
            int unused2 = this.mLayoutState.mAvailable = this.mOrientationHelper.getEndAfterPadding() - anchorInfo.mCoordinate;
        } else {
            int unused3 = this.mLayoutState.mAvailable = anchorInfo.mCoordinate - getPaddingRight();
        }
        int unused4 = this.mLayoutState.mPosition = anchorInfo.mPosition;
        int unused5 = this.mLayoutState.mItemDirection = 1;
        int unused6 = this.mLayoutState.mLayoutDirection = 1;
        int unused7 = this.mLayoutState.mOffset = anchorInfo.mCoordinate;
        int unused8 = this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
        int unused9 = this.mLayoutState.mFlexLinePosition = anchorInfo.mFlexLinePosition;
        if (fromNextLine && this.mFlexLines.size() > 1 && anchorInfo.mFlexLinePosition >= 0 && anchorInfo.mFlexLinePosition < this.mFlexLines.size() - 1) {
            LayoutState.access$1508(this.mLayoutState);
            LayoutState layoutState = this.mLayoutState;
            int unused10 = layoutState.mPosition = layoutState.mPosition + this.mFlexLines.get(anchorInfo.mFlexLinePosition).getItemCount();
        }
    }

    private void updateLayoutStateToFillStart(AnchorInfo anchorInfo, boolean fromPreviousLine, boolean considerInfinite) {
        if (considerInfinite) {
            resolveInfiniteAmount();
        } else {
            boolean unused = this.mLayoutState.mInfinite = false;
        }
        if (isMainAxisDirectionHorizontal() || !this.mIsRtl) {
            int unused2 = this.mLayoutState.mAvailable = anchorInfo.mCoordinate - this.mOrientationHelper.getStartAfterPadding();
        } else {
            int unused3 = this.mLayoutState.mAvailable = (this.mParent.getWidth() - anchorInfo.mCoordinate) - this.mOrientationHelper.getStartAfterPadding();
        }
        int unused4 = this.mLayoutState.mPosition = anchorInfo.mPosition;
        int unused5 = this.mLayoutState.mItemDirection = 1;
        int unused6 = this.mLayoutState.mLayoutDirection = -1;
        int unused7 = this.mLayoutState.mOffset = anchorInfo.mCoordinate;
        int unused8 = this.mLayoutState.mScrollingOffset = Integer.MIN_VALUE;
        int unused9 = this.mLayoutState.mFlexLinePosition = anchorInfo.mFlexLinePosition;
        if (fromPreviousLine && anchorInfo.mFlexLinePosition > 0 && this.mFlexLines.size() > anchorInfo.mFlexLinePosition) {
            LayoutState.access$1510(this.mLayoutState);
            LayoutState layoutState = this.mLayoutState;
            int unused10 = layoutState.mPosition = layoutState.mPosition - this.mFlexLines.get(anchorInfo.mFlexLinePosition).getItemCount();
        }
    }

    private void resolveInfiniteAmount() {
        int crossMode;
        if (isMainAxisDirectionHorizontal()) {
            crossMode = getHeightMode();
        } else {
            crossMode = getWidthMode();
        }
        boolean unused = this.mLayoutState.mInfinite = crossMode == 0 || crossMode == Integer.MIN_VALUE;
    }

    private void ensureOrientationHelper() {
        if (this.mOrientationHelper == null) {
            if (isMainAxisDirectionHorizontal()) {
                if (this.mFlexWrap == 0) {
                    this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                    this.mSubOrientationHelper = OrientationHelper.createVerticalHelper(this);
                    return;
                }
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.mSubOrientationHelper = OrientationHelper.createHorizontalHelper(this);
            } else if (this.mFlexWrap == 0) {
                this.mOrientationHelper = OrientationHelper.createVerticalHelper(this);
                this.mSubOrientationHelper = OrientationHelper.createHorizontalHelper(this);
            } else {
                this.mOrientationHelper = OrientationHelper.createHorizontalHelper(this);
                this.mSubOrientationHelper = OrientationHelper.createVerticalHelper(this);
            }
        }
    }

    private void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = new LayoutState();
        }
    }

    public void scrollToPosition(int position) {
        this.mPendingScrollPosition = position;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        LinearSmoothScroller smoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        smoothScroller.setTargetPosition(position);
        startSmoothScroll(smoothScroller);
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public void setRecycleChildrenOnDetach(boolean recycleChildrenOnDetach) {
        this.mRecycleChildrenOnDetach = recycleChildrenOnDetach;
    }

    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.mParent = (View) recyclerView.getParent();
    }

    public void onDetachedFromWindow(RecyclerView view, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(view, recycler);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    public boolean canScrollHorizontally() {
        if (this.mFlexWrap == 0) {
            return isMainAxisDirectionHorizontal();
        }
        if (isMainAxisDirectionHorizontal()) {
            int width = getWidth();
            View view = this.mParent;
            return width > (view != null ? view.getWidth() : 0);
        }
    }

    public boolean canScrollVertically() {
        if (this.mFlexWrap == 0) {
            return !isMainAxisDirectionHorizontal();
        }
        if (isMainAxisDirectionHorizontal()) {
            return true;
        }
        int height = getHeight();
        View view = this.mParent;
        if (height > (view != null ? view.getHeight() : 0)) {
            return true;
        }
        return false;
    }

    public int scrollHorizontallyBy(int dx, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!isMainAxisDirectionHorizontal() || (this.mFlexWrap == 0 && isMainAxisDirectionHorizontal())) {
            int scrolled = handleScrollingMainOrientation(dx, recycler, state);
            this.mViewCache.clear();
            return scrolled;
        }
        int scrolled2 = handleScrollingSubOrientation(dx);
        AnchorInfo anchorInfo = this.mAnchorInfo;
        int unused = anchorInfo.mPerpendicularCoordinate = anchorInfo.mPerpendicularCoordinate + scrolled2;
        this.mSubOrientationHelper.offsetChildren(-scrolled2);
        return scrolled2;
    }

    public int scrollVerticallyBy(int dy, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (isMainAxisDirectionHorizontal() || (this.mFlexWrap == 0 && !isMainAxisDirectionHorizontal())) {
            int scrolled = handleScrollingMainOrientation(dy, recycler, state);
            this.mViewCache.clear();
            return scrolled;
        }
        int scrolled2 = handleScrollingSubOrientation(dy);
        AnchorInfo anchorInfo = this.mAnchorInfo;
        int unused = anchorInfo.mPerpendicularCoordinate = anchorInfo.mPerpendicularCoordinate + scrolled2;
        this.mSubOrientationHelper.offsetChildren(-scrolled2);
        return scrolled2;
    }

    private int handleScrollingMainOrientation(int delta, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int scrolled;
        if (getChildCount() == 0 || delta == 0) {
            return 0;
        }
        ensureOrientationHelper();
        int layoutDirection = 1;
        boolean unused = this.mLayoutState.mShouldRecycle = true;
        boolean columnAndRtl = !isMainAxisDirectionHorizontal() && this.mIsRtl;
        if (columnAndRtl) {
            if (delta >= 0) {
                layoutDirection = -1;
            }
        } else if (delta <= 0) {
            layoutDirection = -1;
        }
        int absDelta = Math.abs(delta);
        updateLayoutState(layoutDirection, absDelta);
        int consumed = fill(recycler, state, this.mLayoutState) + this.mLayoutState.mScrollingOffset;
        if (consumed < 0) {
            return 0;
        }
        if (columnAndRtl) {
            scrolled = absDelta > consumed ? (-layoutDirection) * consumed : delta;
        } else {
            scrolled = absDelta > consumed ? layoutDirection * consumed : delta;
        }
        this.mOrientationHelper.offsetChildren(-scrolled);
        int unused2 = this.mLayoutState.mLastScrollDelta = scrolled;
        return scrolled;
    }

    private int handleScrollingSubOrientation(int delta) {
        int delta2;
        boolean layoutRtl = false;
        if (getChildCount() == 0 || delta == 0) {
            return 0;
        }
        ensureOrientationHelper();
        boolean isMainAxisHorizontal = isMainAxisDirectionHorizontal();
        View view = this.mParent;
        int parentLength = isMainAxisHorizontal ? view.getWidth() : view.getHeight();
        int mainAxisLength = isMainAxisHorizontal ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            layoutRtl = true;
        }
        if (layoutRtl) {
            int absDelta = Math.abs(delta);
            if (delta < 0) {
                return -Math.min((this.mAnchorInfo.mPerpendicularCoordinate + mainAxisLength) - parentLength, absDelta);
            }
            return this.mAnchorInfo.mPerpendicularCoordinate + delta > 0 ? -this.mAnchorInfo.mPerpendicularCoordinate : delta;
        } else if (delta > 0) {
            return Math.min((mainAxisLength - this.mAnchorInfo.mPerpendicularCoordinate) - parentLength, delta);
        } else {
            if (this.mAnchorInfo.mPerpendicularCoordinate + delta >= 0) {
                delta2 = delta;
            } else {
                delta2 = -this.mAnchorInfo.mPerpendicularCoordinate;
            }
            return delta2;
        }
    }

    private void updateLayoutState(int layoutDirection, int absDelta) {
        int i = layoutDirection;
        if (this.mFlexboxHelper.mIndexToFlexLine != null) {
            int unused = this.mLayoutState.mLayoutDirection = i;
            boolean mainAxisHorizontal = isMainAxisDirectionHorizontal();
            int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
            int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
            boolean columnAndRtl = !mainAxisHorizontal && this.mIsRtl;
            if (i == 1) {
                View lastVisible = getChildAt(getChildCount() - 1);
                int unused2 = this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedEnd(lastVisible);
                int lastVisiblePosition = getPosition(lastVisible);
                FlexLine lastVisibleLine = this.mFlexLines.get(this.mFlexboxHelper.mIndexToFlexLine[lastVisiblePosition]);
                View referenceView = findLastReferenceViewInLine(lastVisible, lastVisibleLine);
                int unused3 = this.mLayoutState.mItemDirection = 1;
                LayoutState layoutState = this.mLayoutState;
                int unused4 = layoutState.mPosition = layoutState.mItemDirection + lastVisiblePosition;
                if (this.mFlexboxHelper.mIndexToFlexLine.length <= this.mLayoutState.mPosition) {
                    int unused5 = this.mLayoutState.mFlexLinePosition = -1;
                } else {
                    int unused6 = this.mLayoutState.mFlexLinePosition = this.mFlexboxHelper.mIndexToFlexLine[this.mLayoutState.mPosition];
                }
                if (columnAndRtl) {
                    int unused7 = this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedStart(referenceView);
                    int unused8 = this.mLayoutState.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(referenceView)) + this.mOrientationHelper.getStartAfterPadding();
                    LayoutState layoutState2 = this.mLayoutState;
                    int unused9 = layoutState2.mScrollingOffset = layoutState2.mScrollingOffset >= 0 ? this.mLayoutState.mScrollingOffset : 0;
                } else {
                    int unused10 = this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedEnd(referenceView);
                    int unused11 = this.mLayoutState.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(referenceView) - this.mOrientationHelper.getEndAfterPadding();
                }
                if (this.mLayoutState.mFlexLinePosition == -1 || this.mLayoutState.mFlexLinePosition > this.mFlexLines.size() - 1) {
                    if (this.mLayoutState.mPosition <= getFlexItemCount()) {
                        int needsToFill = absDelta - this.mLayoutState.mScrollingOffset;
                        this.mFlexLinesResult.reset();
                        if (needsToFill > 0) {
                            if (mainAxisHorizontal) {
                                View view = referenceView;
                                FlexLine flexLine = lastVisibleLine;
                                this.mFlexboxHelper.calculateHorizontalFlexLines(this.mFlexLinesResult, widthMeasureSpec, heightMeasureSpec, needsToFill, this.mLayoutState.mPosition, this.mFlexLines);
                            } else {
                                FlexLine flexLine2 = lastVisibleLine;
                                this.mFlexboxHelper.calculateVerticalFlexLines(this.mFlexLinesResult, widthMeasureSpec, heightMeasureSpec, needsToFill, this.mLayoutState.mPosition, this.mFlexLines);
                            }
                            this.mFlexboxHelper.determineMainSize(widthMeasureSpec, heightMeasureSpec, this.mLayoutState.mPosition);
                            this.mFlexboxHelper.stretchViews(this.mLayoutState.mPosition);
                        } else {
                            FlexLine flexLine3 = lastVisibleLine;
                        }
                    } else {
                        FlexLine flexLine4 = lastVisibleLine;
                    }
                }
            } else {
                int i2 = 0;
                View firstVisible = getChildAt(0);
                int unused12 = this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedStart(firstVisible);
                int firstVisiblePosition = getPosition(firstVisible);
                View referenceView2 = findFirstReferenceViewInLine(firstVisible, this.mFlexLines.get(this.mFlexboxHelper.mIndexToFlexLine[firstVisiblePosition]));
                int unused13 = this.mLayoutState.mItemDirection = 1;
                int flexLinePosition = this.mFlexboxHelper.mIndexToFlexLine[firstVisiblePosition];
                if (flexLinePosition == -1) {
                    flexLinePosition = 0;
                }
                if (flexLinePosition > 0) {
                    int unused14 = this.mLayoutState.mPosition = firstVisiblePosition - this.mFlexLines.get(flexLinePosition - 1).getItemCount();
                } else {
                    int unused15 = this.mLayoutState.mPosition = -1;
                }
                int unused16 = this.mLayoutState.mFlexLinePosition = flexLinePosition > 0 ? flexLinePosition - 1 : 0;
                if (columnAndRtl) {
                    int unused17 = this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedEnd(referenceView2);
                    int unused18 = this.mLayoutState.mScrollingOffset = this.mOrientationHelper.getDecoratedEnd(referenceView2) - this.mOrientationHelper.getEndAfterPadding();
                    LayoutState layoutState3 = this.mLayoutState;
                    if (layoutState3.mScrollingOffset >= 0) {
                        i2 = this.mLayoutState.mScrollingOffset;
                    }
                    int unused19 = layoutState3.mScrollingOffset = i2;
                } else {
                    int unused20 = this.mLayoutState.mOffset = this.mOrientationHelper.getDecoratedStart(referenceView2);
                    int unused21 = this.mLayoutState.mScrollingOffset = (-this.mOrientationHelper.getDecoratedStart(referenceView2)) + this.mOrientationHelper.getStartAfterPadding();
                }
            }
            LayoutState layoutState4 = this.mLayoutState;
            int unused22 = layoutState4.mAvailable = absDelta - layoutState4.mScrollingOffset;
            return;
        }
        throw new AssertionError();
    }

    private View findFirstReferenceViewInLine(View firstView, FlexLine firstVisibleLine) {
        boolean mainAxisHorizontal = isMainAxisDirectionHorizontal();
        View referenceView = firstView;
        int to = firstVisibleLine.mItemCount;
        for (int i = 1; i < to; i++) {
            View viewInSameLine = getChildAt(i);
            if (!(viewInSameLine == null || viewInSameLine.getVisibility() == 8)) {
                if (!this.mIsRtl || mainAxisHorizontal) {
                    if (this.mOrientationHelper.getDecoratedStart(referenceView) > this.mOrientationHelper.getDecoratedStart(viewInSameLine)) {
                        referenceView = viewInSameLine;
                    }
                } else if (this.mOrientationHelper.getDecoratedEnd(referenceView) < this.mOrientationHelper.getDecoratedEnd(viewInSameLine)) {
                    referenceView = viewInSameLine;
                }
            }
        }
        return referenceView;
    }

    private View findLastReferenceViewInLine(View lastView, FlexLine lastVisibleLine) {
        boolean mainAxisHorizontal = isMainAxisDirectionHorizontal();
        View referenceView = lastView;
        int to = (getChildCount() - lastVisibleLine.mItemCount) - 1;
        for (int i = getChildCount() - 2; i > to; i--) {
            View viewInSameLine = getChildAt(i);
            if (!(viewInSameLine == null || viewInSameLine.getVisibility() == 8)) {
                if (!this.mIsRtl || mainAxisHorizontal) {
                    if (this.mOrientationHelper.getDecoratedEnd(referenceView) < this.mOrientationHelper.getDecoratedEnd(viewInSameLine)) {
                        referenceView = viewInSameLine;
                    }
                } else if (this.mOrientationHelper.getDecoratedStart(referenceView) > this.mOrientationHelper.getDecoratedStart(viewInSameLine)) {
                    referenceView = viewInSameLine;
                }
            }
        }
        return referenceView;
    }

    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int allChildrenCount = state.getItemCount();
        ensureOrientationHelper();
        View firstReferenceView = findFirstReferenceChild(allChildrenCount);
        View lastReferenceView = findLastReferenceChild(allChildrenCount);
        if (state.getItemCount() == 0 || firstReferenceView == null || lastReferenceView == null) {
            return 0;
        }
        return Math.min(this.mOrientationHelper.getTotalSpace(), this.mOrientationHelper.getDecoratedEnd(lastReferenceView) - this.mOrientationHelper.getDecoratedStart(firstReferenceView));
    }

    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int allChildrenCount = state.getItemCount();
        View firstReferenceView = findFirstReferenceChild(allChildrenCount);
        View lastReferenceView = findLastReferenceChild(allChildrenCount);
        if (state.getItemCount() == 0 || firstReferenceView == null || lastReferenceView == null) {
            return 0;
        }
        if (this.mFlexboxHelper.mIndexToFlexLine != null) {
            int minPosition = getPosition(firstReferenceView);
            int maxPosition = getPosition(lastReferenceView);
            int laidOutArea = Math.abs(this.mOrientationHelper.getDecoratedEnd(lastReferenceView) - this.mOrientationHelper.getDecoratedStart(firstReferenceView));
            int firstLinePosition = this.mFlexboxHelper.mIndexToFlexLine[minPosition];
            if (firstLinePosition == 0 || firstLinePosition == -1) {
                return 0;
            }
            return Math.round((((float) firstLinePosition) * (((float) laidOutArea) / ((float) ((this.mFlexboxHelper.mIndexToFlexLine[maxPosition] - firstLinePosition) + 1)))) + ((float) (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(firstReferenceView))));
        }
        throw new AssertionError();
    }

    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int allItemCount = state.getItemCount();
        View firstReferenceView = findFirstReferenceChild(allItemCount);
        View lastReferenceView = findLastReferenceChild(allItemCount);
        if (state.getItemCount() == 0 || firstReferenceView == null || lastReferenceView == null) {
            return 0;
        }
        if (this.mFlexboxHelper.mIndexToFlexLine != null) {
            int firstVisiblePosition = findFirstVisibleItemPosition();
            return (int) ((((float) Math.abs(this.mOrientationHelper.getDecoratedEnd(lastReferenceView) - this.mOrientationHelper.getDecoratedStart(firstReferenceView))) / ((float) ((findLastVisibleItemPosition() - firstVisiblePosition) + 1))) * ((float) state.getItemCount()));
        }
        throw new AssertionError();
    }

    private boolean shouldMeasureChild(View child, int widthSpec, int heightSpec, RecyclerView.LayoutParams lp) {
        return child.isLayoutRequested() || !isMeasurementCacheEnabled() || !isMeasurementUpToDate(child.getWidth(), widthSpec, lp.width) || !isMeasurementUpToDate(child.getHeight(), heightSpec, lp.height);
    }

    private static boolean isMeasurementUpToDate(int childSize, int spec, int dimension) {
        int specMode = View.MeasureSpec.getMode(spec);
        int specSize = View.MeasureSpec.getSize(spec);
        if (dimension > 0 && childSize != dimension) {
            return false;
        }
        if (specMode != Integer.MIN_VALUE) {
            if (specMode == 0) {
                return true;
            }
            if (specMode == 1073741824 && specSize == childSize) {
                return true;
            }
            return false;
        } else if (specSize >= childSize) {
            return true;
        } else {
            return false;
        }
    }

    private void clearFlexLines() {
        this.mFlexLines.clear();
        this.mAnchorInfo.reset();
        int unused = this.mAnchorInfo.mPerpendicularCoordinate = 0;
    }

    private int getChildLeft(View view) {
        return getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
    }

    private int getChildRight(View view) {
        return getDecoratedRight(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin;
    }

    private int getChildTop(View view) {
        return getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
    }

    private int getChildBottom(View view) {
        return getDecoratedBottom(view) + ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin;
    }

    private boolean isViewVisible(View view, boolean completelyVisible) {
        int left = getPaddingLeft();
        int top = getPaddingTop();
        int right = getWidth() - getPaddingRight();
        int bottom = getHeight() - getPaddingBottom();
        int childLeft = getChildLeft(view);
        int childTop = getChildTop(view);
        int childRight = getChildRight(view);
        int childBottom = getChildBottom(view);
        boolean horizontalCompletelyVisible = false;
        boolean horizontalPartiallyVisible = false;
        boolean verticalCompletelyVisible = false;
        boolean verticalPartiallyVisible = false;
        if (left <= childLeft && right >= childRight) {
            horizontalCompletelyVisible = true;
        }
        if (childLeft >= right || childRight >= left) {
            horizontalPartiallyVisible = true;
        }
        if (top <= childTop && bottom >= childBottom) {
            verticalCompletelyVisible = true;
        }
        if (childTop >= bottom || childBottom >= top) {
            verticalPartiallyVisible = true;
        }
        if (completelyVisible) {
            if (!horizontalCompletelyVisible || !verticalCompletelyVisible) {
                return false;
            }
            return true;
        } else if (!horizontalPartiallyVisible || !verticalPartiallyVisible) {
            return false;
        } else {
            return true;
        }
    }

    public int findFirstVisibleItemPosition() {
        View child = findOneVisibleChild(0, getChildCount(), false);
        if (child == null) {
            return -1;
        }
        return getPosition(child);
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View child = findOneVisibleChild(0, getChildCount(), true);
        if (child == null) {
            return -1;
        }
        return getPosition(child);
    }

    public int findLastVisibleItemPosition() {
        View child = findOneVisibleChild(getChildCount() - 1, -1, false);
        if (child == null) {
            return -1;
        }
        return getPosition(child);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View child = findOneVisibleChild(getChildCount() - 1, -1, true);
        if (child == null) {
            return -1;
        }
        return getPosition(child);
    }

    private View findOneVisibleChild(int fromIndex, int toIndex, boolean completelyVisible) {
        int next = toIndex > fromIndex ? 1 : -1;
        for (int i = fromIndex; i != toIndex; i += next) {
            View view = getChildAt(i);
            if (isViewVisible(view, completelyVisible)) {
                return view;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public int getPositionToFlexLineIndex(int position) {
        if (this.mFlexboxHelper.mIndexToFlexLine != null) {
            return this.mFlexboxHelper.mIndexToFlexLine[position];
        }
        throw new AssertionError();
    }

    public static class LayoutParams extends RecyclerView.LayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new Parcelable.Creator<LayoutParams>() {
            public LayoutParams createFromParcel(Parcel source) {
                return new LayoutParams(source);
            }

            public LayoutParams[] newArray(int size) {
                return new LayoutParams[size];
            }
        };
        private int mAlignSelf = -1;
        private float mFlexBasisPercent = -1.0f;
        private float mFlexGrow = 0.0f;
        private float mFlexShrink = 1.0f;
        private int mMaxHeight = 16777215;
        private int mMaxWidth = 16777215;
        private int mMinHeight;
        private int mMinWidth;
        private boolean mWrapBefore;

        public int getWidth() {
            return this.width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return this.height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public float getFlexGrow() {
            return this.mFlexGrow;
        }

        public void setFlexGrow(float flexGrow) {
            this.mFlexGrow = flexGrow;
        }

        public float getFlexShrink() {
            return this.mFlexShrink;
        }

        public void setFlexShrink(float flexShrink) {
            this.mFlexShrink = flexShrink;
        }

        public int getAlignSelf() {
            return this.mAlignSelf;
        }

        public void setAlignSelf(int alignSelf) {
            this.mAlignSelf = alignSelf;
        }

        public int getMinWidth() {
            return this.mMinWidth;
        }

        public void setMinWidth(int minWidth) {
            this.mMinWidth = minWidth;
        }

        public int getMinHeight() {
            return this.mMinHeight;
        }

        public void setMinHeight(int minHeight) {
            this.mMinHeight = minHeight;
        }

        public int getMaxWidth() {
            return this.mMaxWidth;
        }

        public void setMaxWidth(int maxWidth) {
            this.mMaxWidth = maxWidth;
        }

        public int getMaxHeight() {
            return this.mMaxHeight;
        }

        public void setMaxHeight(int maxHeight) {
            this.mMaxHeight = maxHeight;
        }

        public boolean isWrapBefore() {
            return this.mWrapBefore;
        }

        public void setWrapBefore(boolean wrapBefore) {
            this.mWrapBefore = wrapBefore;
        }

        public float getFlexBasisPercent() {
            return this.mFlexBasisPercent;
        }

        public void setFlexBasisPercent(float flexBasisPercent) {
            this.mFlexBasisPercent = flexBasisPercent;
        }

        public int getMarginLeft() {
            return this.leftMargin;
        }

        public int getMarginTop() {
            return this.topMargin;
        }

        public int getMarginRight() {
            return this.rightMargin;
        }

        public int getMarginBottom() {
            return this.bottomMargin;
        }

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
        }

        public LayoutParams(int width, int height) {
            super(width, height);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }

        public LayoutParams(RecyclerView.LayoutParams source) {
            super(source);
        }

        public LayoutParams(LayoutParams source) {
            super((RecyclerView.LayoutParams) source);
            this.mFlexGrow = source.mFlexGrow;
            this.mFlexShrink = source.mFlexShrink;
            this.mAlignSelf = source.mAlignSelf;
            this.mFlexBasisPercent = source.mFlexBasisPercent;
            this.mMinWidth = source.mMinWidth;
            this.mMinHeight = source.mMinHeight;
            this.mMaxWidth = source.mMaxWidth;
            this.mMaxHeight = source.mMaxHeight;
            this.mWrapBefore = source.mWrapBefore;
        }

        public int getOrder() {
            return 1;
        }

        public void setOrder(int order) {
            throw new UnsupportedOperationException("Setting the order in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to reorder using the attribute.");
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeFloat(this.mFlexGrow);
            dest.writeFloat(this.mFlexShrink);
            dest.writeInt(this.mAlignSelf);
            dest.writeFloat(this.mFlexBasisPercent);
            dest.writeInt(this.mMinWidth);
            dest.writeInt(this.mMinHeight);
            dest.writeInt(this.mMaxWidth);
            dest.writeInt(this.mMaxHeight);
            dest.writeByte(this.mWrapBefore ? (byte) 1 : 0);
            dest.writeInt(this.bottomMargin);
            dest.writeInt(this.leftMargin);
            dest.writeInt(this.rightMargin);
            dest.writeInt(this.topMargin);
            dest.writeInt(this.height);
            dest.writeInt(this.width);
        }

        protected LayoutParams(Parcel in) {
            super(-2, -2);
            this.mFlexGrow = in.readFloat();
            this.mFlexShrink = in.readFloat();
            this.mAlignSelf = in.readInt();
            this.mFlexBasisPercent = in.readFloat();
            this.mMinWidth = in.readInt();
            this.mMinHeight = in.readInt();
            this.mMaxWidth = in.readInt();
            this.mMaxHeight = in.readInt();
            this.mWrapBefore = in.readByte() != 0;
            this.bottomMargin = in.readInt();
            this.leftMargin = in.readInt();
            this.rightMargin = in.readInt();
            this.topMargin = in.readInt();
            this.height = in.readInt();
            this.width = in.readInt();
        }
    }

    private class AnchorInfo {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        /* access modifiers changed from: private */
        public boolean mAssignedFromSavedState;
        /* access modifiers changed from: private */
        public int mCoordinate;
        /* access modifiers changed from: private */
        public int mFlexLinePosition;
        /* access modifiers changed from: private */
        public boolean mLayoutFromEnd;
        /* access modifiers changed from: private */
        public int mPerpendicularCoordinate;
        /* access modifiers changed from: private */
        public int mPosition;
        /* access modifiers changed from: private */
        public boolean mValid;

        static {
            Class<FlexboxLayoutManager> cls = FlexboxLayoutManager.class;
        }

        private AnchorInfo() {
            this.mPerpendicularCoordinate = 0;
        }

        /* access modifiers changed from: private */
        public void reset() {
            this.mPosition = -1;
            this.mFlexLinePosition = -1;
            this.mCoordinate = Integer.MIN_VALUE;
            boolean z = false;
            this.mValid = false;
            this.mAssignedFromSavedState = false;
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal()) {
                if (FlexboxLayoutManager.this.mFlexWrap == 0) {
                    if (FlexboxLayoutManager.this.mFlexDirection == 1) {
                        z = true;
                    }
                    this.mLayoutFromEnd = z;
                    return;
                }
                if (FlexboxLayoutManager.this.mFlexWrap == 2) {
                    z = true;
                }
                this.mLayoutFromEnd = z;
            } else if (FlexboxLayoutManager.this.mFlexWrap == 0) {
                if (FlexboxLayoutManager.this.mFlexDirection == 3) {
                    z = true;
                }
                this.mLayoutFromEnd = z;
            } else {
                if (FlexboxLayoutManager.this.mFlexWrap == 2) {
                    z = true;
                }
                this.mLayoutFromEnd = z;
            }
        }

        /* access modifiers changed from: private */
        public void assignCoordinateFromPadding() {
            int i;
            int i2;
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal() || !FlexboxLayoutManager.this.mIsRtl) {
                if (this.mLayoutFromEnd) {
                    i = FlexboxLayoutManager.this.mOrientationHelper.getEndAfterPadding();
                } else {
                    i = FlexboxLayoutManager.this.mOrientationHelper.getStartAfterPadding();
                }
                this.mCoordinate = i;
                return;
            }
            if (this.mLayoutFromEnd) {
                i2 = FlexboxLayoutManager.this.mOrientationHelper.getEndAfterPadding();
            } else {
                i2 = FlexboxLayoutManager.this.getWidth() - FlexboxLayoutManager.this.mOrientationHelper.getStartAfterPadding();
            }
            this.mCoordinate = i2;
        }

        /* access modifiers changed from: private */
        public void assignFromView(View anchor) {
            OrientationHelper orientationHelper;
            if (FlexboxLayoutManager.this.mFlexWrap == 0) {
                orientationHelper = FlexboxLayoutManager.this.mSubOrientationHelper;
            } else {
                orientationHelper = FlexboxLayoutManager.this.mOrientationHelper;
            }
            if (FlexboxLayoutManager.this.isMainAxisDirectionHorizontal() || !FlexboxLayoutManager.this.mIsRtl) {
                if (this.mLayoutFromEnd) {
                    this.mCoordinate = orientationHelper.getDecoratedEnd(anchor) + orientationHelper.getTotalSpaceChange();
                } else {
                    this.mCoordinate = orientationHelper.getDecoratedStart(anchor);
                }
            } else if (this.mLayoutFromEnd) {
                this.mCoordinate = orientationHelper.getDecoratedStart(anchor) + orientationHelper.getTotalSpaceChange();
            } else {
                this.mCoordinate = orientationHelper.getDecoratedEnd(anchor);
            }
            this.mPosition = FlexboxLayoutManager.this.getPosition(anchor);
            int i = 0;
            this.mAssignedFromSavedState = false;
            if (FlexboxLayoutManager.this.mFlexboxHelper.mIndexToFlexLine != null) {
                int[] iArr = FlexboxLayoutManager.this.mFlexboxHelper.mIndexToFlexLine;
                int i2 = this.mPosition;
                if (i2 == -1) {
                    i2 = 0;
                }
                int flexLinePosition = iArr[i2];
                if (flexLinePosition != -1) {
                    i = flexLinePosition;
                }
                this.mFlexLinePosition = i;
                if (FlexboxLayoutManager.this.mFlexLines.size() > this.mFlexLinePosition) {
                    this.mPosition = ((FlexLine) FlexboxLayoutManager.this.mFlexLines.get(this.mFlexLinePosition)).mFirstIndex;
                    return;
                }
                return;
            }
            throw new AssertionError();
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mFlexLinePosition=" + this.mFlexLinePosition + ", mCoordinate=" + this.mCoordinate + ", mPerpendicularCoordinate=" + this.mPerpendicularCoordinate + ", mLayoutFromEnd=" + this.mLayoutFromEnd + ", mValid=" + this.mValid + ", mAssignedFromSavedState=" + this.mAssignedFromSavedState + '}';
        }
    }

    private static class LayoutState {
        private static final int ITEM_DIRECTION_TAIL = 1;
        private static final int LAYOUT_END = 1;
        private static final int LAYOUT_START = -1;
        private static final int SCROLLING_OFFSET_NaN = Integer.MIN_VALUE;
        /* access modifiers changed from: private */
        public int mAvailable;
        /* access modifiers changed from: private */
        public int mFlexLinePosition;
        /* access modifiers changed from: private */
        public boolean mInfinite;
        /* access modifiers changed from: private */
        public int mItemDirection;
        /* access modifiers changed from: private */
        public int mLastScrollDelta;
        /* access modifiers changed from: private */
        public int mLayoutDirection;
        /* access modifiers changed from: private */
        public int mOffset;
        /* access modifiers changed from: private */
        public int mPosition;
        /* access modifiers changed from: private */
        public int mScrollingOffset;
        /* access modifiers changed from: private */
        public boolean mShouldRecycle;

        private LayoutState() {
            this.mItemDirection = 1;
            this.mLayoutDirection = 1;
        }

        static /* synthetic */ int access$1508(LayoutState x0) {
            int i = x0.mFlexLinePosition;
            x0.mFlexLinePosition = i + 1;
            return i;
        }

        static /* synthetic */ int access$1510(LayoutState x0) {
            int i = x0.mFlexLinePosition;
            x0.mFlexLinePosition = i - 1;
            return i;
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000a, code lost:
            r0 = r2.mFlexLinePosition;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean hasMore(androidx.recyclerview.widget.RecyclerView.State r3, java.util.List<com.google.android.flexbox.FlexLine> r4) {
            /*
                r2 = this;
                int r0 = r2.mPosition
                if (r0 < 0) goto L_0x0016
                int r1 = r3.getItemCount()
                if (r0 >= r1) goto L_0x0016
                int r0 = r2.mFlexLinePosition
                if (r0 < 0) goto L_0x0016
                int r1 = r4.size()
                if (r0 >= r1) goto L_0x0016
                r0 = 1
                goto L_0x0017
            L_0x0016:
                r0 = 0
            L_0x0017:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.LayoutState.hasMore(androidx.recyclerview.widget.RecyclerView$State, java.util.List):boolean");
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.mAvailable + ", mFlexLinePosition=" + this.mFlexLinePosition + ", mPosition=" + this.mPosition + ", mOffset=" + this.mOffset + ", mScrollingOffset=" + this.mScrollingOffset + ", mLastScrollDelta=" + this.mLastScrollDelta + ", mItemDirection=" + this.mItemDirection + ", mLayoutDirection=" + this.mLayoutDirection + '}';
        }
    }

    private static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel source) {
                return new SavedState(source);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
        /* access modifiers changed from: private */
        public int mAnchorOffset;
        /* access modifiers changed from: private */
        public int mAnchorPosition;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.mAnchorPosition);
            dest.writeInt(this.mAnchorOffset);
        }

        SavedState() {
        }

        private SavedState(Parcel in) {
            this.mAnchorPosition = in.readInt();
            this.mAnchorOffset = in.readInt();
        }

        private SavedState(SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
        }

        /* access modifiers changed from: private */
        public void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        /* access modifiers changed from: private */
        public boolean hasValidAnchor(int itemCount) {
            int i = this.mAnchorPosition;
            return i >= 0 && i < itemCount;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.mAnchorPosition + ", mAnchorOffset=" + this.mAnchorOffset + '}';
        }
    }
}
