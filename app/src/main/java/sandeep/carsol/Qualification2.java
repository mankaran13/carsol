package sandeep.carsol;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class Qualification2 extends AppCompatActivity {


    EditText field_et;
    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qualification2);

        field_et = (EditText) findViewById(R.id.field_et);


        info = (TextView) findViewById(R.id.info_text);
        info.setText("Enter the field in which you have done your "+ getIntent().getStringExtra("key"));



    }

    public void save_qualification(View v)
    {

        String field = field_et.getText().toString();

        SharedPreferences sp = getSharedPreferences("user_info" , MODE_PRIVATE);

        String id =  sp.getString("user_id" , "" );


        JSONObject job = new JSONObject();

        try {
            job.put("qualification_k" , getIntent().getStringExtra("key")+" ( "+field+" ) ");
            job.put("id_k" , id);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println(job);

        JsonObjectRequest jobreq = new JsonObjectRequest("http://"+Internet.ip+"/carsol/save_qualification.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    if(response.getString("key").equals("done"))
                    {
                        finish();
                        Toast.makeText(Qualification2.this , "qualification added successfully" , Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Qualification2.this , Interest.class);

                        i.putExtra("key" , "Matric" );


                        startActivity(i);
                    }

                    else if(response.getString("key").equals("email exist")) {
                        Toast.makeText(Qualification2.this, "this email already exist" , Toast.LENGTH_SHORT).show();

                    }
                    else {
                        Toast.makeText(Qualification2.this , "error" , Toast.LENGTH_SHORT).show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                System.out.println(error);
            }
        });

        jobreq.setRetryPolicy(new DefaultRetryPolicy(5000 , 3 ,2));

        AppController app = new AppController(Qualification2.this);

        app.addToRequestQueue(jobreq);




    }




}
