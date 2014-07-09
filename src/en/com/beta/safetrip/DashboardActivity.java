package en.com.beta.safetrip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class DashboardActivity extends Activity
{
	@Override
	protected void onCreate(Bundle SavedInstanceState)
	{
		super.onCreate(SavedInstanceState);
		setContentView(R.layout.dashboard);
	}
	public void selectOption(View v)
	{
		//based at the view that was clicked, we're gonna do the proper action
		switch(v.getId())
		{
			//need to read about classes anonimas, page 80
			case R.id.new_trip:
			{
				startActivity(new Intent(this, TripActivity.class));
				break;
			}
			case R.id.new_spending:
			{
				startActivity(new Intent(this,SpentActivity.class));
			}
			case R.id.my_trips:
			{
				startActivity(new Intent(getApplicationContext(), TripListActivity.class));
			}
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater mInflater = getMenuInflater();
		mInflater.inflate(R.menu.dashboard_menu, menu);
		return true;
	}
	
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item)
	{
		finish();
		return true;
	}
}
