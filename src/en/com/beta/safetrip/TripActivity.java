package en.com.beta.safetrip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class TripActivity extends Activity 
{
	@Override
	protected void onCreate(Bundle SavedInstanceState)
	{
		super.onCreate(SavedInstanceState);
		setContentView(R.layout.trip);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater mInflater = getMenuInflater();
		mInflater.inflate(R.menu.trip_menu, menu);
		return true;
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item)
	{
		switch(item.getItemId())
		{
			case R.id.new_spent:
				startActivity(new Intent(this, SpentActivity.class));
				return true;
			case R.id.remove_trip:
				//remove trip from data base
				return true;
			default: return super.onMenuItemSelected(featureId, item);
		}
	}
}
