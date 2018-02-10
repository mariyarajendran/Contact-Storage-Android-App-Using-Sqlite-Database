package com.example.newcontact;

import android.os.Bundle;
import android.os.Handler;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityOptions;
import android.app.SearchableInfo;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;


	
	

public class NewContact extends Activity {
Button add,view,search;
EditText dis;
DBAdapter db ;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_contact);
		add=(Button)findViewById(R.id.button1);
		view=(Button)findViewById(R.id.button2);
		
		dis=(EditText)findViewById(R.id.editText1);
	   
		
		
		
		db = new DBAdapter(this);
		
		
		
		
		ActionBar bar = getActionBar();
		//for color
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
		//for image
	//	bar.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic));
	
		
		add.setOnClickListener(new OnClickListener() {
			
			@Override
			public  void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				  add.clearAnimation();
	                TranslateAnimation transAnim = new TranslateAnimation(0, 0, 0,
	                        getDisplayHeight()/2);
	                transAnim.setStartOffset(500);
	                transAnim.setDuration(1500);
	                transAnim.setFillAfter(true);
	                transAnim.setInterpolator(new BounceInterpolator());
	               
	                transAnim.setAnimationListener(new AnimationListener() {

	                    @Override
	                    public  void onAnimationStart(Animation animation) {
	                       

	                    }

	                    @Override
	                    public void onAnimationRepeat(Animation animation) {
	                        // TODO Auto-generated method stub

	                    }

	                    @Override
	                    public void onAnimationEnd(Animation animation) {
	                        
	                        add.clearAnimation();
	                        final int left = add.getLeft();
	                        final int top = add.getTop();
	                        final int right = add.getRight();
	                        final int bottom = add.getBottom();
	                       add.layout(left, top, right, bottom);

	                    }
	                });
	                add.startAnimation(transAnim);
	                new Handler().postDelayed(new Runnable() {
	                      @Override
	                      public void run() {
	                    	  Intent i=new Intent(NewContact.this,Addcontact.class);
	                    	  ActivityOptions options = ActivityOptions.makeScaleUpAnimation(view, 0,
	                    		      0, view.getWidth(), view.getHeight());
	                    		 
	      					//finish();
	      				startActivity(i,options.toBundle());
	                          
	                      }
	                  }, 2000);
	               
	            }
			 
			
		});
		
view.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				graphics();
				 new Handler().postDelayed(new Runnable() {
		               @Override
		               public void run() {
		             	  Intent i=new Intent(NewContact.this,ViewContact.class);
		             	  ActivityOptions options = ActivityOptions.makeScaleUpAnimation(view, 0,
                    		      0, view.getWidth(), view.getHeight());
							//finish();
						startActivity(i,options.toBundle());
		                   
		               }
		           }, 2000);
		        
				
			}
		});
	}





@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		//super.onBackPressed();
	
	Toast.makeText(getApplicationContext(), "Back pressed", Toast.LENGTH_SHORT).show();
	finish();
	}

		 
		 
		 
		 
		 
		 
		 
		
		 
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_contact, menu);
		return true;
	}
	
	private int getDisplayHeight() {
	    return this.getResources().getDisplayMetrics().heightPixels;
	}

	
	public void graphics(){
		
		 view.clearAnimation();
         TranslateAnimation transAnim = new TranslateAnimation(0, 0, 0,
                 getDisplayHeight()/2);
         transAnim.setStartOffset(500);
         transAnim.setDuration(1500);
         transAnim.setFillAfter(true);
         transAnim.setInterpolator(new BounceInterpolator());
        
         transAnim.setAnimationListener(new AnimationListener() {

             @Override
             public  void onAnimationStart(Animation animation) {
                

             }

             @Override
             public void onAnimationRepeat(Animation animation) {
                 // TODO Auto-generated method stub

             }

             @Override
             public void onAnimationEnd(Animation animation) {
                 
                 view.clearAnimation();
                 final int left = view.getLeft();
                 final int top = view.getTop();
                 final int right = view.getRight();
                 final int bottom = view.getBottom();
                view.layout(left, top, right, bottom);

             }
         });
         view.startAnimation(transAnim);
        
     }
	}
	
	
	








