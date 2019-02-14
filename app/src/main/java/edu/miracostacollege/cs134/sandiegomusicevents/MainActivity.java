package edu.miracostacollege.cs134.sandiegomusicevents;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import edu.miracostacollege.cs134.sandiegomusicevents.model.MusicEvent;

public class MainActivity extends ListActivity {

    private ListView eventListView;

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        // Get information from Model
        String artist = MusicEvent.titles[position];
        String details = MusicEvent.details[position];

        // Instantiate intent ...
        Intent detailsIntent = new Intent(this, EventDetailsActivity.class);

        detailsIntent.putExtra("Artist", artist);
        detailsIntent.putExtra("Details", details);

        // Start activity
        startActivity(detailsIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Since layout is being inflated, don't setContentView
        //setContentView(R.layout.activity_main);

        eventListView = findViewById(R.id.eventsListView);

        // Connect ListView with an Array Adapter to fill out data
        ArrayAdapter<String> eventsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, MusicEvent.titles);

        //
        setListAdapter(eventsAdapter);

    }
}
