package com.codepath.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        String text = getIntent().getStringExtra("text");
        position = getIntent().getIntExtra("position", 0);
        EditText editText = (EditText) findViewById(R.id.EditItemBelow);
        //populate with input with todo text
        editText.setText(text);
        //set cursor at the end of edit text
        editText.setSelection(editText.getText().length());
    }

    public void onSubmit(View v) {
        // closes the activity and returns to first screen
        EditText editText = (EditText) findViewById(R.id.EditItemBelow);
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("todo", editText.getText().toString());
        data.putExtra("index", position);
        setResult(RESULT_OK, data); // set result code and bundle data for response
        finish(); // closes the activity, pass data to parent
    }
}
