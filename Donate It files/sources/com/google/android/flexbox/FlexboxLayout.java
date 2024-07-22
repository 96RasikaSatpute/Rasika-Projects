package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.google.android.flexbox.FlexboxHelper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

public class FlexboxLayout extends ViewGroup implements FlexContainer {
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    private int mAlignContent;
    private int mAlignItems;
    private Drawable mDividerDrawableHorizontal;
    private Drawable mDividerDrawableVertical;
    private int mDividerHorizontalHeight;
    private int mDividerVerticalWidth;
    private int mFlexDirection;
    private List<FlexLine> mFlexLines;
    private FlexboxHelper.FlexLinesResult mFlexLinesResult;
    private int mFlexWrap;
    private FlexboxHelper mFlexboxHelper;
    private int mJustifyContent;
    private int mMaxLine;
    private SparseIntArray mOrderCache;
    private int[] mReorderedIndices;
    private int mShowDividerHorizontal;
    private int mShowDividerVertical;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }

    public FlexboxLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public FlexboxLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlexboxLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mMaxLine = -1;
        this.mFlexboxHelper = new FlexboxHelper(this);
        this.mFlexLines = new ArrayList();
        this.mFlexLinesResult = new FlexboxHelper.FlexLinesResult();
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FlexboxLayout, defStyleAttr, 0);
        this.mFlexDirection = a.getInt(R.styleable.FlexboxLayout_flexDirection, 0);
        this.mFlexWrap = a.getInt(R.styleable.FlexboxLayout_flexWrap, 0);
        this.mJustifyContent = a.getInt(R.styleable.FlexboxLayout_justifyContent, 0);
        this.mAlignItems = a.getInt(R.styleable.FlexboxLayout_alignItems, 0);
        this.mAlignContent = a.getInt(R.styleable.FlexboxLayout_alignContent, 0);
        this.mMaxLine = a.getInt(R.styleable.FlexboxLayout_maxLine, -1);
        Drawable drawable = a.getDrawable(R.styleable.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawableHorizontal = a.getDrawable(R.styleable.FlexboxLayout_dividerDrawableHorizontal);
        if (drawableHorizontal != null) {
            setDividerDrawableHorizontal(drawableHorizontal);
        }
        Drawable drawableVertical = a.getDrawable(R.styleable.FlexboxLayout_dividerDrawableVertical);
        if (drawableVertical != null) {
            setDividerDrawableVertical(drawableVertical);
        }
        int dividerMode = a.getInt(R.styleable.FlexboxLayout_showDivider, 0);
        if (dividerMode != 0) {
            this.mShowDividerVertical = dividerMode;
            this.mShowDividerHorizontal = dividerMode;
        }
        int dividerModeVertical = a.getInt(R.styleable.FlexboxLayout_showDividerVertical, 0);
        if (dividerModeVertical != 0) {
            this.mShowDividerVertical = dividerModeVertical;
        }
        int dividerModeHorizontal = a.getInt(R.styleable.FlexboxLayout_showDividerHorizontal, 0);
        if (dividerModeHorizontal != 0) {
            this.mShowDividerHorizontal = dividerModeHorizontal;
        }
        a.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.mOrderCache == null) {
            this.mOrderCache = new SparseIntArray(getChildCount());
        }
        if (this.mFlexboxHelper.isOrderChangedFromLastMeasurement(this.mOrderCache)) {
            this.mReorderedIndices = this.mFlexboxHelper.createReorderedIndices(this.mOrderCache);
        }
        int i = this.mFlexDirection;
        if (i == 0 || i == 1) {
            measureHorizontal(widthMeasureSpec, heightMeasureSpec);
        } else if (i == 2 || i == 3) {
            measureVertical(widthMeasureSpec, heightMeasureSpec);
        } else {
            throw new IllegalStateException("Invalid value for the flex direction is set: " + this.mFlexDirection);
        }
    }

    public int getFlexItemCount() {
        return getChildCount();
    }

    public View getFlexItemAt(int index) {
        return getChildAt(index);
    }

    public View getReorderedChildAt(int index) {
        if (index < 0) {
            return null;
        }
        int[] iArr = this.mReorderedIndices;
        if (index >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[index]);
    }

    public View getReorderedFlexItemAt(int index) {
        return getReorderedChildAt(index);
    }

    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        if (this.mOrderCache == null) {
            this.mOrderCache = new SparseIntArray(getChildCount());
        }
        this.mReorderedIndices = this.mFlexboxHelper.createReorderedIndices(child, index, params, this.mOrderCache);
        super.addView(child, index, params);
    }

    private void measureHorizontal(int widthMeasureSpec, int heightMeasureSpec) {
        this.mFlexLines.clear();
        this.mFlexLinesResult.reset();
        this.mFlexboxHelper.calculateHorizontalFlexLines(this.mFlexLinesResult, widthMeasureSpec, heightMeasureSpec);
        this.mFlexLines = this.mFlexLinesResult.mFlexLines;
        this.mFlexboxHelper.determineMainSize(widthMeasureSpec, heightMeasureSpec);
        if (this.mAlignItems == 3) {
            for (FlexLine flexLine : this.mFlexLines) {
                int largestHeightInLine = Integer.MIN_VALUE;
                for (int i = 0; i < flexLine.mItemCount; i++) {
                    View child = getReorderedChildAt(flexLine.mFirstIndex + i);
                    if (!(child == null || child.getVisibility() == 8)) {
                        LayoutParams lp = (LayoutParams) child.getLayoutParams();
                        if (this.mFlexWrap != 2) {
                            largestHeightInLine = Math.max(largestHeightInLine, child.getMeasuredHeight() + Math.max(flexLine.mMaxBaseline - child.getBaseline(), lp.topMargin) + lp.bottomMargin);
                        } else {
                            largestHeightInLine = Math.max(largestHeightInLine, child.getMeasuredHeight() + lp.topMargin + Math.max((flexLine.mMaxBaseline - child.getMeasuredHeight()) + child.getBaseline(), lp.bottomMargin));
                        }
                    }
                }
                flexLine.mCrossSize = largestHeightInLine;
            }
        }
        this.mFlexboxHelper.determineCrossSize(widthMeasureSpec, heightMeasureSpec, getPaddingTop() + getPaddingBottom());
        this.mFlexboxHelper.stretchViews();
        setMeasuredDimensionForFlex(this.mFlexDirection, widthMeasureSpec, heightMeasureSpec, this.mFlexLinesResult.mChildState);
    }

    private void measureVertical(int widthMeasureSpec, int heightMeasureSpec) {
        this.mFlexLines.clear();
        this.mFlexLinesResult.reset();
        this.mFlexboxHelper.calculateVerticalFlexLines(this.mFlexLinesResult, widthMeasureSpec, heightMeasureSpec);
        this.mFlexLines = this.mFlexLinesResult.mFlexLines;
        this.mFlexboxHelper.determineMainSize(widthMeasureSpec, heightMeasureSpec);
        this.mFlexboxHelper.determineCrossSize(widthMeasureSpec, heightMeasureSpec, getPaddingLeft() + getPaddingRight());
        this.mFlexboxHelper.stretchViews();
        setMeasuredDimensionForFlex(this.mFlexDirection, widthMeasureSpec, heightMeasureSpec, this.mFlexLinesResult.mChildState);
    }

    private void setMeasuredDimensionForFlex(int flexDirection, int widthMeasureSpec, int heightMeasureSpec, int childState) {
        int calculatedMaxWidth;
        int calculatedMaxHeight;
        int widthSizeAndState;
        int heightSizeAndState;
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = View.MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = View.MeasureSpec.getSize(heightMeasureSpec);
        if (flexDirection == 0 || flexDirection == 1) {
            calculatedMaxHeight = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            calculatedMaxWidth = getLargestMainSize();
        } else if (flexDirection == 2 || flexDirection == 3) {
            calculatedMaxHeight = getLargestMainSize();
            calculatedMaxWidth = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        } else {
            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
        }
        if (widthMode == Integer.MIN_VALUE) {
            if (widthSize < calculatedMaxWidth) {
                childState = View.combineMeasuredStates(childState, 16777216);
            } else {
                widthSize = calculatedMaxWidth;
            }
            widthSizeAndState = View.resolveSizeAndState(widthSize, widthMeasureSpec, childState);
        } else if (widthMode == 0) {
            widthSizeAndState = View.resolveSizeAndState(calculatedMaxWidth, widthMeasureSpec, childState);
        } else if (widthMode == 1073741824) {
            if (widthSize < calculatedMaxWidth) {
                childState = View.combineMeasuredStates(childState, 16777216);
            }
            widthSizeAndState = View.resolveSizeAndState(widthSize, widthMeasureSpec, childState);
        } else {
            throw new IllegalStateException("Unknown width mode is set: " + widthMode);
        }
        if (heightMode == Integer.MIN_VALUE) {
            if (heightSize < calculatedMaxHeight) {
                childState = View.combineMeasuredStates(childState, 256);
            } else {
                heightSize = calculatedMaxHeight;
            }
            heightSizeAndState = View.resolveSizeAndState(heightSize, heightMeasureSpec, childState);
        } else if (heightMode == 0) {
            heightSizeAndState = View.resolveSizeAndState(calculatedMaxHeight, heightMeasureSpec, childState);
        } else if (heightMode == 1073741824) {
            if (heightSize < calculatedMaxHeight) {
                childState = View.combineMeasuredStates(childState, 256);
            }
            heightSizeAndState = View.resolveSizeAndState(heightSize, heightMeasureSpec, childState);
        } else {
            throw new IllegalStateException("Unknown height mode is set: " + heightMode);
        }
        setMeasuredDimension(widthSizeAndState, heightSizeAndState);
    }

    public int getLargestMainSize() {
        int largestSize = Integer.MIN_VALUE;
        for (FlexLine flexLine : this.mFlexLines) {
            largestSize = Math.max(largestSize, flexLine.mMainSize);
        }
        return largestSize;
    }

    public int getSumOfCrossSize() {
        int sum = 0;
        int size = this.mFlexLines.size();
        for (int i = 0; i < size; i++) {
            FlexLine flexLine = this.mFlexLines.get(i);
            if (hasDividerBeforeFlexLine(i)) {
                if (isMainAxisDirectionHorizontal()) {
                    sum += this.mDividerHorizontalHeight;
                } else {
                    sum += this.mDividerVerticalWidth;
                }
            }
            if (hasEndDividerAfterFlexLine(i)) {
                if (isMainAxisDirectionHorizontal()) {
                    sum += this.mDividerHorizontalHeight;
                } else {
                    sum += this.mDividerVerticalWidth;
                }
            }
            sum += flexLine.mCrossSize;
        }
        return sum;
    }

    public boolean isMainAxisDirectionHorizontal() {
        int i = this.mFlexDirection;
        return i == 0 || i == 1;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        boolean isRtl;
        boolean isRtl2;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i = this.mFlexDirection;
        boolean isRtl3 = false;
        if (i == 0) {
            if (layoutDirection == 1) {
                isRtl3 = true;
            }
            layoutHorizontal(isRtl3, left, top, right, bottom);
            boolean z = isRtl3;
        } else if (i == 1) {
            if (layoutDirection != 1) {
                isRtl3 = true;
            }
            layoutHorizontal(isRtl3, left, top, right, bottom);
            boolean z2 = isRtl3;
        } else if (i == 2) {
            boolean isRtl4 = layoutDirection == 1;
            if (this.mFlexWrap == 2) {
                if (!isRtl4) {
                    isRtl3 = true;
                }
                isRtl = isRtl3;
            } else {
                isRtl = isRtl4;
            }
            layoutVertical(isRtl, false, left, top, right, bottom);
        } else if (i == 3) {
            boolean isRtl5 = layoutDirection == 1;
            if (this.mFlexWrap == 2) {
                if (!isRtl5) {
                    isRtl3 = true;
                }
                isRtl2 = isRtl3;
            } else {
                isRtl2 = isRtl5;
            }
            layoutVertical(isRtl2, true, left, top, right, bottom);
        } else {
            throw new IllegalStateException("Invalid flex direction is set: " + this.mFlexDirection);
        }
    }

    private void layoutHorizontal(boolean isRtl, int left, int top, int right, int bottom) {
        float childRight;
        float childLeft;
        int paddingRight;
        boolean z;
        int paddingLeft;
        int j;
        float childRight2;
        float childLeft2;
        int beforeDividerLength;
        char c;
        LayoutParams lp;
        int paddingLeft2 = getPaddingLeft();
        int paddingRight2 = getPaddingRight();
        int width = right - left;
        int childBottom = (bottom - top) - getPaddingBottom();
        int childTop = getPaddingTop();
        int i = 0;
        int size = this.mFlexLines.size();
        while (i < size) {
            FlexLine flexLine = this.mFlexLines.get(i);
            if (hasDividerBeforeFlexLine(i)) {
                int i2 = this.mDividerHorizontalHeight;
                childBottom -= i2;
                childTop += i2;
            }
            float spaceBetweenItem = 0.0f;
            int i3 = this.mJustifyContent;
            boolean z2 = true;
            if (i3 == 0) {
                childLeft = (float) paddingLeft2;
                childRight = (float) (width - paddingRight2);
            } else if (i3 == 1) {
                childLeft = (float) ((width - flexLine.mMainSize) + paddingRight2);
                childRight = (float) (flexLine.mMainSize - paddingLeft2);
            } else if (i3 == 2) {
                float childLeft3 = ((float) paddingLeft2) + (((float) (width - flexLine.mMainSize)) / 2.0f);
                childRight = ((float) (width - paddingRight2)) - (((float) (width - flexLine.mMainSize)) / 2.0f);
                childLeft = childLeft3;
            } else if (i3 == 3) {
                childLeft = (float) paddingLeft2;
                int visibleCount = flexLine.getItemCountNotGone();
                spaceBetweenItem = ((float) (width - flexLine.mMainSize)) / (visibleCount != 1 ? (float) (visibleCount - 1) : 1.0f);
                childRight = (float) (width - paddingRight2);
            } else if (i3 == 4) {
                int visibleCount2 = flexLine.getItemCountNotGone();
                if (visibleCount2 != 0) {
                    spaceBetweenItem = ((float) (width - flexLine.mMainSize)) / ((float) visibleCount2);
                }
                childRight = ((float) (width - paddingRight2)) - (spaceBetweenItem / 2.0f);
                childLeft = ((float) paddingLeft2) + (spaceBetweenItem / 2.0f);
            } else if (i3 == 5) {
                int visibleCount3 = flexLine.getItemCountNotGone();
                if (visibleCount3 != 0) {
                    spaceBetweenItem = ((float) (width - flexLine.mMainSize)) / ((float) (visibleCount3 + 1));
                }
                childLeft = ((float) paddingLeft2) + spaceBetweenItem;
                childRight = ((float) (width - paddingRight2)) - spaceBetweenItem;
            } else {
                throw new IllegalStateException("Invalid justifyContent is set: " + this.mJustifyContent);
            }
            float spaceBetweenItem2 = Math.max(spaceBetweenItem, 0.0f);
            int j2 = 0;
            while (j2 < flexLine.mItemCount) {
                int index = flexLine.mFirstIndex + j2;
                View child = getReorderedChildAt(index);
                if (child == null) {
                    paddingLeft = paddingLeft2;
                    paddingRight = paddingRight2;
                    int i4 = index;
                    z = z2;
                    j = j2;
                } else if (child.getVisibility() == 8) {
                    paddingLeft = paddingLeft2;
                    paddingRight = paddingRight2;
                    j = j2;
                    z = true;
                } else {
                    LayoutParams lp2 = (LayoutParams) child.getLayoutParams();
                    float childLeft4 = childLeft + ((float) lp2.leftMargin);
                    float childRight3 = childRight - ((float) lp2.rightMargin);
                    int endDividerLength = 0;
                    if (hasDividerBeforeChildAtAlongMainAxis(index, j2)) {
                        int beforeDividerLength2 = this.mDividerVerticalWidth;
                        paddingLeft = paddingLeft2;
                        beforeDividerLength = beforeDividerLength2;
                        childLeft2 = childLeft4 + ((float) beforeDividerLength2);
                        childRight2 = childRight3 - ((float) beforeDividerLength2);
                    } else {
                        paddingLeft = paddingLeft2;
                        beforeDividerLength = 0;
                        childLeft2 = childLeft4;
                        childRight2 = childRight3;
                    }
                    if (j2 == flexLine.mItemCount - 1) {
                        c = 4;
                        if ((this.mShowDividerVertical & 4) > 0) {
                            endDividerLength = this.mDividerVerticalWidth;
                        }
                    } else {
                        c = 4;
                    }
                    if (this.mFlexWrap != 2) {
                        paddingRight = paddingRight2;
                        int i5 = index;
                        lp = lp2;
                        z = true;
                        char c2 = c;
                        j = j2;
                        if (isRtl) {
                            this.mFlexboxHelper.layoutSingleChildHorizontal(child, flexLine, Math.round(childRight2) - child.getMeasuredWidth(), childTop, Math.round(childRight2), childTop + child.getMeasuredHeight());
                        } else {
                            this.mFlexboxHelper.layoutSingleChildHorizontal(child, flexLine, Math.round(childLeft2), childTop, Math.round(childLeft2) + child.getMeasuredWidth(), childTop + child.getMeasuredHeight());
                        }
                    } else if (isRtl) {
                        int i6 = index;
                        z = true;
                        paddingRight = paddingRight2;
                        lp = lp2;
                        char c3 = c;
                        j = j2;
                        this.mFlexboxHelper.layoutSingleChildHorizontal(child, flexLine, Math.round(childRight2) - child.getMeasuredWidth(), childBottom - child.getMeasuredHeight(), Math.round(childRight2), childBottom);
                    } else {
                        paddingRight = paddingRight2;
                        int i7 = index;
                        lp = lp2;
                        z = true;
                        char c4 = c;
                        j = j2;
                        this.mFlexboxHelper.layoutSingleChildHorizontal(child, flexLine, Math.round(childLeft2), childBottom - child.getMeasuredHeight(), Math.round(childLeft2) + child.getMeasuredWidth(), childBottom);
                    }
                    float childLeft5 = childLeft2 + ((float) child.getMeasuredWidth()) + spaceBetweenItem2 + ((float) lp.rightMargin);
                    float childRight4 = childRight2 - ((((float) child.getMeasuredWidth()) + spaceBetweenItem2) + ((float) lp.leftMargin));
                    if (isRtl) {
                        flexLine.updatePositionFromView(child, endDividerLength, 0, beforeDividerLength, 0);
                    } else {
                        flexLine.updatePositionFromView(child, beforeDividerLength, 0, endDividerLength, 0);
                    }
                    childLeft = childLeft5;
                    childRight = childRight4;
                }
                j2 = j + 1;
                paddingLeft2 = paddingLeft;
                z2 = z;
                paddingRight2 = paddingRight;
            }
            int i8 = paddingRight2;
            int i9 = j2;
            childTop += flexLine.mCrossSize;
            childBottom -= flexLine.mCrossSize;
            i++;
            paddingLeft2 = paddingLeft2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0214  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void layoutVertical(boolean r35, boolean r36, int r37, int r38, int r39, int r40) {
        /*
            r34 = this;
            r0 = r34
            int r1 = r34.getPaddingTop()
            int r2 = r34.getPaddingBottom()
            int r3 = r34.getPaddingRight()
            int r4 = r34.getPaddingLeft()
            int r5 = r39 - r37
            int r6 = r40 - r38
            int r7 = r5 - r3
            r8 = 0
            java.util.List<com.google.android.flexbox.FlexLine> r9 = r0.mFlexLines
            int r9 = r9.size()
        L_0x001f:
            if (r8 >= r9) goto L_0x024a
            java.util.List<com.google.android.flexbox.FlexLine> r10 = r0.mFlexLines
            java.lang.Object r10 = r10.get(r8)
            com.google.android.flexbox.FlexLine r10 = (com.google.android.flexbox.FlexLine) r10
            boolean r11 = r0.hasDividerBeforeFlexLine(r8)
            if (r11 == 0) goto L_0x0033
            int r11 = r0.mDividerVerticalWidth
            int r4 = r4 + r11
            int r7 = r7 - r11
        L_0x0033:
            r11 = 0
            int r12 = r0.mJustifyContent
            r15 = 4
            r14 = 1
            if (r12 == 0) goto L_0x00d0
            if (r12 == r14) goto L_0x00c5
            r13 = 2
            r16 = 1073741824(0x40000000, float:2.0)
            if (r12 == r13) goto L_0x00af
            r13 = 3
            if (r12 == r13) goto L_0x0096
            if (r12 == r15) goto L_0x007c
            r13 = 5
            if (r12 != r13) goto L_0x0061
            int r12 = r10.getItemCountNotGone()
            if (r12 == 0) goto L_0x0059
            int r13 = r10.mMainSize
            int r13 = r6 - r13
            float r13 = (float) r13
            int r15 = r12 + 1
            float r15 = (float) r15
            float r11 = r13 / r15
        L_0x0059:
            float r13 = (float) r1
            float r13 = r13 + r11
            int r15 = r6 - r2
            float r15 = (float) r15
            float r15 = r15 - r11
            goto L_0x00d5
        L_0x0061:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = "Invalid justifyContent is set: "
            java.lang.StringBuilder r13 = r13.append(r14)
            int r14 = r0.mJustifyContent
            java.lang.StringBuilder r13 = r13.append(r14)
            java.lang.String r13 = r13.toString()
            r12.<init>(r13)
            throw r12
        L_0x007c:
            int r12 = r10.getItemCountNotGone()
            if (r12 == 0) goto L_0x008a
            int r13 = r10.mMainSize
            int r13 = r6 - r13
            float r13 = (float) r13
            float r15 = (float) r12
            float r11 = r13 / r15
        L_0x008a:
            float r13 = (float) r1
            float r15 = r11 / r16
            float r13 = r13 + r15
            int r15 = r6 - r2
            float r15 = (float) r15
            float r16 = r11 / r16
            float r15 = r15 - r16
            goto L_0x00d5
        L_0x0096:
            float r13 = (float) r1
            int r12 = r10.getItemCountNotGone()
            if (r12 == r14) goto L_0x00a1
            int r15 = r12 + -1
            float r15 = (float) r15
            goto L_0x00a3
        L_0x00a1:
            r15 = 1065353216(0x3f800000, float:1.0)
        L_0x00a3:
            int r14 = r10.mMainSize
            int r14 = r6 - r14
            float r14 = (float) r14
            float r11 = r14 / r15
            int r14 = r6 - r2
            float r14 = (float) r14
            r15 = r14
            goto L_0x00d5
        L_0x00af:
            float r12 = (float) r1
            int r13 = r10.mMainSize
            int r13 = r6 - r13
            float r13 = (float) r13
            float r13 = r13 / r16
            float r13 = r13 + r12
            int r12 = r6 - r2
            float r12 = (float) r12
            int r14 = r10.mMainSize
            int r14 = r6 - r14
            float r14 = (float) r14
            float r14 = r14 / r16
            float r15 = r12 - r14
            goto L_0x00d5
        L_0x00c5:
            int r12 = r10.mMainSize
            int r12 = r6 - r12
            int r12 = r12 + r2
            float r13 = (float) r12
            int r12 = r10.mMainSize
            int r12 = r12 - r1
            float r15 = (float) r12
            goto L_0x00d5
        L_0x00d0:
            float r13 = (float) r1
            int r12 = r6 - r2
            float r15 = (float) r12
        L_0x00d5:
            r12 = 0
            float r19 = java.lang.Math.max(r11, r12)
            r11 = 0
            r33 = r15
            r15 = r11
            r11 = r33
        L_0x00e0:
            int r12 = r10.mItemCount
            if (r15 >= r12) goto L_0x0238
            int r12 = r10.mFirstIndex
            int r14 = r12 + r15
            android.view.View r20 = r0.getReorderedChildAt(r14)
            if (r20 == 0) goto L_0x0224
            int r12 = r20.getVisibility()
            r21 = r1
            r1 = 8
            if (r12 != r1) goto L_0x0102
            r22 = r2
            r31 = r15
            r30 = 1
            r32 = 4
            goto L_0x0230
        L_0x0102:
            android.view.ViewGroup$LayoutParams r1 = r20.getLayoutParams()
            com.google.android.flexbox.FlexboxLayout$LayoutParams r1 = (com.google.android.flexbox.FlexboxLayout.LayoutParams) r1
            int r12 = r1.topMargin
            float r12 = (float) r12
            float r13 = r13 + r12
            int r12 = r1.bottomMargin
            float r12 = (float) r12
            float r11 = r11 - r12
            r12 = 0
            r16 = 0
            boolean r22 = r0.hasDividerBeforeChildAtAlongMainAxis(r14, r15)
            if (r22 == 0) goto L_0x0127
            int r12 = r0.mDividerHorizontalHeight
            r22 = r2
            float r2 = (float) r12
            float r13 = r13 + r2
            float r2 = (float) r12
            float r11 = r11 - r2
            r2 = r11
            r23 = r12
            r24 = r13
            goto L_0x012e
        L_0x0127:
            r22 = r2
            r2 = r11
            r23 = r12
            r24 = r13
        L_0x012e:
            int r11 = r10.mItemCount
            r18 = 1
            int r11 = r11 + -1
            if (r15 != r11) goto L_0x0143
            int r11 = r0.mShowDividerHorizontal
            r17 = 4
            r11 = r11 & 4
            if (r11 <= 0) goto L_0x0145
            int r11 = r0.mDividerHorizontalHeight
            r25 = r11
            goto L_0x0147
        L_0x0143:
            r17 = 4
        L_0x0145:
            r25 = r16
        L_0x0147:
            if (r35 == 0) goto L_0x01a5
            if (r36 == 0) goto L_0x017d
            com.google.android.flexbox.FlexboxHelper r11 = r0.mFlexboxHelper
            r16 = 1
            int r12 = r20.getMeasuredWidth()
            int r26 = r7 - r12
            int r12 = java.lang.Math.round(r2)
            int r13 = r20.getMeasuredHeight()
            int r27 = r12 - r13
            int r28 = java.lang.Math.round(r2)
            r12 = r20
            r13 = r10
            r29 = r14
            r30 = r18
            r14 = r16
            r31 = r15
            r32 = r17
            r15 = r26
            r16 = r27
            r17 = r7
            r18 = r28
            r11.layoutSingleChildVertical(r12, r13, r14, r15, r16, r17, r18)
            goto L_0x01ec
        L_0x017d:
            r29 = r14
            r31 = r15
            r32 = r17
            r30 = r18
            com.google.android.flexbox.FlexboxHelper r11 = r0.mFlexboxHelper
            r14 = 1
            int r12 = r20.getMeasuredWidth()
            int r15 = r7 - r12
            int r16 = java.lang.Math.round(r24)
            int r12 = java.lang.Math.round(r24)
            int r13 = r20.getMeasuredHeight()
            int r18 = r12 + r13
            r12 = r20
            r13 = r10
            r17 = r7
            r11.layoutSingleChildVertical(r12, r13, r14, r15, r16, r17, r18)
            goto L_0x01ec
        L_0x01a5:
            r29 = r14
            r31 = r15
            r32 = r17
            r30 = r18
            if (r36 == 0) goto L_0x01ce
            com.google.android.flexbox.FlexboxHelper r11 = r0.mFlexboxHelper
            r14 = 0
            int r12 = java.lang.Math.round(r2)
            int r13 = r20.getMeasuredHeight()
            int r16 = r12 - r13
            int r12 = r20.getMeasuredWidth()
            int r17 = r4 + r12
            int r18 = java.lang.Math.round(r2)
            r12 = r20
            r13 = r10
            r15 = r4
            r11.layoutSingleChildVertical(r12, r13, r14, r15, r16, r17, r18)
            goto L_0x01ec
        L_0x01ce:
            com.google.android.flexbox.FlexboxHelper r11 = r0.mFlexboxHelper
            r14 = 0
            int r16 = java.lang.Math.round(r24)
            int r12 = r20.getMeasuredWidth()
            int r17 = r4 + r12
            int r12 = java.lang.Math.round(r24)
            int r13 = r20.getMeasuredHeight()
            int r18 = r12 + r13
            r12 = r20
            r13 = r10
            r15 = r4
            r11.layoutSingleChildVertical(r12, r13, r14, r15, r16, r17, r18)
        L_0x01ec:
            int r11 = r20.getMeasuredHeight()
            float r11 = (float) r11
            float r11 = r11 + r19
            int r12 = r1.bottomMargin
            float r12 = (float) r12
            float r11 = r11 + r12
            float r24 = r24 + r11
            int r11 = r20.getMeasuredHeight()
            float r11 = (float) r11
            float r11 = r11 + r19
            int r12 = r1.topMargin
            float r12 = (float) r12
            float r11 = r11 + r12
            float r2 = r2 - r11
            if (r36 == 0) goto L_0x0214
            r13 = 0
            r15 = 0
            r11 = r10
            r12 = r20
            r14 = r25
            r16 = r23
            r11.updatePositionFromView(r12, r13, r14, r15, r16)
            goto L_0x0220
        L_0x0214:
            r13 = 0
            r15 = 0
            r11 = r10
            r12 = r20
            r14 = r23
            r16 = r25
            r11.updatePositionFromView(r12, r13, r14, r15, r16)
        L_0x0220:
            r11 = r2
            r13 = r24
            goto L_0x0230
        L_0x0224:
            r21 = r1
            r22 = r2
            r29 = r14
            r31 = r15
            r30 = 1
            r32 = 4
        L_0x0230:
            int r15 = r31 + 1
            r1 = r21
            r2 = r22
            goto L_0x00e0
        L_0x0238:
            r21 = r1
            r22 = r2
            r31 = r15
            int r1 = r10.mCrossSize
            int r4 = r4 + r1
            int r1 = r10.mCrossSize
            int r7 = r7 - r1
            int r8 = r8 + 1
            r1 = r21
            goto L_0x001f
        L_0x024a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.layoutVertical(boolean, boolean, int, int, int, int):void");
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (this.mDividerDrawableVertical != null || this.mDividerDrawableHorizontal != null) {
            if (this.mShowDividerHorizontal != 0 || this.mShowDividerVertical != 0) {
                int layoutDirection = ViewCompat.getLayoutDirection(this);
                boolean fromBottomToTop = false;
                int i = this.mFlexDirection;
                boolean z = false;
                boolean z2 = true;
                if (i == 0) {
                    if (layoutDirection == 1) {
                        z = true;
                    }
                    boolean isRtl = z;
                    if (this.mFlexWrap == 2) {
                        fromBottomToTop = true;
                    }
                    drawDividersHorizontal(canvas, isRtl, fromBottomToTop);
                } else if (i == 1) {
                    if (layoutDirection != 1) {
                        z = true;
                    }
                    boolean isRtl2 = z;
                    if (this.mFlexWrap == 2) {
                        fromBottomToTop = true;
                    }
                    drawDividersHorizontal(canvas, isRtl2, fromBottomToTop);
                } else if (i == 2) {
                    boolean isRtl3 = layoutDirection == 1;
                    if (this.mFlexWrap == 2) {
                        if (isRtl3) {
                            z2 = false;
                        }
                        isRtl3 = z2;
                    }
                    drawDividersVertical(canvas, isRtl3, false);
                } else if (i == 3) {
                    boolean isRtl4 = layoutDirection == 1;
                    if (this.mFlexWrap == 2) {
                        if (!isRtl4) {
                            z = true;
                        }
                        isRtl4 = z;
                    }
                    drawDividersVertical(canvas, isRtl4, true);
                }
            }
        }
    }

    private void drawDividersHorizontal(Canvas canvas, boolean isRtl, boolean fromBottomToTop) {
        int horizontalDividerTop;
        int horizontalDividerTop2;
        int dividerLeft;
        int dividerLeft2;
        Canvas canvas2 = canvas;
        int paddingLeft = getPaddingLeft();
        int horizontalDividerLength = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.mFlexLines.size();
        for (int i = 0; i < size; i++) {
            FlexLine flexLine = this.mFlexLines.get(i);
            for (int j = 0; j < flexLine.mItemCount; j++) {
                int viewIndex = flexLine.mFirstIndex + j;
                View view = getReorderedChildAt(viewIndex);
                if (!(view == null || view.getVisibility() == 8)) {
                    LayoutParams lp = (LayoutParams) view.getLayoutParams();
                    if (hasDividerBeforeChildAtAlongMainAxis(viewIndex, j)) {
                        if (isRtl) {
                            dividerLeft2 = view.getRight() + lp.rightMargin;
                        } else {
                            dividerLeft2 = (view.getLeft() - lp.leftMargin) - this.mDividerVerticalWidth;
                        }
                        drawVerticalDivider(canvas2, dividerLeft2, flexLine.mTop, flexLine.mCrossSize);
                    }
                    if (j == flexLine.mItemCount - 1 && (this.mShowDividerVertical & 4) > 0) {
                        if (isRtl) {
                            dividerLeft = (view.getLeft() - lp.leftMargin) - this.mDividerVerticalWidth;
                        } else {
                            dividerLeft = view.getRight() + lp.rightMargin;
                        }
                        drawVerticalDivider(canvas2, dividerLeft, flexLine.mTop, flexLine.mCrossSize);
                    }
                }
            }
            if (hasDividerBeforeFlexLine(i) != 0) {
                if (fromBottomToTop) {
                    horizontalDividerTop2 = flexLine.mBottom;
                } else {
                    horizontalDividerTop2 = flexLine.mTop - this.mDividerHorizontalHeight;
                }
                drawHorizontalDivider(canvas2, paddingLeft, horizontalDividerTop2, horizontalDividerLength);
            }
            if (hasEndDividerAfterFlexLine(i) != 0 && (this.mShowDividerHorizontal & 4) > 0) {
                if (fromBottomToTop) {
                    horizontalDividerTop = flexLine.mTop - this.mDividerHorizontalHeight;
                } else {
                    horizontalDividerTop = flexLine.mBottom;
                }
                drawHorizontalDivider(canvas2, paddingLeft, horizontalDividerTop, horizontalDividerLength);
            }
        }
    }

    private void drawDividersVertical(Canvas canvas, boolean isRtl, boolean fromBottomToTop) {
        int verticalDividerLeft;
        int verticalDividerLeft2;
        int dividerTop;
        int dividerTop2;
        Canvas canvas2 = canvas;
        int paddingTop = getPaddingTop();
        int verticalDividerLength = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.mFlexLines.size();
        for (int i = 0; i < size; i++) {
            FlexLine flexLine = this.mFlexLines.get(i);
            for (int j = 0; j < flexLine.mItemCount; j++) {
                int viewIndex = flexLine.mFirstIndex + j;
                View view = getReorderedChildAt(viewIndex);
                if (!(view == null || view.getVisibility() == 8)) {
                    LayoutParams lp = (LayoutParams) view.getLayoutParams();
                    if (hasDividerBeforeChildAtAlongMainAxis(viewIndex, j)) {
                        if (fromBottomToTop) {
                            dividerTop2 = view.getBottom() + lp.bottomMargin;
                        } else {
                            dividerTop2 = (view.getTop() - lp.topMargin) - this.mDividerHorizontalHeight;
                        }
                        drawHorizontalDivider(canvas2, flexLine.mLeft, dividerTop2, flexLine.mCrossSize);
                    }
                    if (j == flexLine.mItemCount - 1 && (this.mShowDividerHorizontal & 4) > 0) {
                        if (fromBottomToTop) {
                            dividerTop = (view.getTop() - lp.topMargin) - this.mDividerHorizontalHeight;
                        } else {
                            dividerTop = view.getBottom() + lp.bottomMargin;
                        }
                        drawHorizontalDivider(canvas2, flexLine.mLeft, dividerTop, flexLine.mCrossSize);
                    }
                }
            }
            if (hasDividerBeforeFlexLine(i) != 0) {
                if (isRtl) {
                    verticalDividerLeft2 = flexLine.mRight;
                } else {
                    verticalDividerLeft2 = flexLine.mLeft - this.mDividerVerticalWidth;
                }
                drawVerticalDivider(canvas2, verticalDividerLeft2, paddingTop, verticalDividerLength);
            }
            if (hasEndDividerAfterFlexLine(i) != 0 && (this.mShowDividerVertical & 4) > 0) {
                if (isRtl) {
                    verticalDividerLeft = flexLine.mLeft - this.mDividerVerticalWidth;
                } else {
                    verticalDividerLeft = flexLine.mRight;
                }
                drawVerticalDivider(canvas2, verticalDividerLeft, paddingTop, verticalDividerLength);
            }
        }
    }

    private void drawVerticalDivider(Canvas canvas, int left, int top, int length) {
        Drawable drawable = this.mDividerDrawableVertical;
        if (drawable != null) {
            drawable.setBounds(left, top, this.mDividerVerticalWidth + left, top + length);
            this.mDividerDrawableVertical.draw(canvas);
        }
    }

    private void drawHorizontalDivider(Canvas canvas, int left, int top, int length) {
        Drawable drawable = this.mDividerDrawableHorizontal;
        if (drawable != null) {
            drawable.setBounds(left, top, left + length, this.mDividerHorizontalHeight + top);
            this.mDividerDrawableHorizontal.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams p) {
        return p instanceof LayoutParams;
    }

    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(getContext(), attrs);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams lp) {
        if (lp instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) lp);
        }
        if (lp instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) lp);
        }
        return new LayoutParams(lp);
    }

    public int getFlexDirection() {
        return this.mFlexDirection;
    }

    public void setFlexDirection(int flexDirection) {
        if (this.mFlexDirection != flexDirection) {
            this.mFlexDirection = flexDirection;
            requestLayout();
        }
    }

    public int getFlexWrap() {
        return this.mFlexWrap;
    }

    public void setFlexWrap(int flexWrap) {
        if (this.mFlexWrap != flexWrap) {
            this.mFlexWrap = flexWrap;
            requestLayout();
        }
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
        if (this.mAlignItems != alignItems) {
            this.mAlignItems = alignItems;
            requestLayout();
        }
    }

    public int getAlignContent() {
        return this.mAlignContent;
    }

    public void setAlignContent(int alignContent) {
        if (this.mAlignContent != alignContent) {
            this.mAlignContent = alignContent;
            requestLayout();
        }
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
        for (FlexLine flexLine : this.mFlexLines) {
            if (flexLine.getItemCountNotGone() != 0) {
                result.add(flexLine);
            }
        }
        return result;
    }

    public int getDecorationLengthMainAxis(View view, int index, int indexInFlexLine) {
        int decorationLength = 0;
        if (isMainAxisDirectionHorizontal()) {
            if (hasDividerBeforeChildAtAlongMainAxis(index, indexInFlexLine)) {
                decorationLength = 0 + this.mDividerVerticalWidth;
            }
            if ((this.mShowDividerVertical & 4) > 0) {
                return decorationLength + this.mDividerVerticalWidth;
            }
            return decorationLength;
        }
        if (hasDividerBeforeChildAtAlongMainAxis(index, indexInFlexLine)) {
            decorationLength = 0 + this.mDividerHorizontalHeight;
        }
        if ((this.mShowDividerHorizontal & 4) > 0) {
            return decorationLength + this.mDividerHorizontalHeight;
        }
        return decorationLength;
    }

    public int getDecorationLengthCrossAxis(View view) {
        return 0;
    }

    public void onNewFlexLineAdded(FlexLine flexLine) {
        if (isMainAxisDirectionHorizontal()) {
            if ((this.mShowDividerVertical & 4) > 0) {
                flexLine.mMainSize += this.mDividerVerticalWidth;
                flexLine.mDividerLengthInMainSize += this.mDividerVerticalWidth;
            }
        } else if ((this.mShowDividerHorizontal & 4) > 0) {
            flexLine.mMainSize += this.mDividerHorizontalHeight;
            flexLine.mDividerLengthInMainSize += this.mDividerHorizontalHeight;
        }
    }

    public int getChildWidthMeasureSpec(int widthSpec, int padding, int childDimension) {
        return getChildMeasureSpec(widthSpec, padding, childDimension);
    }

    public int getChildHeightMeasureSpec(int heightSpec, int padding, int childDimension) {
        return getChildMeasureSpec(heightSpec, padding, childDimension);
    }

    public void onNewFlexItemAdded(View view, int index, int indexInFlexLine, FlexLine flexLine) {
        if (!hasDividerBeforeChildAtAlongMainAxis(index, indexInFlexLine)) {
            return;
        }
        if (isMainAxisDirectionHorizontal()) {
            flexLine.mMainSize += this.mDividerVerticalWidth;
            flexLine.mDividerLengthInMainSize += this.mDividerVerticalWidth;
            return;
        }
        flexLine.mMainSize += this.mDividerHorizontalHeight;
        flexLine.mDividerLengthInMainSize += this.mDividerHorizontalHeight;
    }

    public void setFlexLines(List<FlexLine> flexLines) {
        this.mFlexLines = flexLines;
    }

    public List<FlexLine> getFlexLinesInternal() {
        return this.mFlexLines;
    }

    public void updateViewCache(int position, View view) {
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.mDividerDrawableHorizontal;
    }

    public Drawable getDividerDrawableVertical() {
        return this.mDividerDrawableVertical;
    }

    public void setDividerDrawable(Drawable divider) {
        setDividerDrawableHorizontal(divider);
        setDividerDrawableVertical(divider);
    }

    public void setDividerDrawableHorizontal(Drawable divider) {
        if (divider != this.mDividerDrawableHorizontal) {
            this.mDividerDrawableHorizontal = divider;
            if (divider != null) {
                this.mDividerHorizontalHeight = divider.getIntrinsicHeight();
            } else {
                this.mDividerHorizontalHeight = 0;
            }
            setWillNotDrawFlag();
            requestLayout();
        }
    }

    public void setDividerDrawableVertical(Drawable divider) {
        if (divider != this.mDividerDrawableVertical) {
            this.mDividerDrawableVertical = divider;
            if (divider != null) {
                this.mDividerVerticalWidth = divider.getIntrinsicWidth();
            } else {
                this.mDividerVerticalWidth = 0;
            }
            setWillNotDrawFlag();
            requestLayout();
        }
    }

    public int getShowDividerVertical() {
        return this.mShowDividerVertical;
    }

    public int getShowDividerHorizontal() {
        return this.mShowDividerHorizontal;
    }

    public void setShowDivider(int dividerMode) {
        setShowDividerVertical(dividerMode);
        setShowDividerHorizontal(dividerMode);
    }

    public void setShowDividerVertical(int dividerMode) {
        if (dividerMode != this.mShowDividerVertical) {
            this.mShowDividerVertical = dividerMode;
            requestLayout();
        }
    }

    public void setShowDividerHorizontal(int dividerMode) {
        if (dividerMode != this.mShowDividerHorizontal) {
            this.mShowDividerHorizontal = dividerMode;
            requestLayout();
        }
    }

    private void setWillNotDrawFlag() {
        if (this.mDividerDrawableHorizontal == null && this.mDividerDrawableVertical == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean hasDividerBeforeChildAtAlongMainAxis(int index, int indexInFlexLine) {
        if (allViewsAreGoneBefore(index, indexInFlexLine)) {
            if (isMainAxisDirectionHorizontal()) {
                if ((this.mShowDividerVertical & 1) != 0) {
                    return true;
                }
                return false;
            } else if ((this.mShowDividerHorizontal & 1) != 0) {
                return true;
            } else {
                return false;
            }
        } else if (isMainAxisDirectionHorizontal()) {
            if ((this.mShowDividerVertical & 2) != 0) {
                return true;
            }
            return false;
        } else if ((this.mShowDividerHorizontal & 2) != 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean allViewsAreGoneBefore(int index, int indexInFlexLine) {
        for (int i = 1; i <= indexInFlexLine; i++) {
            View view = getReorderedChildAt(index - i);
            if (view != null && view.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private boolean hasDividerBeforeFlexLine(int flexLineIndex) {
        if (flexLineIndex < 0 || flexLineIndex >= this.mFlexLines.size()) {
            return false;
        }
        if (allFlexLinesAreDummyBefore(flexLineIndex)) {
            if (isMainAxisDirectionHorizontal()) {
                if ((this.mShowDividerHorizontal & 1) != 0) {
                    return true;
                }
                return false;
            } else if ((this.mShowDividerVertical & 1) != 0) {
                return true;
            } else {
                return false;
            }
        } else if (isMainAxisDirectionHorizontal()) {
            if ((this.mShowDividerHorizontal & 2) != 0) {
                return true;
            }
            return false;
        } else if ((this.mShowDividerVertical & 2) != 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean allFlexLinesAreDummyBefore(int flexLineIndex) {
        for (int i = 0; i < flexLineIndex; i++) {
            if (this.mFlexLines.get(i).getItemCountNotGone() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean hasEndDividerAfterFlexLine(int flexLineIndex) {
        if (flexLineIndex < 0 || flexLineIndex >= this.mFlexLines.size()) {
            return false;
        }
        for (int i = flexLineIndex + 1; i < this.mFlexLines.size(); i++) {
            if (this.mFlexLines.get(i).getItemCountNotGone() > 0) {
                return false;
            }
        }
        if (isMainAxisDirectionHorizontal() != 0) {
            if ((this.mShowDividerHorizontal & 4) != 0) {
                return true;
            }
            return false;
        } else if ((this.mShowDividerVertical & 4) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
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
        private int mMinHeight = -1;
        private int mMinWidth = -1;
        private int mOrder = 1;
        private boolean mWrapBefore;

        public LayoutParams(Context context, AttributeSet attrs) {
            super(context, attrs);
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.FlexboxLayout_Layout);
            this.mOrder = a.getInt(R.styleable.FlexboxLayout_Layout_layout_order, 1);
            this.mFlexGrow = a.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
            this.mFlexShrink = a.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.mAlignSelf = a.getInt(R.styleable.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.mFlexBasisPercent = a.getFraction(R.styleable.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.mMinWidth = a.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minWidth, -1);
            this.mMinHeight = a.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minHeight, -1);
            this.mMaxWidth = a.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxWidth, 16777215);
            this.mMaxHeight = a.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxHeight, 16777215);
            this.mWrapBefore = a.getBoolean(R.styleable.FlexboxLayout_Layout_layout_wrapBefore, false);
            a.recycle();
        }

        public LayoutParams(LayoutParams source) {
            super(source);
            this.mOrder = source.mOrder;
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

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }

        public LayoutParams(int width, int height) {
            super(new ViewGroup.LayoutParams(width, height));
        }

        public LayoutParams(ViewGroup.MarginLayoutParams source) {
            super(source);
        }

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

        public int getOrder() {
            return this.mOrder;
        }

        public void setOrder(int order) {
            this.mOrder = order;
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

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.mOrder);
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

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        protected LayoutParams(Parcel in) {
            super(0, 0);
            boolean z = false;
            this.mOrder = in.readInt();
            this.mFlexGrow = in.readFloat();
            this.mFlexShrink = in.readFloat();
            this.mAlignSelf = in.readInt();
            this.mFlexBasisPercent = in.readFloat();
            this.mMinWidth = in.readInt();
            this.mMinHeight = in.readInt();
            this.mMaxWidth = in.readInt();
            this.mMaxHeight = in.readInt();
            this.mWrapBefore = in.readByte() != 0 ? true : z;
            this.bottomMargin = in.readInt();
            this.leftMargin = in.readInt();
            this.rightMargin = in.readInt();
            this.topMargin = in.readInt();
            this.height = in.readInt();
            this.width = in.readInt();
        }
    }
}
