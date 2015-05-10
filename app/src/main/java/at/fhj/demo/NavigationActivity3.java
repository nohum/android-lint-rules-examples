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
        // possibility for a false positive here with the LocationUsageWithoutPermission rule
        // suppose instead of the string "data" below this could be "network" - as the algorithm
        // is doing heuristic matching, "network" would match although "gps" is the real provider
        locationManager.requestSingleUpdate(LocationManager.GPS_PROVIDER,
                new InternalLocationListener("data"), Looper.myLooper());
    }

    private class InternalLocationListener implements LocationListener {

        private String data;

        public InternalLocationListener(String additionalData) {
            this.data = additionalData;
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
}
