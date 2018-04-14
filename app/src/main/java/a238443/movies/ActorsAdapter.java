package a238443.movies;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class ActorsAdapter extends BaseAdapter {
    private ArrayList<Actor> database = new ArrayList<>();
    private LayoutInflater customInflater;
    private Context appContext;

    ActorsAdapter(Context forAdapter) {
        customInflater = (LayoutInflater)forAdapter.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        appContext = forAdapter;
    }

    void addItem(final Actor newActor) {
        database.add(newActor);
        notifyDataSetChanged();
    }

    void addDatabase(ArrayList<Actor> database) {
        this.database = database;
        notifyDataSetChanged();
    }

    ArrayList<Actor> getDatabase() {
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
    public Actor getItem(int position) {
        return database.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View currentView = convertView;
        ActorHolder holder = new ActorHolder();

        if(convertView == null) {
            currentView = customInflater.inflate(R.layout.list_item,parent,false);

            holder.nameText = currentView.findViewById(R.id.list_top_text);
            holder.ageText = currentView.findViewById(R.id.list_bottom_text);
            holder.avatar = currentView.findViewById(R.id.list_thumbnail);

            currentView.setTag(holder);
        }
        else
            holder = (ActorHolder) currentView.getTag();

        Actor currentActor = database.get(position);
        String tempData = currentActor.getName() + " " + currentActor.getSurname();

        holder.nameText.setText(tempData);

        tempData = currentView.getResources().getString(R.string.age_text) + " " + currentActor.getAge();
        holder.ageText.setText(tempData);

        holder.avatar.setImageDrawable(getPhoto(currentActor.getPhotoPath()));

        return currentView;
    }

    private static class ActorHolder {
        TextView nameText;
        TextView ageText;
        ImageView avatar;
    }

    private Drawable getPhoto(String photoPath) {
        Drawable photo = appContext.getDrawable(R.drawable.ic_placeholder);
        try {
            InputStream input = appContext.getAssets().open(photoPath);
            photo = Drawable.createFromStream(input, null);
            input.close();
        } catch (IOException e) {
            Log.e("photo_error_list","Photo file not found during actors list building");
        }
        return photo;
    }
}
