package at.fhj.demo;

import android.app.Activity;
import android.location.GpsStatus;
import android.location.LocationManager;
import android.os.Bundle;

public class GpsStatusActivity extends Activity implements GpsStatus.Listener {

    private static final int MILLISECONDS_BETWEEN_UPDATES = 5000;
    private static final int MIN_METERS_MOVED = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        // false positive
        locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        // real match
        locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        // real match
        locationManager.isProviderEnabled("gps");

        // false positive
        locationManager.isProviderEnabled(this.getPossibleProvider());

        // false positive (does not require permissions)
        locationManager.removeGpsStatusListener(this);
    }

    private String getPossibleProvider() {
        if (MILLISECONDS_BETWEEN_UPDATES > 10000) {
            return LocationManager.NETWORK_PROVIDER;
        }

        return LocationManager.PASSIVE_PROVIDER;
    }

    @Override
    public void onGpsStatusChanged(int event) {

    }
}
