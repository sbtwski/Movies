package a238443.movies;

import java.io.Serializable;
import java.util.ArrayList;

class Movie implements Serializable{
    private String title;
    private String category;
    private int posterID;
    private ArrayList<Integer> photosIDs;
    private ArrayList<Actor> movieActors;

    Movie(String title, String category, int posterID, ArrayList<Integer> photosIDs, ArrayList<Actor> movieActors) {
        this.title = title;
        this.category = category;
        this.posterID = posterID;
        this.photosIDs = photosIDs;
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


    int getPosterID() { return posterID; }

    void setPosterID(int posterID) {
        this.posterID = posterID;
    }

    ArrayList<Integer> getPhotosIDs() {
        return photosIDs;
    }

    public void setPhotosIDs(ArrayList<Integer> photosIDs) {
        this.photosIDs = photosIDs;
    }


    ArrayList<Actor> getMovieActors() {
        return movieActors;
    }

    public void setMovieActors(ArrayList<Actor> movieActors) {
        this.movieActors = movieActors;
    }
}
