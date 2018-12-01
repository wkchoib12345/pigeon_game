package com.example.think_coding.pigeon_game;

import android.arch.core.executor.TaskExecutor;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    ViewGroup main_layout;
    ViewGroup pigeon_framelayout;
    ImageView pigeon_1;
    ImageView pigeon_2;
    TextView lv_text;
    int lv = 0;
    int add_num = 1;
    TextView lv_plus_view;

    Button function_1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.game_playview);

        pigeon_1 = (ImageView) findViewById(R.id.pigeon_1);




        lv_text = (TextView) findViewById(R.id.lv_text);
        lv_plus_view = (TextView) findViewById(R.id.lv_plus_view);


        pigeon_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO : click event

                lv = lv + add_num;
                lv_text.setText(lv + " 레벨");
                lv_plus_view.setVisibility(View.VISIBLE);
                new Handler().postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        //여기에 딜레이 후 시작할 작업들을 입력

                        lv_plus_view.setVisibility(View.INVISIBLE);
                    }
                }, 500);// 0.5초 정도 딜레이를 준 후 시작


            }
        });
        main_layout = (ViewGroup) findViewById(R.id.main_relative);
        pigeon_framelayout = (ViewGroup) findViewById(R.id.pigeon_framelayout);
        String[] location = new String[2];
        location[0] = "x";
        location[1] = "y";


        Movable_Layout_Class new_movable_button = new Movable_Layout_Class(this, main_layout, pigeon_framelayout, location, "scale", false);

        pigeon_framelayout.setX(10);
        pigeon_framelayout.setY(10);

        function_1 = (Button) findViewById(R.id.function_1);
        function_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO : click event

                add_num = add_num + 1;
                lv_plus_view.setText("+" + add_num);
            }
        });


        function_1.setWidth(500);


    }//oncreate 끝
}
