package at.fhj.demo;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;

public class LocationProximitryListeners {

    private Context context;

    public LocationProximitryListeners(Context context) {
        this.context = context;
    }

    public void startListening() {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        // real match starting with projects at api level 17
        locationManager.addProximityAlert(37.401437, -116.86773, 200, -1, pendingIntent);
    }
}
