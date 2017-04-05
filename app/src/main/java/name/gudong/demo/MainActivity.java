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
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.TextView;

import name.gudong.statebackground.StateBackgroundUtil;

public class MainActivity extends Activity {
    private TextView tvIcon1;
    private TextView tvIcon2;
    private TextView tvIcon3;
    private TextView tvIcon4;
    private TextView tvIcon5;
    private TextView tvIcon6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvIcon1 = (TextView) findViewById(R.id.tv_icon_1);
        tvIcon2 = (TextView) findViewById(R.id.tv_icon_2);
        tvIcon3 = (TextView) findViewById(R.id.tv_icon_3);
        tvIcon4 = (TextView) findViewById(R.id.tv_icon_4);
        tvIcon5 = (TextView) findViewById(R.id.tv_icon_5);
        tvIcon6 = (TextView) findViewById(R.id.tv_icon_6);

        Drawable icon1 = StateBackgroundUtil.getBackgroundWithDarkMode(this,R.drawable.ic_action_name);
        tvIcon1.setBackgroundDrawable(icon1);
        tvIcon1.setClickable(true);

        Drawable icon2 = StateBackgroundUtil.getBackgroundWithDarkMode(this,R.drawable.ic_action_name,0.4f);
        tvIcon2.setBackgroundDrawable(icon2);
        tvIcon2.setClickable(true);

        Drawable icon3 = StateBackgroundUtil.getBackgroundWithAlphaMode(this,R.drawable.ic_action_add);
        tvIcon3.setBackgroundDrawable(icon3);
        tvIcon3.setClickable(true);

        tvIcon4.setBackgroundDrawable(StateBackgroundUtil.getBackgroundWithAlphaMode(this,R.drawable.ic_action_add,0.3f));
        tvIcon4.setClickable(true);

        tvIcon5.setBackgroundDrawable(StateBackgroundUtil.getBackgroundWithDarkMode(this,R.drawable.bk_round));
        tvIcon5.setClickable(true);

        tvIcon6.setBackgroundDrawable(StateBackgroundUtil.getBackgroundWithDarkMode(this,R.drawable.bk_round,0.3f));
        tvIcon6.setClickable(true);
    }
}
