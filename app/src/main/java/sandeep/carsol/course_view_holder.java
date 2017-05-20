package sandeep.carsol;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Monty on 27-04-2017.
 */

public class course_view_holder extends RecyclerView.ViewHolder {

    TextView course_name , scope , duration , university , comments ;
    public course_view_holder(View itemView) {
        super(itemView);

        course_name = (TextView) itemView.findViewById(R.id.name_id);

        scope = (TextView) itemView.findViewById(R.id.scope_id);

        duration = (TextView) itemView.findViewById(R.id.duration_id);

        university = (TextView) itemView.findViewById(R.id.uni_id);

        comments = (TextView) itemView.findViewById(R.id.comments);
    }
}
