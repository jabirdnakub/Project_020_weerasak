package rru.csit.project020;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.os.Bundle;

import static android.provider.BaseColumns._ID;
import static rru.csit.project020.Constants.*;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.format.DateFormat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.Date;

import com.example.finalproject.R;

public class DataNote extends Activity {
Button dback;
private NotesHelper helper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datanote);
        
        dback = (Button)findViewById(R.id.button1); 
        
        dback.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				Intent i = new Intent();
				i.setClass(DataNote.this, MainActivity.class);
				startActivity(i);
				
			}
		});
        
        helper = new NotesHelper(this);
        try {
        	Cursor cursor = getAllNotes();
        	showNotes(cursor);
        }
        finally {
        	helper.close();
        }
        
        final EditText txtNewText = (EditText) findViewById(R.id.edtHelper);
        Button bsave = (Button) findViewById(R.id.btnHelper);
        
        // �?ำห�?ด Listener �?ห�?�?ั�?�?ุ�?ม เมื�?อ�?ุ�?มถู�?�?ลิ�?
        bsave.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
            	try {
                    addNote(txtNewText.getText().toString());
                	Cursor cursor = getAllNotes();
                	showNotes(cursor);
                	txtNewText.setText(null);
            	}
            	finally {
            		helper.close();
            	}
            }
        });
        
        
        
           
    }
    
    
    private void addNote(String str) {
    	SQLiteDatabase db = helper.getWritableDatabase();
    	ContentValues values = new ContentValues();
    	values.put(TIME, System.currentTimeMillis());
    	values.put(CONTENT, str);
    	db.insertOrThrow(TABLE_NAME, null, values);
    }
    
    private static String[] COLUMNS = { _ID, TIME, CONTENT };
    private static String ORDER_BY = TIME + " DESC";
    private Cursor getAllNotes() {
    	SQLiteDatabase db = helper.getReadableDatabase();
    	Cursor cursor = db.query(TABLE_NAME, COLUMNS, null, null, null, null, ORDER_BY);
    	startManagingCursor(cursor);
    	return cursor;
    }
    
    private void showNotes(Cursor cursor) {
    	StringBuilder builder = new StringBuilder("�?�?อ�?วามที�?�?ั�?ทึ�?�?ว�?:\n\n");
    	
    	while (cursor.moveToNext()) {
    		long id = cursor.getLong(0);          // อ�?า�?�?�?อมูล�?า�?�?อลัม�?�? _id
    		long time = cursor.getLong(1);        // อ�?า�?�?�?อมูล�?า�?�?อลัม�?�? time
    		String content = cursor.getString(2); // อ�?า�?�?�?อมูล�?า�?�?อลัม�?�? content

    		builder.append("ลำดั�? ").append(id).append(": ");
            // �?�?ล�?�?�?า Timestamp เ�?�?�?ออ�?เ�?�?�? Date �?ล�?ว�?ัดรู�?�?�?�?วั�?เวลา�?ห�?ดู�?�?าย
    		String strDate = (String) DateFormat.format("yyyy-MM-dd hh:mm:ss", new Date(time));
    		builder.append(strDate).append("\n");
    		builder.append("\t").append(content).append("\n");
    	}
    	
    	TextView tv = (TextView) findViewById(R.id.tvHelper);
    	tv.setText(builder);
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_datanote, menu);
        return true;
    }
}
