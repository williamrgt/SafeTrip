package en.com.beta.safetrip;

import java.util.Arrays;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class SpentListActivity extends ListActivity implements OnItemClickListener 
{	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listSpents()));
		ListView listView = getListView();
		listView.setOnItemClickListener(this);
	}
	
	@Override
	public void onItemClick(AdapterView<?>parent, View view, int position, long id)
	{
		TextView textView = (TextView) view;
		Toast.makeText(this, "spent selected: " + textView.getText().toString(), Toast.LENGTH_SHORT).show();
	}
	
	private List<String> listSpents()
	{
		return Arrays.asList("sanduiche R$: 19,90", "Taxi aeroporto - Hotel R$: 34,00", "Revista R$: 12,00");
	}
}
