package in.digiro.core.micro;

import android.webkit.WebView;

/**
 * Created by corechain on 25/12/17.
 */

public class MicroService  {

    private static MicroService _instance;
    public static MicroService getInstance(){
        if (_instance==null){

        }
        return _instance;
    }
    private MicroService(){

    }

    private WebView _webview;

    public void init(WebView webview){
        this._webview = webview;

        /**
         *  setup client and inject digiroin core db
         */
        this._webview.addJavascriptInterface(new MicroApp(this._webview.getContext())
                , "APP");


    }
}
