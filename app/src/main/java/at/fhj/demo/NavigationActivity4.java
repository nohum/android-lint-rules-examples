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

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);

        // real match
        locationManager.requestSingleUpdate(criteria, null);

        // real match
        locationManager.requestLocationUpdates(5000, 100, criteria, null, Looper.myLooper());

        criteria.setAccuracy(Criteria.ACCURACY_COARSE);

        // false positive
        locationManager.requestLocationUpdates(5000, 100, criteria, null, Looper.myLooper());

        Criteria another = new Criteria();
        another.setPowerRequirement(Criteria.POWER_LOW);
        another.setAccuracy(Criteria.ACCURACY_FINE);
        // real match in method (ACCURACY_FINE = gps)
        setUpAnother(another);

        // should be no match (no requirements - best available is taken)
        setUpAnother(new Criteria());

        CheckBox doFineUpdates = (CheckBox) findViewById(R.id.do_fine_updates);
        Criteria third = new Criteria();
        third.setAccuracy(Criteria.ACCURACY_LOW);
        if (doFineUpdates.isChecked()) {
            third.setAccuracy(Criteria.ACCURACY_FINE);
        }

        thirdSetup(third);
    }

    private void setUpAnother(Criteria another) {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        // at least one report should be here (for one input of a criteria with ACCURACY_FINE)
        locationManager.requestSingleUpdate(another, null);
    }

    private void thirdSetup(Criteria another) {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        // must be reported
        locationManager.requestSingleUpdate(another, null);
    }

}
