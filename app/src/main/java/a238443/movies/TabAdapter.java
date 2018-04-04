package a238443.movies;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class TabAdapter extends FragmentStatePagerAdapter {
    private int numOfTabs;
    private ArrayList<Integer> forGallery;
    private ArrayList<Actor> forList;

    TabAdapter(FragmentManager manager, int numOfTabs, ArrayList<Integer> forGallery, ArrayList<Actor> forList) {
        super(manager);
        this.numOfTabs = numOfTabs;
        this.forGallery = forGallery;
        this.forList = forList;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                GalleryFragment gallery = new GalleryFragment();
                Bundle photoBundle = new Bundle();
                photoBundle.putIntegerArrayList("photos",forGallery);
                gallery.setArguments(photoBundle);
                return gallery;
            case 1:
                ActorsFragment actors = new ActorsFragment();
                Bundle actorBundle = new Bundle();
                actorBundle.putSerializable("actors",forList);
                actors.setArguments(actorBundle);
                return actors;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
