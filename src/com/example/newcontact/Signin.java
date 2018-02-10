package com.example.newcontact;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Signin extends Activity {
Database2forsignin database2forsignin;
TextView passs,conpasss;
Button signinn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signin);
		database2forsignin=new Database2forsignin(getApplicationContext());
		passs=(TextView)findViewById(R.id.pass);
		conpasss=(TextView)findViewById(R.id.conpass);
		signinn=(Button)findViewById(R.id.signin);
		
		signinn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			String pa=passs.getText().toString();
			String con=conpasss.getText().toString();
			
			
		
			
			 if(pa.equalsIgnoreCase("")||con.equalsIgnoreCase(""))
			{
				Toast.makeText(getApplicationContext(), "Please Fill Fields", Toast.LENGTH_LONG).show();
			}
				
			else if(pa.equals(conpasss)){
				
				database2forsignin.insert(pa);
				Intent intent=new Intent(Signin.this,NewContact.class);
				
				startActivity(intent);
				
				
				}
			
			else{
				Toast.makeText(getApplicationContext(), " confirm password wrong", Toast.LENGTH_LONG).show();
			}
			 }
			
			
				
			
		});
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.signin, menu);
		return true;
	}

}
