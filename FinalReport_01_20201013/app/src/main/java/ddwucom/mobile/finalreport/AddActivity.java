package ddwucom.mobile.finalreport;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    EditText MovieTitle;
    EditText MovieDirector;
    EditText MovieActor;
    EditText MovieDate;
    EditText MovieStory;
    MovieDBManager movieDBManager;
    RatingBar MovieRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        MovieTitle = findViewById(R.id.MovieTitle);
        MovieDirector = findViewById(R.id.MovieDirector);
        MovieActor = findViewById(R.id.MovieActor);
        MovieDate = findViewById(R.id.MovieDate);
        MovieStory = findViewById(R.id.MovieStory);
        MovieRating = findViewById(R.id.MovieRating);
        movieDBManager = new MovieDBManager(this);

    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonUpdate:
                if (MovieTitle.getText().toString().equals("") || MovieDirector.getText().toString().equals("")  || MovieActor.getText().toString().equals("") || MovieDate.getText().toString().equals("") || MovieStory.getText().toString().equals("") || MovieRating == null)
                {
                    Toast.makeText(this, "필수 정보를 입력하지 않으셨습니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Movie movie = new Movie(MovieTitle.getText().toString(), MovieDirector.getText().toString(), MovieActor.getText().toString(), MovieDate.getText().toString(), MovieStory.getText().toString(), MovieRating.getRating());
                    boolean result = movieDBManager.addNewMovie(movie);
                    if (result) {
                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("movie", MovieTitle.getText().toString());
                        setResult(RESULT_OK, resultIntent);
                        finish();
                    } else {
                        Toast.makeText(this, "새로운 영화 추가 실패!", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.buttonCancel:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}
