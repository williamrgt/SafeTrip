package en.com.beta.safetrip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SafeTripActivity extends Activity 
{
	private EditText edtLogin;
	private EditText edtPassword;
	
	@Override
	public void onCreate(Bundle SavedInstanceState)
	{
		super.onCreate(SavedInstanceState);
		setContentView(R.layout.login);
		
		edtLogin = (EditText) findViewById(R.id.user);
		edtPassword = (EditText) findViewById(R.id.password);
	}
	
	public void submitOnclick(View v)
	{
		String strUser = edtLogin.getText().toString();
		String strPassword = edtPassword.getText().toString();
		
		if(strUser.equals("leitor") && strPassword.equals("123"))
		{
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
