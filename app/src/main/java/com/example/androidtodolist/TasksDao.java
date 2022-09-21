package com.example.androidtodolist;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface TasksDao {
    @Query("SELECT * FROM tasks")
    List<Task> getTasks();

    @Insert
    void add(Task task);
}
