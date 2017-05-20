package sandeep.carsol;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Monty on 27-04-2017.
 */

public class uni_view_holder extends RecyclerView.ViewHolder {

    TextView name_id , location_id ;

    ImageView uni_image ;

    public uni_view_holder(View itemView) {
        super(itemView);

        name_id = (TextView) itemView.findViewById(R.id.name_id);

        location_id = (TextView) itemView.findViewById(R.id.location_id);

        uni_image  = (ImageView) itemView.findViewById(R.id.uni_image_id);
    }


}
