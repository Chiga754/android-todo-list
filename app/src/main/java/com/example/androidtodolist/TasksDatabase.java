package com.example.androidtodolist;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Task.class},version = 1, exportSchema = false)
public abstract class TasksDatabase extends RoomDatabase {
    private static TasksDatabase instance = null;
    private static final String DB_NAME = "tasks.db";

    public static TasksDatabase getInstance(Application application) {
        if(instance == null) {
            instance = Room.databaseBuilder(
                    application,
                    TasksDatabase.class,
                    DB_NAME
            ).allowMainThreadQueries().build();
        }
        return instance;
    }

    public abstract TasksDao tasksDao();
}
