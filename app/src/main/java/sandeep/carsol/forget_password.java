package sandeep.carsol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class forget_password extends AppCompatActivity {

    EditText email ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        email = (EditText) findViewById(R.id.Edit_text);

    }

    public void verify(View view) {

        if(!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches() )
        {
            Toast.makeText(forget_password.this , "enter valid email",Toast.LENGTH_SHORT).show();
            return;
        }
        JSONObject job = new JSONObject();

        try {
            job.put("email", email.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jobreq = new JsonObjectRequest("http://"+Internet.ip+"/email_verify.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    if(response.getString("key").equals("1"))
                    {
                        int randomPin = (int) (((Math.random())*9000)+1000);

                        Intent i = new Intent(forget_password.this , otp.class);

                        i.putExtra("email_key",email.getText().toString());
                        i.putExtra("randompin_key",String.valueOf(randomPin));

                        startActivity(i);
                        finish();
                    }
                    else {

                        Toast.makeText(forget_password.this, "email not exist", Toast.LENGTH_SHORT).show();

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


        jobreq.setRetryPolicy(new DefaultRetryPolicy(20000 , 2, 2));

        AppController app = new AppController(forget_password.this);
        app.addToRequestQueue(jobreq);
    }

}
