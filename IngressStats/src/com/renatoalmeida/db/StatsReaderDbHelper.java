package com.renatoalmeida.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.renatoalmeida.db.StatsContract.StatsEntry;

public class StatsReaderDbHelper extends SQLiteOpenHelper {

	// If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "IngressStats.db";

    private static final String INT_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    
    private static String SQL_CREATE_ENTRIES =
        "CREATE TABLE " + StatsEntry.TABLE_NAME + " (" +
        		StatsEntry._ID + INT_TYPE + " KEY," +
        		StatsEntry.COLUMN_NAME_STATS_ID + INT_TYPE + COMMA_SEP;
    
    static {
    	
    	for(int i = 0; i<StatsResources.stats.size(); i++){
    		
    		SQL_CREATE_ENTRIES += StatsResources.stats.get(i) + INT_TYPE + COMMA_SEP;
    	}
    	
    	//Remove last comma
    	SQL_CREATE_ENTRIES = SQL_CREATE_ENTRIES.substring(0, SQL_CREATE_ENTRIES.length()-2);
    	
    	SQL_CREATE_ENTRIES += " )";
    }
    
    public StatsReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Do nothing, because it would delete the entries
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
    
    public Cursor getLastEntry(){
    	SQLiteDatabase db = this.getReadableDatabase();

    	Cursor c = db.query(
    			StatsEntry.TABLE_NAME,  
    		    null,                               // The columns to return
    		    null,                                // The columns for the WHERE clause
    		    null,                            
    		    null,                                     
    		    null,                                     
    		    StatsEntry.COLUMN_NAME_STATS_ID + " DESC"                                 
    		    );
    	return c;
    }
}
