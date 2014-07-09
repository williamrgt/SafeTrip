package en.com.beta.safetrip;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Button;
import android.widget.Spinner;

public class SpentActivity extends Activity
{
	//seen by all methods in this class
	private int year, month, day;
	private Button dateSpent;
	private Spinner category;
	
	@Override
	protected void onCreate(Bundle SavedInstanceState)
	{
		super.onCreate(SavedInstanceState);
		setContentView(R.layout.spent);
		
		Calendar cldr = Calendar.getInstance();
		year = cldr.get(Calendar.YEAR);
		month = cldr.get(Calendar.MONTH);
		day = cldr.get(Calendar.DAY_OF_MONTH);
		
		dateSpent = (Button) findViewById(R.id.date);
		dateSpent.setText(day + "/" + (month + 1) + "/" + year);
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.category_spent, 
				android.R.layout.simple_spinner_item);
		
		category = (Spinner) findViewById(R.id.category);
		category.setAdapter(adapter);
	}
	
	public void selectDate(View v)
	{
		showDialog(v.getId());
	}
	
	@Override
	protected Dialog onCreateDialog(int id)
	{
		if(R.id.date == id)
		{
			return new DatePickerDialog(this, Listener, year, month, day);
		}
		return null;
	}
	
	private OnDateSetListener Listener = new OnDateSetListener()
	{
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
		{
			SpentActivity.this.year = year;
			month = monthOfYear;
			day = dayOfMonth;
			
			dateSpent.setText(day + "/" + (month + 1) + "/" + SpentActivity.this.year);
		}
	};
}
