package at.fhj.demo;

import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

public class NavigationActivity extends Activity implements LocationListener {

    private static final int MILLISECONDS_BETWEEN_UPDATES = 5000;
    private static final int MIN_METERS_MOVED = 20;

    private LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        // error detected by LocationUsageWithoutPermission rule (if fine permission is commented out in AndroidManifest.xml)
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MILLISECONDS_BETWEEN_UPDATES,
                MIN_METERS_MOVED, this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // not detected by LocationUsageWithoutPermission as not part of the rule
        locationManager.removeUpdates(this);
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
