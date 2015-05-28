package at.fhj.demo;

import android.app.Activity;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

public class GpsStatusActivity extends Activity implements LocationListener, GpsStatus.Listener {

    private static final int MILLISECONDS_BETWEEN_UPDATES = 5000;
    private static final int MIN_METERS_MOVED = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        String myGpsProvider = LocationManager.GPS_PROVIDER;
        String gpsProvider2 = getPossibleProvider();

        String gpsProviderConditional = myGpsProvider;
        if (hasWindowFocus()) {
            gpsProviderConditional = LocationManager.NETWORK_PROVIDER;
        }

        // false positive
        locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        // real match
        locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);

        // real match
        locationManager.isProviderEnabled(myGpsProvider);

        // real match
        locationManager.isProviderEnabled(gpsProvider2);

        // real match
        locationManager.isProviderEnabled(gpsProviderConditional);

        // real match
        locationManager.isProviderEnabled(MILLISECONDS_BETWEEN_UPDATES < 10000 ? LocationManager.NETWORK_PROVIDER : getPossibleProvider());

        // real match
        locationManager.isProviderEnabled("gps");

        // real match
        locationManager.isProviderEnabled(MILLISECONDS_BETWEEN_UPDATES < 10000 ? LocationManager.GPS_PROVIDER : LocationManager.NETWORK_PROVIDER);

        // false positive
        locationManager.isProviderEnabled(MILLISECONDS_BETWEEN_UPDATES < 10000 ? LocationManager.NETWORK_PROVIDER : "network");

        // should be detected with data-flow analysis
        locationManager.isProviderEnabled(getPossibleProvider());

        // should be detected with data-flow analysis
        locationManager.isProviderEnabled(getPossibleProviderInverse());

        // real match with FINE permission commented out
        locationManager.addGpsStatusListener(this);

        // false positive
        locationManager.removeGpsStatusListener(this);
    }

    private String getPossibleProvider() {
        if (MILLISECONDS_BETWEEN_UPDATES > 10000) {
            return LocationManager.NETWORK_PROVIDER;
        }

        return LocationManager.GPS_PROVIDER;
    }

    private String getPossibleProviderInverse() {
        if (MILLISECONDS_BETWEEN_UPDATES > 10000) {
            return LocationManager.GPS_PROVIDER;
        }

        return LocationManager.NETWORK_PROVIDER;
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
