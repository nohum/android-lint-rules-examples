package at.fhj.demo;

import android.app.Activity;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;

public class NavigationActivity2 extends Activity {

    @Override
    @CustomRuntimeAnnotation("onCreate")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        // real match (method returns GPS and NETWORK in data-flow analysis)
        locationManager.requestSingleUpdate(getProvider(), null, Looper.myLooper());

        // false positive
        requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 100, null);
    }

    private String getProvider() {
        return isTaskRoot() ? LocationManager.NETWORK_PROVIDER : LocationManager.GPS_PROVIDER;
    }

    private void requestLocationUpdates(String provider, long minTime, long minDistance, LocationListener listener) {
        // dummy false positive
    }
}
