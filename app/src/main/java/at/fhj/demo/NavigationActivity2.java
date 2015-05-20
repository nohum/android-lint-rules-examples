package at.fhj.demo;

import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.widget.TextView;

public class NavigationActivity2 extends Activity {

    @Override
    @CustomRuntimeAnnotation("onCreate")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        // real match
        locationManager.requestSingleUpdate(LocationManager.NETWORK_PROVIDER, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                TextView text = (TextView) findViewById(R.id.my_location);
                text.setText(location.toString());
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
        }, Looper.myLooper());

        // false positive
        requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 5000, 100, null);
    }

    private void requestLocationUpdates(String provider, long minTime, long minDistance, LocationListener listener) {
        // dummy false positive
    }
}
