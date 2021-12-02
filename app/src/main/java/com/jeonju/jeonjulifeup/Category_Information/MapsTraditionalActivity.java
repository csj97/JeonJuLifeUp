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

public class MapsTraditionalActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_traditional);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_traditional);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {

        mMap = googleMap;

        //-------------------------------------------------Traditional-------------------------------------------------------------//

        LatLng MAP_Traditional = new LatLng(Double.parseDouble(TraditionalCategoryClick.rwe), Double.parseDouble(TraditionalCategoryClick.rke));

        MarkerOptions markerOptions_Traditional = new MarkerOptions();
        markerOptions_Traditional.position(MAP_Traditional);
        markerOptions_Traditional.title(TraditionalCategoryClick.rtype);
        markerOptions_Traditional.snippet(TraditionalCategoryClick.rname);
        mMap.addMarker(markerOptions_Traditional);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(MAP_Traditional));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16));
        //-------------------------------------------------Traditional-------------------------------------------------------------//
    }
}
