package at.fhj.demo;

import android.app.Activity;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

public class GpsStatusActivity2 extends Activity implements LocationListener, GpsStatus.Listener {

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

        return LocationManager.GPS_PROVIDER;
    }

    private boolean hasPreferencesUseExactLocationChecked() {
        return true; // dummy method
    }

    private boolean hasPreferencesUseLowEnergyChecked() {
        return true; // dummy method
    }

    @Override
    public void onGpsStatusChanged(int event) {

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
