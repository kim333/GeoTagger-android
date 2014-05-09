package kr.co.itrees.geotagger;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * 
 * @author 이준원
 * @since 2014-05-01
 * @update 2014-05-08 이준원
 * @charset UTF-8
 */
public class TaggingActivity extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tagging);

		/**
		 * @since 2014-05-08
		 * @update 2014-05-08 이준원
		 */
		// 질문 1
		final CheckBox chkQ1_1 = (CheckBox)findViewById(R.id.chk_q1_1); // Evangelism
		final CheckBox chkQ1_2 = (CheckBox)findViewById(R.id.chk_q1_2); // Training
		final CheckBox chkQ1_3 = (CheckBox)findViewById(R.id.chk_q1_3); // Mercy
		
		// 질문 2
		final CheckBox chkQ2_1 = (CheckBox)findViewById(R.id.chk_q2_1); // Youth / Children
		final CheckBox chkQ2_2 = (CheckBox)findViewById(R.id.chk_q2_2); // Campus Ministry
		final CheckBox chkQ2_3 = (CheckBox)findViewById(R.id.chk_q2_3); // Indigenous People
		final CheckBox chkQ2_4 = (CheckBox)findViewById(R.id.chk_q2_4); // Prison Ministry
		final CheckBox chkQ2_5 = (CheckBox)findViewById(R.id.chk_q2_5); // Prostitutes
		final CheckBox chkQ2_6 = (CheckBox)findViewById(R.id.chk_q2_6); // Orphans
		final CheckBox chkQ2_7 = (CheckBox)findViewById(R.id.chk_q2_7); // Woman
		final CheckBox chkQ2_8 = (CheckBox)findViewById(R.id.chk_q2_8); // Urban Ministry
		final CheckBox chkQ2_9 = (CheckBox)findViewById(R.id.chk_q2_9); // Hospital Ministry
		final CheckBox chkQ2_10 = (CheckBox)findViewById(R.id.chk_q2_10); // Media / Communications
		final CheckBox chkQ2_11 = (CheckBox)findViewById(R.id.chk_q2_11); // Community Development
		final CheckBox chkQ2_12 = (CheckBox)findViewById(R.id.chk_q2_12); // Bible Studies
		final CheckBox chkQ2_13 = (CheckBox)findViewById(R.id.chk_q2_13); // Church Planting
		final CheckBox chkQ2_14 = (CheckBox)findViewById(R.id.chk_q2_14); // Arts / Entertainment / Sports
		final CheckBox chkQ2_15 = (CheckBox)findViewById(R.id.chk_q2_15); // Counseling
		final CheckBox chkQ2_16 = (CheckBox)findViewById(R.id.chk_q2_16); // Healthcare
		final CheckBox chkQ2_17 = (CheckBox)findViewById(R.id.chk_q2_17); // Maintenance / Construction
		final CheckBox chkQ2_18 = (CheckBox)findViewById(R.id.chk_q2_18); // Research
		
		// 질문 3
		final EditText editText1 = (EditText)findViewById(R.id.editText1); // description
		
		// 질문 4
		final EditText editText2 = (EditText)findViewById(R.id.EditText2); // keywords (comma)
		
		// 질문 5 - 정보 수집 동의
		final CheckBox chkQ5 = (CheckBox)findViewById(R.id.chk_q5);
		
		final EditText editText3 = (EditText)findViewById(R.id.editText3); // email
		final EditText editText4 = (EditText)findViewById(R.id.editText4); // phone
		final EditText editText5 = (EditText)findViewById(R.id.editText5); // website
		
		TextView btnCancel = (TextView)findViewById(R.id.btn_cancel);
		TextView btnSave = (TextView)findViewById(R.id.btn_save);
		
		btnCancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		/**
		 * @since 2014-05-08
		 * @update 2014-05-08 이준원
		 */
		btnSave.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String q1 = "";
				String q2 = "";
				String q3,q4,q5,photo,email,phone,website;
				
				// Question 1
				if(chkQ1_1.isChecked())
				{
					q1 += ",Evangelism";
				}
				
				if(chkQ1_2.isChecked())
				{
					q1 += ",Training";
				}
				
				if(chkQ1_3.isChecked())
				{
					q1 += ",Mercy";
				}
				
				// Question 2
				if(chkQ2_1.isChecked())
				{
					q2 += ",Youth / Children";
				}
				
				if(chkQ2_2.isChecked())
				{
					q2 += ",Campus Ministry";
				}
				
				if(chkQ2_3.isChecked())
				{
					q2 += ",Indigenous People";
				}
				
				if(chkQ2_4.isChecked())
				{
					q2 += ",Prison Ministry";
				}
				
				if(chkQ2_5.isChecked())
				{
					q2 += ",Prostitutes";
				}
				
				if(chkQ2_6.isChecked())
				{
					q2 += ",Orphans";
				}
				
				if(chkQ2_7.isChecked())
				{
					q2 += ",Woman";
				}
				
				if(chkQ2_8.isChecked())
				{
					q2 += ",Urban Ministry";
				}
				
				if(chkQ2_9.isChecked())
				{
					q2 += ",Hospital Ministry";
				}
				
				if(chkQ2_10.isChecked())
				{
					q2 += ",Media / Communications";
				}
				
				if(chkQ2_11.isChecked())
				{
					q2 += ",Community Development";
				}
				
				if(chkQ2_12.isChecked())
				{
					q2 += ",Bible Studies";
				}
				
				if(chkQ2_13.isChecked())
				{
					q2 += ",Church Planting";
				}
				
				if(chkQ2_14.isChecked())
				{
					q2 += ",Arts / Entertainment / Sports";
				}
				
				if(chkQ2_15.isChecked())
				{
					q2 += ",Counseling";
				}
				
				if(chkQ2_16.isChecked())
				{
					q2 += ",Healthcare";
				}
				
				if(chkQ2_17.isChecked())
				{
					q2 += ",Maintenance / Construction";
				}
				
				if(chkQ2_18.isChecked())
				{
					q2 += ",Research";
				}
				
				if(q1.charAt(0) == ',')
				{
					q1 = q1.substring(1);
				}
				
				if(q2.charAt(0) == ',')
				{
					q2 = q2.substring(1);
				}
				
				// Question 3
				q3 = editText1.getText().toString();
				
				// Question 4
				q4 = editText2.getText().toString();
				
				// Question 5 - yes | no
				if(chkQ5.isChecked())
				{
					q5 = "yes";
				}
				else
				{
					q5 = "no";
				}
				
				email = editText3.getText().toString();
				phone = editText4.getText().toString();
				website = editText5.getText().toString();
				
				// 위도 경도에 1000000을 곱한 값
				// 일단 시험삼아 모든 태깅 정보에 열방센터 좌표가 찍히게 함.
				int lat = 36451256;
				int lon = 127920029; 
				
				Location loc = new Location();
				loc.setLat(lat);
				loc.setLon(lon);
				loc.setQ1(q1);
				loc.setQ2(q2);
				loc.setQ3(q3);
				loc.setQ4(q4);
				loc.setQ5(q5);
				loc.setEmail(email);
				loc.setPhone(phone);
				loc.setWebsite(website);
				
				DBAdapter dba = new DBAdapter(TaggingActivity.this);
				dba.insertLocation(loc);
				
				finish();
			}
		});
	}
}
