package a238443.movies;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class PhotoActivity extends AppCompatActivity{
    ImageView photoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        Toolbar movieToolbar = findViewById(R.id.photo_preview_toolbar);
        movieToolbar.setTitle("");
        movieToolbar.setNavigationIcon(R.drawable.ic_back);

        movieToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        photoView = findViewById(R.id.photo_preview);

        Intent fromParent = getIntent();
        String pathToPhoto = fromParent.getStringExtra("photoPath");
        photoView.setImageDrawable(getPhoto(pathToPhoto));
    }

    private Drawable getPhoto(String photoPath) {
        Drawable photo = getDrawable(R.drawable.ic_placeholder);
        try {
            InputStream input = getAssets().open(photoPath);
            photo = Drawable.createFromStream(input, null);
            input.close();
        } catch (IOException e) {
            Log.e("photo_error_preview","Photo file not found during preview building");
        }
        return photo;
    }

}
