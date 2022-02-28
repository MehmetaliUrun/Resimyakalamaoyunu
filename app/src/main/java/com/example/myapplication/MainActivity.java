package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    TextView time;
    int number;
    ImageView imageview;
    ImageView imageview1;
    ImageView imageview2;
    ImageView imageview3;
    ImageView imageview4;
    ImageView imageview5;
    ImageView imageview6;
    ImageView imageview7;
    ImageView imageview8;
    ImageView[] imageArray;
    Handler handler;
    Runnable runnable;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView2);
        time=findViewById(R.id.textView);
        imageview=findViewById(R.id.imageView);
        imageview1=findViewById(R.id.imageView1);
        imageview2=findViewById(R.id.imageView2);
        imageview3=findViewById(R.id.imageView3);
        imageview4=findViewById(R.id.imageView4);
        imageview5=findViewById(R.id.imageView5);
        imageview6=findViewById(R.id.imageView6);
        imageview7=findViewById(R.id.imageView7);
        imageview8=findViewById(R.id.imageView8);
        imageArray=new ImageView[]{imageview,imageview1,imageview2,imageview3,imageview4,imageview5,imageview6,imageview7,imageview8};



        number=0;
        new CountDownTimer(10000,1000){


            @Override
            public void onTick(long millisUntilFinished) {
                time.setText("kalan zaman:" +millisUntilFinished/1000);

            }

            @Override
            public void onFinish() {

                handler.removeCallbacks(runnable);
                for (ImageView a:imageArray){
                    a.setVisibility(View.INVISIBLE);
                }
                AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("quick or restart");
                alert.setMessage("Do you want to quick?");
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"güle güle",Toast.LENGTH_LONG).show();
                        finish();

                    }
                });
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent ıntent =getIntent();
                        finish();
                        startActivity(ıntent);

                    }
                });
                alert.show();

            }
        }.start();

        images();

    }


    public void increasecore (View view){

        number++;

        textView.setText("score:"+number);




    }
    public void images(){
        handler = new Handler();
        runnable= new Runnable() {
            @Override
            public void run() {

                for (ImageView a:imageArray){
                    a.setVisibility(View.INVISIBLE);
                }
                random= new Random();
                int i= random.nextInt(9);
                imageArray[i].setVisibility(View.VISIBLE);
                handler.postDelayed(this,500);

            }
        };
        handler.post(runnable);



    }


}