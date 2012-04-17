package dirk.test;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

public class DirkActivity extends MapActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);
		MapView mapView = (MapView) findViewById(R.id.mapview);
		mapView.setBuiltInZoomControls(true);

		LocationManager mlocManager =

		(LocationManager) getSystemService(Context.LOCATION_SERVICE);

		LocationListener mlocListener = new MyLocationListener();

		mlocManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,
				mlocListener);

	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	public class MyLocationListener implements LocationListener {

		@Override
		public void onLocationChanged(Location loc) {
			loc.getLatitude();

			loc.getLongitude();

			String Text = "My current location is: " +

			"Latitud = " + loc.getLatitude() +

			"Longitud = " + loc.getLongitude();

			Toast.makeText(getApplicationContext(), Text, Toast.LENGTH_SHORT)
					.show();
		}

		@Override
		public void onProviderDisabled(String provider)

		{

			Toast.makeText(getApplicationContext(), "Gps Disabled",
					Toast.LENGTH_SHORT).show();

		}

		@Override
		public void onProviderEnabled(String provider)

		{

			Toast.makeText(getApplicationContext(),

			"Gps Enabled",

			Toast.LENGTH_SHORT).show();

		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras)

		{

		}

	}/* End of Class MyLocationListener */
}