package com.example.androidtodolist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private TasksDatabase tasksDatabase;

    public MainViewModel(@NonNull Application application) {
        super(application);
        tasksDatabase = TasksDatabase.getInstance(application);
    }

    public List<Task> getTasks() {
        return tasksDatabase.tasksDao().getTasks();
    }

}
