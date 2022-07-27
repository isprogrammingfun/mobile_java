package dduwcom.mobile.finalreport;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MovieDBHelper extends SQLiteOpenHelper {

    final static String TAG = "MovieDBHelper";

    final static String DB_NAME = "movie.db";

    public final static String TABLE_NAME = "movie_table";
    public final static String COL_ID = "_id";
    //public final static String COL_POSTER = "";
    public final static String COL_TITLE = "title";
    public final static String COL_DIRECTOR = "director";
    public final static String COL_ACTOR = "actor";
    public final static String COL_DATE = "date";
    public final static String COL_STORY = "story";
    public final static String COL_GRADE = "grade";

    public MovieDBHelper(Context context) { super(context, DB_NAME, null, 2); }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABLE_NAME
                + " ( " + COL_ID + " integer primary key autoincrement, "
                + COL_TITLE + " TEXT, " + COL_DIRECTOR+ " TEXT, " + COL_ACTOR + " TEXT, " + COL_DATE + " TEXT, " + COL_STORY + "TEXT, " + COL_GRADE  + " float)";
        Log.d(TAG, sql);
        db.execSQL(sql);
        db.execSQL("insert into " + TABLE_NAME + " values (null, '어벤져스: 앤드게임','안소니 루소', '로버트 다우니 주니어', '2019.04.24', null, 4.5);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '메이즈 러너','웨스 볼' ,'딜런 오브 라이언','2014.09.18', null, 4);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '닥터스트레인지','스콧 데릭슨', '베네딕트 컴버배치', '2016.10.26', null, 4);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '블랙 위도우','케이트 쇼틀랜드', '스칼릿 조핸슨', '2021.07.07', null, 4.5);");
        db.execSQL("insert into " + TABLE_NAME + " values (null, '아이언맨','존 파브로', '로버트 다우니 주니어', '2008.04.30', null, 4.0);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

//    private void insertSample(SQLiteDatabase db){
//        db.execSQL("insert into " + TABLE_NAME + " values (null, '어벤져스: 앤드게임','안소니 루소', '로버트 다우니 주니어', '2019.04.24', '9.50');");
//        db.execSQL("insert into " + TABLE_NAME + " values (null, '메이즈 러너','웨스 볼' ,'딜런 오브 라이언','2014.09.18', '8.38');");
//        db.execSQL("insert into " + TABLE_NAME + " values (null, '닥터스트레인지','스콧 데릭슨', '베네딕트 컴버배치', '2016.10.26', '8.88');");
//        db.execSQL("insert into " + TABLE_NAME + " values (null, '블랙 위도우','케이트 쇼틀랜드', '스칼릿 조핸슨', '2021.07.07', '9.03');");
//        db.execSQL("insert into " + TABLE_NAME + " values (null, '아이언맨','존 파브로', '로버트 다우니 주니어', '2008.04.30', '8.99');");
//
//    }
}
