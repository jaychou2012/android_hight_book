package com.td.tvsuitdemo.base;

import android.animation.TimeInterpolator;
import android.view.animation.AccelerateDecelerateInterpolator;

public class Config {
    public static final TimeInterpolator interpolator = new AccelerateDecelerateInterpolator();
    public static final int ITEM_TYPE_THREE = 0;
    public static final int ITEM_TYPE_ONE_TWO = 1;
    public static final int ITEM_TYPE_TWO_BIG_SMALL = 2;
	public static final int ITEM_TYPE_ONE_THREE = 13;
	public static final int ITEM_TYPE_ONE_THREE_V = 131;
	public static final int ITEM_TYPE_TWO_EMPTY = 20;
    public static final int ITEM_TYPE_TWO = 22;
	public static final int ITEM_TYPE_TWO_ONE = 21;
    public static final int ITEM_TYPE_TWO_THIN = 11;
	public static final int ITEM_TYPE_TWO_WIDTH = 33;
	public static final int ITEM_TYPE_FOUR = 4;
	public static final int ITEM_TYPE_FOUR_EMPTY = 40;
    public static final int ITEM_TYPE_HOR = 5;
    public static final double RATIO_TYPE_5 = 198.0 / 260.0;//0.7615
    public static final float CARD_SCALE = 1.03F;
    public static final int SCALE_DURATION = 500;
}
