package id.corechain.dgemulator;

import android.webkit.WebView;

/**
 * Created by dpapayas on 10/26/17.
 */

public class WebViewViewer {

    public static void ViewURL(WebView webView, String url){
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);
        webView.setHorizontalScrollBarEnabled(false);
    }
}
