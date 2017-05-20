package sandeep.carsol;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Interest extends AppCompatActivity {

    Boolean commerce_b = false , medical_b = false,humantic_b = false,law_b= false,science_b = false,
    singing_b = false,theatre_b= false,animation_b = false,sports_b = false,
            physics_b = false,politics_b = false,design_b = false,technology_b= false,computer_b = false;
            ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest);
    }








    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void Science(View view)
    {

        if(science_b)
        {
            TextView t = (TextView) view;

            t.setBackgroundTintList(ContextCompat.getColorStateList(Interest.this, R.color.white));

            science_b = false;

        }
        else {

            TextView t = (TextView) view;

            t.setBackgroundTintList(ContextCompat.getColorStateList(Interest.this, R.color.colorAccent));

            science_b = true;
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void physics(View view)
    {

        if(physics_b)
        {
            TextView t = (TextView) view;

            t.setBackgroundTintList(ContextCompat.getColorStateList(Interest.this, R.color.white));

            physics_b = false;

        }
        else {

            TextView t = (TextView) view;

            t.setBackgroundTintList(ContextCompat.getColorStateList(Interest.this, R.color.colorAccent));

            physics_b = true;
        }

    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void humanitics (View view)
    {

        if(humantic_b)
        {
            TextView t = (TextView) view;

            t.setBackgroundTintList(ContextCompat.getColorStateList(Interest.this, R.color.white));

            humantic_b = false;

        }
        else {

            TextView t = (TextView) view;

            t.setBackgroundTintList(ContextCompat.getColorStateList(Interest.this, R.color.colorAccent));

            humantic_b = true;
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void law (View view)
    {

        if(law_b)
        {
            TextView t = (TextView) view;

            t.setBackgroundTintList(ContextCompat.getColorStateList(Interest.this, R.color.white));

            law_b = false;

        }
        else {

            TextView t = (TextView) view;

            t.setBackgroundTintList(ContextCompat.getColorStateList(Interest.this, R.color.colorAccent));

            law_b = true;
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void singing (View view)
    {

        if(singing_b)
        {
            TextView t = (TextView) view;

            t.setBackgroundTintList(ContextCompat.getColorStateList(Interest.this, R.color.white));

            singing_b = false;

        }
        else {

            TextView t = (TextView) view;

            t.setBackgroundTintList(ContextCompat.getColorStateList(Interest.this, R.color.colorAccent));

            singing_b = true;
        }

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

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void animation (View view)
    {

        if(animation_b)
        {
            TextView t = (TextView) view;

            t.setBackgroundTintList(ContextCompat.getColorStateList(Interest.this, R.color.white));

            animation_b = false;

        }
        else {

            TextView t = (TextView) view;

            t.setBackgroundTintList(ContextCompat.getColorStateList(Interest.this, R.color.colorAccent));

            animation_b = true;
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void theatre (View view)
    {

        if(theatre_b)
        {
            TextView t = (TextView) view;

            t.setBackgroundTintList(ContextCompat.getColorStateList(Interest.this, R.color.white));

            theatre_b = false;

        }
        else {

            TextView t = (TextView) view;

            t.setBackgroundTintList(ContextCompat.getColorStateList(Interest.this, R.color.colorAccent));

            theatre_b = true;
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void sports (View view)
    {

        if(sports_b)
        {
            TextView t = (TextView) view;

            t.setBackgroundTintList(ContextCompat.getColorStateList(Interest.this, R.color.white));

            sports_b = false;

        }
        else {

            TextView t = (TextView) view;

            t.setBackgroundTintList(ContextCompat.getColorStateList(Interest.this, R.color.colorAccent));

            sports_b = true;
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void politics (View view)
    {

        if(politics_b)
        {
            TextView t = (TextView) view;

            t.setBackgroundTintList(ContextCompat.getColorStateList(Interest.this, R.color.white));

            politics_b = false;

        }
        else {

            TextView t = (TextView) view;

            t.setBackgroundTintList(ContextCompat.getColorStateList(Interest.this, R.color.colorAccent));

            politics_b = true;
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void design (View view)
    {

        if(design_b)
        {
            TextView t = (TextView) view;

            t.setBackgroundTintList(ContextCompat.getColorStateList(Interest.this, R.color.white));

            design_b = false;

        }
        else {

            TextView t = (TextView) view;

            t.setBackgroundTintList(ContextCompat.getColorStateList(Interest.this, R.color.colorAccent));

            design_b = true;
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void technology (View view)
    {

        if(technology_b)
        {
            TextView t = (TextView) view;

            t.setBackgroundTintList(ContextCompat.getColorStateList(Interest.this, R.color.white));

            technology_b = false;

        }
        else {

            TextView t = (TextView) view;

            t.setBackgroundTintList(ContextCompat.getColorStateList(Interest.this, R.color.colorAccent));

            technology_b = true;
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void computer (View view)
    {

        if(computer_b)
        {
            TextView t = (TextView) view;

            t.setBackgroundTintList(ContextCompat.getColorStateList(Interest.this, R.color.white));

            computer_b = false;

        }
        else {

            TextView t = (TextView) view;

            t.setBackgroundTintList(ContextCompat.getColorStateList(Interest.this, R.color.colorAccent));

            computer_b = true;
        }

    }


















    public void open_home(View view) {

        Intent i = new Intent(Interest.this , Home_page.class);
        startActivity(i);
        finish();
    }



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void medical(View view) {

        if(medical_b)
        {
            TextView t = (TextView) view;

            t.setBackgroundTintList(ContextCompat.getColorStateList(Interest.this, R.color.white));

            medical_b = false;

        }
        else {

            TextView t = (TextView) view;

            t.setBackgroundTintList(ContextCompat.getColorStateList(Interest.this, R.color.colorAccent));

            medical_b = true;
        }
    }
}
