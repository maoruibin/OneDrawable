#StateBackgroundUtil

[![Build Status](https://travis-ci.org/maoruibin/StateBackgroundUtil.svg?branch=master)](https://travis-ci.org/maoruibin/StateBackgroundUtil)
[![](https://img.shields.io/hexpm/l/plug.svg)](https://github.com/maoruibin/ReView/blob/master/LICENSE.txt)

Only use one drawable resource to set the background of the View.

![demo](http://7xr9gx.com1.z0.glb.clouddn.com/statebackground.gif)

## Sample
[download](https://fir.im/leku)

## Gradle
Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Add the dependency

```
dependencies {
    compile 'com.github.maoruibin:StateBackgroundUtil:1.0.0'
}
```

## Usage

pressed state with dark mode. In this mode, drawable will automatically cover a layer of dark when pressed.

```java
Drawable icon1 = StateBackgroundUtil.getBackgroundWithDarkMode(this,R.drawable.ic_action_name);
tvIcon1.setBackgroundDrawable(icon1);
```

pressed state with alpha mode. In this mode, drawable will automatically change alpha value to 0.7 when pressed.

```java
Drawable icon3 = StateBackgroundUtil.getBackgroundWithAlphaMode(this,R.drawable.ic_action_add);
tvIcon3.setBackgroundDrawable(icon3);
```

## TODO
- [ ] support color background 

## Author
[http://gudong.name](http://gudong.name)

[https://github.com/maoruibin](https://github.com/maoruibin)

[http://weibo.com/maoruibin](http://weibo.com/maoruibin)

## License

    Copyright 2017 GuDong

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.



