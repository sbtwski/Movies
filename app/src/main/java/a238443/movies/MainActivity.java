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
        // INTERSTELLAR
        ArrayList<Integer> interstellarPhotos = new ArrayList<>();
        ArrayList<Actor> interstellarActors = new ArrayList<>();
        interstellarPhotos.add(R.drawable.interstellar_photo_1);
        interstellarPhotos.add(R.drawable.interstellar_photo_2);
        interstellarPhotos.add(R.drawable.interstellar_photo_3);
        interstellarPhotos.add(R.drawable.interstellar_photo_4);
        interstellarPhotos.add(R.drawable.interstellar_photo_5);
        interstellarPhotos.add(R.drawable.interstellar_photo_6);
        interstellarPhotos.add(R.drawable.interstellar_photo_7);
        interstellarPhotos.add(R.drawable.interstellar_photo_8);
        interstellarPhotos.add(R.drawable.interstellar_photo_9);

        interstellarActors.add(new Actor("Matthew","McConaughey","4/11/1969",R.drawable.mcconaughey));
        interstellarActors.add(new Actor("Jessica","Chastain","24/3/1977",R.drawable.chastain));
        interstellarActors.add(new Actor("Anne","Hathaway","12/11/1982",R.drawable.hathaway));
        interstellarActors.add(new Actor("David","Oyelowo","1/4/1976",R.drawable.oyelowo));
        interstellarActors.add(new Actor("Michael","Caine","14/3/1933",R.drawable.caine));
        interstellarActors.add(new Actor("Casey","Affleck","12/8/1975",R.drawable.affleck));

        mainAdapter.addItem(new Movie("Interstellar","Science Fiction",R.drawable.interstellar_poster,interstellarPhotos,interstellarActors));

        // BLADE RUNNER 2049
        ArrayList<Integer> bladeRunnerPhotos = new ArrayList<>();
        ArrayList<Actor> bladeRunnerActors = new ArrayList<>();
        bladeRunnerPhotos.add(R.drawable.bladerunner_photo_1);
        bladeRunnerPhotos.add(R.drawable.bladerunner_photo_2);
        bladeRunnerPhotos.add(R.drawable.bladerunner_photo_3);
        bladeRunnerPhotos.add(R.drawable.bladerunner_photo_4);
        bladeRunnerPhotos.add(R.drawable.bladerunner_photo_5);
        bladeRunnerPhotos.add(R.drawable.bladerunner_photo_6);
        bladeRunnerPhotos.add(R.drawable.bladerunner_photo_7);
        bladeRunnerPhotos.add(R.drawable.bladerunner_photo_8);
        bladeRunnerPhotos.add(R.drawable.bladerunner_photo_9);
        bladeRunnerPhotos.add(R.drawable.bladerunner_photo_10);

        bladeRunnerActors.add(new Actor("Ryan","Gosling","12/11/1980",R.drawable.gosling));
        bladeRunnerActors.add(new Actor("Ana","De Armas","30/4/1988",R.drawable.dearmas));
        bladeRunnerActors.add(new Actor("Robin","Wright","8/4/1966",R.drawable.wright));
        bladeRunnerActors.add(new Actor("Jared","Leto","26/12/1971",R.drawable.leto));
        bladeRunnerActors.add(new Actor("Harrison","Ford","13/7/1942",R.drawable.ford));

        mainAdapter.addItem(new Movie("Blade Runner 2049","Science Fiction",R.drawable.bladerunner_poster,bladeRunnerPhotos,bladeRunnerActors));

        // ANNIHILATION
        ArrayList<Integer> annihilationPhotos = new ArrayList<>();
        ArrayList<Actor> annihilationActors = new ArrayList<>();
        annihilationPhotos.add(R.drawable.annihilation_photo_1);
        annihilationPhotos.add(R.drawable.annihilation_photo_2);
        annihilationPhotos.add(R.drawable.annihilation_photo_3);
        annihilationPhotos.add(R.drawable.annihilation_photo_4);
        annihilationPhotos.add(R.drawable.annihilation_photo_5);
        annihilationPhotos.add(R.drawable.annihilation_photo_6);
        annihilationPhotos.add(R.drawable.annihilation_photo_7);

        annihilationActors.add(new Actor("Natalie","Portman","9/6/1981",R.drawable.portman));
        annihilationActors.add(new Actor("Jennifer","Jason Leigh","5/2/1962",R.drawable.leigh));
        annihilationActors.add(new Actor("Gina","Rodriguez","30/7/1984",R.drawable.rodriguez));
        annihilationActors.add(new Actor("Tessa","Thompson","3/10/1983",R.drawable.thompson));
        annihilationActors.add(new Actor("Tuva","Novotny","21/12/1979",R.drawable.novotny));
        annihilationActors.add(new Actor("Benedict","Wong","3/6/1971",R.drawable.wong));
        annihilationActors.add(new Actor("Oscar","Isaac","9/3/1979",R.drawable.isaac));

        mainAdapter.addItem(new Movie("Annihilation","Thriller",R.drawable.annihilation_poster,annihilationPhotos,annihilationActors));

        // SPOTLIGHT
        ArrayList<Integer> spotlightPhotos = new ArrayList<>();
        ArrayList<Actor> spotlightActors = new ArrayList<>();
        spotlightPhotos.add(R.drawable.spotlight_photo_1);
        spotlightPhotos.add(R.drawable.spotlight_photo_2);
        spotlightPhotos.add(R.drawable.spotlight_photo_3);
        spotlightPhotos.add(R.drawable.spotlight_photo_4);
        spotlightPhotos.add(R.drawable.spotlight_photo_5);
        spotlightPhotos.add(R.drawable.spotlight_photo_6);

        spotlightActors.add(new Actor("Mark","Ruffalo","22/11/1967",R.drawable.ruffalo));
        spotlightActors.add(new Actor("Michael","Keaton","5/9/1951",R.drawable.keaton));
        spotlightActors.add(new Actor("Rachel","McAdams","17/11/1978",R.drawable.mcadams));
        spotlightActors.add(new Actor("Brian","d'Arcy James","29/6/1968",R.drawable.darcy));
        spotlightActors.add(new Actor("Stanley","Tucci","11/11/1960",R.drawable.tucci));
        spotlightActors.add(new Actor("John","Slattery","13/8/1962",R.drawable.slattery));

        mainAdapter.addItem(new Movie("Spotlight","Drama",R.drawable.spotlight_poster,spotlightPhotos,spotlightActors));

        // WIND RIVER
        ArrayList<Integer> windRiverPhotos = new ArrayList<>();
        ArrayList<Actor> windRiverActors = new ArrayList<>();
        windRiverPhotos.add(R.drawable.windriver_photo_1);
        windRiverPhotos.add(R.drawable.windriver_photo_2);
        windRiverPhotos.add(R.drawable.windriver_photo_3);
        windRiverPhotos.add(R.drawable.windriver_photo_4);
        windRiverPhotos.add(R.drawable.windriver_photo_5);

        windRiverActors.add(new Actor("Jeremy","Renner","7/1/1971",R.drawable.renner));
        windRiverActors.add(new Actor("Elizabeth","Olsen","16/2/1989",R.drawable.olsen));
        windRiverActors.add(new Actor("Graham","Greene","22/6/1952",R.drawable.greene));
        windRiverActors.add(new Actor("Gil","Birmingham","13/7/1953",R.drawable.birmingham));
        windRiverActors.add(new Actor("Kelsey","Asbille","9/9/1991",R.drawable.asbille));

        mainAdapter.addItem(new Movie("Wind River","Crime",R.drawable.windriver_poster,windRiverPhotos,windRiverActors));

        // EX MACHINA
        ArrayList<Integer> exMachinaPhotos = new ArrayList<>();
        ArrayList<Actor> exMachinaActors = new ArrayList<>();
        exMachinaPhotos.add(R.drawable.exmachina_photo_1);
        exMachinaPhotos.add(R.drawable.exmachina_photo_2);
        exMachinaPhotos.add(R.drawable.exmachina_photo_3);
        exMachinaPhotos.add(R.drawable.exmachina_photo_4);
        exMachinaPhotos.add(R.drawable.exmachina_photo_5);
        exMachinaPhotos.add(R.drawable.exmachina_photo_6);
        exMachinaPhotos.add(R.drawable.exmachina_photo_7);

        exMachinaActors.add(new Actor("Domhnall","Gleeson","12/5/1983",R.drawable.gleeson));
        exMachinaActors.add(new Actor("Alicia","Vikander","3/10/1988",R.drawable.vikander));
        exMachinaActors.add(new Actor("Oscar","Isaac","9/3/1979",R.drawable.isaac_ex));
        exMachinaActors.add(new Actor("Sonoya","Mizuno","1/7/1988",R.drawable.mizuno));

        mainAdapter.addItem(new Movie("Ex Machina","Science Fiction",R.drawable.exmachina_poster,exMachinaPhotos,exMachinaActors));

        // LIFE
        ArrayList<Integer> lifePhotos = new ArrayList<>();
        ArrayList<Actor> lifeActors = new ArrayList<>();
        lifePhotos.add(R.drawable.life_photo_1);
        lifePhotos.add(R.drawable.life_photo_2);
        lifePhotos.add(R.drawable.life_photo_3);
        lifePhotos.add(R.drawable.life_photo_4);
        lifePhotos.add(R.drawable.life_photo_5);
        lifePhotos.add(R.drawable.life_photo_6);

        lifeActors.add(new Actor("Jake","Gyllenhaal","19/12/1980",R.drawable.gyllenhaal));
        lifeActors.add(new Actor("Ryan","Reynolds","23/10/1976",R.drawable.reynolds));
        lifeActors.add(new Actor("Rebecca","Ferguson","19/10/1983",R.drawable.ferguson));
        lifeActors.add(new Actor("Ariyon","Bakare","1/7/1971",R.drawable.bakare));
        lifeActors.add(new Actor("Hiroyuki","Sanada","12/10/1960",R.drawable.sanada));
        lifeActors.add(new Actor("Olga","Dykhovichnaya","4/9/1980",R.drawable.dykhovichnaya));

        mainAdapter.addItem(new Movie("Life","Horror",R.drawable.life_poster,lifePhotos,lifeActors));
    }
}
