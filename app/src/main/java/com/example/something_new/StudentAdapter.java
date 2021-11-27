package com.example.something_new;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {
    ArrayList<Student> students;
    Context context;

    public StudentAdapter(ArrayList<Student> students, Context context) {
        this.students = students;
        this.context = context;
    }

    @Override
    public int getCount() {return students.size();}

    @Override
    public Object getItem(int position) { return students.get(position);}

    @Override
    public long getItemId(int position) { return 0;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Student tmp = students.get(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.row_list_student, null);

        TextView tv_student_name = convertView.findViewById(R.id.tv_name);
        TextView tv_student_Lname = convertView.findViewById(R.id.tv_lName);
        TextView tv_student_addres = convertView.findViewById(R.id.tv_addres);
        TextView tv_student_averageG= convertView.findViewById(R.id.tv_avergeGrade);

        tv_student_name.setText(tmp.getName());
        tv_student_Lname.setText(tmp.getFamilyName());
        tv_student_addres.setText(tmp.getClassName());
        tv_student_averageG.setText(String.valueOf(tmp.getAveageGrade()));

        return convertView;
    }
}
