package rru.csit.project020;

import com.example.finalproject.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculate extends Activity {
	Button cback,add,sub,multi,devid;
	EditText value1,value2;
	TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);
        
        cback = (Button)findViewById(R.id.button1); 
        add = (Button)findViewById(R.id.button2);
        sub = (Button)findViewById(R.id.button3);
        multi = (Button)findViewById(R.id.button4);
        devid = (Button)findViewById(R.id.button5);
      
        value1 = (EditText)findViewById(R.id.editText1);
        value2 = (EditText)findViewById(R.id.editText2);
        tv = (TextView)findViewById(R.id.textView2);
        
        cback.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				Intent i = new Intent();
				i.setClass(Calculate.this, MainActivity.class);
				startActivity(i);
				
			}
		});
        
        
        
        
        add.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				tv.setText(  Integer.parseInt(value1.getText().toString()) +
						     Integer.parseInt(value2.getText().toString())+""
						);
				
			}
		});
        
        sub.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				tv.setText(  Integer.parseInt(value1.getText().toString()) -
						     Integer.parseInt(value2.getText().toString())+""
						);
				
			}
		});
        
        multi.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				tv.setText(  Integer.parseInt(value1.getText().toString()) *
						     Integer.parseInt(value2.getText().toString())+""
						);
				
			}
		});
        
        devid.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				tv.setText(  (Integer.parseInt(value1.getText().toString()) /
						     Integer.parseInt(value2.getText().toString())) +""
						);
				
			}
		});
        
        
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_calculate, menu);
        return true;
    }
}
