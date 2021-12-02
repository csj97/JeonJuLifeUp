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


public class MapsToiletActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_toilet);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_toilet);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {

        mMap = googleMap;

        //-------------------------------------------------Toilet-------------------------------------------------------------//
        LatLng MAP_Toilet = new LatLng(Double.parseDouble(ToiletCategoryClick.rwe), Double.parseDouble(ToiletCategoryClick.rke));

        MarkerOptions markerOptions_Toilet = new MarkerOptions();
        markerOptions_Toilet.position(MAP_Toilet);
        markerOptions_Toilet.title("전주");
        markerOptions_Toilet.snippet(  ToiletCategoryClick.rname);
        mMap.addMarker(markerOptions_Toilet);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(MAP_Toilet));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16));
        //-------------------------------------------------Toilet-------------------------------------------------------------//
    }
}