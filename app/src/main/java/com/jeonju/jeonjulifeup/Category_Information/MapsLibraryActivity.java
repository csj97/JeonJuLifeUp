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


public class MapsLibraryActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_library);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_library);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {

        mMap = googleMap;

        //-------------------------------------------------Library-------------------------------------------------------------//

        LatLng MAP_Library = new LatLng(Double.parseDouble(LibraryCategoryClick.rlibrarylatitude), Double.parseDouble(LibraryCategoryClick.rlibrarylongitude));

        MarkerOptions markerOptions_Library = new MarkerOptions();
        markerOptions_Library.position(MAP_Library);
        markerOptions_Library.title(LibraryCategoryClick.rlibraryinstitution);
        markerOptions_Library.snippet(LibraryCategoryClick.rlibraryname);
        mMap.addMarker(markerOptions_Library);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(MAP_Library));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16));
        //-------------------------------------------------Library-------------------------------------------------------------//
    }

}