package com.admire.remotehealthmonitoring;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GraphView.GraphViewData;
//import com.admire.remotehealthmonitoring.R;
import com.jjoe64.graphview.GraphViewSeries;
import com.jjoe64.graphview.LineGraphView;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import android.os.StrictMode;
import android.util.Log;


public class AdvancedGraph extends Activity {
	/** Called when the activity is first created. */
	//@SuppressLint("NewApi")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 StrictMode.enableDefaults();
		setContentView(R.layout.graphs);
		
		EditText edpatientid = (EditText) findViewById(R.id.tbgpid);
		edpatientid.setText(getIntent().getStringExtra("id").toString());
		
		
		if (getIntent().getStringExtra("type").equals("ecg")) 
		{
			TextView text = (TextView) findViewById(R.id.lbpatientidgraph);
			text.setText("ECG Graph");
			getData();
		}
		else if (getIntent().getStringExtra("type").equals("temperature")) 
		{
			TextView text = (TextView) findViewById(R.id.lbpatientidgraph);
			text.setText("Temperature Graph");
			getData();
		}
		else if (getIntent().getStringExtra("type").equals("stress")) 
		{
			TextView text = (TextView) findViewById(R.id.lbpatientidgraph);
			text.setText("Stress Level Graph");
			getData();
		}
		

		((Button) findViewById(R.id.btadd)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				 msbox("BSN","Save Successfully ");
				addData();
			}
		});
		
		((Button) findViewById(R.id.liveupdate)).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				LinearLayout layout = (LinearLayout) findViewById(R.id.graph1);
				layout.removeAllViewsInLayout();
				getData();
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
	
	
	public void addData(){
		
    	try{
    		String result = "";
        	InputStream isr = null;
        	
        	EditText eddoctor = (EditText) findViewById(R.id.tbgdoctorid);
        	String doctorid=eddoctor.getText().toString();
        	
        	EditText edpatientid = (EditText) findViewById(R.id.tbgpid);
        	String pid=edpatientid.getText().toString();
        	
        	EditText eddesc = (EditText) findViewById(R.id.tbdesc);
        	String desc=eddesc.getText().toString();
        	desc= desc.replaceAll(" ","%20");
            HttpClient httpclient = new DefaultHttpClient();
            
            
             //HttpPost httppost = new HttpPost("http://192.168.2.4/health/setdescription.php?pid="+pid+"&did="+doctorid+"&desc="+desc);//00002"); //YOUR PHP SCRIPT ADDRESS
            HttpPost httppost = new HttpPost("http://www.admiresolution.com/health/setdescription.php?pid="+pid+"&did="+doctorid+"&desc="+desc);//00002"); //YOUR PHP SCRIPT ADDRESS
    		
            HttpResponse response = httpclient.execute(httppost);
            msbox("BSN","Save Successfully ");

            
            
    }
    	
    	
    catch(Exception e){
            Log.e("log_tag", "Error in http connection "+e.toString());
            msbox("check",e.toString());
          
    }

    
    }
	
	
	
	
	public void getData(){
    	String result = "";
    	InputStream isr = null;
    	try{
            HttpClient httpclient = new DefaultHttpClient();
            String qry="";
            
            if (getIntent().getStringExtra("type").equals("ecg")) 
    		{
            	//qry ="http://192.168.2.4/health/gethearthrate.php?patientid="+getIntent().getStringExtra("id").toString();//00002"); //YOUR PHP SCRIPT ADDRESS
            	qry ="http://www.admiresolution.com/health/gethearthrate.php?patientid="+getIntent().getStringExtra("id").toString();//00002"); //YOUR PHP SCRIPT ADDRESS
    		}
            else if (getIntent().getStringExtra("type").equals("temperature")) 
    		{
            	//qry ="http://192.168.2.4/health/gettempreature.php?patientid="+getIntent().getStringExtra("id").toString();//00002"); //YOUR PHP SCRIPT ADDRESS
            	qry ="http://www.admiresolution.com/health/gettempreature.php?patientid="+getIntent().getStringExtra("id").toString();//00002"); //YOUR PHP SCRIPT ADDRESS
    		}
            else if (getIntent().getStringExtra("type").equals("stress")) 
    		{
            	//qry ="http://192.168.2.4/health/getstress.php?patientid="+getIntent().getStringExtra("id").toString();//00002"); //YOUR PHP SCRIPT ADDRESS
            	qry ="http://www.admiresolution.com/health/getstress.php?patientid="+getIntent().getStringExtra("id").toString();//00002"); //YOUR PHP SCRIPT ADDRESS
    		}
            HttpPost httppost = new HttpPost(qry);//00002"); //YOUR PHP SCRIPT ADDRESS
            // HttpPost httppost = new HttpPost("http://omega.uta.edu/~kmr2464/jsonscript.php");
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            isr = entity.getContent();
    }
    catch(Exception e){
            Log.e("log_tag", "Error in http connection "+e.toString());
          
    }
    //convert response to string
    try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(isr,"iso-8859-1"),8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                    sb.append(line + "\n");
            }
            isr.close();
     
            result=sb.toString();
    }
    catch(Exception e){
            Log.e("log_tag", "Error  converting result "+e.toString());
    }
     
    //parse json data
   try {
	   double s ;
	   JSONArray jArray = new JSONArray(result);
	   int arrylen = jArray.length();
	   GraphViewData[] data = new GraphViewData[arrylen];
	
	   for(int i=0; i<arrylen;i++)
	   {
		   JSONObject json = jArray.getJSONObject(i);
		   s = json.getDouble("v");
		   data[i] = new GraphViewData(i,s);
		   
		   
	   }
	    
	   String Graphname = "";
	   if (getIntent().getStringExtra("type").equals("ecg")) 
		{
		   Graphname = "Heart Rate Graph";
		}
	   else if (getIntent().getStringExtra("type").equals("temperature")) 
		{
		   Graphname = "Temperature Graph";
		}
	   else if (getIntent().getStringExtra("type").equals("stress")) 
		{
		   Graphname = "Stress Level Graph";
		   
		}
		GraphView graphView;
		graphView = new LineGraphView(this,Graphname);
	
	// add data
	graphView.addSeries(new GraphViewSeries(data));
	// set view port, start=2, size=40
	graphView.setViewPort(2, 40);
	graphView.setScrollable(true);
	LinearLayout layout = (LinearLayout) findViewById(R.id.graph1);
	layout.addView(graphView);
	   
	
   } catch (Exception e) {
	// TODO: handle exception
	   Log.e("log_tag", "Error Parsing Data "+e.toString());
   }
    
    }

}
