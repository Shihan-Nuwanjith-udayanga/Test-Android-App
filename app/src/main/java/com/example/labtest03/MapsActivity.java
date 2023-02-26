package com.example.labtest03;

import androidx.fragment.app.FragmentActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.labtest03.databinding.ActivityMapsBinding;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    List<Address> listGeoCoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        try {
            listGeoCoder = new Geocoder(this).getFromLocationName
                    ("Akmeemana, Galle, SriLanka", 1);

            double longitude = listGeoCoder.get(0).getLongitude();
            double latitude = listGeoCoder.get(0).getLatitude();
            String countryName = listGeoCoder.get(0).getCountryName();

            Log.i("GOOGLE_MAP_TAG", "longitude is : "+ String.valueOf(longitude));
            Log.i("GOOGLE_MAP_TAG", "Latitude is : "+ String.valueOf(latitude));
            Log.i("GOOGLE_MAP_TAG", "Country is: "+ String.valueOf(countryName));

        }catch (Exception exception){
            exception.printStackTrace();
        }
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
        /*mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng galle = new LatLng(6.0343813717254084, 80.21654526534354);
        mMap.addMarker(new MarkerOptions().position(galle).title("Marker in Galle, Sri Lanka"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(galle, 18.0f));
        mMap.getUiSettings().setZoomControlsEnabled(true);*/
    }
}