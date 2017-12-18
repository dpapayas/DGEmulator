package id.corechain.dgemulator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

/**
 * Created by dpapayas on 10/26/17.
 */

public class MicroServiceWebActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_action_chevron_left);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);;

        webView = (WebView)findViewById(R.id.webView);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url").replace("app", "https");

        WebViewViewer.ViewURL(webView, url);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {

            case android.R.id.home:
                intent = new Intent(MicroServiceWebActivity.this, DashboardActivity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.action_settings:
                intent = new Intent(MicroServiceWebActivity.this, InfoMicroAppActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
