package com.example.tiktaktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int player=0;//0-x,1-o
    boolean executed =false;
    int[] table={2,2,2,2,2,2,2,2,2};//2-blank,0-x,1-o
    int[][] win={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};//winning combos
    public void tap(View view)
    {
        TextView status=findViewById(R.id.status);
        ImageView img=(ImageView)view;
        int tapped=Integer.parseInt(img.getTag().toString());

        if(table[tapped]==2&& !executed)
        {
            table[tapped]=player;
            img.setTranslationY(-1000f);
            if(player==0)
            {
                img.setImageResource(R.drawable.x);
                player=1;
                status.setText("O's Turn To Play");
            }
            else{
                img.setImageResource(R.drawable.o);
                player=0;
                status.setText("X's Turn To Play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        for(int[] temp:win)
        {
            if(table[temp[0]]==table[temp[1]]&&table[temp[1]]==table[temp[2]]&&table[temp[0]]!=2)
            {
                String winner;
               if(table[temp[0]]==0)
               {
                   winner="X has won";
               }
               else
                   winner="o has won";
                status.setText(winner);
                executed =true;
            }
        }
    }

    void gameReset(View view)
    {
        player=0;
        for(int i=0;i<9;i++)
        {
            table[i]=2;
        }
        executed =false;
        ImageView i=(ImageView) view;
        (i=findViewById(R.id.imageView1)).setImageResource(0);
        (i=findViewById(R.id.imageView2)).setImageResource(0);
        (i=findViewById(R.id.imageView3)).setImageResource(0);
        (i=findViewById(R.id.imageView4)).setImageResource(0);
        (i=findViewById(R.id.imageView5)).setImageResource(0);
        (i=findViewById(R.id.imageView6)).setImageResource(0);
        (i=findViewById(R.id.imageView7)).setImageResource(0);
        (i=findViewById(R.id.imageView8)).setImageResource(0);
        (i=findViewById(R.id.imageView9)).setImageResource(0);
        TextView status=findViewById(R.id.status);
        status.setText("X's Turn to play");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       ImageView img1=findViewById(R.id.imageView1);
        img1.setOnClickListener(this);
        ImageView img2=findViewById(R.id.imageView2);
        img2.setOnClickListener(this);
        ImageView img3=findViewById(R.id.imageView3);
        img3.setOnClickListener(this);
        ImageView img4=findViewById(R.id.imageView4);
        img4.setOnClickListener(this);
        ImageView img5=findViewById(R.id.imageView5);
        img5.setOnClickListener(this);
        ImageView img6=findViewById(R.id.imageView6);
        img6.setOnClickListener(this);
        ImageView img7=findViewById(R.id.imageView7);
        img7.setOnClickListener(this);
        ImageView img8=findViewById(R.id.imageView8);
        img8.setOnClickListener(this);
        ImageView img9=findViewById(R.id.imageView9);
        img9.setOnClickListener(this);
        Button button=findViewById(R.id.button);
        button.setOnClickListener(this::gameReset);
        }

    @Override
    public void onClick(View view) {

        tap(view);
    }
}