package at.fhj.demo;

import android.app.Activity;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.widget.CheckBox;

public class NavigationActivity4 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        CheckBox doFineUpdates = (CheckBox) findViewById(R.id.do_fine_updates);

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);

        // real match
        locationManager.requestSingleUpdate(criteria, null);

        // real match
        locationManager.requestLocationUpdates(5000, 100, criteria, null, Looper.myLooper());

        // false positive
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);
        locationManager.requestLocationUpdates(5000, 100, criteria, null, Looper.myLooper());

        Criteria third = new Criteria();
        third.setAccuracy(Criteria.ACCURACY_LOW);
        if (doFineUpdates.isChecked()) {
            third.setAccuracy(Criteria.ACCURACY_FINE);
        }

        // real match (ACCURACY_LOW, also ACCURACY_FINE = gps)
        locationManager.requestSingleUpdate(third, null, Looper.myLooper());
    }
}
