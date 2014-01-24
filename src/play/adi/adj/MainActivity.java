package play.adi.adj;

import android.app.Activity;
import android.app.Dialog;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;





public class MainActivity extends Activity implements OnClickListener {
	
	
	public String spin_src,spin_des;
	private BusDb myDbHelper;
	String name,name2;
	int[] no = new int[10];
	Spinner spinner;
	Spinner spinner_des;
	private static final String DB_NAME = "hello.db";
	private static final String DB_PATH = "/data/data/play.adi.adj/databases/";
	String[] answer = {"default","default","default","default","default"};
	String[] lst = { 
			"AGARWAL FARM",
			"AJMERI GATE", 
			"BADI CHOPAR",
			"BHANKROTA",
			
			
			"CHANDPOLE",
			"CHOMU PULIA",
			"CHOTI CHOPAR",
			"CITY PLEX MALL ASHRAM MARG",
			"COLLECTORATE",
			"DADI KA PHATAK",
			"DURGAPURA",
			"ESI",
			"GALTA GATE",
			"GANDHI NAGAR",
			"GOPALPURA",
			"GPO",
			"HEERAPURA",
			"JAGATPURA",
			"KANOTA",
			"KHOLE KE HANUMAN JI",
			"KHIRNI PHATAK",
			"KINGS ROAD",
			"KUNDA",
			"MAHARANI COLLEGE",
			
			"MALAVIYA NAGAR",
			"NARAYAN SINGH CIRCLE",
			"NEW SANGANER ROAD",
			
			"PEETAL FACTORY",
			"PRATAP NAGAR",
			"PURANI CHUNGI",
	
			"RAMBAGH",
			"SANGANER",
			"SANGANER THANA",
			"SANGANERI GATE",
			"SINDHI CAMP",
			"SODALA",
			
			"SURYA NAGAR",
			
			"TODI",
			"TONK PHATAK",
			"VKI ROAD NO17"
					

					
};

	
	public Button sqlGetInfo;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		spinner = (Spinner) findViewById(R.id.spinner_src);
		spinner_des = (Spinner) findViewById(R.id.spinner_dest);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, lst);
		spinner.setAdapter(adapter);
		//spinner.setOnItemSelectedListener(this);
		
		sqlGetInfo = (Button) findViewById(R.id.button1);
		sqlGetInfo.setOnClickListener(this);
		//ArrayAdapter<String> adapter_des = new ArrayAdapter<String>(this,
			//	android.R.layout.simple_list_item_1, lst);
		spinner_des.setAdapter(adapter);
		//spinner_des.setOnItemSelectedListener(this);
		
		//DataBaseHelper myDbHelper;
       
        
        
        boolean didItWork = true;
        
        myDbHelper = new BusDb(this);
        
        boolean dbExist = checkDataBase();
    	
    	if(dbExist) {
    		//do nothing - database already exist
    		Log.d("Check_Db","DB exist already");
    	}else {
        
		try {

			 
		        
		        myDbHelper.open();
		    
		        
            for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
            name = "TODI";
			no[0] =1;
			myDbHelper.createEntry(name,no);
			
			for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
		    name = "BADI CHOPAR";
			no[0] = 1; no[4] = 1;
			myDbHelper.createEntry(name,no);


            for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
            name = "VKI ROAD NO17";
			no[0] =1;
			myDbHelper.createEntry(name,no);
			
			for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
			name = "BHANKROTA";
			no[1] = 1;
			myDbHelper.createEntry(name,no);

            for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
            name = "CHANDPOLE";
			no[0] =1;no[1] =1; no[3] = 1; no[8] = 1; no[9] = 1;
			myDbHelper.createEntry(name,no);
			
			for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
			name = "PRATAP NAGAR";
			no[2] = 1;
			myDbHelper.createEntry(name,no);

            for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
            name = "CHOTI CHOPAR";
			no[0] =1;no[2] =1;
			myDbHelper.createEntry(name,no);
			
			for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
			name = "SANGANER";
			no[7] = 1;
			myDbHelper.createEntry(name,no);


            for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
            name = "AJMERI GATE";
			no[2] =1; no[3] = 1; no[4] = 1; no[7] = 1;
			myDbHelper.createEntry(name,no);
			
			for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
			name = "KANOTA";
			no[3] = 1;
			myDbHelper.createEntry(name,no);


            for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
            name = "SINDHI CAMP";
			no[0] =1;
			myDbHelper.createEntry(name,no);
			
			for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
			name = "KUNDA";
			no[4] = 1;
			myDbHelper.createEntry(name,no);


            for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
            name = "COLLECTORATE";
			no[4] =1; no[5] = 1;
			myDbHelper.createEntry(name,no);
			
			for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
			name = "MALAVIYA NAGAR";
			no[5] = 1;
			myDbHelper.createEntry(name,no);


            for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
            name = "KHIRNI PHATAK";
			no[5] =1;
			myDbHelper.createEntry(name,no);
			
			for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
			name = "JAGATPURA";
			no[7] = 1;
			myDbHelper.createEntry(name,no);

            for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
            name = "AGARWAL FARM";
			no[7] =1;no[8] =1;
			myDbHelper.createEntry(name,no);
			
			for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
			name = "DADI KA PHATAK";
			no[8] = 1;
			myDbHelper.createEntry(name,no);


            for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
            name = "GALTA GATE";
			no[9] = 1;
			myDbHelper.createEntry(name,no);
			
			for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
			name = "KHOLE KE HANUMAN JI";
			no[3] = 1;
			myDbHelper.createEntry(name,no);
    

            for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
            name = "SURYA NAGAR";
			no[6] =1;
			myDbHelper.createEntry(name,no);
			
			for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
			name = "DURGAPURA";
			no[8] = 1; no[2] = 1;
			myDbHelper.createEntry(name,no);


            for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
            name = "TONK PHATAK";
			no[2] =1;no[6] =1; no[8] = 1;
			myDbHelper.createEntry(name,no);
			
			for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
			name= "GANDHI NAGAR";
			no[2] = 1; no[6] = 1;no[7] = 1;
			myDbHelper.createEntry(name,no);


            for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
            name = "RAMBAGH";
			no[2] = 1; no[6] = 1;no[7] = 1;
			myDbHelper.createEntry(name,no);
			
			for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
			name = "NARAYAN SINGH CIRCLE";
			no[2] = 1; no[5] = 1; no[6] = 1;no[7] = 1;
			myDbHelper.createEntry(name,no);

            for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
            name = "MAHARANI COLLEGE";
			no[2] =1; no[3] = 1; no[7] = 1;
			myDbHelper.createEntry(name,no);
			
			for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
			name = "SANGANERI GATE";
			no[3] = 1; no[4] = 1;
			myDbHelper.createEntry(name,no);


            for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
            name = "PEETAL FACTORY";
			no[0] =1; no[8] = 1;
			myDbHelper.createEntry(name,no);
			
			for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
			name = "CHOMU PULIA";
			no[0] = 1; no[5] = 1;
			myDbHelper.createEntry(name,no);


            for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
            name = "HEERAPURA";
			no[1] =1; no[6] = 1;
			myDbHelper.createEntry(name,no);
			
			for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
			name = "KINGS ROAD";
			no[8] = 1; no[8] = 1;
			myDbHelper.createEntry(name,no);

            for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
            name = "PURANI CHUNGI";
			no[1] =1; no[3] = 1; no[8] = 1;
			myDbHelper.createEntry(name,no);
			
			for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
			name = "NEW SANGANER ROAD";
			no[1] = 1; no[7] = 1;
			myDbHelper.createEntry(name,no);


            for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
            name = "SODALA";
			no[1] =1; no[7] = 1;
			myDbHelper.createEntry(name,no);
			
			for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
			name = "ESI";
			no[1] = 1; no[7] = 1;no[9] = 1;
			myDbHelper.createEntry(name,no);


            for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
            name = "GPO";
			no[1] =1; no[3] = 1; no[4] = 1; no[7] = 1;
			myDbHelper.createEntry(name,no);
			
			for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
			name = "SANGANER THANA";
			no[2] = 1;
			myDbHelper.createEntry(name,no);


            for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
             name = "CITY PLEX MALL ASHRAM MARG";
			no[2] =1;no[7] =1; 
			myDbHelper.createEntry(name,no);
			
			for (byte i= 0; i<10;i++){
				no[i] = 0;
			}
			 name = "GOPALPURA";
			no[2] = 1; no[6] = 1;no[8] = 1;
			myDbHelper.createEntry(name,no);
			myDbHelper.close();
			
		    	

		} catch (Exception e) {
			didItWork = false;
			String error = e.toString();
			Dialog d = new Dialog(this);
			d.setTitle("Database creation failed");
			TextView tv = new TextView(this);
			tv.setText(error);
			d.setContentView(tv);
			d.show();
		} 
    	}
		/*finally {
			if (didItWork) {
				Dialog d = new Dialog(this);
				d.setTitle("Heck Yea!");
				TextView tv = new TextView(this);
				tv.setText("Success");
				d.setContentView(tv);
				d.show();
			}
		}
		*/
        
        
		
 
 	
 	
 	
 	
 	
	}
		
	
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		switch (arg0.getId()) {
		case R.id.button1:
			TextView tv_ans = (TextView) findViewById(R.id.textView4);
			//DataBaseHelper bus_db = new DataBaseHelper(this);
			//bus_db.openDataBase();
			spin_src = spinner.getSelectedItem().toString();
			spin_des = spinner_des.getSelectedItem().toString();
			Log.d("SOURCE",spin_des);
			if(spin_src == spin_des){
				tv_ans.setText("Your source and destination are same,Please select source and destination different");
			}
			else {
				
			
			myDbHelper.open();
			answer = myDbHelper.routeSearch(spin_src,spin_des);
			myDbHelper.close();
			//Log.d("TAGGGG",answer[0]);
			//Log.d("2TAGGGG",answer[1]);
			//Log.d("3TAGGGG",answer[2]);
			//Log.d("4TAGGGG",answer[3]);
			//Log.d("5TAGGGG",answer[4]);
			//tv_ans.setText(answer.toString());
			tv_ans.setText(CharSequence(answer));
		//	Intent i = new Intent("play.adi.adj.ROUTEVIEW");
			//startActivity(i);
			}
			
		}
		
	}
	
	
	private CharSequence CharSequence(String[] answer) {
		// TODO Auto-generated method stub
		CharSequence seq ="";
		if(answer[0] == null){
			seq = "No route has been found\n";
			return seq;
				}
		seq = "Following routes found -\n";
		for(int i =0;i<5;i++){
			if(answer[i] != null){
				seq = seq + answer[i]+"\n";
			}
		}
		return seq;
	}
	
	
	public void onSearch(View view){
		
	}
	
	private boolean checkDataBase() {
		
		SQLiteDatabase checkDB = null;
		
		try{
			String myPath = DB_PATH + DB_NAME;
			checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
			
		}catch(SQLiteException e){
			Log.d("Db_error","database does't exist yet.");
		}
		
		if(checkDB != null){
			checkDB.close();
		}
		
		 return checkDB != null ? true : false;
	}

	@Override
    public void onPause() {
        super.onPause();
        myDbHelper.close();
    }
	
	 @Override
	    public void onResume() {
	        super.onResume();
	        myDbHelper.open();
	    }
	
	
	/*
	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
		switch(arg1.getId()){
		case R.id.spinner_dest:
			spin_des = spinner_des.getSelectedItem().toString();
			//getStand(spin_src,spin_des);
			break;
		case R.id.spinner_src:
			spin_src = spinner.getSelectedItem().toString();
			break;
		}
		
	}


	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
*/
}