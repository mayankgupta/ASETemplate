package app.com.example.lpolepeddi.asetemplate;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

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


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng m1 = new LatLng(33.777187, -84.397421);
        LatLng m2 = new LatLng(33.77653,-84.388336);
        LatLng m3 = new LatLng(33.778723,-84.398507);
        LatLng m4 = new LatLng(33.775493,-84.397343);
        mMap.addMarker(new MarkerOptions().position(m1).title("Harshit Sharma"));
        mMap.addMarker(new MarkerOptions().position(m2).title("Lalith Polpeddi"));
        mMap.addMarker(new MarkerOptions().position(m3).title("Mayank Gupta"));
        mMap.addMarker(new MarkerOptions().position(m4).title("Chris Ernst"));

        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(m1);
        builder.include(m2);
        builder.include(m3);
        builder.include(m4);
        LatLngBounds bounds = builder.build();
        int padding = 100;

        mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, padding));
    }
}
