package com.example.n56j.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

public class ServiceAdminActivity extends FragmentActivity implements OnMapReadyCallback {

    //Explicit
    private GoogleMap mMap;
    private double latPbruADouble = 13.071468;
    private double lngPbruADouble = 99.976380;
    private Button listViewButton, addMarkerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_service_layout);

        //Bind Widget
        listViewButton = (Button) findViewById(R.id.button15);
        addMarkerButton = (Button) findViewById(R.id.button16);

        //addMarker Controller
        addMarkerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ServiceAdminActivity.this, AddEditActivity.class);
                intent.putExtra("Status", true);
                startActivity(intent);

            }   // onClick
        });


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }   // Main Method


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


       //Setup PBRU Center
        LatLng latLng = new LatLng(latPbruADouble, lngPbruADouble);
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));


    }   // Second Method

}   // Main Class
