package com.example.androidtodolist;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface TasksDao {
    @Query("SELECT * FROM tasks")
    LiveData<List<Task>> getTasks();

    @Insert
    void add(Task task);


    @Query("DELETE FROM tasks WHERE id = :id")
    void remove(int id);
}
