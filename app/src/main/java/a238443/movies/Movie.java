package a238443.movies;

import java.io.Serializable;
import java.util.ArrayList;

class Movie implements Serializable{
    private String title;
    private String category;
    private String posterPath;
    private ArrayList<String> photosPaths;
    private ArrayList<Actor> movieActors;

    Movie(String title, String category, String posterPath, ArrayList<String> photosPaths, ArrayList<Actor> movieActors) {
        this.title = title;
        this.category = category;
        this.posterPath = posterPath;
        this.photosPaths = photosPaths;
        this.movieActors = movieActors;
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getCategory() {
        return category;
    }

    void setCategory(String category) {
        this.category = category;
    }

    String getPosterPath() { return posterPath; }

    void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    ArrayList<String> getPhotosPaths() {
        return photosPaths;
    }

    public void setPhotosPaths(ArrayList<String> photosPaths) {
        this.photosPaths = photosPaths;
    }

    ArrayList<Actor> getMovieActors() {
        return movieActors;
    }

    public void setMovieActors(ArrayList<Actor> movieActors) {
        this.movieActors = movieActors;
    }

}
