package a238443.movies;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class GalleryAdapter extends BaseAdapter{
    private ArrayList<String> database = new ArrayList<>();
    private LayoutInflater customInflater;
    private Context appContext;

    GalleryAdapter(Context forAdapter) {
        customInflater = (LayoutInflater)forAdapter.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        appContext = forAdapter;
    }

    void addItem(final String newPhotoPath) {
        database.add(newPhotoPath);
        notifyDataSetChanged();
    }

    void addDatabase(ArrayList<String> database) {
        this.database = database;
        notifyDataSetChanged();
    }

    ArrayList<String> getDatabase() {
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
    public String getItem(int position) {
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


        String currentPhotoPath = database.get(position);

        holder.photo.setImageDrawable(getPhoto(currentPhotoPath));

        return currentView;
    }

    private static class ImageHolder {
        ImageView photo;
    }

    private Drawable getPhoto(String photoPath) {
        Drawable photo = appContext.getDrawable(R.drawable.ic_placeholder);
        try {
            InputStream input = appContext.getAssets().open(photoPath);
            photo = Drawable.createFromStream(input, null);
            input.close();
        } catch (IOException e) {
            Log.e("photo_error_grid","Photo file not found during gallery building");
        }
        return photo;
    }
}
