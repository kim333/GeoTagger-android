package kr.co.itrees.geotagger;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

/**
 * 
 * @author ITREE-DEV (Junwon Lee)
 * @since 2014-04-28
 *
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
*/
        TabHost tabHost = (TabHost) findViewById(R.id.tab_host);
        tabHost.setup();
        
        // 탭 1 : 지도
        TabSpec tabSpec1 = tabHost.newTabSpec("Map");
        tabSpec1.setIndicator("Map");
        tabSpec1.setContent(R.id.tab1);
        tabHost.addTab(tabSpec1);
        
        // 탭 2 : 히스토리
        TabSpec tabSpec2 = tabHost.newTabSpec("History");
        tabSpec2.setIndicator("History");
        tabSpec2.setContent(R.id.tab2);
        tabHost.addTab(tabSpec2);
        // 탭 3 : 설정
        TabSpec tabSpec3 = tabHost.newTabSpec("Settings");
        tabSpec3.setIndicator("Settings");
        tabSpec3.setContent(R.id.tab3);
        tabHost.addTab(tabSpec3);
        
        WebView web1 = (WebView)findViewById(R.id.webView1);
        
        WebSettings webSettings = web1.getSettings();
        /*webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setPluginState(PluginState.ON);*/
        
        web1.loadUrl("file:///android_asset/www/map.html");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
/*
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
*/
}
