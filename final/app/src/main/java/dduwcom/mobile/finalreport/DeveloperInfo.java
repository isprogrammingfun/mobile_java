package dduwcom.mobile.finalreport;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DeveloperInfo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.developer);
        ImageView imageView = findViewById(R.id.developerimg);
        imageView.setImageResource(R.mipmap.developer);
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Imagegoogle:
                Intent intent_google = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.kr/"));
                startActivity(intent_google);
                break;
            case R.id.Imagenaver:
                Intent intent_naver = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.naver.com/"));
                startActivity(intent_naver);
        }
    }
}
