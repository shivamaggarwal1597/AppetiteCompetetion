package com.example.shivam.appetite;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback,GoogleMap.OnInfoWindowClickListener {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                View infoWindow = getLayoutInflater().inflate(R.layout.layout_info_window, null);
                MarkerTag mt= (MarkerTag) marker.getTag();

                TextView itemname = ((TextView) infoWindow.findViewById(R.id.tvitemname));
                itemname.setText(mt.getName());

                TextView category = ((TextView) infoWindow.findViewById(R.id.tvcategory));
                category.setText(mt.getCategory());
                TextView state=((TextView) infoWindow.findViewById(R.id.tvstate));
                state.setText(mt.getState());
                ImageView img=((ImageView) infoWindow.findViewById(R.id.img));
                switch(mt.getName()){
                    case "Darjeeling Tea":
                        img.setImageResource(R.drawable.tealleaves);
                        break;
                    case "Solapur Chaddar":

                        img.setImageResource(R.drawable.chaddar);
                        break;
                    case "Navara Rice":

                        img.setImageResource(R.drawable.rice);
                        break;
                    case "Puneri Pagdi":

                        img.setImageResource(R.drawable.pagdi);
                        break;
                    case "Tangaliya Shawl":

                        img.setImageResource(R.drawable.shawl);
                        break;
                }
                img.setImageResource(R.drawable.chaddar);
                return infoWindow;
            }
        });

        // Add a marker in Sydney and move the camera
        placemarkers();
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(20.5937,78.9629),4.5f));

        mMap.setOnInfoWindowClickListener(this);

    }
    private void placemarkers() {
        LatLng dt = new LatLng(22.9868, 87.8550);
        LatLng sc=new LatLng(19.7515, 75.7139);
        LatLng nr=new LatLng(10.8505, 76.2711);
        LatLng pp=new LatLng(18.5204, 73.8567);
        LatLng ts=new LatLng(22.2587, 71.1924);
        Marker mdt=mMap.addMarker(new MarkerOptions().position(dt).
                icon(BitmapDescriptorFactory.fromResource(R.drawable.tealleaves)));
        Marker msc=mMap.addMarker(new MarkerOptions().position(sc).
                icon(BitmapDescriptorFactory.fromResource(R.drawable.chaddar)));
        Marker mnr=mMap.addMarker(new MarkerOptions().position(nr).
                icon(BitmapDescriptorFactory.fromResource(R.drawable.rice)));
        Marker mpp=mMap.addMarker(new MarkerOptions().position(pp).
                icon(BitmapDescriptorFactory.fromResource(R.drawable.pagdi)));
        Marker mts=mMap.addMarker(new MarkerOptions().position(ts).
                icon(BitmapDescriptorFactory.fromResource(R.drawable.shawl)));

        MarkerTag mtdt=new MarkerTag("Darjeeling Tea","Agriculture","West Bengal");
        mdt.setTag(mtdt);

        MarkerTag mtsc=new MarkerTag("Solapur Chaddar","Agriculture","West Bengal");
        msc.setTag(mtsc);
        MarkerTag mtnr=new MarkerTag("Navara Rice","Agriculture","Kerala");
        mnr.setTag(mtnr);
        MarkerTag mtpp=new MarkerTag("Puneri Pagdi","Handicraft","Maharashtra");
        mpp.setTag(mtpp);
        MarkerTag mtts=new MarkerTag("Tangaliya Shawl","Handicraft","Gujarat");
        mts.setTag(mtts);

    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        MarkerTag mt= (MarkerTag) marker.getTag();

        //Intent i=new Intent(this,DescGi.class);
        //i.putExtra("name",mt.getName().toString().toLowerCase().trim().replace(" ",""));
        //startActivity(i);
    }
}
