package com.example.amit_saxena.eventhandlingapplication.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.amit_saxena.eventhandlingapplication.R;

public class CustomListView extends Activity {
    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_activity_example);
        mListView=(ListView)findViewById(R.id.myList);

        // Defined Array values to show in ListView
        final String[] myListItems = new String[] {
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

        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(CustomListView.this, myListItems[position], Toast.LENGTH_SHORT).show();
            }
        });

    }



}
