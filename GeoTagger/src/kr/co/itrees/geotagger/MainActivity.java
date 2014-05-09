package kr.co.itrees.geotagger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

/**
 * 
 * @author 이준원
 * @since 2014-05-01
 * @update 2014-05-08 이준원
 * @charset UTF-8
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
		
		/**
		 * @since 2014-05-08
		 * @update 2014-05-08 이준원
		 * @reference http://blog.naver.com/PostView.nhn?blogId=akj61300&logNo=80126183947
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
		
	}
}
