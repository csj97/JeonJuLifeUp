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

public class MapsParkActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_park);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map_park);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(final GoogleMap googleMap) {

        mMap = googleMap;

        //-------------------------------------------------Park-------------------------------------------------------------//

        LatLng MAP_Park = new LatLng(Double.parseDouble(ParkCategoryClick.pwe), Double.parseDouble(ParkCategoryClick.pke));

        MarkerOptions markerOptions_Park = new MarkerOptions();
        markerOptions_Park.position(MAP_Park);
        markerOptions_Park.title(ParkCategoryClick.ptype);
        markerOptions_Park.snippet(ParkCategoryClick.pname);
        mMap.addMarker(markerOptions_Park);

        mMap.moveCamera(CameraUpdateFactory.newLatLng(MAP_Park));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16));
        //-------------------------------------------------Park-------------------------------------------------------------//
    }
}
