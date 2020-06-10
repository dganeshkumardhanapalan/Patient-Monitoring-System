package com.admire.remotehealthmonitoring;




import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		

		((Button) findViewById(R.id.btclear)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				
				EditText username = (EditText) findViewById(R.id.tbusername);
				username.setText("");
				EditText password = (EditText) findViewById(R.id.tbpassword);
				password.setText("");
			}
		});
		
		((Button) findViewById(R.id.btlogin)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				EditText username = (EditText) findViewById(R.id.tbusername);
				EditText password = (EditText) findViewById(R.id.tbpassword);
				if(username.getText().toString().length()>0 && password.getText().toString().length()>0)
				{
					if((username.getText().toString().equals("admin")) && (password.getText().toString().equals("admin")))
					{
						//setContentView(R.layout.patient_selection);
						startGraphActivity(patientselection.class);
					}
					else
					{
						msbox("Login","Invaild Username and password");
					}
					
				}
				else
				{
					msbox("Login","Enter Username and password");
				}
				
			}
		});
	}
	
	private void startGraphActivity(Class<? extends Activity> activity) {
		Intent intent = new Intent(MainActivity.this, activity);
	
			intent.putExtra("type", "line");
	
		startActivity(intent);
	}
	
	
	public void msbox(String str,String str2)
	{
		AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);  
		dlgAlert.setTitle(str);
		dlgAlert.setMessage(str2);
		dlgAlert.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
