package ddwucom.mobile.finalreport;

import java.io.Serializable;

public class Movie implements Serializable{
    long _id;
    int poster;
    String title;
    String director;
    String actor;
    String date;
    String story;
    float rate;

    public Movie(String title, String director, String actor, String date, String story, float rate) {
        this.title = title;
        this.director = director;
        this.actor = actor;
        this.date = date;
        this.story = story;
        this.rate = rate;
    }

    public Movie(long _id, int poster, String title, String director, String actor, String date, String story, float rate) {
        this._id = _id;
        this.poster = poster;
        this.title = title;
        this.director = director;
        this.actor = actor;
        this.date = date;
        this.story = story;
        this.rate = rate;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public int getPoster(){return poster; }

    public void setPoster(int poster){this.poster = poster;}

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

    public String getStory()
    {
        return story;
    }
    public void setStory(String story){this.story = story;}

    public float getRating(){
        return rate;
    }
    public void setRating(float grade){
        this.rate = grade;
    }

}
