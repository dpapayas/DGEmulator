package id.corechain.dgemulator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by dpapayas on 1/4/18.
 */

public class AmountActivity extends AppCompatActivity {

    Button btnConfirm, btnClear;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frag_send_amount);

        btnConfirm = (Button)findViewById(R.id.btnKirim);
        btnClear = (Button)findViewById(R.id.btnClear);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AmountActivity.this, ConfirmActivity.class);
                startActivity(intent);
            }
        });
    }
}
