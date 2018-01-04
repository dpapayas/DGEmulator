package in.digiro.core;

import android.content.Context;
import android.util.Log;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 * Created by corechain on 04/01/18.
 */

public class Peer {

    public Peer(Keypairs keypairs, Context context){

        MqttAndroidClient client =
                new MqttAndroidClient(context,
                        "tcp://seed.digiro.in:1883",
                        keypairs.getPubKey());


        try {
            Log.d("CORE", "initiate peer connection");
            MqttConnectOptions options = new MqttConnectOptions();
            options.setAutomaticReconnect(true);
            IMqttToken token = client.connect();
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    // We are connected
                    Log.d("CORE", "peer connection success");
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    // Something went wrong e.g. connection timeout or firewall problems
                    Log.d("CORE", "peer connection success");

                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }


}
