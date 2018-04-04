package a238443.movies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class GalleryAdapter extends BaseAdapter{
    private ArrayList<Integer> database = new ArrayList<>();
    private LayoutInflater customInflater;

    GalleryAdapter(Context forAdapter) {
        customInflater = (LayoutInflater)forAdapter.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    void addItem(final Integer newID) {
        database.add(newID);
        notifyDataSetChanged();
    }

    void addDatabase(ArrayList<Integer> database) {
        this.database = database;
        notifyDataSetChanged();
    }

    ArrayList<Integer> getDatabase() {
        return database;
    }

    private void removeItem(int position) {
        database.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return database.size();
    }

    @Override
    public Integer getItem(int position) {
        return database.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View currentView = convertView;
        ImageHolder holder = new ImageHolder();

        if(convertView == null) {
            currentView = customInflater.inflate(R.layout.gallery_item,parent,false);
            holder.photo = currentView.findViewById(R.id.photo_view);
            currentView.setTag(holder);
        }
        else
            holder = (ImageHolder) currentView.getTag();

        int currentID = database.get(position);

        holder.photo.setImageResource(currentID);

        return currentView;
    }

    private static class ImageHolder {
        ImageView photo;
    }
}
