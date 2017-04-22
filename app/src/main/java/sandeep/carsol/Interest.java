package sandeep.carsol;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Interest extends AppCompatActivity {

    Boolean commerce_b = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void commerce(View view)
    {

        if(commerce_b)
        {
            TextView t = (TextView) view;

            t.setBackgroundTintList(ContextCompat.getColorStateList(Interest.this, R.color.white));

            commerce_b = false;

        }
        else {

            TextView t = (TextView) view;

            t.setBackgroundTintList(ContextCompat.getColorStateList(Interest.this, R.color.colorAccent));

            commerce_b = true;
        }

    }

    public void computer(View view)
    {

    }
}
