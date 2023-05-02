package com.example.roomlibrary;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "EXPENSE")
public class Expense {

    //column names
    @PrimaryKey (autoGenerate = true)
    private int ID;

    @ColumnInfo (name = "ITEM")
    private String ITEM;

    @ColumnInfo (name = "AMOUNT")
    private String AMOUNT;

    //constructor for select
    public Expense(int ID, String ITEM, String AMOUNT) {
        this.ID = ID;
        this.ITEM = ITEM;
        this.AMOUNT = AMOUNT;
    }

    //constructor for insertion
    @Ignore
    public Expense(String ITEM, String AMOUNT) {
        this.ITEM = ITEM;
        this.AMOUNT = AMOUNT;
    }


    //getter setter methods
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getITEM() {
        return ITEM;
    }

    public void setITEM(String ITEM) {
        this.ITEM = ITEM;
    }

    public String getAMOUNT() {
        return AMOUNT;
    }

    public void setAMOUNT(String AMOUNT) {
        this.AMOUNT = AMOUNT;
    }
}
