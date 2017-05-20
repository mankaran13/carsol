package sandeep.carsol;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Monty on 27-04-2017.
 */

public class course_adapter extends RecyclerView.Adapter<course_view_holder> {


    JSONArray jarr;
    Activity a ;

    public course_adapter(JSONArray jarr , Activity a)
    {
        this.jarr = jarr;
        this.a = a;

    }


    @Override
    public course_view_holder onCreateViewHolder(ViewGroup parent, int viewType) {

        course_view_holder v = new course_view_holder(LayoutInflater.from(a).inflate(R.layout.couse_cell , parent , false));

        return v;
    }

    @Override
    public void onBindViewHolder(course_view_holder holder, int position) {

        try {
            final JSONObject jobj = jarr.getJSONObject(position);

            holder.course_name.setText(jobj.getString("name"));
            holder.scope.setText(jobj.getString("scope"));
            holder.duration.setText(jobj.getString("duration"));
            holder.university.setText(jobj.getString("uni"));

            holder.comments.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(a , Comments.class);

                    try {
                        i.putExtra("course_id" , jobj.getString("id"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    a.startActivity(i);
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return jarr.length();
    }
}
