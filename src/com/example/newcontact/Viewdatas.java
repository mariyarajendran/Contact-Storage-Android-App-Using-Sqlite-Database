package com.example.newcontact;

import android.net.Uri;
import android.opengl.Visibility;
import android.os.Bundle;
import android.os.IInterface;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Viewdatas extends Activity {
TextView nam,pho,mails,id,edittt,custom;
Button edit,save,previous;
EditText n,p,m;
ImageView imageView;
Button phone,msg;
DBAdapter db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewdatas);
		db=new DBAdapter(getApplicationContext());
		nam=(TextView)findViewById(R.id.name);
		pho=(TextView)findViewById(R.id.phone);
		mails=(TextView)findViewById(R.id.mailid);
		edit=(Button)findViewById(R.id.button1);
	imageView=(ImageView)findViewById(R.id.imageView1);
	phone=(Button)findViewById(R.id.imageButton1);
	msg=(Button)findViewById(R.id.imageButton2);
	id=(TextView)findViewById(R.id.textView2);
	edittt=(TextView)findViewById(R.id.editt);
	custom=(TextView)findViewById(R.id.textView1);
	

	
	
	
	
		save=(Button)findViewById(R.id.s1ave);
		n=(EditText)findViewById(R.id.n1ame);
		p=(EditText)findViewById(R.id.p1hone);
		m=(EditText)findViewById(R.id.m1ail);
		 Intent intent = getIntent();
		 
		
		    
		    final String na = intent.getStringExtra("disname");
		    String ph = intent.getStringExtra("disphone");
		    final String mai = intent.getStringExtra("dismail");
		    final String ids=intent.getStringExtra("idss");
		    
		    
		    
		    ActionBar bar = getActionBar();
			//for color
			bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#008000")));
		    
		    
		//custom
		    nam.setText(na);
		    pho.setText(ph);
		    mails.setText(mai);
		    id.setText(ids);
		    
		    
	//custom images	    
		  Bundle bundle=this.getIntent().getExtras();
		    int pic=bundle.getInt("image");
		    imageView.setImageResource(pic);
		    
		    //custom image and text visible
		    nam.setVisibility(View.VISIBLE);
		    pho.setVisibility(View.VISIBLE);
		    mails.setVisibility(View.VISIBLE);
		    id.setVisibility(View.INVISIBLE);
		    imageView.setVisibility(View.VISIBLE);
		    edit.setVisibility(View.VISIBLE);
		    custom.setVisibility(View.VISIBLE);

		    //invisible edit
		    n.setVisibility(View.INVISIBLE);
		    p.setVisibility(View.INVISIBLE);
		    m.setVisibility(View.INVISIBLE);
		    save.setVisibility(View.INVISIBLE);
		 edittt.setVisibility(View.INVISIBLE);
		 phone.setVisibility(View.VISIBLE);
		 msg.setVisibility(View.VISIBLE);
		    //save here  
		    
		  save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String iddd=id.getText().toString();
				String name=n.getText().toString();
				String phone=p.getText().toString();
				String mail=m.getText().toString();
				if(name.equalsIgnoreCase("")||phone.equalsIgnoreCase("")||mail.equalsIgnoreCase("")){
					
					 Toast.makeText(getApplicationContext(), "Please Fill The Fields", Toast.LENGTH_LONG).show();
					}
				else if(mail.contentEquals(".com")||mail.contains("@")){
					db.open();
					db.updateContact(iddd, name, phone, mail);
					id.setText("");
					n.setText("");
					p.setText("");
					m.setText("");
					Intent i=new Intent(Viewdatas.this,NewContact.class);
					finish();
					startActivity(i);
					 Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
				}
					else {
						Toast.makeText(getApplicationContext(), "Give Correct Mail Id", Toast.LENGTH_LONG).show();
						
					
				
				}
			}
		});
		  
		  phone.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			
			String number=pho.getText().toString();  
		
			
	                Intent callIntent = new Intent(Intent.ACTION_CALL);  
	      
	               callIntent.setData(Uri.parse("tel:"+pho.getText().toString().substring(6)));  
	              
	                startActivity(callIntent);  
				
			}
		});
		  
		  msg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(Viewdatas.this,Messages.class);
				 String number=pho.getText().toString();
				i.putExtra("nu",number );
				startActivity(i);
			}
		});
		  
		 //edit here
		    
		
		    previous.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Intent i=new Intent(Viewdatas.this,ViewContact.class);
					finish();
					startActivity(i);
				}
			});
		    
	}
	
public  void menuedit(){
	
				// TODO Auto-generated method stub
				Log.d("edit", "error in edit");
				
				/*Intent in=new Intent(Viewdatas.this,Edit.class);
				 in.putExtra("idss", ids);
				   in.putExtra("disname", na);
	                  in.putExtra("disphone", ph);
	                  in.putExtra("dismail", mai);
	                  finish();
				    startActivity(in);*/
				
				
				 Intent intent = getIntent();
				 
					
				    String n1am = intent.getStringExtra("disname");
				    String p1ho = intent.getStringExtra("disphone");
				   String m1ai = intent.getStringExtra("dismail");
				  // String i1ds=intent.getStringExtra("idss");
				   
				
				   n.setText(n1am.substring(5));
				    p.setText(p1ho.substring(6));
				    m.setText(m1ai.substring(6));
				  
				  //custom
				  
				    nam.setVisibility(View.INVISIBLE);
				    pho.setVisibility(View.INVISIBLE);
				    mails.setVisibility(View.INVISIBLE);
				    id.setVisibility(View.INVISIBLE);
				    imageView.setVisibility(View.INVISIBLE);
				    edit.setVisibility(View.INVISIBLE);
				    custom.setVisibility(View.INVISIBLE);
				    
				    //edit
				    n.setVisibility(View.VISIBLE);
				    p.setVisibility(View.VISIBLE);
				    m.setVisibility(View.VISIBLE);
				    save.setVisibility(View.VISIBLE);
				 edittt.setVisibility(View.VISIBLE);

				
		
	}

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.viewdatas, menu);
		return true;
	}
	@Override
		public boolean onOptionsItemSelected(MenuItem item) {
			// TODO Auto-generated method stub
		if(item.getItemId()==R.id.item1){
			 phone.setVisibility(View.INVISIBLE);
			 msg.setVisibility(View.INVISIBLE);
			menuedit();
			
			
		}
			return super.onOptionsItemSelected(item);
		}
	
	
	
	

}
