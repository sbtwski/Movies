package a238443.movies;

import java.io.Serializable;

class Movie implements Serializable{
    private String title;
    private String category;
    private int posterID;

    Movie(String title, String category, int posterID) {
        this.title = title;
        this.category = category;
        this.posterID = posterID;
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
}
