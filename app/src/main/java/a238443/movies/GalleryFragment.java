package a238443.movies;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class GalleryFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.gallery_layout, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        GalleryAdapter adapter = new GalleryAdapter(getActivity());
        GridView grid = getActivity().findViewById(R.id.gallery_grid);
        grid.setAdapter(adapter);

        adapter.addItem(R.drawable.ic_delete);
        adapter.addItem(R.drawable.ic_delete);
        adapter.addItem(R.drawable.ic_delete);
        adapter.addItem(R.drawable.ic_delete);
        adapter.addItem(R.drawable.ic_delete);
        adapter.addItem(R.drawable.ic_delete);
        adapter.addItem(R.drawable.ic_delete);
        adapter.addItem(R.drawable.ic_delete);
        adapter.addItem(R.drawable.ic_delete);
        adapter.addItem(R.drawable.ic_delete);
        adapter.addItem(R.drawable.ic_delete);
        adapter.addItem(R.drawable.ic_delete);
        adapter.addItem(R.drawable.ic_delete);
        adapter.addItem(R.drawable.ic_delete);
        adapter.addItem(R.drawable.ic_delete);
        adapter.addItem(R.drawable.ic_delete);
    }
}
