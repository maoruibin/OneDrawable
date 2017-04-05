/*
 *     Copyright 2017 GuDong
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package name.gudong.statebackground;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.FloatRange;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;

/**
 * Created by GuDong on 2017/4/5 14:03.
 * Contact with gudong.name@gmail.com.
 */

public class StateBackgroundUtil {
    /**
     * 默认的按下后的透明度变化值
     */
    private static final float DEFAULT_ALPHA_VALUE = 0.7f;
    /**
     * 默认按下使用 20% 透明度的黑色作为遮罩
     */
    private static final float DEFAULT_DARK_ALPHA_VALUE = 0.2f;

    public static Drawable getBackgroundWithAlphaMode(@NonNull Context context, @DrawableRes int res) {
        return getBackgroundWithAlphaMode(context, res, DEFAULT_ALPHA_VALUE);
    }

    public static Drawable getBackgroundWithAlphaMode(@NonNull Context context, @DrawableRes int res, @FloatRange(from = 0.0f, to = 1.0f) float alpha) {
        return getBackground(context, res, StatePressedMode.ALPHA, alpha);
    }

    public static Drawable getBackgroundWithDarkMode(@NonNull Context context, @DrawableRes int res) {
        return getBackgroundWithDarkMode(context, res, DEFAULT_DARK_ALPHA_VALUE);
    }

    public static Drawable getBackgroundWithDarkMode(@NonNull Context context, @DrawableRes int res, @FloatRange(from = 0.0f, to = 1.0f) float alpha) {
        return getBackground(context, res, StatePressedMode.DARK, alpha);
    }

    /**
     * 使用一个 Drawable 资源生成一个具有按下效果的 StateListDrawable
     * @param context context
     * @param res drawable  resource
     * @param mode mode for press
     * @param alpha value
     * @return a stateListDrawable
     */
    private static Drawable getBackground(@NonNull Context context, @DrawableRes int res, @StatePressedMode.Mode int mode, @FloatRange(from = 0.0f, to = 1.0f) float alpha) {
        Drawable normal = context.getResources().getDrawable(res);
        Drawable pressed = context.getResources().getDrawable(res);
        pressed.mutate();
        setPressedStateDrawable(mode, alpha, pressed);
        final StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, pressed);
        stateListDrawable.addState(new int[]{}, normal);
        return stateListDrawable;
    }

    private static void setPressedStateDrawable(@StatePressedMode.Mode int mode, @FloatRange(from = 0.0f, to = 1.0f) float alpha, @NonNull Drawable pressed) {
        switch (mode) {
            case StatePressedMode.ALPHA:
                pressed.setAlpha(convertAlphaToInt(alpha));
                break;
            case StatePressedMode.DARK:
                pressed.setColorFilter(alphaColor(Color.BLACK, convertAlphaToInt(alpha)), PorterDuff.Mode.SRC_ATOP);
                break;
            default:
                pressed.setAlpha(convertAlphaToInt(alpha));
        }
    }

    private static int convertAlphaToInt(@FloatRange(from = 0.0f, to = 1.0f) float alpha) {
        return (int) (255 * alpha);
    }

    private static int alphaColor(@ColorInt int color, @IntRange(from = 0, to = 255) int alpha) {
        return Color.argb(alpha, Color.red(color), Color.green(color), Color.blue(color));
    }

    static float getDefaultAlpha(@StatePressedMode.Mode int mode) {
        switch (mode) {
            case StatePressedMode.ALPHA:
                return DEFAULT_ALPHA_VALUE;
            case StatePressedMode.DARK:
                return DEFAULT_DARK_ALPHA_VALUE;
            default:
                return DEFAULT_ALPHA_VALUE;
        }
    }
}
