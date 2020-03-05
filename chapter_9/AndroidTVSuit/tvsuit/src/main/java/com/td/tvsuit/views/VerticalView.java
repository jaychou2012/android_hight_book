package com.td.tvsuit.views;

import android.content.Context;
import android.graphics.Rect;
import android.support.v17.leanback.widget.VerticalGridView;
import android.support.v7.widget.GridLayoutManager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.Toast;

//import android.support.v17.leanback.widget.GridLayoutManager;

public class VerticalView extends VerticalGridView {
    private int mLoadMoreBeforehandCount = 0;
    private OnLoadMoreListener mOnLoadMoreListener;
    private int columnCount;
    private boolean isLoading = false;

    public VerticalView(Context context) {
        super(context);
        init();
    }

    public VerticalView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public VerticalView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setDescendantFocusability(FOCUS_AFTER_DESCENDANTS);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setLayoutFrozen(true);
    }

    @Override
    public boolean onRequestFocusInDescendants(int direction, Rect previouslyFocusedRect) {
        return super.onRequestFocusInDescendants(direction, previouslyFocusedRect);
//        return onRequestFocusInDescendantsSuper(direction, previouslyFocusedRect);
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    public void isLoading(boolean isLoading) {
        this.isLoading = isLoading;
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            if (isLoading) {
                return true;
            }
            if (columnCount == 0) {
                return super.dispatchKeyEvent(event);
            }
            if (getLayoutManager().getItemCount() % columnCount == 0) {
                return super.dispatchKeyEvent(event);
            }
            if (getLayoutManager().getItemCount() - getSelectedPosition() < 2 * columnCount) {
                switch (event.getKeyCode()) {
                    case KeyEvent.KEYCODE_DPAD_DOWN:
                        if ((getSelectedPosition() + 1) % columnCount == 0) {
                            setSelectedPosition(getSelectedPosition() + 1);
                        } else if ((getSelectedPosition() + 1) % columnCount > (getLayoutManager().getItemCount() % columnCount)) {
                            setSelectedPosition(getLayoutManager().getItemCount() - 1);
                        }
                        break;
                }
            }
        }
        return super.dispatchKeyEvent(event);
    }

    public void showToast(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onScrollStateChanged(int state) {
        if (columnCount == 0) {
            super.onScrollStateChanged(state);
            return;
        }
        if (state == SCROLL_STATE_IDLE) {
            int totalItemCount = getLayoutManager().getItemCount();
            int totalRow = totalItemCount / columnCount;
            int selectionPosition = getSelectedPosition();
            int currentRow = selectionPosition / columnCount;
            if (currentRow == totalRow - 1) {
                if (mOnLoadMoreListener != null) {
                    mOnLoadMoreListener.onLoadMore();
                }
            }
        }
        super.onScrollStateChanged(state);
    }

    public GridLayoutManager getTVLayoutManager() {
        if (getLayoutManager() instanceof GridLayoutManager) {
            return (GridLayoutManager) getLayoutManager();
        }
        return (GridLayoutManager) getLayoutManager();
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        mOnLoadMoreListener = onLoadMoreListener;
    }

    public interface OnLoadMoreListener {
        boolean onLoadMore();
    }
}
