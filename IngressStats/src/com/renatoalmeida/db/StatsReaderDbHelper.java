package com.renatoalmeida.db;

import java.util.HashMap;
import java.util.Map.Entry;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.renatoalmeida.ingressstats.R;

public class StatsReaderDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 4;
    public static final String DATABASE_NAME = "IngressStats.db";

    private static final String INT_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    
    public static final String TABLE_NAME = "IngressStats";

    
    private String SQL_CREATE_ENTRIES =
        "CREATE TABLE " + TABLE_NAME + " ("+
        		"StatID INTEGER PRIMARY KEY AUTOINCREMENT, ";
        		
    
    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + TABLE_NAME;
    
    public StatsReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        
        String[] stats = context.getResources().getStringArray(R.array.stats);
        
        //add the rest of the columns
        for(int i = 0; i< stats.length; i++){
    		SQL_CREATE_ENTRIES += stats[i] + INT_TYPE + COMMA_SEP;
    	}
    	
    	//Remove last comma
    	SQL_CREATE_ENTRIES = SQL_CREATE_ENTRIES.substring(0, SQL_CREATE_ENTRIES.length()-2);
    	
    	SQL_CREATE_ENTRIES += " )";
    }
    
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    	db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
    
    public void addEntry(HashMap<String, Long> values){
    	SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cValues = new ContentValues();
		
		for (Entry<String, Long> item : values.entrySet()) {
			cValues.put(item.getKey(), item.getValue());
		}
		
		db.insert(TABLE_NAME, null, cValues);
		db.close();
    }
    
    public HashMap<String, Long> getFirstEntry(){
    	SQLiteDatabase db = this.getReadableDatabase();
    	HashMap<String, Long> values = null;
    	
    	Cursor c = db.query(
    			TABLE_NAME,  
    		    null,                               // The columns to return
    		    null,                                // The columns for the WHERE clause
    		    null,                            
    		    null,                                     
    		    null,                                     
    		    "StatID DESC"                                 
    		    );
    	
    	if(c.moveToFirst()){
    		values = new HashMap<String, Long>();
    		for(int i = 0; i < c.getColumnCount(); i++){
    			values.put(c.getColumnName(i), c.getLong(i));
    		}
    	}
    	
    	db.close();
    	return values;
    }

    public HashMap<String, Long> getSecondEntry(){
    	SQLiteDatabase db = this.getReadableDatabase();
    	HashMap<String, Long> values = null;
    	
    	Cursor c = db.query(
    			TABLE_NAME,  
    		    null,                               // The columns to return
    		    null,                                // The columns for the WHERE clause
    		    null,                            
    		    null,                                     
    		    null,                                     
    		    "StatID DESC"                                 
    		    );
    	
    	if(c.moveToFirst() && c.moveToNext()){
    		values = new HashMap<String, Long>();
    		for(int i = 0; i < c.getColumnCount(); i++){
    			values.put(c.getColumnName(i), c.getLong(i));
    		}
    	}
    	
    	db.close();
    	return values;
    }
    

    public HashMap<String, Long> getAllEntries(){
    	SQLiteDatabase db = this.getReadableDatabase();
    	HashMap<String, Long> values = null;
    	
    	Cursor c = db.query(
    			TABLE_NAME,  
    		    null,                               // The columns to return
    		    null,                                // The columns for the WHERE clause
    		    null,                            
    		    null,                                     
    		    null,                                     
    		    "StatID DESC"                                 
    		    );
    	
    	while(c.moveToFirst()){
    		values = new HashMap<String, Long>();
    		for(int i = 0; i < c.getColumnCount(); i++){
    			values.put(c.getColumnName(i), c.getLong(i));
    		}
    	}
    	
    	db.close();
    	return values;
    }
}
