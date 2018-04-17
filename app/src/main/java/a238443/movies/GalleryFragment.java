package a238443.movies;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {
    GalleryAdapter adapter;
    GridView grid;
    ArrayList<String> moviePhotos;

    @Override
    @SuppressWarnings("unchecked")
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        Bundle bundle = getArguments();
        moviePhotos = (ArrayList<String>)bundle.getSerializable("photos");
        return inflater.inflate(R.layout.gallery_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new GalleryAdapter(getActivity());
        grid = getActivity().findViewById(R.id.gallery_grid);
        grid.setAdapter(adapter);

        adapter.addDatabase(moviePhotos);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent photoClicked = new Intent(getContext(), PhotoActivity.class);
                photoClicked.putExtra("photoPath",moviePhotos.get(position));
                startActivity(photoClicked);
            }
        });
    }
}
