package kr.co.itrees.geotagger;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

/*
 * 
 * author 이준원
 * since 2014-05-01
 * update 2014-05-09 이준원
 * charset UTF-8
 */
public class MainActivity extends Activity 
{

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TextView btn_add = (TextView) findViewById(R.id.btn_add);
		
		
		// Add 버튼을 누르면 태깅 페이지로 이동
		btn_add.setOnClickListener(new View.OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				Intent i = new Intent(MainActivity.this, TaggingActivity.class);
				startActivity(i);
			}
		});
		
		/*
		 * since 2014-05-08
		 * update 2014-05-08 이준원
		 * reference http://blog.naver.com/PostView.nhn?blogId=akj61300&logNo=80126183947
		 */
		// 탭 호스트 설정
		final TabHost tabHost = (TabHost)findViewById(R.id.tabHost);
        tabHost.setup();

		tabHost.addTab(tabHost.newTabSpec("tab1")
                .setIndicator("Tag", this.getResources().getDrawable(R.drawable.map_pin_7))
                .setContent(R.id.Tag));
		
        tabHost.addTab(tabHost.newTabSpec("tab2")
                .setIndicator("History", this.getResources().getDrawable(android.R.drawable.ic_menu_recent_history))
                .setContent(R.id.History));
        tabHost.addTab(tabHost.newTabSpec("tab3")
                .setIndicator("Settings", this.getResources().getDrawable(R.drawable.list_star_7))
                .setContent(R.id.Settings));
		
        
        /*
         * since 2014-05-09
         * update 2014-05-09 이준원
         * reference http://sharepid.tistory.com/951
         */
        // 히스토리 리스트
        
        ArrayList<String> historyList = new ArrayList<String>();
        //historyList.add("요르단");
        //historyList.add("시리아");
        //historyList.add("터키");
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, historyList);
        		
        ListView historyListView = (ListView)findViewById(R.id.historyList);
        historyListView.setAdapter(adapter);
        historyListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        
        DBAdapter dba = new DBAdapter(MainActivity.this);
        List<Location> locList = dba.selectAllLocation();
        
        		
        for(int i = 0; i  < locList.size(); i++)
        {
        	historyList.add(locList.get(i).getQ3());
        }
	}
}
