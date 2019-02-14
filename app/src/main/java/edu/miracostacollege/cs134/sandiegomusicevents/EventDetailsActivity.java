package edu.miracostacollege.cs134.sandiegomusicevents;

import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class EventDetailsActivity extends AppCompatActivity {

    private ImageView eventImageView;
    private TextView eventTitleTextView;
    private TextView eventDetailsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_details);

        // Retrieve intent
        Intent mainIntent = getIntent();

        // Extract artists and details
        String artist = mainIntent.getStringExtra("Artist");
        String details = mainIntent.getStringExtra("Details");
        String imageName = artist.replaceAll(" ", "") + ".png";

        eventImageView = findViewById(R.id.eventImageView);
        eventTitleTextView = findViewById(R.id.eventTitleTextView);
        eventDetailsTextView = findViewById(R.id.eventDetailsTextView);

        eventTitleTextView.setText(artist);
        eventDetailsTextView.setText(details);

        // To load image, use AssetManager
        AssetManager am = getAssets();
        try {
            InputStream stream = am.open(imageName);
            // Create drawable object
            Drawable eventImage = Drawable.createFromStream(stream, artist);
            eventImageView.setImageDrawable(eventImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
