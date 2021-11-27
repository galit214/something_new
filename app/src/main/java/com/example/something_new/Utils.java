package com.example.something_new;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Utils {
    final static String DATABASE_NAME = "db_school";

    final static String TABLE_NAME_STUDENT = "tbl_student";
    final static String TABLE_STUDENT_COL_ID="sid";
    final static String TABLE_STUDENT_COL_FNAME = "fname";
    final static String TABLE_STUDENT_COL_LNAME = "lname";
    final static String TABLE_STUDENT_COL_CLASSNAME = "classname";
    final static String TABLE_STUDENT_COL_AVERAGE = "average";

    final static String TABLE_NAME_TEACHER="tbl_teacher";
    final static String TABLE_TEACHER_COL_FNAME="Tfname";
    final static String TABLE_TEACHER_COL_LNAME="Tlname";
    final static String TABLE_TEACHER_COL_ID="Tid";
    final static String TABLE_TEACHER_COL_SUBJECT="Tsubject";

    final static String TABLE_NAME_CLASSES="tbl_class";
    final static String TABLE_CLASS_COL_CNAME="class_name";
    final static String TABLE_CLASS_COL_TNAME="teacher_name";



//tables builder//
    public static void build_tables(SQLiteDatabase db) {
        db.execSQL("create table if not exists "
                + TABLE_NAME_STUDENT +
                "(" +TABLE_STUDENT_COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT,"+ TABLE_STUDENT_COL_FNAME + " text, " + TABLE_STUDENT_COL_LNAME + " text, " + TABLE_STUDENT_COL_CLASSNAME + " text, " + TABLE_STUDENT_COL_AVERAGE + " integer)");

        db.execSQL("create table if not exists "
                + TABLE_NAME_TEACHER +
                "(" + TABLE_TEACHER_COL_ID + " integer, " +
                TABLE_TEACHER_COL_FNAME + " text, " +
                TABLE_TEACHER_COL_LNAME + " text, " +
                TABLE_TEACHER_COL_SUBJECT + " text)");

        db.execSQL("create table if not exists "+ TABLE_NAME_CLASSES+ "("+ TABLE_CLASS_COL_CNAME+" text, " +
                TABLE_CLASS_COL_TNAME+"text)");

    }

    public static void insertStudent2table(SQLiteDatabase db, Student st){
        db.execSQL("insert into "+TABLE_NAME_STUDENT+" values( null , '"+st.getName()+"', '"+st.getFamilyName()+"','" + st.getClassName() + "','"+st.getAveageGrade()+"')");

    }
    public static ArrayList<Student> studentsSameName(SQLiteDatabase db,String name){
        ArrayList<Student> s=new ArrayList<>();
        Cursor cursor =db.rawQuery("select * from " + Utils.TABLE_NAME_STUDENT, null);
        while(cursor.moveToNext()){
            String n=cursor.getString(1);
            if(name.equals(n)){
                s.add(new Student(n,cursor.getString(2),cursor.getString(3),cursor.getInt(4)));
            }
        }
        return s;
    }

    public static ArrayList<Student> studanetsBiggerAvrage(SQLiteDatabase db,int avarage){
        ArrayList<Student> s=new ArrayList<>();
        Cursor cursor =db.rawQuery("select * from " + Utils.TABLE_NAME_STUDENT, null);
        while(cursor.moveToNext()){
            int a=cursor.getInt(4);
            if(avarage<a){
                s.add(new Student(cursor.getString(1),cursor.getString(2),cursor.getString(3),a));
            }
        }
        return s;
    }

    public static void removeStudent(SQLiteDatabase db,int id){
        Cursor cursor=db.rawQuery("select * from " + TABLE_NAME_STUDENT, null);
        while(cursor.moveToNext()){
            if(cursor.getInt(0)==id){
                db.execSQL("delete from "+TABLE_NAME_STUDENT+" where "+TABLE_STUDENT_COL_ID+" ='"+id);
            }
        }

    }
    public static void updateStudent(Student s,SQLiteDatabase db) {
       db.execSQL("UPDATE tbl_student SET fname = "+s.getName()+", lname = "+s.getFamilyName()+", address="+s.getClassName()+", average="+s.getAveageGrade()+"WHERE sid="+s.getId());
    }

    //gold grade i the avrage grade of all students grades
    public static int goldGrade(SQLiteDatabase db){
        int count=0;
        int allGrade=0;
        Cursor cursor=db.rawQuery("select * from " + TABLE_NAME_STUDENT, null);
        while(cursor.moveToNext()){
            count++;
            allGrade=cursor.getInt(4)+allGrade;
        }
        if(count==0){
            return count;
        }
        return allGrade/count;
    }


}
