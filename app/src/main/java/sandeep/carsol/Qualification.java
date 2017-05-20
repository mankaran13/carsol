package sandeep.carsol;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class Qualification extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qualification);
    }


    public void matric(View v)
    {
       save_qualification();
    }

    public void highschool(View v)
    {
        Intent i = new Intent(Qualification.this , Qualification2.class);

        i.putExtra("key" , "High School" );

        startActivity(i);
    }

    public void save_qualification()
    {


        SharedPreferences sp = getSharedPreferences("user_info" , MODE_PRIVATE);

        String id =  sp.getString("user_id" , "" );


        JSONObject job = new JSONObject();

        try {
            job.put("qualification_k" , "matric");
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
                        Toast.makeText(Qualification.this , "qualification added successfully" , Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Qualification.this , Interest.class);

                        i.putExtra("key" , "Matric" );


                        startActivity(i);
                    }

                    else if(response.getString("key").equals("email exist")) {
                        Toast.makeText(Qualification.this, "this email already exist" , Toast.LENGTH_SHORT).show();

                    }
                    else {
                        Toast.makeText(Qualification.this , "error" , Toast.LENGTH_SHORT).show();

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

        AppController app = new AppController(Qualification.this);

        app.addToRequestQueue(jobreq);




    }

    public void doctrate(View view) {
        Intent i = new Intent(Qualification.this , Qualification2.class);

        i.putExtra("key" , "Doctrate" );

        startActivity(i);
    }

    public void postgraduation(View view) {
        Intent i = new Intent(Qualification.this , Qualification2.class);

        i.putExtra("key" , "Post Graduation" );

        startActivity(i);
    }

    public void graduation(View view) {
        Intent i = new Intent(Qualification.this , Qualification2.class);

        i.putExtra("key" , "Graduation" );

        startActivity(i);
    }
}
