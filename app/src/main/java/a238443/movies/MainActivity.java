package a238443.movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener{
    RecyclerAdapter mainAdapter;
    RecyclerView recyclerView;
    RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListeners();

        recyclerView = findViewById(R.id.main_recyclerView);
        mainAdapter = new RecyclerAdapter(listener);
        recyclerView.setAdapter(mainAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT, this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);

        Toolbar mainToolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(mainToolbar);

        dataBuilding();
    }

    private void addListeners() {
        listener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent movieClicked = new Intent(getApplicationContext(), MovieActivity.class);
                movieClicked.putExtra("movie",mainAdapter.getItem(position));
                startActivity(movieClicked);
            }
        };
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putSerializable("database", mainAdapter.getDatabase());
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mainAdapter.addDatabase((ArrayList<Movie>)savedInstanceState.getSerializable("database"));
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (viewHolder instanceof RecyclerAdapter.MovieHolder) {
            mainAdapter.removeItem(viewHolder.getAdapterPosition());
        }
    }

    private void dataBuilding() {
        ArrayList<Integer> photosID = new ArrayList<>();
        ArrayList<Actor> actorsInfo = new ArrayList<>();

        // INTERSTELLAR

        photosID.add(R.drawable.interstellar_photo_1);
        photosID.add(R.drawable.interstellar_photo_2);
        photosID.add(R.drawable.interstellar_photo_3);
        photosID.add(R.drawable.interstellar_photo_4);
        photosID.add(R.drawable.interstellar_photo_5);
        photosID.add(R.drawable.interstellar_photo_6);
        photosID.add(R.drawable.interstellar_photo_7);
        photosID.add(R.drawable.interstellar_photo_8);

        actorsInfo.add(new Actor("Matthew","McConaughey",48,R.drawable.mcconaughey));

        mainAdapter.addItem(new Movie("Interstellar","Science-fiction",R.drawable.interstellar_poster,photosID,actorsInfo));
    }
}
