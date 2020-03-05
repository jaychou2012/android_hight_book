package com.td.tvsuit.adapter;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;

public abstract class PagerAdapter {
    private final DataSetObservable mObservable = new DataSetObservable();
    private DataSetObserver mViewPagerObserver;
    public static final int POSITION_UNCHANGED = -1;
    public static final int POSITION_NONE = -2;

    public PagerAdapter() {
    }

    public abstract int getCount();

    public void startUpdate(@NonNull ViewGroup container) {
        this.startUpdate((View)container);
    }

    @NonNull
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        return this.instantiateItem((View)container, position);
    }

    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        this.destroyItem((View)container, position, object);
    }

    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        this.setPrimaryItem((View)container, position, object);
    }

    public void finishUpdate(@NonNull ViewGroup container) {
        this.finishUpdate((View)container);
    }

    /** @deprecated */
    @Deprecated
    public void startUpdate(@NonNull View container) {
    }

    /** @deprecated */
    @Deprecated
    @NonNull
    public Object instantiateItem(@NonNull View container, int position) {
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
    }

    /** @deprecated */
    @Deprecated
    public void destroyItem(@NonNull View container, int position, @NonNull Object object) {
        throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    /** @deprecated */
    @Deprecated
    public void setPrimaryItem(@NonNull View container, int position, @NonNull Object object) {
    }

    /** @deprecated */
    @Deprecated
    public void finishUpdate(@NonNull View container) {
    }

    public abstract boolean isViewFromObject(@NonNull View var1, @NonNull Object var2);

    @Nullable
    public Parcelable saveState() {
        return null;
    }

    public void restoreState(@Nullable Parcelable state, @Nullable ClassLoader loader) {
    }

    public int getItemPosition(@NonNull Object object) {
        return -1;
    }

    public void notifyDataSetChanged() {
        synchronized(this) {
            if (this.mViewPagerObserver != null) {
                this.mViewPagerObserver.onChanged();
            }
        }

        this.mObservable.notifyChanged();
    }

    public void registerDataSetObserver(@NonNull DataSetObserver observer) {
        this.mObservable.registerObserver(observer);
    }

    public void unregisterDataSetObserver(@NonNull DataSetObserver observer) {
        this.mObservable.unregisterObserver(observer);
    }

   public void setViewPagerObserver(DataSetObserver observer) {
        synchronized(this) {
            this.mViewPagerObserver = observer;
        }
    }

    @Nullable
    public CharSequence getPageTitle(int position) {
        return null;
    }

    public float getPageWidth(int position) {
        return 1.0F;
    }
}
