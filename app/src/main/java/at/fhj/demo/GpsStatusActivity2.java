package at.fhj.demo;

import android.app.Activity;
import android.location.LocationManager;
import android.os.Bundle;

public class GpsStatusActivity2 extends Activity {

    private static final int MILLISECONDS_BETWEEN_UPDATES = 5000;
    private static final int MIN_METERS_MOVED = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        boolean exact = hasPreferencesUseExactLocationChecked();

        // real match
        locationManager.isProviderEnabled(exact ? LocationManager.NETWORK_PROVIDER : getNextPossibleProvider());
    }

    private String getNextPossibleProvider() {
        if (hasPreferencesUseLowEnergyChecked()) {
            return LocationManager.PASSIVE_PROVIDER;
        }

        String provider = LocationManager.NETWORK_PROVIDER;
        provider = LocationManager.GPS_PROVIDER;
        return provider;
    }

    private boolean hasPreferencesUseExactLocationChecked() {
        return true; // dummy method
    }

    private boolean hasPreferencesUseLowEnergyChecked() {
        return true; // dummy method
    }
}
