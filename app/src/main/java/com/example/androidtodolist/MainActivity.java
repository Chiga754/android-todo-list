package com.example.androidtodolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton floatingActionButton;
    private TaskAdapter taskAdapter;

    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        // Создание инстанса базы данных
        mainViewModel = new MainViewModel(getApplication());

        // Работа с RecyclerView
        taskAdapter = new TaskAdapter();
        taskAdapter.setTasks(mainViewModel.getTasks());
        recyclerView.setAdapter(taskAdapter);

        // Обработчик события клика по FloatingActionButton
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(AddTaskActivity.newIntent(MainActivity.this));
            }
        });
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        floatingActionButton = findViewById(R.id.floatingActionButton);
    }
}