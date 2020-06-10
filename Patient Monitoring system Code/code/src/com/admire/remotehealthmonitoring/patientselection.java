package com.admire.remotehealthmonitoring;

import com.admire.remotehealthmonitoring.AdvancedGraph;


import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class patientselection extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.patient_selection);
		
	
		((Button) findViewById(R.id.btclear)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				
				EditText patientid = (EditText) findViewById(R.id.tbpatientid);
				patientid.setText("");
				
			}
		});
		
		((Button) findViewById(R.id.btshowgraph)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//msbox("Checking","show button click");
				startGraphActivity(AdvancedGraph.class);
			}
		});

	}
	
	public void msbox(String str,String str2)
	{
		AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);  
		dlgAlert.setTitle(str);
		dlgAlert.setMessage(str2);
		dlgAlert.show();
	}
	
	private void startGraphActivity(Class<? extends Activity> activity) {
		Intent intent = new Intent(patientselection.this, activity);
		EditText patientid = (EditText) findViewById(R.id.tbpatientid);
		if(patientid.getText().toString().length()>0 )
		{
		   
			if (((RadioButton) findViewById(R.id.rbecg)).isChecked()) 
			{
				intent.putExtra("type","ecg");
			}
			else if (((RadioButton) findViewById(R.id.rbtemperature)).isChecked()) 
			{
				intent.putExtra("type","temperature");
			} 
			else if (((RadioButton) findViewById(R.id.rbstress)).isChecked()) 
			{
				intent.putExtra("type","stress");
			}
			intent.putExtra("id",patientid.getText().toString());
			startActivity(intent);
		}
		else
		{
			msbox("Warning","Enter Patient Id");
		
		}
	
		
	}


}




