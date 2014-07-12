package en.com.beta.safetrip;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.View;

public class ConfigActivity extends PreferenceActivity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferences);
	}
	
	public void selectOption(View view)
	{
		switch(view.getId())
		{
			case R.id.configs:
				startActivity(new Intent(this, ConfigActivity.class));
				break;
		}
	}
}
