package kr.co.itrees.geotagger;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * 
 * @author 이준원
 * @since 2014-05-07
 * @update 2014-05-08 이준원
 * @reference http://whitememo.tistory.com/241
 * @charset UTF-8
 */
public class DBAdapter 
{
	static final String DB_NAME = "geo_tagger";
	
	//데이터 베이스를 이용하는 컨텍스트  
    private Context context;  
    //데이터 연동객체   
    private SQLiteDatabase db;  
    
    public DBAdapter(Context context) 
    {
    	this.context = context;
    }
    
    public long insertLocation(Location loc)
    {
    	long result;
    	
    	try
    	{
    		db = (new DBHelper(context).getWritableDatabase());  
    		
	    	ContentValues values = new ContentValues();
	    	
	    	values.put("lat", loc.getLat());
	    	values.put("lon", loc.getLon());
	    	
	    	values.put("q1", loc.getQ1());
	    	values.put("q2", loc.getQ2());
	    	values.put("q3", loc.getQ3());
	    	values.put("q4", loc.getQ4());
	    	values.put("q5", loc.getQ5());
	    	
	    	values.put("photo", loc.getPhoto());
	    	values.put("email", loc.getEmail());
	    	values.put("phone", loc.getPhone());
	    	values.put("website", loc.getWebsite());
	    	
	    	result = db.insert(DB_NAME,null,values);
	    	
	    	return result;
    	}
    	
    	catch(SQLException e)
    	{
    		return -1;
    	}
    	
    	finally
    	{
    		db.close();
    	}
    }
    
    /**
     * @since 2014-05-08 이준원
     * @update 2014-05-08 이준원
     * @return
     */
    public List<Location> selectAllLocation()
    {
    	List<Location> result = new ArrayList<Location>();
    	
    	try
    	{
    		db = (new DBHelper(context).getReadableDatabase());
    		String sql = "select * from geo_tagger";
    		
    		Cursor c = db.rawQuery(sql, null);
    		
    		if(c.moveToFirst()) {
    		
	    		do
	    		{
	    			Location loc = new Location();
	    			loc.setLat(c.getInt(c.getColumnIndex("lat")));
	    			loc.setLon(c.getInt(c.getColumnIndex("lon")));
	    			
	    			loc.setQ1(c.getString(c.getColumnIndex("q1")));
	    			loc.setQ2(c.getString(c.getColumnIndex("q2")));
	    			loc.setQ3(c.getString(c.getColumnIndex("q3")));
	    			loc.setQ4(c.getString(c.getColumnIndex("q4")));
	    			loc.setQ5(c.getString(c.getColumnIndex("q5")));
	    			
	    			loc.setPhoto(c.getString(c.getColumnIndex("photo")));
	    			loc.setEmail(c.getString(c.getColumnIndex("email")));
	    			loc.setPhone(c.getString(c.getColumnIndex("phone")));
	    			loc.setWebsite(c.getString(c.getColumnIndex("website")));
	    			
	    			result.add(loc);
	    		} while(c.moveToNext());
    		}
    	}
    	
    	finally
    	{
    		db.close();
    	}
    	
    	return result;
    }
}
