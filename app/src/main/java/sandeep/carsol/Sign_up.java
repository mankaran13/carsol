package sandeep.carsol;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class Sign_up extends AppCompatActivity {

    EditText name_et , email_et , mobile_et , pass_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name_et  = (EditText) findViewById(R.id.name_et);
        email_et = (EditText) findViewById(R.id.email_et);
        mobile_et = (EditText) findViewById(R.id.mobil_et_et);
        pass_et = (EditText) findViewById(R.id.password_et);



    }

    public void save_data(View v)
    {
       String name_s =  name_et.getText().toString();
        String email_s = email_et.getText().toString();
        String mobile_s = mobile_et.getText().toString();

        String pass_s = pass_et.getText().toString();

        JSONObject job = new JSONObject();

        try {
            job.put("name_k" , name_s);
            job.put("email_k" , email_s);
            job.put("mobile_k" , mobile_s);
            job.put("pass_k" , pass_s);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println(job);

        JsonObjectRequest jobreq = new JsonObjectRequest("http://192.168.0.15/user_signup.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    if(response.getString("key").equals("done"))
                    {
                        finish();
                        Toast.makeText(Sign_up.this , "account created successfully" , Toast.LENGTH_SHORT).show();
                        SharedPreferences.Editor sp = getSharedPreferences("user_info" , MODE_PRIVATE).edit();

                        sp.putString("user_id" , response.getString("id") );
                        sp.commit();

                        Intent i = new Intent(Sign_up.this , Qualification.class);
                        startActivity(i);

                    }

                    else if(response.getString("key").equals("email exist")) {
                        Toast.makeText(Sign_up.this , "this email already exist" , Toast.LENGTH_SHORT).show();

                    }
                    else {
                        Toast.makeText(Sign_up.this , "error" , Toast.LENGTH_SHORT).show();

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

        AppController app = new AppController(Sign_up.this);

        app.addToRequestQueue(jobreq);




    }


}
