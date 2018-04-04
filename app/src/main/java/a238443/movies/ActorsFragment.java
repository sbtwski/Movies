package a238443.movies;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class ActorsFragment extends Fragment {
    ActorsAdapter adapter;
    ListView list;
    ArrayList<Actor> movieActors;

    @Override
    @SuppressWarnings("unchecked")
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle bundle = getArguments();
        movieActors = (ArrayList<Actor>)bundle.getSerializable("actors");
        return inflater.inflate(R.layout.actor_list_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new ActorsAdapter(getActivity());
        list = getActivity().findViewById(R.id.main_list_view);
        list.setAdapter(adapter);

        for(int i=0;i<movieActors.size();i++)
            adapter.addItem(movieActors.get(i));
    }
}
