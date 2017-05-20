package sandeep.carsol;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Course_by_qualification extends AppCompatActivity {

    RecyclerView recycle ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_by_qualification);

        recycle = (RecyclerView) findViewById(R.id.recycler_id);

        recycle.setLayoutManager(new LinearLayoutManager(Course_by_qualification.this , LinearLayoutManager.VERTICAL , false));

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

        System.out.println(job);
        JsonObjectRequest jobreq = new JsonObjectRequest("http://"+Internet.ip+"/carsol/get_courses_by_qualification.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    JSONArray jarr = response.getJSONArray("result");

                    course_adapter ad = new course_adapter(jarr , Course_by_qualification.this);

                    recycle.setAdapter(ad);
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

        AppController app = new AppController(Course_by_qualification.this);

        app.addToRequestQueue(jobreq);
    }
}
