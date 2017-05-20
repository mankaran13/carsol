package sandeep.carsol;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Monty on 22-04-2017.
 */

public class Courses_list extends Fragment {

    RecyclerView recycle ;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.courses_list_layout , container , false);

        recycle = (RecyclerView) v.findViewById(R.id.recycler_id);

        recycle.setLayoutManager(new LinearLayoutManager(getActivity() , LinearLayoutManager.VERTICAL , false));

        get_data();

        return v;
    }

    public void get_data()
    {


        JsonObjectRequest jobreq = new JsonObjectRequest("http://"+Internet.ip+"/get_courses.php", new JSONObject(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    JSONArray jarr = response.getJSONArray("result");

                    course_adapter ad = new course_adapter(jarr , getActivity());

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

        AppController app = new AppController(getActivity());

        app.addToRequestQueue(jobreq);
    }
}
