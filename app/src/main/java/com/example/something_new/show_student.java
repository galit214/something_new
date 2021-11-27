package com.example.something_new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class show_student extends AppCompatActivity {
    ArrayList<Student> studentsList;
    ListView lv;
    StudentAdapter studentAdapter;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_student);
        db = openOrCreateDatabase(Utils.DATABASE_NAME,
                MODE_PRIVATE, null);
        studentsList=new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + Utils.TABLE_NAME_STUDENT, null);
        while(cursor.moveToNext()){
            String name = cursor.getString(1);
            String lname = cursor.getString(2);
            String className = cursor.getString(3);
            int avrageGrade=cursor.getInt(4);
            Student student = new Student(name, lname, className,avrageGrade);
            studentsList.add(student);

        }
        lv=findViewById(R.id.lv_student);
        studentAdapter=new StudentAdapter(studentsList,show_student.this);
        lv.setAdapter(studentAdapter);



    }
}