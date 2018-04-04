package a238443.movies;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ActorsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.actor_list_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ActorsAdapter adapter = new ActorsAdapter(getActivity());
        ListView list = getActivity().findViewById(R.id.main_list_view);
        list.setAdapter(adapter);

        adapter.addItem(new Actor("name","surname",35,R.drawable.ic_back));
        adapter.addItem(new Actor("name","surname",35,R.drawable.ic_back));
        adapter.addItem(new Actor("name","surname",35,R.drawable.ic_back));
        adapter.addItem(new Actor("name","surname",35,R.drawable.ic_back));
        adapter.addItem(new Actor("name","surname",35,R.drawable.ic_back));
        adapter.addItem(new Actor("name","surname",35,R.drawable.ic_back));
        adapter.addItem(new Actor("name","surname",35,R.drawable.ic_back));
        adapter.addItem(new Actor("name","surname",35,R.drawable.ic_back));
        adapter.addItem(new Actor("name","surname",35,R.drawable.ic_back));
        adapter.addItem(new Actor("name","surname",35,R.drawable.ic_back));
        adapter.addItem(new Actor("name","surname",35,R.drawable.ic_back));
        adapter.addItem(new Actor("name","surname",35,R.drawable.ic_back));
        adapter.addItem(new Actor("name","surname",35,R.drawable.ic_back));
        adapter.addItem(new Actor("name","surname",35,R.drawable.ic_back));
        adapter.addItem(new Actor("name","surname",35,R.drawable.ic_back));
    }
}
