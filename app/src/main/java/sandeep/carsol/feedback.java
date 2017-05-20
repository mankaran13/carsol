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

public class feedback extends AppCompatActivity {

    EditText fed_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        fed_btn = (EditText) findViewById(R.id.fed_edit);

    }

    public  void send_feed(View v)
    {
      final String feedback = fed_btn.getText().toString();

        JSONObject job = new JSONObject();

        SharedPreferences sp = getSharedPreferences("user_info" , MODE_PRIVATE);

        try {
            job.put("user_id" ,   sp.getString("user_id" , "") );
        } catch (JSONException e) {
            e.printStackTrace();
        }
       try
       {
           job.put("feedback_key",feedback);

       }
       catch ( Exception e)
       {
           e.printStackTrace();
       }

        JsonObjectRequest jobreq = new JsonObjectRequest("http://" + Internet.ip + "/carsol/feedback.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response)
            {

                Toast.makeText(feedback.this , "sent successfully" , Toast.LENGTH_SHORT).show();

                Intent i = new Intent(feedback.this,Home_page.class);
                startActivity(i);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        jobreq.setRetryPolicy(new DefaultRetryPolicy(5000 , 3 ,2));

        AppController app = new AppController(feedback.this);

        app.addToRequestQueue(jobreq);

    }
}
