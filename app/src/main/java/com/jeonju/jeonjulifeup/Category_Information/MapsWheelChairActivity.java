package com.jeonju.jeonjulifeup.Category_Information;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.jeonju.jeonjulifeup.R;

public class MapsWheelChairActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_wheelchair);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_wheelchair);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {

        mMap = googleMap;

        //-------------------------------------------------WheelChair-------------------------------------------------------------//
        LatLng MAP_WheelChair = new LatLng(Double.parseDouble(WheelChairCategoryClick.rwe), Double.parseDouble(WheelChairCategoryClick.rke));

        MarkerOptions markerOptions_WheelChair = new MarkerOptions();
        markerOptions_WheelChair.position(MAP_WheelChair);
        markerOptions_WheelChair.title("전주");
        markerOptions_WheelChair.snippet(WheelChairCategoryClick.radd);
        mMap.addMarker(markerOptions_WheelChair);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(MAP_WheelChair));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16));
        //-------------------------------------------------WheelChair-------------------------------------------------------------//
    }

}
