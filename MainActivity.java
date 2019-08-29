package com.example.myproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = findViewById(R.id.lv);
       final ArrayList<String> arr = new ArrayList<>();
        arr.add("Orange");
        arr.add("Mango");
        arr.add("Apple");
        arr.add("Banana");
        arr.add("Kiwi");
        arr.add("Peach");
        arr .add("WaterMelon");
        arr.add("PineApple");
        arr.add("PassionFruit");


        adapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, arr);
            listView.setAdapter(adapter);

        Button button = findViewById(R.id.addButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.editText);
                adapter.add(editText.getText().toString());
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getBaseContext(), "The item " + arr.get(i) + " was clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getBaseContext(),SeccondActivity.class);
                intent.putExtra("name",arr.get(i));
                startActivity(intent);
            }
        });
            

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int position, long l) {

                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                adb.setTitle("Delete?");
                adb.setMessage("Are you sure you want to delete " + arr.get(position));
                final int positionToRemove = position;
                adb.setNegativeButton("Cancel", null);
                adb.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        adapter.remove(adapter.getItem(positionToRemove));
                        adapter.notifyDataSetChanged();
                    }});
                adb.show();
                return true;
            }
        });




}
}

