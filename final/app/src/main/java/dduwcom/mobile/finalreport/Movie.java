package dduwcom.mobile.finalreport;

import java.io.Serializable;

public class Movie implements Serializable{
     long _id;
     String title;
     String director;
     String actor;
     String date;
     String story;
     float grade;

    public Movie(String title, String director, String actor, String date, String story, float grade) {
        this.title = title;
        this.director = director;
        this.actor = actor;
        this.date = date;
        this.story = story;
        this.grade = grade;
    }

    public Movie(long _id, String title, String director, String actor, String date, String story, float grade) {
        this._id = _id;
        this.title = title;
        this.director = director;
        this.actor = actor;
        this.date = date;
        this.story = story;
        this.grade = grade;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor(){
        return actor;
    }

    public void setActor(String actor){
        this.actor = actor;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }
    public float getGrade(){
        return grade;
    }
    public void setGrade(float grade){
        this.grade = grade;
    }

}
