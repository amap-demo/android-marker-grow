package com.amap.markergrow;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Interpolator;
import android.widget.Toast;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.SupportMapFragment;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.animation.Animation;
import com.amap.api.maps.model.animation.ScaleAnimation;

/**
 * AMap 地图SDK添加marker生长效果动画
 */
public class MainActivity extends AppCompatActivity implements AMap.OnMarkerClickListener {
    AMap mAMap;
    LatLng markerPosition = new LatLng(39.993308, 116.473258);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    /**
     * 初始化AMap对象
     */
    private void init() {
        if (mAMap == null) {
            mAMap = ((SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map)).getMap();
            mAMap.setOnMarkerClickListener(this);
            mAMap.moveCamera(CameraUpdateFactory.changeLatLng(markerPosition));
        }
        addGrowMarker();
        Toast.makeText(this.getApplicationContext(),"点击marker查看动画效果",Toast.LENGTH_LONG).show();
    }

    /**
     * 添加带生长效果marker
     */
    private void addGrowMarker() {
        MarkerOptions options = new MarkerOptions();
        options.position(markerPosition);
        options.icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(this.getResources(),R.drawable.icon_openmap_mark)));
        Marker marker = mAMap.addMarker(options);
        Animation markerAnimation = new ScaleAnimation(0, 1, 0, 1); //初始化生长效果动画
        markerAnimation.setDuration(1000);  //设置动画时间 单位毫秒
        marker.setAnimation(markerAnimation);

    }

    /**
     * markerClick回调启动marker动画
     *
     * @param marker
     * @return
     */
    @Override
    public boolean onMarkerClick(Marker marker) {
        marker.startAnimation();
        return true;
    }
}
