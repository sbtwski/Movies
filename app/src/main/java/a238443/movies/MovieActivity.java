package a238443.movies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MovieActivity extends AppCompatActivity{
    TextView titleView, categoryView;
    ImageView posterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        Toolbar movieToolbar = findViewById(R.id.movie_toolbar);
        movieToolbar.setTitle("");
        setSupportActionBar(movieToolbar);
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
    }

    private void v_displayValues() {
        Intent fromMain = getIntent();
        Movie toDisplay = (Movie)fromMain.getSerializableExtra("movie");

        titleView.setText(toDisplay.getTitle());
        categoryView.setText(toDisplay.getCategory());
        posterView.setImageResource(toDisplay.getPosterID());
    }
}
