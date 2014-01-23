package play.adi.adj;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BusDb {
	private static final String DB_NAME = "hello.db";
	//private static final String DB_PATH = "/data/data/play.adi.adj/databases/";
	private static String TABLE_NAME = "mydata";

	public static final String COLUMN_ID = "_id";
	private static final String BUS_STOP = "BUS_STOP";
	private static final String Route1 = "Route1";
	private static final String Route2 = "Route2";
	private static final String Route3 = "Route3";
	private static final String Route4 = "Route4";
	private static final String Route5 = "Route5";
	private static final String Route6 = "Route6";
	private static final String Route7 = "Route7";
	private static final String Route8 = "Route8";
	private static final String Route9 = "Route9";
	private static final String Route10 = "Route10";
	private static final int DATABASE_VERSION = 1;

	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;

	private static class DbHelper extends SQLiteOpenHelper {

		public DbHelper(Context context) {
			super(context, DB_NAME, null, DATABASE_VERSION);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onCreate(SQLiteDatabase db) {

			// TODO Auto-generated method stub

			db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID
					+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + BUS_STOP
					+ " TEXT NOT NULL, " + Route1 + " NUMERIC NOT NULL, " + Route2
					+ " NUMERIC NOT NULL, " + Route3 + " NUMERIC NOT NULL, " + Route4
					+ " NUMERIC NOT NULL, " + Route5 + " NUMERIC NOT NULL, " + Route6
					+ " NUMERIC NOT NULL, " + Route7 + " NUMERIC NOT NULL, " + Route8
					+ " NUMERIC NOT NULL, " + Route9 + " NUMERIC NOT NULL, " + Route10
					+ " NUMERIC NOT NULL);");

		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
			onCreate(db);
		}

	}

	public BusDb(Context c) {
		ourContext = c;
	}

	public BusDb open() throws SQLException {
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		ourHelper.close();
	}

	public long createEntry(String name, int[] no) {
		// ,byte Route2,byte Route3,byte Route4,byte Route5,byte Route6,byte Route7,byte Route8,byte Route9,byte
		// Route10

		ContentValues cv = new ContentValues();
		cv.put(BUS_STOP, name);
		cv.put(Route1, no[0]);
		cv.put(Route2, no[1]);
		cv.put(Route3, no[2]);
		cv.put(Route4, no[3]);
		cv.put(Route5, no[4]);
		cv.put(Route6, no[5]);
		cv.put(Route7, no[6]);
		cv.put(Route8, no[7]);
		cv.put(Route9, no[8]);
		cv.put(Route10, no[9]);
		/***
		 * cv.put(Route2, Route2); cv.put(Route3, Route3); cv.put(Route4, Route4); cv.put(Route5, Route5);
		 * cv.put(Route6, Route6); cv.put(Route7, Route7); cv.put(Route8, Route8); cv.put(Route9, Route9);
		 * cv.put(Route10, Route10);
		 **/

		return ourDatabase.insert(TABLE_NAME, null, cv);
	}
	
	
	
	
	
	public String[] routeSearch(String src, String des) throws SQLException {
		String[] columns = new String[] {COLUMN_ID,BUS_STOP,Route1,Route2,Route3,Route4,Route5,Route6,Route7,Route8,Route9,Route10};
		String[] answer = new String[5];
		// byte flag = 0;
		Cursor c = ourDatabase.query(TABLE_NAME, columns, BUS_STOP + "=?",
				new String[]{src}, null, null, null, null);
		Cursor d = ourDatabase.query(TABLE_NAME, columns, BUS_STOP + "=?",
				new String[]{des}, null, null, null, null);
		c.moveToFirst();
		d.moveToFirst();
		int[] routes = new int[10];
		if (c != null) {
			for (int i = 0, j = 0; i < 10; i++) {
				routes[i] =  c.getInt(i + 2);
				//Log.i(routes,"ERROR MESSAGE");
				if (routes[i] == 1) {

					if (d != null) {
						if (d.getInt(i + 2) == 1) {
							answer[j++] = name(columns[i + 2]);
							// flag++;
						}

					}
				}
			}
			return answer;
		}
		return null;

	}
	private String name(String colm){
		if (colm == "Route1") {
			return "Route No.1";
		}
		else if(colm == "Route2") {
			return "Route No.2";
		}
		else if(colm == "Route3") {
			return "Route No.3";
		}
		else if(colm == "Route4") {
			return "Route No.4";
		}
		else if(colm == "Route5") {
			return "Route No.5";
		}
		else if(colm == "Route6") {
			return "Route No.6";
		}
		else if(colm == "Route7") {
			return "Route No.7";
		}
		else if(colm == "Route8") {
			return "Route No.8";
		}
		else if(colm == "Route9") {
			return "Route No.9";
		}
		else if(colm == "Route10") {
			return "Route No.10";
		}
		return "Wrong entry";
	}
	
}
