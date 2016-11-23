# android-marker-grow

Marker生长动画示例

## 前述 ##
- [高德官网申请Key](http://lbs.amap.com/dev/#/).
- 阅读
  [地图SDK参考手册](http://a.amap.com/lbs/static/unzip/Android_Map_Doc/index.html). 
- 工程基于高德地图实现

## 使用方法##
###1:配置搭建AndroidSDK工程###
- [Android Studio工程搭建方法](http://lbs.amap.com/api/android-sdk/guide/creat-project/android-studio-creat-project/#add-jars).
- [通过maven库引入SDK方法](http://lbsbbs.amap.com/forum.php?mod=viewthread&tid=18786).


## 示例效果##
![img](https://github.com/amap-demo/android-marker-grow/raw/master/resource/markerGrow.gif)


## 扫一扫安装##
![Screenshot](https://github.com/amap-demo/android-marker-grow/raw/master/resource/download.png)


##实现步骤##
 - 添加marker
 
 ```java
   MarkerOptions options = new MarkerOptions();
   options.position(markerPosition);
   Marker marker = mAMap.addMarker(options);
 ```
 - 设置marker动画
 
 ```java
  Animation markerAnimation = new ScaleAnimation(0, 1, 0, 1); //初始化生长效果动画
  markerAnimation.setDuration(1000);  //设置动画时间 单位毫秒
  marker.setAnimation(markerAnimation);
 ```
 - 启动marker动画
 
 ```java
  marker.startAnimation();
  ```
