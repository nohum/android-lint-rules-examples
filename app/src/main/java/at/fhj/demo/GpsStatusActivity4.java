package at.fhj.demo;

import android.app.Activity;
import android.location.LocationManager;
import android.os.Bundle;

public class GpsStatusActivity4 extends Activity {

    private static final int MILLISECONDS_BETWEEN_UPDATES = 5000;
    private static final int MIN_METERS_MOVED = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        String myGpsProvider = LocationManager.GPS_PROVIDER;
        String gpsProviderConditional = myGpsProvider;
        if (hasWindowFocus()) {
            gpsProviderConditional = LocationManager.NETWORK_PROVIDER;
        }

        // real match
        locationManager.isProviderEnabled(gpsProviderConditional);
    }
}
