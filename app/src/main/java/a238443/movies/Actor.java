package a238443.movies;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

class Actor implements Serializable{
    private String name;
    private String surname;
    private int age;
    private String photoPath;

    Actor(String name, String surname, String birthDate, String photoPath) {
        this.name = name;
        this.surname = surname;
        ageCount(birthDate);
        this.photoPath = photoPath;

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

    String getPhotoPath() {
        return photoPath;
    }

    void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    private void ageCount(String birthDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date dt_temp = new Date();
        boolean correctDate = true;
        formatter.setLenient(false);

        try {
            dt_temp = formatter.parse(birthDate);
        } catch(ParseException e) {
            correctDate = false;
        }

        if(correctDate) {
            Calendar cal_forInput = Calendar.getInstance();
            Calendar cal_forCurrent = Calendar.getInstance();
            cal_forInput.setTime(dt_temp);
            cal_forCurrent.getTime();

            int i_yearDifference = cal_forCurrent.get(Calendar.YEAR) - cal_forInput.get(Calendar.YEAR);
            int i_monthDifference = cal_forCurrent.get(Calendar.MONTH) - cal_forInput.get(Calendar.MONTH);
            int i_dayDifference = cal_forCurrent.get(Calendar.DAY_OF_MONTH) - cal_forInput.get(Calendar.DAY_OF_MONTH);
            age = i_yearDifference;

            if (i_monthDifference < 0)
                age--;
            else {
                if (i_monthDifference == 0) {
                    if (i_dayDifference < 0)
                        age--;
                }
            }
        }
    }

}
