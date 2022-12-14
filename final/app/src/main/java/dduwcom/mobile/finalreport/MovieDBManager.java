package dduwcom.mobile.finalreport;

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
            String title = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_TITLE));
            String director = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_DIRECTOR));
            String actor = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_ACTOR));
            String date = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_DATE));
            String story = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_STORY));
            String str_grade = cursor.getString(cursor.getColumnIndexOrThrow(MovieDBHelper.COL_GRADE));
            float grade = Float.parseFloat(str_grade);

            movieList.add(new Movie(id, title, director, actor, date, story, grade));
        }

        cursor.close();
        movieDBHelper.close();
        return movieList;
    }

    public boolean addNewMovie(Movie newMovie) {
        SQLiteDatabase db = movieDBHelper.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(MovieDBHelper.COL_TITLE, newMovie.getTitle());
        value.put(MovieDBHelper.COL_DIRECTOR, newMovie.getDirector());
        value.put(MovieDBHelper.COL_ACTOR, newMovie.getActor());
        value.put(MovieDBHelper.COL_DATE, newMovie.getDate());
        value.put(MovieDBHelper.COL_GRADE, newMovie.getGrade());

//      insert ???????????? ????????? ?????? ????????? ????????? ??????????????? ???????????? ?????? 1 ??????, ????????? ?????? ?????? 0 ?????? ?????? ??????
        long count = db.insert(MovieDBHelper.TABLE_NAME, null, value);
        movieDBHelper.close();
        if (count > 0) return true;
        return false;
    }

    //    _id ??? ???????????? food ??? ????????? nation ??????
    public boolean modifyMovie(Movie movie) {
        SQLiteDatabase sqLiteDatabase = movieDBHelper.getWritableDatabase();
        ContentValues row = new ContentValues();
        row.put(MovieDBHelper.COL_TITLE, movie.getTitle());
        row.put(MovieDBHelper.COL_DIRECTOR, movie.getDirector());
        row.put(MovieDBHelper.COL_ACTOR, movie.getDirector());
        row.put(MovieDBHelper.COL_DATE, movie.getDate());
        row.put(MovieDBHelper.COL_GRADE, movie.getGrade());
        String whereClause = MovieDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(movie.get_id()) };
        int result = sqLiteDatabase.update(MovieDBHelper.TABLE_NAME, row, whereClause, whereArgs);
        movieDBHelper.close();
        if (result > 0) return true;
        return false;
    }


    public boolean removeMovie(long id) {
        SQLiteDatabase sqLiteDatabase = movieDBHelper.getWritableDatabase();
        String whereClause = MovieDBHelper.COL_ID + "=?";
        String[] whereArgs = new String[] { String.valueOf(id) };
        int result = sqLiteDatabase.delete(MovieDBHelper.TABLE_NAME, whereClause,whereArgs);
        movieDBHelper.close();
        if (result > 0) return true;
        return false;
    }

    //    ?????? ???????????? DB ??????
    public ArrayList<Movie> getFoodsByNation(String nation) {

        return null;
    }

    //    ?????? ???????????? DB ??????
    public ArrayList<Movie> getFoodByName(String foodName) {
        return null;
    }

    //    id ??? DB ??????
    public Movie getFoodById(long id) {

        return  null;
    }

    //    close ??????
    public void close() {
        if (movieDBHelper != null) movieDBHelper.close();
        if (cursor != null) cursor.close();
    };

}
