package play.adi.adj;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {
		
		private static final String DB_PATH = "/data/data/play.adi.adj/databases/";
		private static final String DB_NAME = "test.db";
		
		private static String TABLE_NAME = "mydata";
		
		public static final String COLUMN_ID = "_id";
		private static final String BUS_STOP = "BUS_STOP";
		private static final String R1 = "R1";
		private static final String R2 = "R2";
		private static final String R3 = "R3";
		private static final String R4 = "R4";
		private static final String R5 = "R5";
		private static final String R6 = "R6";
		private static final String R7 = "R7";
		private static final String R8 = "R8";
		private static final String R9 = "R9";
		private static final String R10 = "R10";
		
		
		
		private SQLiteDatabase busDataBase;
		private final Context myContext;
		
		public DataBaseHelper(Context context) {
			
			super(context, DB_NAME, null, 1);
	        this.myContext = context;
		}
		
		public void createDataBase() throws IOException{
			 
	    	boolean dbExist = checkDataBase();
	    	
	    	if(dbExist) {
	    		//do nothing - database already exist
	    	}else {
	    		
	    		this.getReadableDatabase();
	    		
	    		try {
	    			 
	    			copyDataBase();
	 
	    		} catch (IOException e) {
	 
	        		throw new Error("Error copying database");
	 
	        	}
	    	}
		}
		
		 private void copyDataBase()throws IOException {
			
			//Open your local db as the input stream
		    	InputStream myInput = myContext.getAssets().open(DB_NAME);
		  
		    // Path to the just created empty db
		    	String outFileName = DB_PATH + DB_NAME;
		    	
		    //Open the empty db as the output stream
		    	OutputStream myOutput = new FileOutputStream(outFileName);
		    	
		    	
		    //transfer bytes from the inputfile to the outputfile
		    	byte[] buffer = new byte[1024];
		    	int length;
		    	while ((length = myInput.read(buffer))>0){
		    		myOutput.write(buffer, 0, length);
		    	}	
		    	
		    //Close the streams
		    	myOutput.flush();
		    	myOutput.close();
		    	myInput.close();
		}

		/**
	     * Check if the database already exist to avoid re-copying the file each time you open the application.
	     * @return true if it exists, false if it doesn't
	     */
		private boolean checkDataBase() {
			
			SQLiteDatabase checkDB = null;
			
			try{
				String myPath = DB_PATH + DB_NAME;
				checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
				
			}catch(SQLiteException e){
				//database does't exist yet.
			}
			
			if(checkDB != null){
				checkDB.close();
			}
			
			 return checkDB != null ? true : false;
		}
		
		 public void openDataBase() throws SQLException{
			 
		    	//Open the database
		        String myPath = DB_PATH + DB_NAME;
		    	busDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
		    	if (busDataBase == null) {
		    		
		    	}
		    }
		 
		 @Override
			public synchronized void close() {
		 
		    	    if(busDataBase != null)
		    		    busDataBase.close();
		 
		    	    super.close();
		 
			}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			
		}
		
		public void onSave(String busStand,String r1,String r2, String r3) {
			
			ContentValues contentValues = new ContentValues();
			
			contentValues.put("BUS STOP", busStand);
			
			contentValues.put("R1",r1);
			contentValues.put("R2",r2);
			contentValues.put("R3",r3);
			
			busDataBase.insert("mydata", null, contentValues);
		
		
			
		}
		
		public String[] routeSearch(String src, String des) throws SQLException{
			String[] columns = new String[]{ COLUMN_ID,BUS_STOP,R1,R2,R3,R4,R5,R6,R7,R8,R9,R10};
			String[] answer = new String[5];
			//byte flag = 0;
			Cursor c = busDataBase.query(TABLE_NAME, columns, BUS_STOP + "=" + src, null, null, null, null);
			Cursor d = busDataBase.query(TABLE_NAME, columns, BUS_STOP + "=" + des, null, null, null, null);
			byte[] routes = new byte[10];
			if (c!=null) {
				for(byte i = 0, j =0;i< 10; i++){
					routes[i] = (byte)c.getInt(i+2);
					if(routes[i] == 1){
						
						if(d!= null){
							if( d.getInt(i+2) == 1){
								answer[j++] = columns[i+2];
								//flag++;
							}
							
						}
					}
				}
				return answer;
			}
			return null;
			
		}
		
		
		public Cursor getAllRecords() {
			return busDataBase.rawQuery("SELECT * FROM " + TABLE_NAME,null);
		}
		
}
