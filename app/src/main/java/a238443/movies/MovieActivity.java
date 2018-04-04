package a238443.movies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.design.widget.TabLayout;

public class MovieActivity extends AppCompatActivity{
    TextView titleView, categoryView;
    ImageView posterView;
    Movie toDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        Toolbar movieToolbar = findViewById(R.id.movie_toolbar);
        movieToolbar.setTitle("");
        movieToolbar.setNavigationIcon(R.drawable.ic_back);

        movieToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        titleView = findViewById(R.id.title_view);
        categoryView = findViewById(R.id.category_view);
        posterView = findViewById(R.id.poster_view);

        v_displayValues();
        v_setupTabs();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        toDisplay = (Movie)savedInstanceState.getSerializable("movie");
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedInstanceState.putSerializable("movie",toDisplay);
    }

    private void v_displayValues() {
        if(toDisplay == null) {
            Intent fromMain = getIntent();
            toDisplay = (Movie)fromMain.getSerializableExtra("movie");
        }

        titleView.setText(toDisplay.getTitle());
        categoryView.setText(toDisplay.getCategory());
        posterView.setImageResource(toDisplay.getPosterID());
    }

    private void v_setupTabs() {
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Gallery"));
        tabLayout.addTab(tabLayout.newTab().setText("Actors"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);


        final ViewPager viewPager = findViewById(R.id.pager);
        final TabAdapter adapter = new TabAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        v_setupActors();
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void v_setupActors() {

    }
}
