package at.fhj.demo;

import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;

public class NavigationActivity3 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        // real match
        locationManager.requestSingleUpdate(LocationManager.GPS_PROVIDER,
                new InternalLocationListener("data"), Looper.myLooper());

        // false positive ("network" string on the stack)
        locationManager.requestSingleUpdate(LocationManager.NETWORK_PROVIDER,
                new InternalLocationListener("network"), Looper.myLooper());

        // must not be detected ("gps" string on the stack, but is "network")
        locationManager.requestSingleUpdate(LocationManager.NETWORK_PROVIDER,
                new InternalLocationListener("gps"), Looper.myLooper());
    }

    private class InternalLocationListener implements LocationListener {

        private String data;

        public InternalLocationListener(String additionalData) {
            this.data = additionalData;
        }

        public void onLocationChanged(Location location) { }
        public void onStatusChanged(String provider, int status, Bundle extras) { }
        public void onProviderEnabled(String provider) { }
        public void onProviderDisabled(String provider) { }
    }
}
