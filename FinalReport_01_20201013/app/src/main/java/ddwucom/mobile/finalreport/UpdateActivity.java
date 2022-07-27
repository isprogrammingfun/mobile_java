package ddwucom.mobile.finalreport;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateActivity extends AppCompatActivity {
    Movie movie;
    EditText MovieTitle;
    EditText MovieDirector;
    EditText MovieActor;
    EditText MovieDate;
    EditText MovieStory;
    MovieDBManager movieDBManager;
    RatingBar MovieRating;
    ImageView MoviePoster;
    String movietitle;
    String moviedirector;
    String movieactor;
    String moviedate;
    String moviestory;
    Float movierate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        movie = (Movie) getIntent().getSerializableExtra("movie");

        MovieTitle = findViewById(R.id.MovieTitle);
        MovieDirector = findViewById(R.id.MovieDirector);
        MovieActor = findViewById(R.id.MovieActor);
        MovieDate = findViewById(R.id.MovieDate);
        MovieStory = findViewById(R.id.MovieStory);
        MovieRating = findViewById(R.id.MovieRating);
        MoviePoster = findViewById(R.id.updateimage);
        movietitle = movie.getTitle();
        moviedirector = movie.getDirector();
        movieactor = movie.getActor();
        moviedate = movie.getDate();
        moviestory = movie.getStory();
        movierate = movie.getRating();

        MovieTitle.setText(movietitle);
        MovieDirector.setText(moviedirector);
        MovieActor.setText(movieactor);
        MovieDate.setText(moviedate);
        MovieStory.setText(moviestory);
        MovieRating.setRating(movierate);

        if (movie.getPoster() == 1)
            MoviePoster.setImageResource(R.mipmap.movie1);
        else if (movie.getPoster() == 2)
            MoviePoster.setImageResource(R.mipmap.movie2);
        else if (movie.getPoster() == 3)
            MoviePoster.setImageResource(R.mipmap.movie3);
        else if (movie.getPoster() == 4)
           MoviePoster.setImageResource(R.mipmap.movie4);
        else if (movie.getPoster() == 5)
            MoviePoster.setImageResource(R.mipmap.movie5);
        else
            MoviePoster.setImageResource(R.mipmap.movieadd);

        movieDBManager = new MovieDBManager(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonUpdate:
                if (MovieTitle.getText().toString().equals(movietitle) || MovieDirector.getText().toString().equals(moviedirector) || MovieActor.getText().toString().equals(movieactor) || MovieDate.getText().toString().equals(moviedate) || MovieStory.getText().toString().equals(moviestory) || MovieRating == null) {
                    Toast.makeText(this, "필수 정보를 입력하지 않으셨습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    movie.setTitle(MovieTitle.getText().toString());
                    movie.setDirector(MovieDirector.getText().toString());
                    movie.setActor(MovieActor.getText().toString());
                    movie.setDate(MovieDate.getText().toString());
                    movie.setRating(MovieRating.getRating());
                    movie.setStory(MovieStory.getText().toString());

                    if (movieDBManager.modifyMovie(movie)) {
                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("movie", movie);
                        setResult(RESULT_OK, resultIntent);
                    } else {
                        setResult(RESULT_CANCELED);
                    }
                    finish();
                }
                break;
            case R.id.buttonCancel:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }
}