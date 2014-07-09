package en.com.beta.safetrip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleAdapter;

public class TripListActivity extends ListActivity implements OnItemClickListener, OnClickListener 
{
	private List<Map<String, Object>> trips;
	private AlertDialog alertdialog;
	private int tripSelected;
	private AlertDialog confirmDialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		String[] from = {"image", "destination", "date", "total"};
		int[] to = {R.id.trip_type, R.id.id_destination, R.id.id_date, R.id.id_value};
		
		SimpleAdapter sAdapter = new SimpleAdapter(this, listTrips(), R.layout.list_trip, from, to);
		setListAdapter(sAdapter);
		getListView().setOnItemClickListener(this);
		
		this.alertdialog = createAlertDialog();
		this.confirmDialog = confirmDialog();
	}
	
	private List<Map<String, Object>> listTrips()
	{
		trips = new ArrayList<Map<String, Object>>();
		
		Map<String, Object> item = new HashMap<String, Object>();
		item.put("image", R.drawable.busines);
		item.put("destination", "Sao Paulo");
		item.put("date", "02/02/2014 to 04/04/2014");
		item.put("total", "Total spent: R$ 314,98");
		trips.add(item);
		
		item = new HashMap<String, Object>();
		item.put("image", R.drawable.leisure);
		item.put("destination", "Maceio");
		item.put("date", "05//05/2014 to 05/06/2014");
		item.put("total", "Total spent: R$ 2584,68");
		trips.add(item);
	
		return trips;
		
	}
	
	@Override
	public void onItemClick(AdapterView<?>parent, View view, int position, long id)
	{
		/*Map<String, Object> map = trips.get(position);
		String destine = (String) map.get("destination");
		String message = "Trip selected: " + destine.toString();
		Toast.makeText(getApplicationContext(), message.toString(), Toast.LENGTH_SHORT).show();
		startActivity(new Intent(getApplicationContext(), SpentListActivity.class));
		*/
		
		this.tripSelected = position;
		alertdialog.show();
	}
	
	@Override
	public void onClick(DialogInterface dialog, int item)
	{
		switch(item)
		{
			case 0:
				startActivity(new Intent(this, TripActivity.class));
				break;
			case 1:
				startActivity(new Intent(this, SpentActivity.class));
			case 2:
				startActivity(new Intent(this, SpentListActivity.class));
			case 3:
				confirmDialog.show();
				break;
			case DialogInterface.BUTTON_POSITIVE:
				trips.remove(tripSelected);
				getListView().invalidateViews();
			case DialogInterface.BUTTON_NEGATIVE:
				confirmDialog.dismiss();
		}
	}
	
	private AlertDialog createAlertDialog()
	{
		final CharSequence[] items = {getString(R.string.dialog_edit), 
				getString(R.string.new_spending), getString(R.string.dialog_spents), getString(R.string.dialog_remove)};
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(R.string.dialog_options);
		builder.setItems(items, this);
		
		return builder.create();
	}
	
	private AlertDialog confirmDialog()
	{
		AlertDialog.Builder build = new AlertDialog.Builder(this);
		build.setMessage(R.string.confirm);
		build.setPositiveButton(R.string.positive, this);
		build.setNegativeButton(R.string.negative, this);
		
		return build.create();
	}
	
	/*@Override
	public boolean setViewValue(View view, Object data, String textRepresentation)
	{
		if(view.getId() == R.id.progress)
		{
			Double values[] = (Double[]) data;
			ProgressBar barProgress = (ProgressBar) view;
			barProgress.setMax(values[0].intValue());
			barProgress.setSecondaryProgress(values[1].intValue());
			barProgress.setProgress(values[2].intValue());
			
			return true;
		}
		return false;
	}*/
}
