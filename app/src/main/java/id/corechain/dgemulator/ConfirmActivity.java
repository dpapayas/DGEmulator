package id.corechain.dgemulator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import id.corechain.dgemulator.swipe.OnActiveListener;
import id.corechain.dgemulator.swipe.SwipeButton;

/**
 * Created by dpapayas on 1/4/18.
 */

public class ConfirmActivity extends AppCompatActivity {

    SwipeButton swipeButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_send_confirm);

        swipeButton = (SwipeButton)findViewById(R.id.swipeNoState);

        swipeButton.setOnActiveListener(new OnActiveListener() {
            @Override
            public void onActive() {
                Intent intent = new Intent(ConfirmActivity.this, ReceiptActivity.class);
                startActivity(intent);
            }
        });
    }
}
