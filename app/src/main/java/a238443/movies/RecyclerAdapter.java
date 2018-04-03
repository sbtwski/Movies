package a238443.movies;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MovieHolder> {
    private ArrayList<Movie> database = new ArrayList<>();
    private RecyclerViewClickListener clickListener;

    class MovieHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private RecyclerViewClickListener holderListener;
        TextView titleText, categoryText;
        ImageView poster;
        RelativeLayout viewBackground, viewForeground;

        MovieHolder(View itemView, RecyclerViewClickListener listener) {
            super(itemView);

            titleText= itemView.findViewById(R.id.list_top_text);
            categoryText = itemView.findViewById(R.id.list_bottom_text);
            poster = itemView.findViewById(R.id.list_thumbnail);
            viewBackground = itemView.findViewById(R.id.view_background);
            viewForeground = itemView.findViewById(R.id.view_foreground);
            holderListener = listener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            holderListener.onClick(view, getAdapterPosition());
        }
    }

    RecyclerAdapter(RecyclerViewClickListener listener) {
        clickListener = listener;
        database = new ArrayList<>();
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.MovieHolder movHolder, int i) {
        TextView title = movHolder.titleText;
        TextView category = movHolder.categoryText;
        ImageView poster = movHolder.poster;

        Movie toBind = database.get(i);

        title.setText(toBind.getTitle());
        category.setText(toBind.getCategory());
        poster.setImageResource(toBind.getPosterID());
    }

    @Override
    public int getItemCount() {
        return database.size();
    }


    @Override
    public RecyclerAdapter.MovieHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.list_item, parent, false);

        return new MovieHolder(view, clickListener);
    }

    void addItem(final Movie newMovie) {
        database.add(newMovie);
        notifyDataSetChanged();
    }

    Movie getItem(int position) {
        return database.get(position);
    }

    void addDatabase(ArrayList<Movie> database) {
        this.database = database;
        notifyDataSetChanged();
    }

    ArrayList<Movie> getDatabase() {
        return database;
    }

    void removeItem(int position) {
        database.remove(position);
        notifyDataSetChanged();
    }
}
