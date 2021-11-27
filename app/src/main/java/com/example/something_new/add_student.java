package com.example.something_new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class add_student extends AppCompatActivity implements View.OnClickListener {
    SQLiteDatabase db;
    EditText name,lastName, className,avrageGrade;
    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        db = openOrCreateDatabase(Utils.DATABASE_NAME, 0, null);
        name=findViewById(R.id.ed_name);
        lastName=findViewById(R.id.ed_lastName);
        className =findViewById(R.id.ed_addres);
        avrageGrade=findViewById(R.id.ed_avrageGrade);
        save=findViewById(R.id.btn_save);

       save.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               int aG=Integer.valueOf(avrageGrade.getText().toString());
               Student st=new Student(name.getText().toString(),lastName.getText().toString(), className.getText().toString(),aG);
               Utils.insertStudent2table(db,st);
               startActivity(new Intent(add_student.this,
                       MainActivity.class));
                finish();
           }
       });

    }


    @Override
    public void onClick(View view) {

    }
}