package sandeep.carsol;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Monty on 27-04-2017.
 */

public class uni_adapter extends RecyclerView.Adapter<uni_view_holder> {


    JSONArray jarr;
    Activity a ;

    public uni_adapter(JSONArray jarr , Activity a)
    {
        this.jarr = jarr ;

        this.a = a;

    }
    @Override
    public uni_view_holder onCreateViewHolder(ViewGroup parent, int viewType) {
        uni_view_holder v = new uni_view_holder(LayoutInflater.from(a).inflate(R.layout.uni_cell , parent , false));

        return v;
    }

    @Override
    public void onBindViewHolder(uni_view_holder holder, int position) {

        try {
            final JSONObject jobj = jarr.getJSONObject(position);

            holder.name_id.setText(jobj.getString("name"));

            holder.uni_image.setImageBitmap(StringToBitMap(jobj.getString("image")));

            holder.uni_image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(a , uni_web.class);

                    try {
                        i.putExtra("uni_link",jobj.getString("hyper_link"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    a.startActivity(i);
                }
            });

            holder.location_id.setText(jobj.getString("location"));



        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return jarr.length();
    }

    public Bitmap StringToBitMap(String encodedString){
        try {
            byte [] encodeByte=Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap= BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch(Exception e) {
            e.getMessage();
            return null;
        }
    }
}
