package com.example.louis.no_find_you;


import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


//         // 반경 1KM원
//        CircleOptions circle1KM = new CircleOptions().center(position) //원점
//                .radius(10000)      //반지름 단위 : m
//                .strokeWidth(0f)  //선너비 0f : 선없음
//                .fillColor(Color.parseColor("#880000ff")); //배경색


public class MainActivity_9_page_Google_Map_Fragment extends AppCompatActivity implements OnMapReadyCallback {


    LocationManager mLocationManager;

    private GoogleMap mGoogleMap = null;

    Location mCurrentLocation;


    double latitude;
    double longitude;

    boolean locationTag = true;


    static final String TAG = "louis";
    boolean isOpen = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_9_page_googlemap_fragment);

//-----------------------------------------------------------------------------------------------------  플로팅 액션 버튼

        final FloatingActionButton animation_plus = (FloatingActionButton) findViewById(R.id.animation_plus);

        final FloatingActionButton animation_person_outline = (FloatingActionButton) findViewById(R.id.animation_person_outline);
        final FloatingActionButton animation_location = (FloatingActionButton) findViewById(R.id.animation_location);


        final Animation floatingactionbutton_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        final Animation floatingactionbutton_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);

        final Animation rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_forward);
        final Animation rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_backward);


        animation_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isOpen) {
                    animation_person_outline.startAnimation(floatingactionbutton_close);
                    animation_location.startAnimation(floatingactionbutton_close);

                    animation_plus.startAnimation(rotate_backward);

                    animation_person_outline.setClickable(false);
                    animation_location.setClickable(false);

                    isOpen = false;

                } else {
                    animation_person_outline.startAnimation(floatingactionbutton_open);
                    animation_location.startAnimation(floatingactionbutton_open);

                    animation_plus.startAnimation(rotate_forward);

                    animation_person_outline.setClickable(true);
                    animation_location.setClickable(true);

                    isOpen = true;
                }

            }
        }); // ------------------------------------------------------------------------------------------플로팅 액션버튼 끝


        //--------------------------------------------------------------------------구글 지도
        mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.main_9_fragment);
        mapFragment.getMapAsync(this);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }


        if (mLocationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {

            mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, new LocationListener() {

                @Override
                public void onLocationChanged(Location location) {

                    mCurrentLocation = location;

                    setCurrentLocation();

                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            });

        } else if (mLocationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {

            mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {

                @Override
                public void onLocationChanged(Location location) {

                        setCurrentLocation();

                }

                @Override
                public void onStatusChanged(String provider, int status, Bundle extras) {

                }

                @Override
                public void onProviderEnabled(String provider) {

                }

                @Override
                public void onProviderDisabled(String provider) {

                }
            });
        }


    }//------------------------------------------------------------------------------------------------------------------------------------------------------ onCreate End


    //------------------------------------------------------------------    현재 나의 위치
    private void setCurrentLocation() {


        latitude = mCurrentLocation.getLatitude();
        longitude = mCurrentLocation.getLongitude();

        LatLng latLng = new LatLng(latitude, longitude);

        CircleOptions circleOptions = new CircleOptions();

        MarkerOptions markerOptions = new MarkerOptions();

        markerOptions.position(latLng);
        markerOptions.title(getCurrentAddress(latLng));

        markerOptions.snippet("\n NETWORK" + "\n 위도 : " + String.valueOf(mCurrentLocation.getLatitude())
                + "\n경도 : " + String.valueOf(mCurrentLocation.getLongitude()));


        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        markerOptions.draggable(true);

        circleOptions.center(latLng);
        circleOptions.strokeWidth(5);
        circleOptions.radius(10000);
//                    circleOptions.strokeColor(Color.argb(200, 255, 0, 255));
//                    circleOptions.fillColor(Color.argb(20, 255, 0, 255));

        mGoogleMap.addCircle(circleOptions);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mGoogleMap.setMyLocationEnabled(true);
        mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17));





    }



    @Override
    public void onMapReady(GoogleMap googleMap) {

        mGoogleMap = googleMap;


    }

    @Override
    protected void onResume() {
        super.onResume();


    }


    @Override
    protected void onStop() {
        super.onStop();

    }

    //-----------------------------------------------------------------------------------------------지오코더 현주소 가져오기
    public String getCurrentAddress(LatLng latlng) {

        //지오코더... GPS를 주소로 변환
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());

        List<Address> addresses;

        try {

            addresses = geocoder.getFromLocation(latlng.latitude, latlng.longitude, 1);

        } catch (IOException ioException) {

            //네트워크 문제
            Toast.makeText(this, "지오코더 서비스 사용불가", Toast.LENGTH_LONG).show();
            return "지오코더 서비스 사용불가";

        } catch (IllegalArgumentException illegalArgumentException) {

            Toast.makeText(this, "잘못된 GPS 좌표", Toast.LENGTH_LONG).show();
            return "잘못된 GPS 좌표";

        }
        if (addresses == null || addresses.size() == 0) {
            Toast.makeText(this, "주소 미발견", Toast.LENGTH_LONG).show();
            return "주소 미발견";

        } else {
            Address address = addresses.get(0);
            return address.getAddressLine(0).toString();
        }

    }





}// End of Class


/**  나의게 필요한 메서드
 *
 *
 * void 메서드 addProximityAlert( double latitude , double longitude , float radius , long expiration , pendingIntent Intent)
 *
 * 이 메서드는 ------> 위치 (위도, 경도) 및 주어진 반지름으로 주이진 위치에 대한 근접 경고를 설정 하십시요.
 *
 * 안드로이드 개발자 홈페이지에서 메서드 종류가 많다 ----------> LocationManager 에서 좋은 메서드들이 많다
 *
 */






