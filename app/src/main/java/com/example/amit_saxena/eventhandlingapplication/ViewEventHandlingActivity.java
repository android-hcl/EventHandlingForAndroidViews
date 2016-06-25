package com.example.amit_saxena.eventhandlingapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class ViewEventHandlingActivity extends Activity {
    private Button mTestBtn;
    private Button mTestBtn1;
    private CheckBox mCheckUnchecked;
    private RadioGroup radioResponseGroup;
    private RadioButton radioResponseButton;
    private Spinner mSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_event_handling);

        //Initialising Views

        mTestBtn= (Button) findViewById(R.id.testBtn);
      //  mTestBtn1= (Button) findViewById(R.id.testBtn);
        mCheckUnchecked= (CheckBox) findViewById(R.id.myCheckbox);
        radioResponseGroup= (RadioGroup) findViewById(R.id.radioGroup);
        mSpinner= (Spinner) findViewById(R.id.mySpinner);

        //Attaching listeners to Views
     /*   mTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ViewEventHandlingActivity.this,"Hello",Toast.LENGTH_SHORT).show();
            }
        });*/

        mTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get selected radio button from radioGroup
                int selectedId = radioResponseGroup.getCheckedRadioButtonId();

                // find the radio button by returned id
                radioResponseButton = (RadioButton) findViewById(selectedId);

                Toast.makeText(ViewEventHandlingActivity.this,radioResponseButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        mCheckUnchecked.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean status) {
                if(status){
                    Toast.makeText(getApplicationContext(),"Checked",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(),"UnChecked",Toast.LENGTH_SHORT).show();
                }

            }
        });


        //Elements that needs to be displayed in Spinner List
        List<String> itemsList=new ArrayList<String>();
        itemsList.add("India");
        itemsList.add("US");
        itemsList.add("China");
        itemsList.add("Japan");
        itemsList.add("UK");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, itemsList);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        mSpinner.setAdapter(dataAdapter);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(adapterView.getContext(), "Country Selected: " + item, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


}
