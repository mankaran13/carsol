package sandeep.carsol;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static sandeep.carsol.R.drawable.interest;

public class Home_page extends AppCompatActivity {

    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        fm = getSupportFragmentManager();

        FragmentTransaction ft = fm.beginTransaction();
        Fragment cm = new Courses_list();

        ft.replace(R.id.frame_id ,cm);

        ft.commit();
    }

    public void opencourses(View v)
    {



        FragmentTransaction ft = fm.beginTransaction();
        Fragment cm = new Courses_list();

        ft.replace(R.id.frame_id ,cm);

        ft.commit();

    }

    public void openuni(View v)
    {
        FragmentTransaction ft = fm.beginTransaction();
        Fragment chat_frag = new Uni_list();
        ft.replace(R.id.frame_id , chat_frag);

        ft.commit();

    }


    public void go_profile(View view)
    {
        Intent i = new Intent(Home_page.this,profile.class);
        startActivity(i);

    }

    public void go_logout(View view) {

        Intent i = new Intent(Home_page.this,Login.class);
        startActivity(i);
    }

    public  void  go_feedback (View view)
    {
        Intent i = new Intent(Home_page.this,feedback.class);
        startActivity(i);
    }

    public void interest(View view) {


        Intent i=new Intent(Home_page.this,Interest.class);
        startActivity(i);
    }

    public void search_course(View view) {

        Intent i=new Intent(Home_page.this, Search_course.class);
        startActivity(i);
    }

    public void search_uni(View view) {

        Intent i=new Intent(Home_page.this, Search_uni.class);
        startActivity(i);
    }

    public void quali_course(View view) {

        Intent i=new Intent(Home_page.this,Course_by_qualification.class);
        startActivity(i);
    }
}
