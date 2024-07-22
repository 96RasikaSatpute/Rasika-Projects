package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FlexboxItemDecoration extends RecyclerView.ItemDecoration {
    public static final int BOTH = 3;
    public static final int HORIZONTAL = 1;
    private static final int[] LIST_DIVIDER_ATTRS = {16843284};
    public static final int VERTICAL = 2;
    private Drawable mDrawable;
    private int mOrientation;

    public FlexboxItemDecoration(Context context) {
        TypedArray a = context.obtainStyledAttributes(LIST_DIVIDER_ATTRS);
        this.mDrawable = a.getDrawable(0);
        a.recycle();
        setOrientation(3);
    }

    public void setDrawable(Drawable drawable) {
        if (drawable != null) {
            this.mDrawable = drawable;
            return;
        }
        throw new IllegalArgumentException("Drawable cannot be null.");
    }

    public void setOrientation(int orientation) {
        this.mOrientation = orientation;
    }

    public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        drawHorizontalDecorations(canvas, parent);
        drawVerticalDecorations(canvas, parent);
    }

    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view);
        if (position != 0) {
            if (needsHorizontalDecoration() || needsVerticalDecoration()) {
                FlexboxLayoutManager layoutManager = (FlexboxLayoutManager) parent.getLayoutManager();
                List<FlexLine> flexLines = layoutManager.getFlexLines();
                setOffsetAlongMainAxis(outRect, position, layoutManager, flexLines, layoutManager.getFlexDirection());
                setOffsetAlongCrossAxis(outRect, position, layoutManager, flexLines);
                return;
            }
            outRect.set(0, 0, 0, 0);
        }
    }

    private void setOffsetAlongCrossAxis(Rect outRect, int position, FlexboxLayoutManager layoutManager, List<FlexLine> flexLines) {
        if (flexLines.size() != 0 && layoutManager.getPositionToFlexLineIndex(position) != 0) {
            if (layoutManager.isMainAxisDirectionHorizontal()) {
                if (!needsHorizontalDecoration()) {
                    outRect.top = 0;
                    outRect.bottom = 0;
                    return;
                }
                outRect.top = this.mDrawable.getIntrinsicHeight();
                outRect.bottom = 0;
            } else if (needsVerticalDecoration()) {
                if (layoutManager.isLayoutRtl()) {
                    outRect.right = this.mDrawable.getIntrinsicWidth();
                    outRect.left = 0;
                    return;
                }
                outRect.left = this.mDrawable.getIntrinsicWidth();
                outRect.right = 0;
            }
        }
    }

    private void setOffsetAlongMainAxis(Rect outRect, int position, FlexboxLayoutManager layoutManager, List<FlexLine> flexLines, int flexDirection) {
        if (!isFirstItemInLine(position, flexLines, layoutManager)) {
            if (layoutManager.isMainAxisDirectionHorizontal()) {
                if (!needsVerticalDecoration()) {
                    outRect.left = 0;
                    outRect.right = 0;
                } else if (layoutManager.isLayoutRtl()) {
                    outRect.right = this.mDrawable.getIntrinsicWidth();
                    outRect.left = 0;
                } else {
                    outRect.left = this.mDrawable.getIntrinsicWidth();
                    outRect.right = 0;
                }
            } else if (!needsHorizontalDecoration()) {
                outRect.top = 0;
                outRect.bottom = 0;
            } else if (flexDirection == 3) {
                outRect.bottom = this.mDrawable.getIntrinsicHeight();
                outRect.top = 0;
            } else {
                outRect.top = this.mDrawable.getIntrinsicHeight();
                outRect.bottom = 0;
            }
        }
    }

    private void drawVerticalDecorations(Canvas canvas, RecyclerView parent) {
        int right;
        int left;
        int bottom;
        int top;
        if (needsVerticalDecoration()) {
            FlexboxLayoutManager layoutManager = (FlexboxLayoutManager) parent.getLayoutManager();
            int parentTop = parent.getTop() - parent.getPaddingTop();
            int parentBottom = parent.getBottom() + parent.getPaddingBottom();
            int childCount = parent.getChildCount();
            int flexDirection = layoutManager.getFlexDirection();
            for (int i = 0; i < childCount; i++) {
                View child = parent.getChildAt(i);
                RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) child.getLayoutParams();
                if (layoutManager.isLayoutRtl()) {
                    left = child.getRight() + lp.rightMargin;
                    right = this.mDrawable.getIntrinsicWidth() + left;
                } else {
                    right = child.getLeft() - lp.leftMargin;
                    left = right - this.mDrawable.getIntrinsicWidth();
                }
                if (layoutManager.isMainAxisDirectionHorizontal()) {
                    top = child.getTop() - lp.topMargin;
                    bottom = child.getBottom() + lp.bottomMargin;
                } else if (flexDirection == 3) {
                    bottom = Math.min(child.getBottom() + lp.bottomMargin + this.mDrawable.getIntrinsicHeight(), parentBottom);
                    top = child.getTop() - lp.topMargin;
                } else {
                    top = Math.max((child.getTop() - lp.topMargin) - this.mDrawable.getIntrinsicHeight(), parentTop);
                    bottom = child.getBottom() + lp.bottomMargin;
                }
                this.mDrawable.setBounds(left, top, right, bottom);
                this.mDrawable.draw(canvas);
            }
        }
    }

    private void drawHorizontalDecorations(Canvas canvas, RecyclerView parent) {
        int bottom;
        int top;
        int left;
        int right;
        if (needsHorizontalDecoration()) {
            FlexboxLayoutManager layoutManager = (FlexboxLayoutManager) parent.getLayoutManager();
            int flexDirection = layoutManager.getFlexDirection();
            int parentLeft = parent.getLeft() - parent.getPaddingLeft();
            int parentRight = parent.getRight() + parent.getPaddingRight();
            int childCount = parent.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View child = parent.getChildAt(i);
                RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) child.getLayoutParams();
                if (flexDirection == 3) {
                    top = child.getBottom() + lp.bottomMargin;
                    bottom = this.mDrawable.getIntrinsicHeight() + top;
                } else {
                    bottom = child.getTop() - lp.topMargin;
                    top = bottom - this.mDrawable.getIntrinsicHeight();
                }
                if (!layoutManager.isMainAxisDirectionHorizontal()) {
                    left = child.getLeft() - lp.leftMargin;
                    right = child.getRight() + lp.rightMargin;
                } else if (layoutManager.isLayoutRtl()) {
                    right = Math.min(child.getRight() + lp.rightMargin + this.mDrawable.getIntrinsicWidth(), parentRight);
                    left = child.getLeft() - lp.leftMargin;
                } else {
                    left = Math.max((child.getLeft() - lp.leftMargin) - this.mDrawable.getIntrinsicWidth(), parentLeft);
                    right = child.getRight() + lp.rightMargin;
                }
                this.mDrawable.setBounds(left, top, right, bottom);
                this.mDrawable.draw(canvas);
            }
        }
    }

    private boolean needsHorizontalDecoration() {
        return (this.mOrientation & 1) > 0;
    }

    private boolean needsVerticalDecoration() {
        return (this.mOrientation & 2) > 0;
    }

    private boolean isFirstItemInLine(int position, List<FlexLine> flexLines, FlexboxLayoutManager layoutManager) {
        int flexLineIndex = layoutManager.getPositionToFlexLineIndex(position);
        if ((flexLineIndex != -1 && flexLineIndex < layoutManager.getFlexLinesInternal().size() && layoutManager.getFlexLinesInternal().get(flexLineIndex).mFirstIndex == position) || position == 0) {
            return true;
        }
        if (flexLines.size() == 0) {
            return false;
        }
        if (flexLines.get(flexLines.size() - 1).mLastIndex == position - 1) {
            return true;
        }
        return false;
    }
}
