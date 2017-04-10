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

package name.gudong.demo;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;

import name.gudong.statebackground.OneDrawable;

public class MainActivity extends Activity {
    private TextView tvIcon1;
    private TextView tvIcon2;
    private TextView tvIcon3;
    private TextView tvIcon4;
    private TextView tvColor1;
    private TextView tvColor2;
    private TextView tvColor3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvIcon1 = (TextView) findViewById(R.id.tv_icon_1);
        tvIcon2 = (TextView) findViewById(R.id.tv_icon_2);
        tvIcon3 = (TextView) findViewById(R.id.tv_icon_3);
        tvIcon4 = (TextView) findViewById(R.id.tv_icon_4);

        tvColor1 = (TextView) findViewById(R.id.tv_color_1);
        tvColor2 = (TextView) findViewById(R.id.tv_color_2);
        tvColor3 = (TextView) findViewById(R.id.tv_color_3);


        Drawable icon1 = OneDrawable.createBgDrawable(this, R.drawable.ic_action_add);
        tvIcon1.setBackgroundDrawable(icon1);
        tvIcon1.setClickable(true);
        tvIcon1.setEnabled(false);

        tvIcon1.postDelayed(new Runnable() {
            @Override
            public void run() {
                tvIcon1.setEnabled(true);
            }
        }, 3000);

        Drawable icon2 = OneDrawable.createBgDrawableWithDarkMode(this, R.drawable.ic_action_add, 0.4f);
        tvIcon2.setBackgroundDrawable(icon2);
        tvIcon2.setClickable(true);

        Drawable icon3 = OneDrawable.createBgDrawableWithAlphaMode(this, R.drawable.ic_action_name);
        tvIcon3.setBackgroundDrawable(icon3);
        tvIcon3.setClickable(true);

        Drawable icon4 = OneDrawable.createBgDrawableWithAlphaMode(this, R.drawable.ic_action_name, 0.3f);
        tvIcon4.setBackgroundDrawable(icon4);
        tvIcon4.setClickable(true);

        Drawable color1 = OneDrawable.createBgColorWithAlphaMode(this, getResources().getColor(R.color.colorPrimary));
        tvColor1.setBackgroundDrawable(color1);
        tvColor1.setClickable(true);

        Drawable color2 = OneDrawable.createBgColor(this, getResources().getColor(R.color.colorAccent));
        tvColor2.setBackgroundDrawable(color2);
        tvColor2.setClickable(true);
        tvColor2.setEnabled(false);
        tvColor2.postDelayed(new Runnable() {
            @Override
            public void run() {
                tvColor2.setEnabled(true);
            }
        }, 1000);

        Drawable color3 = OneDrawable.createBgColor(this, Color.parseColor("#cccccc"));
        tvColor3.setBackgroundDrawable(color3);
        tvColor3.setClickable(true);
        tvColor3.setEnabled(false);
        tvColor3.postDelayed(new Runnable() {
            @Override
            public void run() {
                tvColor3.setEnabled(true);
            }
        }, 1000);
    }
}
