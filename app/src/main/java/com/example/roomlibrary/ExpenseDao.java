package com.example.roomlibrary;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

//contains methods for table manipulation

@Dao
public interface ExpenseDao {

    @Query("SELECT * FROM EXPENSE")
    List<Expense> select();

    @Insert
    void insert(Expense expense);

    @Update
    void update(Expense expense);

    @Delete
    void delete(Expense expense);

}
