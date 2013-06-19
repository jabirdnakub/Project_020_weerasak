package rru.csit.project020;

import static android.provider.BaseColumns._ID;
import static rru.csit.project020.Constants.*;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class NotesHelper extends SQLiteOpenHelper {
	private static final String DATABASE_NAME = "simple_note.db";
	private static final int DATABASE_VERSION = 1;
	
	public NotesHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override 
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + _ID
			       + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TIME
			       + " INTEGER, " + CONTENT + " TEXT NOT NULL);");
	}
	
	@Override 
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// à¹?à¸?à¹?à¸”à¸—à¸µà¹?à¹?à¸?à¹?à¸­à¸±à¸?à¹€à¸?à¸£à¸”à¸?à¸²à¸?à¸?à¹?à¸­à¸¡à¸¹à¸¥
	}
}
