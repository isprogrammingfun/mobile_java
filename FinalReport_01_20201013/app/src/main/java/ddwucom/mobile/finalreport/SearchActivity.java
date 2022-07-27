package ddwucom.mobile.finalreport;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    ListView listView;
    MyAdapter myAdapter;
    ArrayList<Movie> movieList;
    MovieDBManager movieDBManager;
    TextView moviesearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        listView = findViewById(R.id.search_list);
        movieList = (ArrayList<Movie>) getIntent().getSerializableExtra("movie");
        myAdapter = new MyAdapter(this, R.layout.custom_adapter_view, movieList);
        listView.setAdapter(myAdapter);
    }

    public void onClick (View v) {
        listView = findViewById(R.id.search_list);
        moviesearch = findViewById(R.id.moviesearch);
        movieDBManager = new MovieDBManager(this);
        switch (v.getId()) {
            case R.id.buttonsearch:
                if (moviesearch.getText().toString().equals("")) {
                    myAdapter = new MyAdapter(this, R.layout.custom_adapter_view, movieList);
                    listView.setAdapter(myAdapter);
                }
                else {
                    ArrayList<Movie> searchBook = movieDBManager.getMovieByName(String.valueOf(moviesearch.getText()));
                    myAdapter = new MyAdapter(this, R.layout.custom_adapter_view, searchBook);
                    listView.setAdapter(myAdapter);
                }
                break;

        }
    }
}
