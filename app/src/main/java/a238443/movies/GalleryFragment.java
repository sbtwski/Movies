package a238443.movies;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {
    GalleryAdapter adapter;
    GridView grid;
    ArrayList<Integer> moviePhotos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Bundle bundle = getArguments();
        moviePhotos = bundle.getIntegerArrayList("photos");
        return inflater.inflate(R.layout.gallery_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new GalleryAdapter(getActivity());
        grid = getActivity().findViewById(R.id.gallery_grid);
        grid.setAdapter(adapter);

        for(int i=0;i<moviePhotos.size();i++)
            adapter.addItem(moviePhotos.get(i));
    }
}
