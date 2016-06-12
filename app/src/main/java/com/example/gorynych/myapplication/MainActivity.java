package com.example.gorynych.myapplication;

import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textSetCrow;
    Button buttonAdd;
    Button buttonDel;
    GridLayout linearLayout;
    final ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(100,100);
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setIcon(R.drawable.raven_38144);


        textSetCrow = (TextView) findViewById(R.id.textSetCrow);
        textSetCrow.setText(String.valueOf(i));

        linearLayout = (GridLayout) findViewById(R.id.linearLayoutImg);



        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonDel = (Button) findViewById(R.id.buttonDel);

        buttonAdd.setOnClickListener(this);



        buttonDel.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonAdd:
                textSetCrow.setText(String.valueOf(++i));

                ImageView imageView = new ImageView(this);
                imageView.setImageResource(R.drawable.raven_38144);
                LinearLayout linearLayout1 = new LinearLayout(this);
                linearLayout1.setId(i);
                linearLayout1.addView(imageView,layoutParams);

                linearLayout.addView(linearLayout1);

                break;

            case R.id.buttonDel:
                if (i > 0) {
                    textSetCrow.setText(String.valueOf(--i));
                    linearLayout.removeView(findViewById(i+1));
                } else {
                    textSetCrow.setText(String.valueOf(i));
                }

                break;

            default:
                break;
        }
    }
}
