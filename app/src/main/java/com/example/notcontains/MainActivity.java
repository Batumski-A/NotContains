package com.example.notcontains;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public Button Submit,AddSubmit,Clear;
    public EditText Addthis;
    public TextView GetBool,Array;
    public int[] mArray = new int[50];
    ArrayList<Integer> arrayList = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Clear = findViewById(R.id.mClear);
        Submit = findViewById(R.id.mSubmit);
        Addthis = findViewById(R.id.mAddThis);
        GetBool = findViewById(R.id.mGetBool);
        AddSubmit = findViewById(R.id.mAddSubmit);
        Array = findViewById(R.id.mArray);
        AddSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ArrayTex = "";
                arrayList.add(Integer.parseInt(Addthis.getText().toString()));
                for (int i = 0;i < arrayList.size();i++){
                    ArrayTex += String.valueOf(arrayList.get(i)) + " | ";
                }
                Array.setText(ArrayTex);
                Toast.makeText(MainActivity.this,"Success Added",Toast.LENGTH_LONG).show();
            }
        });

        Clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.clear();
                for (int i = 0 ; i<mArray.length;i++){
                    mArray[i] = 0;
                }
                Array.setText("");
            }
        });

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,String.valueOf(notContains(mArray)) ,Toast.LENGTH_SHORT).show();
                for (int i=0;i<arrayList.size();i++){
                    mArray[i] = arrayList.get(i);
                }
                GetBool.setText(String.valueOf(notContains(mArray)));
            }
        });
    }

    public int notContains(int[] Array){
        int MinNumber = 1;
        Boolean TF = true;
        while(TF){
            for(int i=0;i<Array.length;i++){
                if(MinNumber==Array[i]){
                    MinNumber = MinNumber + 1;
                    break;
                }else if(i == Array.length-1){
                    TF = false;
                    break;
                }
            }
        }
        return MinNumber;
    }
}
