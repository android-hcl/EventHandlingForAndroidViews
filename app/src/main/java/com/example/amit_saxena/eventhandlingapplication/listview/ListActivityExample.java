package com.example.amit_saxena.eventhandlingapplication.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.amit_saxena.eventhandlingapplication.R;


public class ListActivityExample extends Activity {

    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_activity_example);

        mListView=(ListView)findViewById(R.id.myList);

        // Defined Array values to show in ListView
        String[] myListItems = new String[] {
                "Item A",
                "Item B",
                "Item C",
                "Item D",
                "Item E",
                "Item F",
                "Item G",
                "Item H"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, myListItems);


        // Assign adapter to ListView
        mListView.setAdapter(adapter);

        //Adding listener to ListView

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListActivityExample.this,mListView.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }



}
