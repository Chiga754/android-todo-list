package com.example.androidtodolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Task> tasks;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        taskAdapter = new TaskAdapter();
        tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Task task = new Task(i, "Task " + i);
            tasks.add(task);
        }
        taskAdapter.setTasks(tasks);
        recyclerView.setAdapter(taskAdapter);
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
    }
}