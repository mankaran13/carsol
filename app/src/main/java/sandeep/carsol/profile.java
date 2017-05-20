package sandeep.carsol;

import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.ContactsContract;
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

public class profile extends AppCompatActivity {

    EditText name_et,email_et,password_et,contact_et,qualification_et ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name_et = (EditText) findViewById(R.id.name_et);
        email_et = (EditText)findViewById(R.id.email_et);
        password_et = (EditText) findViewById(R.id.password_et);
        contact_et = (EditText) findViewById(R.id.contact_et);
        qualification_et = (EditText) findViewById(R.id.qualification_et);

        get_data();
    }

    public void get_data()
    {
        JSONObject job = new JSONObject();


        SharedPreferences sp = getSharedPreferences("user_info" , MODE_PRIVATE);

        try {
            job.put("user_id" ,   sp.getString("user_id" , "") );
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jobreq = new JsonObjectRequest("http://"+Internet.ip+"/get_profile.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    name_et.setText(response.getString("name"));
                    email_et.setText(response.getString("email"));
                    password_et.setText(response.getString("password"));
                    contact_et.setText(response.getString("mobile"));
                    qualification_et.setText(response.getString("qualification"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        jobreq.setRetryPolicy(new DefaultRetryPolicy(20000 , 2 ,2));

        AppController app = new AppController(profile.this);
        app.addToRequestQueue(jobreq);

    }

    public void update(View view)
    {
        String name = name_et.getText().toString();
        String email= email_et.getText().toString();
        String password = password_et.getText().toString();
        String contact = contact_et.getText().toString();
        String qualification = qualification_et.getText().toString();

        SharedPreferences sp = getSharedPreferences("user_info" , MODE_PRIVATE);

        JSONObject job = new JSONObject();

        try {
            job.put("name_key",name);
            job.put("email_key",email);
            job.put("password_key",password);
            job.put("contact_key",contact);
            job.put("qualification_key",qualification);
            job.put("user_id" ,   sp.getString("user_id" , "") );
        } catch (JSONException e) {
            e.printStackTrace();
        }




        JsonObjectRequest jobreq = new JsonObjectRequest("http://" + Internet.ip + "/user_update.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(profile.this,"update successfully", Toast.LENGTH_SHORT).show();

                Intent i=  new Intent(profile.this,Home_page.class);
                startActivity(i);

            }


        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        jobreq.setRetryPolicy(new DefaultRetryPolicy(20000,2,3));

        AppController app = new AppController(profile.this);

        app.addToRequestQueue(jobreq);


    }


    public void edit(View view)

    {

        name_et.setEnabled(true);
        email_et.setEnabled(true);
        password_et.setEnabled(true);
        contact_et.setEnabled(true);
        qualification_et.setEnabled(true);
    }
}
