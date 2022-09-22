package com.example.androidtodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class AddTaskActivity extends AppCompatActivity {

    private Button btnAddTask;
    private EditText editTextTitleAddTask;
    private EditText editTextDescriptionTask;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        initView();

        mainViewModel = new MainViewModel(getApplication());

        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickBtnAddTask();
            }
        });

    }

    private void initView() {
        btnAddTask = findViewById(R.id.btnAddTask);
        editTextTitleAddTask = findViewById(R.id.editTextTitleAddTask);
        editTextDescriptionTask = findViewById(R.id.editTextDescriptionTask);
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, AddTaskActivity.class);
    }

    private void onClickBtnAddTask() {
        String title = editTextTitleAddTask.getText().toString().trim();
        String description = editTextDescriptionTask.getText().toString().trim();
        mainViewModel.add(new Task(0, title));
        finish();
    }

}