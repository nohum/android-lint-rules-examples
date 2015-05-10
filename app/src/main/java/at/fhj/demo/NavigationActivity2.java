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
        // this works as coarse location is switched on in permissions
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
    }
}
