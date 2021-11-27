package com.example.something_new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Spalash_Screen extends AppCompatActivity implements View.OnClickListener {
    TextView tvStart;
    SQLiteDatabase db;
    Animation anim_rotate;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalash_screen);
        imageView=findViewById(R.id.imageView2);
        anim_rotate= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rutate);
        imageView.startAnimation(anim_rotate);

        tvStart=findViewById(R.id.tv_start);
        db = openOrCreateDatabase(Utils.DATABASE_NAME,
                MODE_PRIVATE, null);

        Utils.build_tables(db);
        tvStart.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view==tvStart){
            startActivity(new Intent(Spalash_Screen.this,
                    MainActivity.class));
        }

    }
}