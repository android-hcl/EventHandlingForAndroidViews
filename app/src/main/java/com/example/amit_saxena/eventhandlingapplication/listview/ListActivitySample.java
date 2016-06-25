package com.example.amit_saxena.eventhandlingapplication.listview;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.amit_saxena.eventhandlingapplication.R;

public class ListActivitySample extends ListActivity {
    private String[] myListItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_activity_sample);
        // Defined Array values to show in ListView
        myListItems = new String[] {
                "Item A",
                "Item B",
                "Item C",
                "Item D",
                "Item E",
                "Item F",
                "Item G",
                "Item H"
        };
        //Initializing Adapter
        MyCustomAdapter adapter=new MyCustomAdapter(this, myListItems);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(ListActivitySample.this, myListItems[position], Toast.LENGTH_SHORT).show();
    }
}
