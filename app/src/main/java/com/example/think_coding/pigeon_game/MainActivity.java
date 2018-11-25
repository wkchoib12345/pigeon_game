package com.example.think_coding.pigeon_game;

import android.arch.core.executor.TaskExecutor;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    ImageView pigeon_1;
    TextView lv_text;
    int lv = 0;
    TextView lv_plus_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.game_playview);

        pigeon_1 = (ImageView) findViewById(R.id.pigeon_1);
        lv_text = (TextView) findViewById(R.id.lv_text);
        lv_plus_view = (TextView) findViewById(R.id.lv_plus_view);
        pigeon_1.setScaleX(0.3f);
        pigeon_1.setScaleY(0.3f);

        pigeon_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO : click event

                lv = lv + 1;
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


    }
}
