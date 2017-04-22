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

public class Login extends AppCompatActivity {

    EditText  email_et  , pass_et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email_et = (EditText) findViewById(R.id.email_et);

        pass_et = (EditText) findViewById(R.id.password_et);

    }


    public void verify_data(View v)
    {

        String email_s = email_et.getText().toString();


        String pass_s = pass_et.getText().toString();

        JSONObject job = new JSONObject();

        try {

            job.put("email_k" , email_s);

            job.put("pass_k" , pass_s);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println(job);

        JsonObjectRequest jobreq = new JsonObjectRequest("http://192.168.0.15/user_signin.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    if(response.getString("key").equals("done"))
                    {

                        SharedPreferences.Editor sp = getSharedPreferences("user_info" , MODE_PRIVATE).edit();

                        sp.putString("user_id" , response.getString("id") );
                        sp.commit();


                        Toast.makeText(Login.this , "logged in  successfully" , Toast.LENGTH_SHORT).show();

                    }

                    else if(response.getString("key").equals("not done")) {
                        Toast.makeText(Login.this , "invalid credentials" , Toast.LENGTH_SHORT).show();

                    }
                    else {
                        Toast.makeText(Login.this , "error" , Toast.LENGTH_SHORT).show();

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

        AppController app = new AppController(Login.this);

        app.addToRequestQueue(jobreq);


    }


    public void gotosignup(View v)
    {
        Intent i = new Intent(Login.this , Sign_up.class);

        startActivity(i);
    }
}