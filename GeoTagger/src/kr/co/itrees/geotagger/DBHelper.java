package kr.co.itrees.geotagger;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
 * 
 * author 이준원
 * since 2014-05-07
 * update 2014-05-07 이준원
 * reference http://whitememo.tistory.com/241
 * charset UTF-8
 */
public class DBHelper extends  SQLiteOpenHelper 
{
	private static final String DB_NAME = "geo_tagger.db";
	private static final int DB_VER = 1;  

	public DBHelper(Context context) 
	{
		super(context, DB_NAME, null, DB_VER);
	}

	@Override
	public void onCreate(SQLiteDatabase db) 
	{
		// TODO Auto-generated method stub
		String sql = "create table geo_tagger ("
						+ "rowid integer primary key autoincrement"
						+ ", time_stamp timestamp datetime default current_timestamp"
						+ ", lat integer"
						+ ", lon integer"
						+ ", q1 text"
						+ ", q2 text"
						+ ", q3 text"
						+ ", q4 text"
						+ ", q5 text"
						+ ", photo text"
						+ ", email text"
						+ ", phone text"
						+ ", website text"
					+ ");";
		db.execSQL(sql); 
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) 
	{
		// TODO Auto-generated method stub
		String sql_droptable = "DROP TABLE IF EXISTS " + "geo_tagger;";  
        db.execSQL(sql_droptable);
	}

}
