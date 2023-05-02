package com.example.roomlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText eItem,eAmount;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eItem=findViewById(R.id.eItem);
        eAmount=findViewById(R.id.eAmount);
        btnAdd=findViewById(R.id.btnAdd);


        btnAdd.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        String item_name = eItem.getText().toString();
        String amount = eAmount.getText().toString();

        MyDBHelper dbHelper = MyDBHelper.getDatabase(this);
        dbHelper.expenseDao().insert(
                new Expense(item_name,amount)
        );

        ArrayList<Expense> arrExpenses = (ArrayList<Expense>) dbHelper.expenseDao().select();

        for (int i=0; i<arrExpenses.size(); i++){
            Log.d("Row : ", "Item name "+arrExpenses.get(i).getITEM()+",\n"+
                    "Amount "+arrExpenses.get(i).getAMOUNT());
        }
    }
}