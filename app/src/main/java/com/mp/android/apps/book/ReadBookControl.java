
package com.mp.android.apps.book;

import android.content.SharedPreferences;
import android.graphics.Color;

import com.mp.android.apps.book.utils.DensityUtil;
import com.mp.android.apps.MyApplication;
import com.mp.android.apps.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 读书界面控制器
 * <p>
 * 控制 1.背景 2.字号 3. 音量翻页 4.点击页面两侧翻页
 */
public class ReadBookControl {
    /**
     * 字号默认设置为16 行间距默认设置为8
     */
    public static final int DEFAULT_TEXT = 2;
    /**
     * 背景默认设置为
     */
    public static final int DEFAULT_BG = 1;

    /**
     * 文字大小设置(设置文字大小需要同时修改行间距)
     * textSize 文字大小尺寸设置
     * textExtra 文字行间距设置
     */
    private static List<Map<String, Integer>> textKind;

    /**
     * 背景色设置(设置背景色需要同时修改文字颜色)
     * textColor 文字颜色
     * textBackground 背景色彩
     */
    private static List<Map<String, Integer>> textDrawable;

    private int textSize;
    private int textExtra;
    private int textColor;
    private int textBackground;

    private int textKindIndex = DEFAULT_TEXT;
    private int textDrawableIndex = DEFAULT_BG;

    private Boolean canClickTurn = true;
    private Boolean canKeyTurn = true;

    /**
     * 应用sp存储设置内容及相关状态
     */
    private SharedPreferences preference;

    private static ReadBookControl readBookControl;

    public static ReadBookControl getInstance() {
        if (readBookControl == null) {
            synchronized (ReadBookControl.class) {
                if (readBookControl == null) {
                    readBookControl = new ReadBookControl();
                }
            }
        }
        return readBookControl;
    }

    private ReadBookControl() {
        if (null == textKind) {
            textKind = new ArrayList<>();
            Map<String, Integer> temp1 = new HashMap<>();
            temp1.put("textSize", 14);
            temp1.put("textExtra", DensityUtil.dp2px(MyApplication.getInstance(), 6.5f));
            textKind.add(temp1);

            Map<String, Integer> temp2 = new HashMap<>();
            temp2.put("textSize", 16);
            temp2.put("textExtra", DensityUtil.dp2px(MyApplication.getInstance(), 8));
            textKind.add(temp2);

            Map<String, Integer> temp3 = new HashMap<>();
            temp3.put("textSize", 17);
            temp3.put("textExtra", DensityUtil.dp2px(MyApplication.getInstance(), 9));
            textKind.add(temp3);

            Map<String, Integer> temp4 = new HashMap<>();
            temp4.put("textSize", 20);
            temp4.put("textExtra", DensityUtil.dp2px(MyApplication.getInstance(), 11));
            textKind.add(temp4);

            Map<String, Integer> temp5 = new HashMap<>();
            temp5.put("textSize", 22);
            temp5.put("textExtra", DensityUtil.dp2px(MyApplication.getInstance(), 13));
            textKind.add(temp5);

            Map<String, Integer> temp6 = new HashMap<>();
            temp6.put("textSize", 24);
            temp6.put("textExtra", DensityUtil.dp2px(MyApplication.getInstance(), 15));
            textKind.add(temp6);

            Map<String, Integer> temp7 = new HashMap<>();
            temp7.put("textSize", 26);
            temp7.put("textExtra", DensityUtil.dp2px(MyApplication.getInstance(), 17));
            textKind.add(temp7);

        }
        if (null == textDrawable) {
            textDrawable = new ArrayList<>();
            Map<String, Integer> temp1 = new HashMap<>();
            temp1.put("textColor", Color.parseColor("#3E3D3B"));
            temp1.put("textBackground", R.drawable.shape_bg_readbook_white);
            textDrawable.add(temp1);

            Map<String, Integer> temp2 = new HashMap<>();
            temp2.put("textColor", Color.parseColor("#5E432E"));
            temp2.put("textBackground", R.drawable.bg_readbook_yellow);
            textDrawable.add(temp2);

            Map<String, Integer> temp3 = new HashMap<>();
            temp3.put("textColor", Color.parseColor("#22482C"));
            temp3.put("textBackground", R.drawable.bg_readbook_green);
            textDrawable.add(temp3);

            Map<String, Integer> temp4 = new HashMap<>();
            temp4.put("textColor", Color.parseColor("#808080"));
            temp4.put("textBackground", R.drawable.bg_readbook_black);
            textDrawable.add(temp4);
        }

        preference = MyApplication.getInstance().getSharedPreferences("CONFIG", 0);

        this.textKindIndex = preference.getInt("textKindIndex", DEFAULT_TEXT);
        this.textSize = textKind.get(textKindIndex).get("textSize");
        this.textExtra = textKind.get(textKindIndex).get("textExtra");

        this.textDrawableIndex = preference.getInt("textDrawableIndex", DEFAULT_BG);
        this.textColor = textDrawable.get(textDrawableIndex).get("textColor");
        this.textBackground = textDrawable.get(textDrawableIndex).get("textBackground");

        this.canClickTurn = preference.getBoolean("canClickTurn", true);
        this.canKeyTurn = preference.getBoolean("canClickTurn", true);
    }

    public int getTextSize() {
        return textSize;
    }

    public int getTextExtra() {
        return textExtra;
    }

    public int getTextColor() {
        return textColor;
    }

    public int getTextBackground() {
        return textBackground;
    }

    public int getTextKindIndex() {
        return textKindIndex;
    }

    public void setTextKindIndex(int textKindIndex) {
        this.textKindIndex = textKindIndex;
        SharedPreferences.Editor editor = preference.edit();
        editor.putInt("textKindIndex", textKindIndex);
        editor.commit();
        this.textSize = textKind.get(textKindIndex).get("textSize");
        this.textExtra = textKind.get(textKindIndex).get("textExtra");
    }

    public int getTextDrawableIndex() {
        return textDrawableIndex;
    }

    public void setTextDrawableIndex(int textDrawableIndex) {
        this.textDrawableIndex = textDrawableIndex;
        SharedPreferences.Editor editor = preference.edit();
        editor.putInt("textDrawableIndex", textDrawableIndex);
        editor.commit();
        this.textColor = textDrawable.get(textDrawableIndex).get("textColor");
        this.textBackground = textDrawable.get(textDrawableIndex).get("textBackground");
    }

    public static List<Map<String, Integer>> getTextKind() {
        return textKind;
    }

    public static List<Map<String, Integer>> getTextDrawable() {
        return textDrawable;
    }

    public Boolean getCanKeyTurn() {
        return canKeyTurn;
    }

    public void setCanKeyTurn(Boolean canKeyTurn) {
        this.canKeyTurn = canKeyTurn;
        SharedPreferences.Editor editor = preference.edit();
        editor.putBoolean("canKeyTurn", canKeyTurn);
        editor.commit();
    }

    public Boolean getCanClickTurn() {
        return canClickTurn;
    }

    public void setCanClickTurn(Boolean canClickTurn) {
        this.canClickTurn = canClickTurn;
        SharedPreferences.Editor editor = preference.edit();
        editor.putBoolean("canClickTurn", canClickTurn);
        editor.commit();
    }

    public int getDayColorIndex() {
        return preference.getInt("dayColorIndex", 1);
    }

    public void setDayColorIndex(int dayColorIndex) {
        preference.edit().putInt("dayColorIndex", dayColorIndex).apply();

    }
}