package a238443.movies;

import java.io.Serializable;

class Actor implements Serializable{
    private String name;
    private String surname;
    private int age;
    private int photoID;

    Actor(String name, String surname, int age, int photoID) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.photoID = photoID;

    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }

    String getSurname() {
        return surname;
    }

    void setSurname(String surname) {
        this.surname = surname;
    }

    String getName() {

        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getPhotoID() {
        return photoID;
    }

    void setPhotoID(int photoID) {
        this.photoID = photoID;
    }

}
