package com.example.javaformserializer;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        PlantLogForm testForm = new PlantLogForm("06/20/20", "123", GrowthStage.MaturePlant, "ping");
        final String formJson = testForm.toJsonString();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, formJson, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        setFirstFragmentView();
        setSecondFragmentView();
    }

    private void setFirstFragmentView(){
        View fragLayout = ((LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.fragment_first, null, false);

        GrowthStage[] stages = GrowthStage.values();
        String[] stagesStrings = new String[(stages.length + 1)];
        stagesStrings[0] = " ";
        for(int i=1;i<stagesStrings.length;i++){
            stagesStrings[i] = stages[i-1].getName();
        }

        Spinner stagesOptions = fragLayout.findViewById(R.id.stageOptions);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, stagesStrings);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        stagesOptions.setAdapter(adapter);
    }

    private  void setSecondFragmentView(){
        View fragLayout = ((LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.fragment_second, null, false);


        int test = 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}