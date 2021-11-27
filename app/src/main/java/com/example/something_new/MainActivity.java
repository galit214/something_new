package com.example.something_new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    SQLiteDatabase db;
    TextView tv_stClass,tv_students_names, tv_goldGrade,tv_studentsGold;
    EditText ed_class_name;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_goldGrade =findViewById(R.id.tv_goldGade);
        tv_studentsGold=findViewById(R.id.tv_studentsGold);
        tv_stClass = findViewById(R.id.tv_student_class);
        tv_stClass.setVisibility(View.INVISIBLE);
        tv_students_names = findViewById(R.id.ed_names);
        tv_students_names.setVisibility(View.INVISIBLE);
        ed_class_name=findViewById(R.id.ed_className);
        ed_class_name.setOnClickListener(this);

        db = openOrCreateDatabase(Utils.DATABASE_NAME, 0, null);
        Utils.build_tables(db);
        int allAvrageGrade=Utils.goldGrade(db);
        tv_goldGrade.setText(String.valueOf(allAvrageGrade));

        String studentsBiggerGraedGold="";
        ArrayList<Student> sbga=Utils.studanetsBiggerAvrage(db,Utils.goldGrade(db));
        for(int i=0; i<sbga.size();i++){
            studentsBiggerGraedGold=studentsBiggerGraedGold+","+sbga.get(i).getName();
        }
        tv_studentsGold.setText(studentsBiggerGraedGold);



    }


    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        int id = item.getItemId();
        if (id == R.id.action_show_students) {
            startActivity(new Intent(MainActivity.this,
                    show_student.class));
        }
        if (id == R.id.action_add_student) {
            startActivity(new Intent(MainActivity.this,
                    add_student.class));
        }
        if (id == R.id.action_show_details) {
            startActivity(new Intent(MainActivity.this,
                    details.class));
        }
        return true;
    }


    @Override
    public void onClick(View view) {
        if(view==ed_class_name){
            tv_stClass.setVisibility(View.VISIBLE);
            String nameStudents="";
            String nClass=ed_class_name.getText().toString();
            Cursor cursor1=db.rawQuery("select * from " + Utils.TABLE_NAME_STUDENT,null);
            while(cursor1.moveToNext()){
                if(nClass.equals(cursor1.getString(3))){
                    nameStudents=nameStudents+","+cursor1.getString(1)+", ";

                }
            }
            tv_students_names.setText(nameStudents);
            tv_students_names.setVisibility(View.VISIBLE);

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
