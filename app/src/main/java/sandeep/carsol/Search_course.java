package sandeep.carsol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Search_course extends AppCompatActivity {

    RecyclerView recycle ;

    EditText search ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_course);

        search = (EditText) findViewById(R.id.course_et);

        recycle = (RecyclerView) findViewById(R.id.recycler_id);

        recycle.setLayoutManager(new LinearLayoutManager(Search_course.this , LinearLayoutManager.VERTICAL , false));



    }

    public void search(View view)

    {
        String course = search.getText().toString();

        JSONObject job = new JSONObject();

        try {
            job.put("course" , course);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jobreq = new JsonObjectRequest("http://"+Internet.ip+"/carsol/get_search_courses.php", job , new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    JSONArray jarr = response.getJSONArray("result");

                    course_adapter ad = new course_adapter(jarr , Search_course.this);

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

        AppController app = new AppController(Search_course.this);

        app.addToRequestQueue(jobreq);
    }
}
