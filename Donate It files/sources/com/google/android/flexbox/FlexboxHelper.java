package com.google.android.flexbox;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.widget.CompoundButtonCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class FlexboxHelper {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int INITIAL_CAPACITY = 10;
    private static final long MEASURE_SPEC_WIDTH_MASK = 4294967295L;
    private boolean[] mChildrenFrozen;
    private final FlexContainer mFlexContainer;
    int[] mIndexToFlexLine;
    long[] mMeasureSpecCache;
    private long[] mMeasuredSizeCache;

    FlexboxHelper(FlexContainer flexContainer) {
        this.mFlexContainer = flexContainer;
    }

    /* access modifiers changed from: package-private */
    public int[] createReorderedIndices(View viewBeforeAdded, int indexForViewBeforeAdded, ViewGroup.LayoutParams paramsForViewBeforeAdded, SparseIntArray orderCache) {
        int childCount = this.mFlexContainer.getFlexItemCount();
        List<Order> orders = createOrders(childCount);
        Order orderForViewToBeAdded = new Order();
        if (viewBeforeAdded == null || !(paramsForViewBeforeAdded instanceof FlexItem)) {
            orderForViewToBeAdded.order = 1;
        } else {
            orderForViewToBeAdded.order = ((FlexItem) paramsForViewBeforeAdded).getOrder();
        }
        if (indexForViewBeforeAdded == -1 || indexForViewBeforeAdded == childCount) {
            orderForViewToBeAdded.index = childCount;
        } else if (indexForViewBeforeAdded < this.mFlexContainer.getFlexItemCount()) {
            orderForViewToBeAdded.index = indexForViewBeforeAdded;
            for (int i = indexForViewBeforeAdded; i < childCount; i++) {
                orders.get(i).index++;
            }
        } else {
            orderForViewToBeAdded.index = childCount;
        }
        orders.add(orderForViewToBeAdded);
        return sortOrdersIntoReorderedIndices(childCount + 1, orders, orderCache);
    }

    /* access modifiers changed from: package-private */
    public int[] createReorderedIndices(SparseIntArray orderCache) {
        int childCount = this.mFlexContainer.getFlexItemCount();
        return sortOrdersIntoReorderedIndices(childCount, createOrders(childCount), orderCache);
    }

    private List<Order> createOrders(int childCount) {
        List<Order> orders = new ArrayList<>(childCount);
        for (int i = 0; i < childCount; i++) {
            Order order = new Order();
            order.order = ((FlexItem) this.mFlexContainer.getFlexItemAt(i).getLayoutParams()).getOrder();
            order.index = i;
            orders.add(order);
        }
        return orders;
    }

    /* access modifiers changed from: package-private */
    public boolean isOrderChangedFromLastMeasurement(SparseIntArray orderCache) {
        int childCount = this.mFlexContainer.getFlexItemCount();
        if (orderCache.size() != childCount) {
            return true;
        }
        for (int i = 0; i < childCount; i++) {
            View view = this.mFlexContainer.getFlexItemAt(i);
            if (view != null && ((FlexItem) view.getLayoutParams()).getOrder() != orderCache.get(i)) {
                return true;
            }
        }
        return false;
    }

    private int[] sortOrdersIntoReorderedIndices(int childCount, List<Order> orders, SparseIntArray orderCache) {
        Collections.sort(orders);
        orderCache.clear();
        int[] reorderedIndices = new int[childCount];
        int i = 0;
        for (Order order : orders) {
            reorderedIndices[i] = order.index;
            orderCache.append(order.index, order.order);
            i++;
        }
        return reorderedIndices;
    }

    /* access modifiers changed from: package-private */
    public void calculateHorizontalFlexLines(FlexLinesResult result, int widthMeasureSpec, int heightMeasureSpec) {
        calculateFlexLines(result, widthMeasureSpec, heightMeasureSpec, Integer.MAX_VALUE, 0, -1, (List<FlexLine>) null);
    }

    /* access modifiers changed from: package-private */
    public void calculateHorizontalFlexLines(FlexLinesResult result, int widthMeasureSpec, int heightMeasureSpec, int needsCalcAmount, int fromIndex, List<FlexLine> existingLines) {
        calculateFlexLines(result, widthMeasureSpec, heightMeasureSpec, needsCalcAmount, fromIndex, -1, existingLines);
    }

    /* access modifiers changed from: package-private */
    public void calculateHorizontalFlexLinesToIndex(FlexLinesResult result, int widthMeasureSpec, int heightMeasureSpec, int needsCalcAmount, int toIndex, List<FlexLine> existingLines) {
        calculateFlexLines(result, widthMeasureSpec, heightMeasureSpec, needsCalcAmount, 0, toIndex, existingLines);
    }

    /* access modifiers changed from: package-private */
    public void calculateVerticalFlexLines(FlexLinesResult result, int widthMeasureSpec, int heightMeasureSpec) {
        calculateFlexLines(result, heightMeasureSpec, widthMeasureSpec, Integer.MAX_VALUE, 0, -1, (List<FlexLine>) null);
    }

    /* access modifiers changed from: package-private */
    public void calculateVerticalFlexLines(FlexLinesResult result, int widthMeasureSpec, int heightMeasureSpec, int needsCalcAmount, int fromIndex, List<FlexLine> existingLines) {
        calculateFlexLines(result, heightMeasureSpec, widthMeasureSpec, needsCalcAmount, fromIndex, -1, existingLines);
    }

    /* access modifiers changed from: package-private */
    public void calculateVerticalFlexLinesToIndex(FlexLinesResult result, int widthMeasureSpec, int heightMeasureSpec, int needsCalcAmount, int toIndex, List<FlexLine> existingLines) {
        calculateFlexLines(result, heightMeasureSpec, widthMeasureSpec, needsCalcAmount, 0, toIndex, existingLines);
    }

    /* access modifiers changed from: package-private */
    public void calculateFlexLines(FlexLinesResult result, int mainMeasureSpec, int crossMeasureSpec, int needsCalcAmount, int fromIndex, int toIndex, List<FlexLine> existingLines) {
        List<FlexLine> flexLines;
        int mainMode;
        int mainSize;
        List<FlexLine> flexLines2;
        int mainSize2;
        int childCount;
        int i;
        int childMainSize;
        List<FlexLine> flexLines3;
        int childMainMeasureSpec;
        boolean z;
        boolean z2;
        int indexInFlexLine;
        View child;
        int indexInFlexLine2;
        FlexLinesResult flexLinesResult = result;
        int i2 = mainMeasureSpec;
        int i3 = crossMeasureSpec;
        int i4 = toIndex;
        boolean isMainHorizontal = this.mFlexContainer.isMainAxisDirectionHorizontal();
        int mainMode2 = View.MeasureSpec.getMode(mainMeasureSpec);
        int mainSize3 = View.MeasureSpec.getSize(mainMeasureSpec);
        int largestSizeInCross = 0;
        if (existingLines == null) {
            flexLines = new ArrayList<>();
        } else {
            flexLines = existingLines;
        }
        flexLinesResult.mFlexLines = flexLines;
        boolean reachedToIndex = i4 == -1;
        int mainPaddingStart = getPaddingStartMain(isMainHorizontal);
        int mainPaddingEnd = getPaddingEndMain(isMainHorizontal);
        int crossPaddingStart = getPaddingStartCross(isMainHorizontal);
        int crossPaddingEnd = getPaddingEndCross(isMainHorizontal);
        FlexLine flexLine = new FlexLine();
        flexLine.mFirstIndex = fromIndex;
        flexLine.mMainSize = mainPaddingStart + mainPaddingEnd;
        int childCount2 = this.mFlexContainer.getFlexItemCount();
        int indexInFlexLine3 = 0;
        boolean reachedToIndex2 = reachedToIndex;
        int largestSizeInCross2 = Integer.MIN_VALUE;
        int largestSizeInCross3 = fromIndex;
        FlexLine flexLine2 = flexLine;
        int sumCrossSize = 0;
        FlexLine flexLine3 = flexLine2;
        while (true) {
            if (largestSizeInCross3 >= childCount2) {
                int i5 = largestSizeInCross3;
                List<FlexLine> list = flexLines;
                int i6 = mainSize3;
                int i7 = mainMode2;
                int mainSize4 = i4;
                int i8 = childCount2;
                int sumCrossSize2 = sumCrossSize;
                FlexLine flexLine4 = flexLine3;
                int i9 = sumCrossSize2;
                break;
            }
            View child2 = this.mFlexContainer.getReorderedFlexItemAt(largestSizeInCross3);
            if (child2 != null) {
                if (child2.getVisibility() != 8) {
                    if (child2 instanceof CompoundButton) {
                        evaluateMinimumSizeForCompoundButton((CompoundButton) child2);
                    }
                    FlexItem flexItem = (FlexItem) child2.getLayoutParams();
                    int childCount3 = childCount2;
                    if (flexItem.getAlignSelf() == 4) {
                        flexLine3.mIndicesAlignSelfStretch.add(Integer.valueOf(largestSizeInCross3));
                    }
                    int childMainSize2 = getFlexItemSizeMain(flexItem, isMainHorizontal);
                    if (flexItem.getFlexBasisPercent() == -1.0f || mainMode2 != 1073741824) {
                        childMainSize = childMainSize2;
                    } else {
                        childMainSize = Math.round(((float) mainSize3) * flexItem.getFlexBasisPercent());
                    }
                    if (isMainHorizontal) {
                        int childMainMeasureSpec2 = this.mFlexContainer.getChildWidthMeasureSpec(i2, mainPaddingStart + mainPaddingEnd + getFlexItemMarginStartMain(flexItem, true) + getFlexItemMarginEndMain(flexItem, true), childMainSize);
                        mainSize = mainSize3;
                        z2 = true;
                        mainMode = mainMode2;
                        flexLines3 = flexLines;
                        int childCrossMeasureSpec = this.mFlexContainer.getChildHeightMeasureSpec(i3, crossPaddingStart + crossPaddingEnd + getFlexItemMarginStartCross(flexItem, true) + getFlexItemMarginEndCross(flexItem, true) + sumCrossSize, getFlexItemSizeCross(flexItem, true));
                        child2.measure(childMainMeasureSpec2, childCrossMeasureSpec);
                        updateMeasureCache(largestSizeInCross3, childMainMeasureSpec2, childCrossMeasureSpec, child2);
                        childMainMeasureSpec = childMainMeasureSpec2;
                        int i10 = childCrossMeasureSpec;
                        z = false;
                    } else {
                        flexLines3 = flexLines;
                        mainSize = mainSize3;
                        mainMode = mainMode2;
                        z2 = true;
                        z = false;
                        int childCrossMeasureSpec2 = this.mFlexContainer.getChildWidthMeasureSpec(i3, crossPaddingStart + crossPaddingEnd + getFlexItemMarginStartCross(flexItem, false) + getFlexItemMarginEndCross(flexItem, false) + sumCrossSize, getFlexItemSizeCross(flexItem, false));
                        int childMainMeasureSpec3 = this.mFlexContainer.getChildHeightMeasureSpec(i2, mainPaddingStart + mainPaddingEnd + getFlexItemMarginStartMain(flexItem, false) + getFlexItemMarginEndMain(flexItem, false), childMainSize);
                        child2.measure(childCrossMeasureSpec2, childMainMeasureSpec3);
                        updateMeasureCache(largestSizeInCross3, childCrossMeasureSpec2, childMainMeasureSpec3, child2);
                        childMainMeasureSpec = childMainMeasureSpec3;
                        int i11 = childCrossMeasureSpec2;
                    }
                    this.mFlexContainer.updateViewCache(largestSizeInCross3, child2);
                    checkSizeConstraints(child2, largestSizeInCross3);
                    int childState = View.combineMeasuredStates(largestSizeInCross, child2.getMeasuredState());
                    int i12 = flexLine3.mMainSize;
                    int childMainSize3 = getFlexItemMarginEndMain(flexItem, isMainHorizontal) + getViewMeasuredSizeMain(child2, isMainHorizontal) + getFlexItemMarginStartMain(flexItem, isMainHorizontal);
                    int sumCrossSize3 = flexLines3.size();
                    View child3 = child2;
                    int i13 = largestSizeInCross3;
                    FlexLine flexLine5 = flexLine3;
                    boolean z3 = z2;
                    int childCount4 = childCount3;
                    int i14 = childMainSize;
                    boolean z4 = z;
                    flexLines2 = flexLines3;
                    int childMainMeasureSpec4 = childMainMeasureSpec;
                    int childCount5 = childCount4;
                    int sumCrossSize4 = sumCrossSize;
                    if (isWrapRequired(child2, mainMode, mainSize, i12, childMainSize3, flexItem, i13, indexInFlexLine3, sumCrossSize3)) {
                        if (flexLine5.getItemCountNotGone() > 0) {
                            i = i13;
                            FlexLine flexLine6 = flexLine5;
                            addFlexLine(flexLines2, flexLine6, i > 0 ? i - 1 : z4, sumCrossSize4);
                            sumCrossSize4 = flexLine6.mCrossSize + sumCrossSize4;
                        } else {
                            i = i13;
                            FlexLine flexLine7 = flexLine5;
                        }
                        if (!isMainHorizontal) {
                            int childMainMeasureSpec5 = childMainMeasureSpec4;
                            child = child3;
                            if (flexItem.getWidth() == -1) {
                                FlexContainer flexContainer = this.mFlexContainer;
                                int childCrossMeasureSpec3 = flexContainer.getChildWidthMeasureSpec(i3, flexContainer.getPaddingLeft() + this.mFlexContainer.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + sumCrossSize4, flexItem.getWidth());
                                child.measure(childCrossMeasureSpec3, childMainMeasureSpec5);
                                checkSizeConstraints(child, i);
                                int i15 = childCrossMeasureSpec3;
                            }
                        } else if (flexItem.getHeight() == -1) {
                            FlexContainer flexContainer2 = this.mFlexContainer;
                            int childCrossMeasureSpec4 = flexContainer2.getChildHeightMeasureSpec(i3, flexContainer2.getPaddingTop() + this.mFlexContainer.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + sumCrossSize4, flexItem.getHeight());
                            child = child3;
                            child.measure(childMainMeasureSpec4, childCrossMeasureSpec4);
                            checkSizeConstraints(child, i);
                            int i16 = childCrossMeasureSpec4;
                        } else {
                            child = child3;
                        }
                        flexLine3 = new FlexLine();
                        flexLine3.mItemCount = 1;
                        flexLine3.mMainSize = mainPaddingStart + mainPaddingEnd;
                        flexLine3.mFirstIndex = i;
                        indexInFlexLine = 0;
                        sumCrossSize = sumCrossSize4;
                        indexInFlexLine2 = Integer.MIN_VALUE;
                    } else {
                        child = child3;
                        i = i13;
                        FlexLine flexLine8 = flexLine5;
                        flexLine8.mItemCount++;
                        flexLine3 = flexLine8;
                        sumCrossSize = sumCrossSize4;
                        indexInFlexLine2 = largestSizeInCross2;
                        indexInFlexLine = indexInFlexLine3 + 1;
                    }
                    flexLine3.mAnyItemsHaveFlexGrow |= flexItem.getFlexGrow() != 0.0f ? true : z4;
                    flexLine3.mAnyItemsHaveFlexShrink |= flexItem.getFlexShrink() != 0.0f ? true : z4;
                    int[] iArr = this.mIndexToFlexLine;
                    if (iArr != null) {
                        iArr[i] = flexLines2.size();
                    }
                    flexLine3.mMainSize += getViewMeasuredSizeMain(child, isMainHorizontal) + getFlexItemMarginStartMain(flexItem, isMainHorizontal) + getFlexItemMarginEndMain(flexItem, isMainHorizontal);
                    flexLine3.mTotalFlexGrow += flexItem.getFlexGrow();
                    flexLine3.mTotalFlexShrink += flexItem.getFlexShrink();
                    this.mFlexContainer.onNewFlexItemAdded(child, i, indexInFlexLine, flexLine3);
                    int largestSizeInCross4 = Math.max(indexInFlexLine2, getViewMeasuredSizeCross(child, isMainHorizontal) + getFlexItemMarginStartCross(flexItem, isMainHorizontal) + getFlexItemMarginEndCross(flexItem, isMainHorizontal) + this.mFlexContainer.getDecorationLengthCrossAxis(child));
                    flexLine3.mCrossSize = Math.max(flexLine3.mCrossSize, largestSizeInCross4);
                    if (isMainHorizontal) {
                        if (this.mFlexContainer.getFlexWrap() != 2) {
                            flexLine3.mMaxBaseline = Math.max(flexLine3.mMaxBaseline, child.getBaseline() + flexItem.getMarginTop());
                        } else {
                            flexLine3.mMaxBaseline = Math.max(flexLine3.mMaxBaseline, (child.getMeasuredHeight() - child.getBaseline()) + flexItem.getMarginBottom());
                        }
                    }
                    childCount = childCount5;
                    if (isLastFlexItem(i, childCount, flexLine3)) {
                        addFlexLine(flexLines2, flexLine3, i, sumCrossSize);
                        sumCrossSize += flexLine3.mCrossSize;
                    }
                    mainSize2 = toIndex;
                    if (mainSize2 != -1) {
                        if (flexLines2.size() > 0) {
                            if (flexLines2.get(flexLines2.size() - 1).mLastIndex >= mainSize2 && i >= mainSize2 && !reachedToIndex2) {
                                sumCrossSize = -flexLine3.getCrossSize();
                                reachedToIndex2 = true;
                            }
                        }
                    }
                    if (sumCrossSize > needsCalcAmount && reachedToIndex2) {
                        int i17 = largestSizeInCross4;
                        int i18 = indexInFlexLine;
                        largestSizeInCross = childState;
                        break;
                    }
                    largestSizeInCross2 = largestSizeInCross4;
                    indexInFlexLine3 = indexInFlexLine;
                    largestSizeInCross = childState;
                    largestSizeInCross3 = i + 1;
                    FlexLinesResult flexLinesResult2 = result;
                    int i19 = fromIndex;
                    childCount2 = childCount;
                    i4 = mainSize2;
                    flexLines = flexLines2;
                    mainSize3 = mainSize;
                    mainMode2 = mainMode;
                    i2 = mainMeasureSpec;
                } else {
                    flexLine3.mGoneItemCount++;
                    flexLine3.mItemCount++;
                    if (isLastFlexItem(largestSizeInCross3, childCount2, flexLine3)) {
                        addFlexLine(flexLines, flexLine3, largestSizeInCross3, sumCrossSize);
                    }
                }
            } else if (isLastFlexItem(largestSizeInCross3, childCount2, flexLine3)) {
                addFlexLine(flexLines, flexLine3, largestSizeInCross3, sumCrossSize);
            }
            i = largestSizeInCross3;
            flexLines2 = flexLines;
            mainSize = mainSize3;
            mainMode = mainMode2;
            mainSize2 = i4;
            int i20 = needsCalcAmount;
            childCount = childCount2;
            largestSizeInCross3 = i + 1;
            FlexLinesResult flexLinesResult22 = result;
            int i192 = fromIndex;
            childCount2 = childCount;
            i4 = mainSize2;
            flexLines = flexLines2;
            mainSize3 = mainSize;
            mainMode2 = mainMode;
            i2 = mainMeasureSpec;
        }
        result.mChildState = largestSizeInCross;
    }

    private void evaluateMinimumSizeForCompoundButton(CompoundButton compoundButton) {
        FlexItem flexItem = (FlexItem) compoundButton.getLayoutParams();
        int minWidth = flexItem.getMinWidth();
        int minHeight = flexItem.getMinHeight();
        Drawable drawable = CompoundButtonCompat.getButtonDrawable(compoundButton);
        int drawableMinHeight = 0;
        int drawableMinWidth = drawable == null ? 0 : drawable.getMinimumWidth();
        if (drawable != null) {
            drawableMinHeight = drawable.getMinimumHeight();
        }
        flexItem.setMinWidth(minWidth == -1 ? drawableMinWidth : minWidth);
        flexItem.setMinHeight(minHeight == -1 ? drawableMinHeight : minHeight);
    }

    private int getPaddingStartMain(boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return this.mFlexContainer.getPaddingStart();
        }
        return this.mFlexContainer.getPaddingTop();
    }

    private int getPaddingEndMain(boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return this.mFlexContainer.getPaddingEnd();
        }
        return this.mFlexContainer.getPaddingBottom();
    }

    private int getPaddingStartCross(boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return this.mFlexContainer.getPaddingTop();
        }
        return this.mFlexContainer.getPaddingStart();
    }

    private int getPaddingEndCross(boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return this.mFlexContainer.getPaddingBottom();
        }
        return this.mFlexContainer.getPaddingEnd();
    }

    private int getViewMeasuredSizeMain(View view, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private int getViewMeasuredSizeCross(View view, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int getFlexItemSizeMain(FlexItem flexItem, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return flexItem.getWidth();
        }
        return flexItem.getHeight();
    }

    private int getFlexItemSizeCross(FlexItem flexItem, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return flexItem.getHeight();
        }
        return flexItem.getWidth();
    }

    private int getFlexItemMarginStartMain(FlexItem flexItem, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return flexItem.getMarginLeft();
        }
        return flexItem.getMarginTop();
    }

    private int getFlexItemMarginEndMain(FlexItem flexItem, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return flexItem.getMarginRight();
        }
        return flexItem.getMarginBottom();
    }

    private int getFlexItemMarginStartCross(FlexItem flexItem, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return flexItem.getMarginTop();
        }
        return flexItem.getMarginLeft();
    }

    private int getFlexItemMarginEndCross(FlexItem flexItem, boolean isMainHorizontal) {
        if (isMainHorizontal) {
            return flexItem.getMarginBottom();
        }
        return flexItem.getMarginRight();
    }

    private boolean isWrapRequired(View view, int mode, int maxSize, int currentLength, int childLength, FlexItem flexItem, int index, int indexInFlexLine, int flexLinesSize) {
        if (this.mFlexContainer.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.isWrapBefore()) {
            return true;
        }
        if (mode == 0) {
            return false;
        }
        int maxLine = this.mFlexContainer.getMaxLine();
        if (maxLine != -1 && maxLine <= flexLinesSize + 1) {
            return false;
        }
        int decorationLength = this.mFlexContainer.getDecorationLengthMainAxis(view, index, indexInFlexLine);
        if (decorationLength > 0) {
            childLength += decorationLength;
        }
        if (maxSize < currentLength + childLength) {
            return true;
        }
        return false;
    }

    private boolean isLastFlexItem(int childIndex, int childCount, FlexLine flexLine) {
        return childIndex == childCount + -1 && flexLine.getItemCountNotGone() != 0;
    }

    private void addFlexLine(List<FlexLine> flexLines, FlexLine flexLine, int viewIndex, int usedCrossSizeSoFar) {
        flexLine.mSumCrossSizeBefore = usedCrossSizeSoFar;
        this.mFlexContainer.onNewFlexLineAdded(flexLine);
        flexLine.mLastIndex = viewIndex;
        flexLines.add(flexLine);
    }

    private void checkSizeConstraints(View view, int index) {
        boolean needsMeasure = false;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int childWidth = view.getMeasuredWidth();
        int childHeight = view.getMeasuredHeight();
        if (childWidth < flexItem.getMinWidth()) {
            needsMeasure = true;
            childWidth = flexItem.getMinWidth();
        } else if (childWidth > flexItem.getMaxWidth()) {
            needsMeasure = true;
            childWidth = flexItem.getMaxWidth();
        }
        if (childHeight < flexItem.getMinHeight()) {
            needsMeasure = true;
            childHeight = flexItem.getMinHeight();
        } else if (childHeight > flexItem.getMaxHeight()) {
            needsMeasure = true;
            childHeight = flexItem.getMaxHeight();
        }
        if (needsMeasure) {
            int widthSpec = View.MeasureSpec.makeMeasureSpec(childWidth, BasicMeasure.EXACTLY);
            int heightSpec = View.MeasureSpec.makeMeasureSpec(childHeight, BasicMeasure.EXACTLY);
            view.measure(widthSpec, heightSpec);
            updateMeasureCache(index, widthSpec, heightSpec, view);
            this.mFlexContainer.updateViewCache(index, view);
        }
    }

    /* access modifiers changed from: package-private */
    public void determineMainSize(int widthMeasureSpec, int heightMeasureSpec) {
        determineMainSize(widthMeasureSpec, heightMeasureSpec, 0);
    }

    /* access modifiers changed from: package-private */
    public void determineMainSize(int widthMeasureSpec, int heightMeasureSpec, int fromIndex) {
        int paddingAlongMainAxis;
        int mainSize;
        int flexLineIndex;
        int mainSize2;
        int mainSize3;
        int i = fromIndex;
        ensureChildrenFrozen(this.mFlexContainer.getFlexItemCount());
        if (i < this.mFlexContainer.getFlexItemCount()) {
            int flexDirection = this.mFlexContainer.getFlexDirection();
            int flexDirection2 = this.mFlexContainer.getFlexDirection();
            if (flexDirection2 == 0 || flexDirection2 == 1) {
                int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
                int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
                int largestMainSize = this.mFlexContainer.getLargestMainSize();
                if (widthMode == 1073741824) {
                    mainSize2 = widthSize;
                } else {
                    mainSize2 = largestMainSize > widthSize ? widthSize : largestMainSize;
                }
                mainSize = mainSize2;
                paddingAlongMainAxis = this.mFlexContainer.getPaddingLeft() + this.mFlexContainer.getPaddingRight();
            } else if (flexDirection2 == 2 || flexDirection2 == 3) {
                int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
                int heightSize = View.MeasureSpec.getSize(heightMeasureSpec);
                if (heightMode == 1073741824) {
                    mainSize3 = heightSize;
                } else {
                    mainSize3 = this.mFlexContainer.getLargestMainSize();
                }
                mainSize = mainSize3;
                paddingAlongMainAxis = this.mFlexContainer.getPaddingTop() + this.mFlexContainer.getPaddingBottom();
            } else {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int[] iArr = this.mIndexToFlexLine;
            if (iArr != null) {
                flexLineIndex = iArr[i];
            } else {
                flexLineIndex = 0;
            }
            List<FlexLine> flexLines = this.mFlexContainer.getFlexLinesInternal();
            int size = flexLines.size();
            int i2 = flexLineIndex;
            while (i2 < size) {
                FlexLine flexLine = flexLines.get(i2);
                if (flexLine.mMainSize >= mainSize || !flexLine.mAnyItemsHaveFlexGrow) {
                    FlexLine flexLine2 = flexLine;
                    if (flexLine2.mMainSize > mainSize && flexLine2.mAnyItemsHaveFlexShrink) {
                        shrinkFlexItems(widthMeasureSpec, heightMeasureSpec, flexLine2, mainSize, paddingAlongMainAxis, false);
                    }
                } else {
                    FlexLine flexLine3 = flexLine;
                    expandFlexItems(widthMeasureSpec, heightMeasureSpec, flexLine, mainSize, paddingAlongMainAxis, false);
                }
                i2++;
            }
        }
    }

    private void ensureChildrenFrozen(int size) {
        boolean[] zArr = this.mChildrenFrozen;
        if (zArr == null) {
            int i = 10;
            if (size >= 10) {
                i = size;
            }
            this.mChildrenFrozen = new boolean[i];
        } else if (zArr.length < size) {
            int newCapacity = zArr.length * 2;
            this.mChildrenFrozen = new boolean[(newCapacity >= size ? newCapacity : size)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private void expandFlexItems(int widthMeasureSpec, int heightMeasureSpec, FlexLine flexLine, int maxMainSize, int paddingAlongMainAxis, boolean calledRecursively) {
        int sizeBeforeExpand;
        int largestCrossSize;
        int sizeBeforeExpand2;
        int sizeBeforeExpand3;
        int flexDirection;
        int largestCrossSize2;
        int needsReexpand;
        int needsReexpand2;
        int childMeasuredWidth;
        int sizeBeforeExpand4;
        View child;
        int childMeasuredHeight;
        int childMeasuredWidth2;
        View child2;
        int childMeasuredHeight2;
        FlexLine flexLine2 = flexLine;
        int i = maxMainSize;
        if (flexLine2.mTotalFlexGrow > 0.0f && i >= flexLine2.mMainSize) {
            int sizeBeforeExpand5 = flexLine2.mMainSize;
            float unitSpace = ((float) (i - flexLine2.mMainSize)) / flexLine2.mTotalFlexGrow;
            flexLine2.mMainSize = paddingAlongMainAxis + flexLine2.mDividerLengthInMainSize;
            if (!calledRecursively) {
                flexLine2.mCrossSize = Integer.MIN_VALUE;
            }
            int i2 = 0;
            int needsReexpand3 = 0;
            int largestCrossSize3 = 0;
            float accumulatedRoundError = 0.0f;
            while (i2 < flexLine2.mItemCount) {
                int index = flexLine2.mFirstIndex + i2;
                View child3 = this.mFlexContainer.getReorderedFlexItemAt(index);
                if (child3 == null) {
                    int i3 = heightMeasureSpec;
                    sizeBeforeExpand3 = sizeBeforeExpand5;
                    sizeBeforeExpand2 = largestCrossSize3;
                    largestCrossSize = needsReexpand3;
                } else if (child3.getVisibility() == 8) {
                    int i4 = heightMeasureSpec;
                    sizeBeforeExpand3 = sizeBeforeExpand5;
                    sizeBeforeExpand2 = largestCrossSize3;
                    largestCrossSize = needsReexpand3;
                } else {
                    FlexItem flexItem = (FlexItem) child3.getLayoutParams();
                    int flexDirection2 = this.mFlexContainer.getFlexDirection();
                    if (flexDirection2 == 0) {
                        sizeBeforeExpand4 = sizeBeforeExpand5;
                    } else if (flexDirection2 == 1) {
                        sizeBeforeExpand4 = sizeBeforeExpand5;
                    } else {
                        int childMeasuredHeight3 = child3.getMeasuredHeight();
                        long[] jArr = this.mMeasuredSizeCache;
                        if (jArr != null) {
                            child = child3;
                            childMeasuredHeight = extractHigherInt(jArr[index]);
                        } else {
                            child = child3;
                            childMeasuredHeight = childMeasuredHeight3;
                        }
                        int childMeasuredWidth3 = child.getMeasuredWidth();
                        long[] jArr2 = this.mMeasuredSizeCache;
                        if (jArr2 != null) {
                            sizeBeforeExpand = sizeBeforeExpand5;
                            childMeasuredWidth3 = extractLowerInt(jArr2[index]);
                        } else {
                            sizeBeforeExpand = sizeBeforeExpand5;
                        }
                        if (this.mChildrenFrozen[index] || flexItem.getFlexGrow() <= 0.0f) {
                            int childMeasuredWidth4 = childMeasuredWidth3;
                            child2 = child;
                            childMeasuredHeight2 = childMeasuredHeight;
                            childMeasuredWidth2 = childMeasuredWidth4;
                        } else {
                            float rawCalculatedHeight = ((float) childMeasuredHeight) + (flexItem.getFlexGrow() * unitSpace);
                            if (i2 == flexLine2.mItemCount - 1) {
                                rawCalculatedHeight += accumulatedRoundError;
                                accumulatedRoundError = 0.0f;
                            }
                            int newHeight = Math.round(rawCalculatedHeight);
                            if (newHeight > flexItem.getMaxHeight()) {
                                needsReexpand3 = 1;
                                newHeight = flexItem.getMaxHeight();
                                this.mChildrenFrozen[index] = true;
                                flexLine2.mTotalFlexGrow -= flexItem.getFlexGrow();
                                int i5 = childMeasuredHeight;
                                int i6 = childMeasuredWidth3;
                            } else {
                                accumulatedRoundError += rawCalculatedHeight - ((float) newHeight);
                                int i7 = childMeasuredHeight;
                                int i8 = childMeasuredWidth3;
                                if (((double) accumulatedRoundError) > 1.0d) {
                                    newHeight++;
                                    accumulatedRoundError = (float) (((double) accumulatedRoundError) - 1.0d);
                                } else if (((double) accumulatedRoundError) < -1.0d) {
                                    newHeight--;
                                    accumulatedRoundError = (float) (((double) accumulatedRoundError) + 1.0d);
                                }
                            }
                            int childWidthMeasureSpec = getChildWidthMeasureSpecInternal(widthMeasureSpec, flexItem, flexLine2.mSumCrossSizeBefore);
                            int childHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(newHeight, BasicMeasure.EXACTLY);
                            child2 = child;
                            child2.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                            childMeasuredWidth2 = child2.getMeasuredWidth();
                            int childMeasuredHeight4 = child2.getMeasuredHeight();
                            updateMeasureCache(index, childWidthMeasureSpec, childHeightMeasureSpec, child2);
                            int i9 = childWidthMeasureSpec;
                            this.mFlexContainer.updateViewCache(index, child2);
                            childMeasuredHeight2 = childMeasuredHeight4;
                        }
                        int largestCrossSize4 = Math.max(largestCrossSize3, childMeasuredWidth2 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.mFlexContainer.getDecorationLengthCrossAxis(child2));
                        flexLine2.mMainSize += flexItem.getMarginTop() + childMeasuredHeight2 + flexItem.getMarginBottom();
                        int i10 = flexDirection2;
                        flexDirection = largestCrossSize4;
                        int largestCrossSize5 = heightMeasureSpec;
                        flexLine2.mCrossSize = Math.max(flexLine2.mCrossSize, flexDirection);
                        largestCrossSize3 = flexDirection;
                        i2++;
                        int i11 = maxMainSize;
                        sizeBeforeExpand5 = sizeBeforeExpand;
                    }
                    int childMeasuredWidth5 = child3.getMeasuredWidth();
                    long[] jArr3 = this.mMeasuredSizeCache;
                    if (jArr3 != null) {
                        needsReexpand = needsReexpand3;
                        largestCrossSize2 = largestCrossSize3;
                        childMeasuredWidth5 = extractLowerInt(jArr3[index]);
                    } else {
                        needsReexpand = needsReexpand3;
                        largestCrossSize2 = largestCrossSize3;
                    }
                    int childMeasuredHeight5 = child3.getMeasuredHeight();
                    long[] jArr4 = this.mMeasuredSizeCache;
                    if (jArr4 != null) {
                        int i12 = childMeasuredHeight5;
                        needsReexpand2 = needsReexpand;
                        childMeasuredHeight5 = extractHigherInt(jArr4[index]);
                    } else {
                        int i13 = childMeasuredHeight5;
                        needsReexpand2 = needsReexpand;
                    }
                    if (this.mChildrenFrozen[index] || flexItem.getFlexGrow() <= 0.0f) {
                        int i14 = heightMeasureSpec;
                        int i15 = flexDirection2;
                        needsReexpand3 = needsReexpand2;
                        childMeasuredWidth = childMeasuredWidth5;
                    } else {
                        float rawCalculatedWidth = ((float) childMeasuredWidth5) + (flexItem.getFlexGrow() * unitSpace);
                        if (i2 == flexLine2.mItemCount - 1) {
                            rawCalculatedWidth += accumulatedRoundError;
                            accumulatedRoundError = 0.0f;
                        }
                        int newWidth = Math.round(rawCalculatedWidth);
                        if (newWidth > flexItem.getMaxWidth()) {
                            newWidth = flexItem.getMaxWidth();
                            this.mChildrenFrozen[index] = true;
                            flexLine2.mTotalFlexGrow -= flexItem.getFlexGrow();
                            int i16 = flexDirection2;
                            needsReexpand2 = 1;
                        } else {
                            accumulatedRoundError += rawCalculatedWidth - ((float) newWidth);
                            int i17 = flexDirection2;
                            if (((double) accumulatedRoundError) > 1.0d) {
                                newWidth++;
                                accumulatedRoundError = (float) (((double) accumulatedRoundError) - 1.0d);
                            } else if (((double) accumulatedRoundError) < -1.0d) {
                                newWidth--;
                                accumulatedRoundError = (float) (((double) accumulatedRoundError) + 1.0d);
                            }
                        }
                        int childHeightMeasureSpec2 = getChildHeightMeasureSpecInternal(heightMeasureSpec, flexItem, flexLine2.mSumCrossSizeBefore);
                        int i18 = childMeasuredWidth5;
                        int childMeasuredWidth6 = View.MeasureSpec.makeMeasureSpec(newWidth, BasicMeasure.EXACTLY);
                        child3.measure(childMeasuredWidth6, childHeightMeasureSpec2);
                        int childMeasuredWidth7 = child3.getMeasuredWidth();
                        childMeasuredHeight5 = child3.getMeasuredHeight();
                        updateMeasureCache(index, childMeasuredWidth6, childHeightMeasureSpec2, child3);
                        int i19 = childMeasuredWidth6;
                        this.mFlexContainer.updateViewCache(index, child3);
                        needsReexpand3 = needsReexpand2;
                        childMeasuredWidth = childMeasuredWidth7;
                    }
                    flexDirection = Math.max(largestCrossSize2, flexItem.getMarginTop() + childMeasuredHeight5 + flexItem.getMarginBottom() + this.mFlexContainer.getDecorationLengthCrossAxis(child3));
                    flexLine2.mMainSize += flexItem.getMarginLeft() + childMeasuredWidth + flexItem.getMarginRight();
                    flexLine2.mCrossSize = Math.max(flexLine2.mCrossSize, flexDirection);
                    largestCrossSize3 = flexDirection;
                    i2++;
                    int i112 = maxMainSize;
                    sizeBeforeExpand5 = sizeBeforeExpand;
                }
                needsReexpand3 = largestCrossSize;
                largestCrossSize3 = sizeBeforeExpand2;
                i2++;
                int i1122 = maxMainSize;
                sizeBeforeExpand5 = sizeBeforeExpand;
            }
            int i20 = heightMeasureSpec;
            int sizeBeforeExpand6 = sizeBeforeExpand5;
            int sizeBeforeExpand7 = largestCrossSize3;
            if (needsReexpand3 == 0) {
            } else if (sizeBeforeExpand6 != flexLine2.mMainSize) {
                expandFlexItems(widthMeasureSpec, heightMeasureSpec, flexLine, maxMainSize, paddingAlongMainAxis, true);
            }
        }
    }

    private void shrinkFlexItems(int widthMeasureSpec, int heightMeasureSpec, FlexLine flexLine, int maxMainSize, int paddingAlongMainAxis, boolean calledRecursively) {
        int sizeBeforeShrink;
        int sizeBeforeShrink2;
        int sizeBeforeShrink3;
        int flexDirection;
        int largestCrossSize;
        int largestCrossSize2;
        int childMeasuredWidth;
        int sizeBeforeShrink4;
        View child;
        int childMeasuredHeight;
        int childMeasuredWidth2;
        View child2;
        int childMeasuredHeight2;
        FlexLine flexLine2 = flexLine;
        int i = maxMainSize;
        int sizeBeforeShrink5 = flexLine2.mMainSize;
        if (flexLine2.mTotalFlexShrink <= 0.0f) {
        } else if (i > flexLine2.mMainSize) {
            int i2 = sizeBeforeShrink5;
        } else {
            float unitShrink = ((float) (flexLine2.mMainSize - i)) / flexLine2.mTotalFlexShrink;
            flexLine2.mMainSize = paddingAlongMainAxis + flexLine2.mDividerLengthInMainSize;
            if (!calledRecursively) {
                flexLine2.mCrossSize = Integer.MIN_VALUE;
            }
            int i3 = 0;
            boolean needsReshrink = false;
            float accumulatedRoundError = 0.0f;
            int largestCrossSize3 = 0;
            while (i3 < flexLine2.mItemCount) {
                int index = flexLine2.mFirstIndex + i3;
                View child3 = this.mFlexContainer.getReorderedFlexItemAt(index);
                if (child3 == null) {
                    int i4 = heightMeasureSpec;
                    sizeBeforeShrink3 = sizeBeforeShrink5;
                    sizeBeforeShrink2 = largestCrossSize3;
                } else if (child3.getVisibility() == 8) {
                    int i5 = heightMeasureSpec;
                    sizeBeforeShrink3 = sizeBeforeShrink5;
                    sizeBeforeShrink2 = largestCrossSize3;
                } else {
                    FlexItem flexItem = (FlexItem) child3.getLayoutParams();
                    int flexDirection2 = this.mFlexContainer.getFlexDirection();
                    if (flexDirection2 == 0) {
                        sizeBeforeShrink4 = sizeBeforeShrink5;
                    } else if (flexDirection2 == 1) {
                        sizeBeforeShrink4 = sizeBeforeShrink5;
                    } else {
                        int childMeasuredHeight3 = child3.getMeasuredHeight();
                        long[] jArr = this.mMeasuredSizeCache;
                        if (jArr != null) {
                            child = child3;
                            childMeasuredHeight = extractHigherInt(jArr[index]);
                        } else {
                            child = child3;
                            childMeasuredHeight = childMeasuredHeight3;
                        }
                        int childMeasuredWidth3 = child.getMeasuredWidth();
                        long[] jArr2 = this.mMeasuredSizeCache;
                        if (jArr2 != null) {
                            sizeBeforeShrink = sizeBeforeShrink5;
                            childMeasuredWidth3 = extractLowerInt(jArr2[index]);
                        } else {
                            sizeBeforeShrink = sizeBeforeShrink5;
                        }
                        if (this.mChildrenFrozen[index] || flexItem.getFlexShrink() <= 0.0f) {
                            childMeasuredWidth2 = childMeasuredWidth3;
                            child2 = child;
                            childMeasuredHeight2 = childMeasuredHeight;
                        } else {
                            float rawCalculatedHeight = ((float) childMeasuredHeight) - (flexItem.getFlexShrink() * unitShrink);
                            if (i3 == flexLine2.mItemCount - 1) {
                                rawCalculatedHeight += accumulatedRoundError;
                                accumulatedRoundError = 0.0f;
                            }
                            int newHeight = Math.round(rawCalculatedHeight);
                            if (newHeight < flexItem.getMinHeight()) {
                                needsReshrink = true;
                                newHeight = flexItem.getMinHeight();
                                this.mChildrenFrozen[index] = true;
                                flexLine2.mTotalFlexShrink -= flexItem.getFlexShrink();
                                int i6 = childMeasuredHeight;
                                int i7 = childMeasuredWidth3;
                            } else {
                                accumulatedRoundError += rawCalculatedHeight - ((float) newHeight);
                                int i8 = childMeasuredHeight;
                                int i9 = childMeasuredWidth3;
                                if (((double) accumulatedRoundError) > 1.0d) {
                                    newHeight++;
                                    accumulatedRoundError -= 1.0f;
                                } else if (((double) accumulatedRoundError) < -1.0d) {
                                    newHeight--;
                                    accumulatedRoundError += 1.0f;
                                }
                            }
                            int childWidthMeasureSpec = getChildWidthMeasureSpecInternal(widthMeasureSpec, flexItem, flexLine2.mSumCrossSizeBefore);
                            int childHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(newHeight, BasicMeasure.EXACTLY);
                            child2 = child;
                            child2.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                            int childMeasuredWidth4 = child2.getMeasuredWidth();
                            int childMeasuredHeight4 = child2.getMeasuredHeight();
                            updateMeasureCache(index, childWidthMeasureSpec, childHeightMeasureSpec, child2);
                            int i10 = childWidthMeasureSpec;
                            this.mFlexContainer.updateViewCache(index, child2);
                            childMeasuredHeight2 = childMeasuredHeight4;
                            childMeasuredWidth2 = childMeasuredWidth4;
                        }
                        int largestCrossSize4 = Math.max(largestCrossSize3, childMeasuredWidth2 + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.mFlexContainer.getDecorationLengthCrossAxis(child2));
                        flexLine2.mMainSize += flexItem.getMarginTop() + childMeasuredHeight2 + flexItem.getMarginBottom();
                        int i11 = flexDirection2;
                        flexDirection = largestCrossSize4;
                        int largestCrossSize5 = heightMeasureSpec;
                        flexLine2.mCrossSize = Math.max(flexLine2.mCrossSize, flexDirection);
                        largestCrossSize3 = flexDirection;
                        i3++;
                        int i12 = maxMainSize;
                        sizeBeforeShrink5 = sizeBeforeShrink;
                    }
                    int childMeasuredWidth5 = child3.getMeasuredWidth();
                    long[] jArr3 = this.mMeasuredSizeCache;
                    if (jArr3 != null) {
                        largestCrossSize = largestCrossSize3;
                        childMeasuredWidth5 = extractLowerInt(jArr3[index]);
                    } else {
                        largestCrossSize = largestCrossSize3;
                    }
                    int childMeasuredHeight5 = child3.getMeasuredHeight();
                    long[] jArr4 = this.mMeasuredSizeCache;
                    if (jArr4 != null) {
                        int i13 = childMeasuredHeight5;
                        largestCrossSize2 = largestCrossSize;
                        childMeasuredHeight5 = extractHigherInt(jArr4[index]);
                    } else {
                        int i14 = childMeasuredHeight5;
                        largestCrossSize2 = largestCrossSize;
                    }
                    if (this.mChildrenFrozen[index] || flexItem.getFlexShrink() <= 0.0f) {
                        int i15 = heightMeasureSpec;
                        int i16 = flexDirection2;
                        childMeasuredWidth = childMeasuredWidth5;
                    } else {
                        float rawCalculatedWidth = ((float) childMeasuredWidth5) - (flexItem.getFlexShrink() * unitShrink);
                        if (i3 == flexLine2.mItemCount - 1) {
                            rawCalculatedWidth += accumulatedRoundError;
                            accumulatedRoundError = 0.0f;
                        }
                        int newWidth = Math.round(rawCalculatedWidth);
                        if (newWidth < flexItem.getMinWidth()) {
                            newWidth = flexItem.getMinWidth();
                            this.mChildrenFrozen[index] = true;
                            flexLine2.mTotalFlexShrink -= flexItem.getFlexShrink();
                            int i17 = flexDirection2;
                            needsReshrink = true;
                        } else {
                            accumulatedRoundError += rawCalculatedWidth - ((float) newWidth);
                            int i18 = flexDirection2;
                            if (((double) accumulatedRoundError) > 1.0d) {
                                newWidth++;
                                accumulatedRoundError -= 1.0f;
                            } else if (((double) accumulatedRoundError) < -1.0d) {
                                newWidth--;
                                accumulatedRoundError += 1.0f;
                            }
                        }
                        int childHeightMeasureSpec2 = getChildHeightMeasureSpecInternal(heightMeasureSpec, flexItem, flexLine2.mSumCrossSizeBefore);
                        int i19 = childMeasuredWidth5;
                        int childMeasuredWidth6 = View.MeasureSpec.makeMeasureSpec(newWidth, BasicMeasure.EXACTLY);
                        child3.measure(childMeasuredWidth6, childHeightMeasureSpec2);
                        int childMeasuredWidth7 = child3.getMeasuredWidth();
                        childMeasuredHeight5 = child3.getMeasuredHeight();
                        updateMeasureCache(index, childMeasuredWidth6, childHeightMeasureSpec2, child3);
                        int i20 = childMeasuredWidth6;
                        this.mFlexContainer.updateViewCache(index, child3);
                        childMeasuredWidth = childMeasuredWidth7;
                    }
                    flexDirection = Math.max(largestCrossSize2, flexItem.getMarginTop() + childMeasuredHeight5 + flexItem.getMarginBottom() + this.mFlexContainer.getDecorationLengthCrossAxis(child3));
                    flexLine2.mMainSize += flexItem.getMarginLeft() + childMeasuredWidth + flexItem.getMarginRight();
                    flexLine2.mCrossSize = Math.max(flexLine2.mCrossSize, flexDirection);
                    largestCrossSize3 = flexDirection;
                    i3++;
                    int i122 = maxMainSize;
                    sizeBeforeShrink5 = sizeBeforeShrink;
                }
                largestCrossSize3 = sizeBeforeShrink2;
                i3++;
                int i1222 = maxMainSize;
                sizeBeforeShrink5 = sizeBeforeShrink;
            }
            int i21 = heightMeasureSpec;
            int sizeBeforeShrink6 = sizeBeforeShrink5;
            int sizeBeforeShrink7 = largestCrossSize3;
            if (!needsReshrink) {
            } else if (sizeBeforeShrink6 != flexLine2.mMainSize) {
                shrinkFlexItems(widthMeasureSpec, heightMeasureSpec, flexLine, maxMainSize, paddingAlongMainAxis, true);
            }
        }
    }

    private int getChildWidthMeasureSpecInternal(int widthMeasureSpec, FlexItem flexItem, int padding) {
        FlexContainer flexContainer = this.mFlexContainer;
        int childWidthMeasureSpec = flexContainer.getChildWidthMeasureSpec(widthMeasureSpec, flexContainer.getPaddingLeft() + this.mFlexContainer.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + padding, flexItem.getWidth());
        int childWidth = View.MeasureSpec.getSize(childWidthMeasureSpec);
        if (childWidth > flexItem.getMaxWidth()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), View.MeasureSpec.getMode(childWidthMeasureSpec));
        }
        if (childWidth < flexItem.getMinWidth()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMinWidth(), View.MeasureSpec.getMode(childWidthMeasureSpec));
        }
        return childWidthMeasureSpec;
    }

    private int getChildHeightMeasureSpecInternal(int heightMeasureSpec, FlexItem flexItem, int padding) {
        FlexContainer flexContainer = this.mFlexContainer;
        int childHeightMeasureSpec = flexContainer.getChildHeightMeasureSpec(heightMeasureSpec, flexContainer.getPaddingTop() + this.mFlexContainer.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + padding, flexItem.getHeight());
        int childHeight = View.MeasureSpec.getSize(childHeightMeasureSpec);
        if (childHeight > flexItem.getMaxHeight()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxHeight(), View.MeasureSpec.getMode(childHeightMeasureSpec));
        }
        if (childHeight < flexItem.getMinHeight()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMinHeight(), View.MeasureSpec.getMode(childHeightMeasureSpec));
        }
        return childHeightMeasureSpec;
    }

    /* access modifiers changed from: package-private */
    public void determineCrossSize(int widthMeasureSpec, int heightMeasureSpec, int paddingAlongCrossAxis) {
        int size;
        int mode;
        int flexDirection = this.mFlexContainer.getFlexDirection();
        int i = 1;
        if (flexDirection == 0 || flexDirection == 1) {
            mode = View.MeasureSpec.getMode(heightMeasureSpec);
            size = View.MeasureSpec.getSize(heightMeasureSpec);
        } else if (flexDirection == 2 || flexDirection == 3) {
            mode = View.MeasureSpec.getMode(widthMeasureSpec);
            size = View.MeasureSpec.getSize(widthMeasureSpec);
        } else {
            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
        }
        List<FlexLine> flexLines = this.mFlexContainer.getFlexLinesInternal();
        if (mode == 1073741824) {
            int totalCrossSize = this.mFlexContainer.getSumOfCrossSize() + paddingAlongCrossAxis;
            if (flexLines.size() == 1) {
                flexLines.get(0).mCrossSize = size - paddingAlongCrossAxis;
            } else if (flexLines.size() >= 2) {
                int alignContent = this.mFlexContainer.getAlignContent();
                if (alignContent == 1) {
                    FlexLine dummySpaceFlexLine = new FlexLine();
                    dummySpaceFlexLine.mCrossSize = size - totalCrossSize;
                    flexLines.add(0, dummySpaceFlexLine);
                } else if (alignContent == 2) {
                    this.mFlexContainer.setFlexLines(constructFlexLinesForAlignContentCenter(flexLines, size, totalCrossSize));
                } else if (alignContent != 3) {
                    if (alignContent != 4) {
                        if (alignContent == 5 && totalCrossSize < size) {
                            float freeSpaceUnit = ((float) (size - totalCrossSize)) / ((float) flexLines.size());
                            float accumulatedError = 0.0f;
                            int i2 = 0;
                            int flexLinesSize = flexLines.size();
                            while (i2 < flexLinesSize) {
                                FlexLine flexLine = flexLines.get(i2);
                                float newCrossSizeAsFloat = ((float) flexLine.mCrossSize) + freeSpaceUnit;
                                if (i2 == flexLines.size() - i) {
                                    newCrossSizeAsFloat += accumulatedError;
                                    accumulatedError = 0.0f;
                                }
                                int newCrossSize = Math.round(newCrossSizeAsFloat);
                                accumulatedError += newCrossSizeAsFloat - ((float) newCrossSize);
                                if (accumulatedError > 1.0f) {
                                    newCrossSize++;
                                    accumulatedError -= 1.0f;
                                } else if (accumulatedError < -1.0f) {
                                    newCrossSize--;
                                    accumulatedError += 1.0f;
                                }
                                flexLine.mCrossSize = newCrossSize;
                                i2++;
                                i = 1;
                            }
                        }
                    } else if (totalCrossSize >= size) {
                        this.mFlexContainer.setFlexLines(constructFlexLinesForAlignContentCenter(flexLines, size, totalCrossSize));
                    } else {
                        List<FlexLine> newFlexLines = new ArrayList<>();
                        FlexLine dummySpaceFlexLine2 = new FlexLine();
                        dummySpaceFlexLine2.mCrossSize = (size - totalCrossSize) / (flexLines.size() * 2);
                        for (FlexLine flexLine2 : flexLines) {
                            newFlexLines.add(dummySpaceFlexLine2);
                            newFlexLines.add(flexLine2);
                            newFlexLines.add(dummySpaceFlexLine2);
                        }
                        this.mFlexContainer.setFlexLines(newFlexLines);
                    }
                } else if (totalCrossSize < size) {
                    float spaceBetweenFlexLine = ((float) (size - totalCrossSize)) / ((float) (flexLines.size() - 1));
                    float accumulatedError2 = 0.0f;
                    List<FlexLine> newFlexLines2 = new ArrayList<>();
                    int flexLineSize = flexLines.size();
                    for (int i3 = 0; i3 < flexLineSize; i3++) {
                        newFlexLines2.add(flexLines.get(i3));
                        if (i3 != flexLines.size() - 1) {
                            FlexLine dummySpaceFlexLine3 = new FlexLine();
                            if (i3 == flexLines.size() - 2) {
                                dummySpaceFlexLine3.mCrossSize = Math.round(spaceBetweenFlexLine + accumulatedError2);
                                accumulatedError2 = 0.0f;
                            } else {
                                dummySpaceFlexLine3.mCrossSize = Math.round(spaceBetweenFlexLine);
                            }
                            accumulatedError2 += spaceBetweenFlexLine - ((float) dummySpaceFlexLine3.mCrossSize);
                            if (accumulatedError2 > 1.0f) {
                                dummySpaceFlexLine3.mCrossSize++;
                                accumulatedError2 -= 1.0f;
                            } else if (accumulatedError2 < -1.0f) {
                                dummySpaceFlexLine3.mCrossSize--;
                                accumulatedError2 += 1.0f;
                            }
                            newFlexLines2.add(dummySpaceFlexLine3);
                        }
                    }
                    this.mFlexContainer.setFlexLines(newFlexLines2);
                }
            }
        }
    }

    private List<FlexLine> constructFlexLinesForAlignContentCenter(List<FlexLine> flexLines, int size, int totalCrossSize) {
        List<FlexLine> newFlexLines = new ArrayList<>();
        FlexLine dummySpaceFlexLine = new FlexLine();
        dummySpaceFlexLine.mCrossSize = (size - totalCrossSize) / 2;
        int flexLineSize = flexLines.size();
        for (int i = 0; i < flexLineSize; i++) {
            if (i == 0) {
                newFlexLines.add(dummySpaceFlexLine);
            }
            newFlexLines.add(flexLines.get(i));
            if (i == flexLines.size() - 1) {
                newFlexLines.add(dummySpaceFlexLine);
            }
        }
        return newFlexLines;
    }

    /* access modifiers changed from: package-private */
    public void stretchViews() {
        stretchViews(0);
    }

    /* access modifiers changed from: package-private */
    public void stretchViews(int fromIndex) {
        char c;
        int i = fromIndex;
        if (i < this.mFlexContainer.getFlexItemCount()) {
            int flexDirection = this.mFlexContainer.getFlexDirection();
            char c2 = 4;
            if (this.mFlexContainer.getAlignItems() == 4) {
                int flexLineIndex = 0;
                int[] iArr = this.mIndexToFlexLine;
                if (iArr != null) {
                    flexLineIndex = iArr[i];
                }
                List<FlexLine> flexLines = this.mFlexContainer.getFlexLinesInternal();
                int size = flexLines.size();
                for (int i2 = flexLineIndex; i2 < size; i2++) {
                    FlexLine flexLine = flexLines.get(i2);
                    int j = 0;
                    int itemCount = flexLine.mItemCount;
                    while (j < itemCount) {
                        int viewIndex = flexLine.mFirstIndex + j;
                        if (j >= this.mFlexContainer.getFlexItemCount()) {
                            c = c2;
                        } else {
                            View view = this.mFlexContainer.getReorderedFlexItemAt(viewIndex);
                            if (view == null) {
                                c = c2;
                            } else if (view.getVisibility() == 8) {
                                c = c2;
                            } else {
                                FlexItem flexItem = (FlexItem) view.getLayoutParams();
                                if (flexItem.getAlignSelf() != -1) {
                                    c = 4;
                                    if (flexItem.getAlignSelf() != 4) {
                                        continue;
                                    }
                                } else {
                                    c = 4;
                                }
                                if (flexDirection == 0 || flexDirection == 1) {
                                    stretchViewVertically(view, flexLine.mCrossSize, viewIndex);
                                } else if (flexDirection == 2 || flexDirection == 3) {
                                    stretchViewHorizontally(view, flexLine.mCrossSize, viewIndex);
                                } else {
                                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                                }
                            }
                        }
                        j++;
                        c2 = c;
                    }
                    char c3 = c2;
                }
                return;
            }
            for (FlexLine flexLine2 : this.mFlexContainer.getFlexLinesInternal()) {
                for (Integer index : flexLine2.mIndicesAlignSelfStretch) {
                    View view2 = this.mFlexContainer.getReorderedFlexItemAt(index.intValue());
                    if (flexDirection == 0 || flexDirection == 1) {
                        stretchViewVertically(view2, flexLine2.mCrossSize, index.intValue());
                    } else if (flexDirection == 2 || flexDirection == 3) {
                        stretchViewHorizontally(view2, flexLine2.mCrossSize, index.intValue());
                    } else {
                        throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                    }
                }
            }
        }
    }

    private void stretchViewVertically(View view, int crossSize, int index) {
        int measuredWidth;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int newHeight = Math.min(Math.max(((crossSize - flexItem.getMarginTop()) - flexItem.getMarginBottom()) - this.mFlexContainer.getDecorationLengthCrossAxis(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        long[] jArr = this.mMeasuredSizeCache;
        if (jArr != null) {
            measuredWidth = extractLowerInt(jArr[index]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int childWidthSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, BasicMeasure.EXACTLY);
        int childHeightSpec = View.MeasureSpec.makeMeasureSpec(newHeight, BasicMeasure.EXACTLY);
        view.measure(childWidthSpec, childHeightSpec);
        updateMeasureCache(index, childWidthSpec, childHeightSpec, view);
        this.mFlexContainer.updateViewCache(index, view);
    }

    private void stretchViewHorizontally(View view, int crossSize, int index) {
        int measuredHeight;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int newWidth = Math.min(Math.max(((crossSize - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.mFlexContainer.getDecorationLengthCrossAxis(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        long[] jArr = this.mMeasuredSizeCache;
        if (jArr != null) {
            measuredHeight = extractHigherInt(jArr[index]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int childHeightSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, BasicMeasure.EXACTLY);
        int childWidthSpec = View.MeasureSpec.makeMeasureSpec(newWidth, BasicMeasure.EXACTLY);
        view.measure(childWidthSpec, childHeightSpec);
        updateMeasureCache(index, childWidthSpec, childHeightSpec, view);
        this.mFlexContainer.updateViewCache(index, view);
    }

    /* access modifiers changed from: package-private */
    public void layoutSingleChildHorizontal(View view, FlexLine flexLine, int left, int top, int right, int bottom) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.mFlexContainer.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int crossSize = flexLine.mCrossSize;
        if (alignItems != 0) {
            if (alignItems != 1) {
                if (alignItems == 2) {
                    int topFromCrossAxis = (((crossSize - view.getMeasuredHeight()) + flexItem.getMarginTop()) - flexItem.getMarginBottom()) / 2;
                    if (this.mFlexContainer.getFlexWrap() != 2) {
                        view.layout(left, top + topFromCrossAxis, right, top + topFromCrossAxis + view.getMeasuredHeight());
                        return;
                    } else {
                        view.layout(left, top - topFromCrossAxis, right, (top - topFromCrossAxis) + view.getMeasuredHeight());
                        return;
                    }
                } else if (alignItems != 3) {
                    if (alignItems != 4) {
                        return;
                    }
                } else if (this.mFlexContainer.getFlexWrap() != 2) {
                    int marginTop = Math.max(flexLine.mMaxBaseline - view.getBaseline(), flexItem.getMarginTop());
                    view.layout(left, top + marginTop, right, bottom + marginTop);
                    return;
                } else {
                    int marginBottom = Math.max((flexLine.mMaxBaseline - view.getMeasuredHeight()) + view.getBaseline(), flexItem.getMarginBottom());
                    view.layout(left, top - marginBottom, right, bottom - marginBottom);
                    return;
                }
            } else if (this.mFlexContainer.getFlexWrap() != 2) {
                view.layout(left, ((top + crossSize) - view.getMeasuredHeight()) - flexItem.getMarginBottom(), right, (top + crossSize) - flexItem.getMarginBottom());
                return;
            } else {
                view.layout(left, (top - crossSize) + view.getMeasuredHeight() + flexItem.getMarginTop(), right, (bottom - crossSize) + view.getMeasuredHeight() + flexItem.getMarginTop());
                return;
            }
        }
        if (this.mFlexContainer.getFlexWrap() != 2) {
            view.layout(left, flexItem.getMarginTop() + top, right, flexItem.getMarginTop() + bottom);
        } else {
            view.layout(left, top - flexItem.getMarginBottom(), right, bottom - flexItem.getMarginBottom());
        }
    }

    /* access modifiers changed from: package-private */
    public void layoutSingleChildVertical(View view, FlexLine flexLine, boolean isRtl, int left, int top, int right, int bottom) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.mFlexContainer.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int crossSize = flexLine.mCrossSize;
        if (alignItems != 0) {
            if (alignItems != 1) {
                if (alignItems == 2) {
                    ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int leftFromCrossAxis = (((crossSize - view.getMeasuredWidth()) + MarginLayoutParamsCompat.getMarginStart(lp)) - MarginLayoutParamsCompat.getMarginEnd(lp)) / 2;
                    if (!isRtl) {
                        view.layout(left + leftFromCrossAxis, top, right + leftFromCrossAxis, bottom);
                        return;
                    } else {
                        view.layout(left - leftFromCrossAxis, top, right - leftFromCrossAxis, bottom);
                        return;
                    }
                } else if (!(alignItems == 3 || alignItems == 4)) {
                    return;
                }
            } else if (!isRtl) {
                view.layout(((left + crossSize) - view.getMeasuredWidth()) - flexItem.getMarginRight(), top, ((right + crossSize) - view.getMeasuredWidth()) - flexItem.getMarginRight(), bottom);
                return;
            } else {
                view.layout((left - crossSize) + view.getMeasuredWidth() + flexItem.getMarginLeft(), top, (right - crossSize) + view.getMeasuredWidth() + flexItem.getMarginLeft(), bottom);
                return;
            }
        }
        if (!isRtl) {
            view.layout(flexItem.getMarginLeft() + left, top, flexItem.getMarginLeft() + right, bottom);
        } else {
            view.layout(left - flexItem.getMarginRight(), top, right - flexItem.getMarginRight(), bottom);
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureMeasuredSizeCache(int size) {
        long[] jArr = this.mMeasuredSizeCache;
        if (jArr == null) {
            int i = 10;
            if (size >= 10) {
                i = size;
            }
            this.mMeasuredSizeCache = new long[i];
        } else if (jArr.length < size) {
            int newCapacity = jArr.length * 2;
            this.mMeasuredSizeCache = Arrays.copyOf(jArr, newCapacity >= size ? newCapacity : size);
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureMeasureSpecCache(int size) {
        long[] jArr = this.mMeasureSpecCache;
        if (jArr == null) {
            int i = 10;
            if (size >= 10) {
                i = size;
            }
            this.mMeasureSpecCache = new long[i];
        } else if (jArr.length < size) {
            int newCapacity = jArr.length * 2;
            this.mMeasureSpecCache = Arrays.copyOf(jArr, newCapacity >= size ? newCapacity : size);
        }
    }

    /* access modifiers changed from: package-private */
    public int extractLowerInt(long longValue) {
        return (int) longValue;
    }

    /* access modifiers changed from: package-private */
    public int extractHigherInt(long longValue) {
        return (int) (longValue >> 32);
    }

    /* access modifiers changed from: package-private */
    public long makeCombinedLong(int widthMeasureSpec, int heightMeasureSpec) {
        return (((long) heightMeasureSpec) << 32) | (((long) widthMeasureSpec) & MEASURE_SPEC_WIDTH_MASK);
    }

    private void updateMeasureCache(int index, int widthMeasureSpec, int heightMeasureSpec, View view) {
        long[] jArr = this.mMeasureSpecCache;
        if (jArr != null) {
            jArr[index] = makeCombinedLong(widthMeasureSpec, heightMeasureSpec);
        }
        long[] jArr2 = this.mMeasuredSizeCache;
        if (jArr2 != null) {
            jArr2[index] = makeCombinedLong(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureIndexToFlexLine(int size) {
        int[] iArr = this.mIndexToFlexLine;
        if (iArr == null) {
            int i = 10;
            if (size >= 10) {
                i = size;
            }
            this.mIndexToFlexLine = new int[i];
        } else if (iArr.length < size) {
            int newCapacity = iArr.length * 2;
            this.mIndexToFlexLine = Arrays.copyOf(iArr, newCapacity >= size ? newCapacity : size);
        }
    }

    /* access modifiers changed from: package-private */
    public void clearFlexLines(List<FlexLine> flexLines, int fromFlexItem) {
        int[] iArr = this.mIndexToFlexLine;
        if (iArr == null) {
            throw new AssertionError();
        } else if (this.mMeasureSpecCache != null) {
            int fromFlexLine = iArr[fromFlexItem];
            if (fromFlexLine == -1) {
                fromFlexLine = 0;
            }
            for (int i = flexLines.size() - 1; i >= fromFlexLine; i--) {
                flexLines.remove(i);
            }
            int[] iArr2 = this.mIndexToFlexLine;
            int fillTo = iArr2.length - 1;
            if (fromFlexItem > fillTo) {
                Arrays.fill(iArr2, -1);
            } else {
                Arrays.fill(iArr2, fromFlexItem, fillTo, -1);
            }
            long[] jArr = this.mMeasureSpecCache;
            int fillTo2 = jArr.length - 1;
            if (fromFlexItem > fillTo2) {
                Arrays.fill(jArr, 0);
            } else {
                Arrays.fill(jArr, fromFlexItem, fillTo2, 0);
            }
        } else {
            throw new AssertionError();
        }
    }

    private static class Order implements Comparable<Order> {
        int index;
        int order;

        private Order() {
        }

        public int compareTo(Order another) {
            int i = this.order;
            int i2 = another.order;
            if (i != i2) {
                return i - i2;
            }
            return this.index - another.index;
        }

        public String toString() {
            return "Order{order=" + this.order + ", index=" + this.index + '}';
        }
    }

    static class FlexLinesResult {
        int mChildState;
        List<FlexLine> mFlexLines;

        FlexLinesResult() {
        }

        /* access modifiers changed from: package-private */
        public void reset() {
            this.mFlexLines = null;
            this.mChildState = 0;
        }
    }
}
