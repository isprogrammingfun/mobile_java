package ddwucom.mobile.finalreport;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class MovieDBManager {
    MovieDBHelper movieDBHelper = null;
    Cursor cursor = null;

    public MovieDBManager(Context context) {
        movieDBHelper = new MovieDBHelper(context);
    }

    public ArrayList<Movie> getAllMovie() {
        ArrayList movieList = new ArrayList();
        SQLiteDatabase db = movieDBHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + MovieDBHelper.TABLE_NAME, null);

        while(cursor.moveToNext()) {
            long id = cursor.getInt(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_ID));
            int poster = cursor.getInt(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_POSTER));
            String title = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_TITLE));
            String director = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_DIRECTOR));
            String actor = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_ACTOR));
            String date = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_DATE));
            String story = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_STORY));
            float rate = cursor.getFloat(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_RATE));

            movieList.add(new Movie(id, poster, title, director, actor, date, story, rate));
        }

        cursor.close();
        movieDBHelper.close();
        return movieList;
    }

    public boolean addNewMovie(Movie newMovie) {
        SQLiteDatabase db = movieDBHelper.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(MovieDBHelper.COL_POSTER, newMovie.getPoster());
        value.put(MovieDBHelper.COL_TITLE, newMovie.getTitle());
        value.put(MovieDBHelper.COL_DIRECTOR, newMovie.getDirector());
        value.put(MovieDBHelper.COL_ACTOR, newMovie.getActor());
        value.put(MovieDBHelper.COL_DATE, newMovie.getDate());
        value.put(MovieDBHelper.COL_STORY, newMovie.getStory());
        value.put(MovieDBHelper.COL_RATE, newMovie.getRating());


        long count = db.insert(MovieDBHelper.TABLE_NAME, null, value);
        movieDBHelper.close();
        if (count > 0) return true;
        return false;
    }


    public boolean modifyMovie(Movie movie) {
        SQLiteDatabase db = movieDBHelper.getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put(MovieDBHelper.COL_POSTER, movie.getPoster());
        row.put(MovieDBHelper.COL_TITLE, movie.getTitle());
        row.put(MovieDBHelper.COL_DIRECTOR, movie.getDirector());
        row.put(MovieDBHelper.COL_ACTOR, movie.getActor());
        row.put(MovieDBHelper.COL_DATE, movie.getDate());
        row.put(MovieDBHelper.COL_STORY, movie.getStory());
        row.put(MovieDBHelper.COL_RATE, movie.getRating());
        String whereClause = MovieDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(movie.get_id()) };
        int result = db.update(MovieDBHelper.TABLE_NAME, row, whereClause, whereArgs);
        movieDBHelper.close();
        if (result > 0) return true;
        return false;
    }


    public boolean removeMovie(long id) {
        SQLiteDatabase db = movieDBHelper.getWritableDatabase();
        String whereClause = MovieDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(id) };
        int result = db.delete(MovieDBHelper.TABLE_NAME, whereClause,whereArgs);
        movieDBHelper.close();
        if (result > 0) return true;
        return false;
    }

    public ArrayList<Movie> getMovieByName(String movieName) {
        ArrayList movieList = new ArrayList();
        SQLiteDatabase db = movieDBHelper.getReadableDatabase();
        String[] columns = null;
        String whereClause = movieDBHelper.COL_TITLE + "=?";
        String[] whereArgs = new String[] {movieName};
        Cursor cursor = db.query(movieDBHelper.TABLE_NAME, columns, whereClause, whereArgs, null, null, null, null);
        while(cursor.moveToNext()) {
            long id = cursor.getInt(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_ID));
            int poster = cursor.getInt(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_POSTER));
            String title = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_TITLE));
            String director = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_DIRECTOR));
            String actor = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_ACTOR));
            String date = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_DATE));
            String story = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_STORY));
            float rate = cursor.getFloat(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_RATE));
            movieList.add(new Movie(id, poster, title, director, actor, date, story, rate));
        }
        cursor.close();
        movieDBHelper.close();
        return movieList;

    }
    public ArrayList<Movie> getMovieByTitle(String title) {

        return null;
    }


    public void close() {
        if (movieDBHelper != null) movieDBHelper.close();
        if (cursor != null) cursor.close();
    };

}
