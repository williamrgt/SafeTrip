package en.com.beta.safetrip;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SafeTripActivity extends Activity 
{
	private EditText edtLogin;
	private EditText edtPassword;
	private TextView txtVversion;
	private String versionName;
	private CheckBox keep_connected;
	private static final String KEEP_CONNECTED = "keep_connected";
	
	@Override
	public void onCreate(Bundle SavedInstanceState)
	{
		super.onCreate(SavedInstanceState);
		setContentView(R.layout.login);
		
		try 
		{
			versionName = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
		}catch (NameNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		txtVversion = (TextView) findViewById(R.id.txtv_id_version);
		txtVversion.setText("Version: " + versionName);
		edtLogin = (EditText) findViewById(R.id.user);
		edtPassword = (EditText) findViewById(R.id.password);
		keep_connected = (CheckBox) findViewById(R.id.id_keep_connected);
		
		SharedPreferences preferences = getPreferences(MODE_PRIVATE);
		boolean connected = preferences.getBoolean(KEEP_CONNECTED, false);
		if(connected)
			startActivity(new Intent(this, DashboardActivity.class));
	}
	
	public void submitOnclick(View v)
	{
		String strUser = edtLogin.getText().toString();
		String strPassword = edtPassword.getText().toString();
		
		if(strUser.equals("leitor") && strPassword.equals("123"))
		{
			SharedPreferences preferences = getPreferences(MODE_PRIVATE);
			Editor EdiEdt = preferences.edit();
			EdiEdt.putBoolean(KEEP_CONNECTED, keep_connected.isChecked());
			EdiEdt.commit();
			
			//goes to another activity
			startActivity(new Intent(this, DashboardActivity.class));
		}
		else
		{
			String loginError = getResources().getString(R.string.login_error); //get string from strings
			Toast message = Toast.makeText(this, loginError, Toast.LENGTH_SHORT); //make toast
			message.show();
		}
	}
}
