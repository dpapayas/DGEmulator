package in.digiro.core.micro;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import org.json.JSONObject;

/**
 * Created by corechain on 25/12/17.
 */

public class MicroApp {
    Context mContext;

    /** Instantiate the interface and set the context */
    MicroApp(Context c) {
        mContext = c;
    }

    /** Show a toast from the web page */
    @JavascriptInterface
    public void about() {
        Toast.makeText(mContext, "MicroAPP ver 1.0", Toast.LENGTH_SHORT).show();
    }


    public void auth(String publickey, String token){

    }


    public void  openScanner(){

    }

    public void  getPaid(int amount){

    }


    public void  sendPayment(int amount){

    }

    public void setData(String key ,JSONObject data){

    }

    public String setData(JSONObject data){
        return "_random_id";
    }


    public JSONObject getData(String key){
        return null;
    }


    public JSONObject AsynchRequest(String url , JSONObject payload) {
        return null;
    }


}
