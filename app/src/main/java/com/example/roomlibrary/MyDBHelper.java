package com.example.roomlibrary;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = Expense.class,exportSchema = false,version = 1)
public abstract class MyDBHelper extends RoomDatabase {
    private static final String DATABASE_NAME = "DATABASE_EXPENSE";
    private static MyDBHelper instance;


    //creating databasee instance
    public static synchronized MyDBHelper getDatabase(Context context){
        if (instance==null){
            instance= Room.databaseBuilder(context, MyDBHelper.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }


    //interface
    public abstract ExpenseDao expenseDao();
}
