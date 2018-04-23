package com.gmail.runkevich8.presentation.screen;

import android.arch.lifecycle.ViewModelProviders;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gmail.runkevich8.base.BaseMvvmActivity;
import com.gmail.runkevich8.weatherapp.R;
import com.gmail.runkevich8.weatherapp.databinding.ActivityMainBinding;
import com.google.android.gms.location.LocationListener;


public class MainActivity extends BaseMvvmActivity<ActivityMainBinding,MainActivityViewModel> implements LocationListener {

    private static final int PERMS_REQUEST_GPS_ACCESS = 2001;
    LocationManager locationManager;
    boolean updateInProgress = false,
            isLocationEnabled = false;
 //   @Inject
   // public PrefsManager appSharedPrefs;
        @Override
        public int provideLayoutId() {
            return R.layout.activity_main;
        }

        @Override
        public MainActivityViewModel provideViewModel() {
            return ViewModelProviders.of(this).get(MainActivityViewModel.class);
        }
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
//
//            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.ACCESS_FINE_LOCATION }, PERMS_REQUEST_GPS_ACCESS);
//            } else {
//                setUpLocationManager();
//            }

        }

    @Override
    public void onLocationChanged(Location location) {

    }


//    @Override
//    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
//        if (requestCode == PERMS_REQUEST_GPS_ACCESS && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//            Log.w("Location", "Permission was granted");
//            setUpLocationManager();
//        }
//    }
//    public void setUpLocationManager() {
//        // Set up the location manager
//        locationManager = (LocationManager)getSystemService(LOCATION_SERVICE);
//        isLocationEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
//        if (isLocationEnabled) {
//            this.onProviderEnabled(LocationManager.GPS_PROVIDER);
//        } else {
//            Log.w("Location", "Location/GPS is not enabled");
//        }
//    }
//
//    public void onProviderEnabled(String provider) {
//        if (provider == LocationManager.GPS_PROVIDER) {
//            Log.w("Location", "Enabling GPS Provider");
//            isLocationEnabled = true;
//            try {
//                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 60000L, 100, (android.location.LocationListener) this);
//                onLocationChanged(locationManager.getLastKnownLocation(provider));
//            } catch (SecurityException ex) {
//                Toast.makeText(this, "You need the GPS permission", Toast.LENGTH_LONG);
//            }
//        }
//    }
}
