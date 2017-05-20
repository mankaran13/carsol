package sandeep.carsol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

public class otp extends AppCompatActivity {

    EditText otp1, otp2, otp3, otp4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        Toast.makeText(otp.this, getIntent().getStringExtra("randompin_key"), Toast.LENGTH_LONG).show();


        otp1 = (EditText) findViewById(R.id.otp_1);
        otp2 = (EditText) findViewById(R.id.otp_2);
        otp3 = (EditText) findViewById(R.id.otp_3);
        otp4 = (EditText) findViewById(R.id.otp_4);

        otp1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() == 1) {
                    otp1.clearFocus();
                    otp2.requestFocus();
                    otp2.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        otp2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() == 1) {
                    otp2.clearFocus();
                    otp3.requestFocus();
                    otp3.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        otp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s.length() == 1) {
                    otp3.clearFocus();
                    otp4.requestFocus();
                    otp4.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        otp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                if (s.length() == 1) {

                    Intent i = new Intent(otp.this , reset_password.class);
                    i.putExtra("email_key" , getIntent().getStringExtra("email_key"));

                    startActivity(i);
                    finish();
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

}
