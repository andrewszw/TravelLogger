package com.example.andrewszw.travellogger;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by andrewszw on 6/23/15.
 */
public class LocationAddress {

    private static final String TAG = "LocationAddress";

    public Double[] getLatLongFromAddress(Context context, String address) {
        Geocoder geo = new Geocoder(context, Locale.getDefault());
        Double[] points = new Double[2];

        List<Address> list = null;

        try {
            list = geo.getFromLocationName(address, 1);
            if(list.size() > 0) {

                double latitude = list.get(0).getLatitude();
                double longitude = list.get(0).getLongitude();
                points[0] = latitude;
                points[1] = longitude;
            }
        } catch(IOException ioe) {
            Log.e(TAG, "Error");
        }
        return points;
    }
}
