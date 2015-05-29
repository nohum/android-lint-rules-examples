package at.fhj.demo;

import android.content.Context;
import android.location.GpsStatus;
import android.location.LocationManager;

public class LocationStateListeners implements GpsStatus.Listener, GpsStatus.NmeaListener {

    private Context context;

    public LocationStateListeners(Context context) {
        this.context = context;
    }

    public void startListening() {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        locationManager.addGpsStatusListener(this);
        locationManager.addNmeaListener(this);
    }


    public void onGpsStatusChanged(int event) {

    }

    public void onNmeaReceived(long timestamp, String nmea) {

    }
}
