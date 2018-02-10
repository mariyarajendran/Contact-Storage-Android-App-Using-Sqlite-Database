package com.example.newcontact;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Edit extends Activity {
	EditText n,p,m,i;
	TextView tv;
	Button save;
	DBAdapter db ;
	String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit);
		n=(EditText)findViewById(R.id.editText1);
		p=(EditText)findViewById(R.id.editText2);
		m=(EditText)findViewById(R.id.editText3);
		tv=(TextView)findViewById(R.id.textView1);
		save=(Button)findViewById(R.id.button1);
		i=(EditText)findViewById(R.id.editText4);
	db	= new DBAdapter(this);
	
	
	
	
		 Intent intent = getIntent();
		 
		 String i1=intent.getStringExtra("idss");
		 String n1 = intent.getStringExtra("disname");
		    String p1 = intent.getStringExtra("disphone");
		    String m1 = intent.getStringExtra("dismail");
		    n.setText(n1.substring(5));
		    p.setText(p1.substring(6));
		    m.setText(m1.substring(6));
		    i.setText(i1);
		    
		    
		    save.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					String iddd=i.getText().toString();
					 
					String name=n.getText().toString();
					String phone=p.getText().toString();
					String emailss=m.getText().toString();
					if(name.equalsIgnoreCase("")||phone.equalsIgnoreCase("")||emailss.equalsIgnoreCase("")){
						
						 Toast.makeText(getApplicationContext(), "Please Fill The Fields", Toast.LENGTH_LONG).show();
						}
					
					else if(emailss.matches(emailPattern)){
					db.open();
					db.updateContact(iddd, name, phone, emailss);
			    	i.setText("");
					n.setText("");
					p.setText("");
					m.setText("");
					 Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
					db.close();
					Intent i=new Intent(Edit.this,NewContact.class);
					finish();
					startActivity(i);}
					
					else {
						Toast.makeText(getApplicationContext(), "Give Correct Mail Id", Toast.LENGTH_LONG).show();
						
					}
					
				}
			});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit, menu);
		return true;
	}

}
