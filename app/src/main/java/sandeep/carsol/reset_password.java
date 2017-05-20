package sandeep.carsol;

import android.content.Intent;
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

public class reset_password extends AppCompatActivity {
    EditText pswrd , cpswrd ;
    String email ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        pswrd=(EditText)findViewById(R.id.Password);

        cpswrd=(EditText)findViewById(R.id.confirm_password);

        email = getIntent().getStringExtra("email_key");
    }

    public void reset_pass(View v)

    {
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[!@#$%^&*+=?-]).{8,15}$";
        String pass = pswrd.getText().toString();
        String cpass = cpswrd.getText().toString();



        if(!pass.matches(pattern) || pass.length() < 8)
        {
            Toast.makeText(reset_password.this, "password must contain atleast one alphabet , digit , special character and length must be 8 character", Toast.LENGTH_SHORT).show();
            return;
        }



        if( ! pass.equals(cpass))
        {
            Toast.makeText(reset_password.this , "password do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        JSONObject job = new JSONObject();

        try {
            job.put("email_key", email);
            job.put("pass_key" , pass);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jobreq = new JsonObjectRequest("http://"+Internet.ip+"/reset_pass.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                try {
                    if(response.getString("response_key").equals("done"))
                    {
                        Toast.makeText(reset_password.this , "updated successfully " , Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(reset_password.this , Login.class);
                        startActivity(i);
                        finish();
                    }

                    if(response.getString("response_key").equals("not done"))
                    {
                        Toast.makeText(reset_password.this , "error try again" , Toast.LENGTH_SHORT).show();

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

        jobreq.setRetryPolicy(new DefaultRetryPolicy(20000 , 3 , 2 ));

        AppController app = new AppController(reset_password.this);

        app.addToRequestQueue(jobreq);



    }
}
