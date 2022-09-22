package com.example.androidtodolist;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private TasksDatabase tasksDatabase;

    public MainViewModel(@NonNull Application application) {
        super(application);
        tasksDatabase = TasksDatabase.getInstance(application);
    }

    public LiveData<List<Task>> getTasksLiveData() {
        return tasksDatabase.tasksDao().getTasks();
    }

    public void add (Task task) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                tasksDatabase.tasksDao().add(task);
            }
        });
        thread.start();
    }

    public void remove (int id) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("testTest", String.valueOf(id));
                tasksDatabase.tasksDao().remove(id);
            }
        });
        thread.start();
    }
}
