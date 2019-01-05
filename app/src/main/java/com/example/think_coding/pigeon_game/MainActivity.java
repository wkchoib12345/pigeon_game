package com.example.think_coding.pigeon_game;

import android.arch.core.executor.TaskExecutor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    ViewGroup main_layout;
    ViewGroup pigeon_framelayout;
    ImageView pigeon_1;
    ImageView pigeon_2;
    ViewGroup pigeon_framelayout2;
    ViewGroup pigeon_framelayout3;
    ViewGroup pigeon_framelayout4;
    TextView lv_text;
    int lv = 0;
    int add_num = 1;
    int click_time = 0;
    TextView lv_plus_view;
    TextView function_title;
    Button function_1;
    Button function_2;
    EditText name;
    String save_name;


// 적 관련 변수
    TextView enemey_health;
    public ImageView enemey_image;
    TextView enemey_lv;
    TextView enemey_name;


    int now_enemey_health;
    int now_enemey_lv;
    Enemey_class enemey1_pigeon;
    Enemey_class enemey2_cat;
    Enemey_class enemey3_eagle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.game_playview);





        enemey_image = (ImageView) findViewById(R.id.enemey_image);
        lv_text = (TextView) findViewById(R.id.lv_text);
        lv_plus_view = (TextView) findViewById(R.id.lv_plus_view);

        pigeon_1 = (ImageView) findViewById(R.id.pigeon_1);

        main_layout = (ViewGroup) findViewById(R.id.main_relative);
        pigeon_framelayout = (ViewGroup) findViewById(R.id.pigeon_framelayout);
        pigeon_framelayout2 = (ViewGroup) findViewById(R.id.pigeon_framelayout);
        pigeon_framelayout3 = (ViewGroup) findViewById(R.id.pigeon_framelayout);
        pigeon_framelayout4 = (ViewGroup) findViewById(R.id.pigeon_framelayout);
        String[] location = new String[2];
        location[0] = "x";
        location[1] = "y";


        Movable_Layout_Class new_movable_button = new Movable_Layout_Class(this, main_layout, pigeon_framelayout, location, "scale", false);
        pigeon_framelayout.setVisibility( View.VISIBLE);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) pigeon_framelayout
                .getLayoutParams();
        layoutParams.leftMargin = 100;
        layoutParams.topMargin = 100;
        pigeon_framelayout.setLayoutParams(layoutParams);


        Movable_Layout_Class new_movable_button2 = new Movable_Layout_Class(this, main_layout, pigeon_framelayout2, location, "scale", false);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) pigeon_framelayout2
                .getLayoutParams();
        layoutParams2.leftMargin = 50;
        layoutParams2.topMargin = 100;
        pigeon_framelayout2.setLayoutParams(layoutParams2);

        Movable_Layout_Class new_movable_button3 = new Movable_Layout_Class(this, main_layout, pigeon_framelayout3, location, "scale", false);
        FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) pigeon_framelayout3
                .getLayoutParams();
        layoutParams3.leftMargin = 50;
        layoutParams3.topMargin = 100;
        pigeon_framelayout3.setLayoutParams(layoutParams2);

        Movable_Layout_Class new_movable_button4 = new Movable_Layout_Class(this, main_layout, pigeon_framelayout4, location, "scale", false);
        FrameLayout.LayoutParams layoutParams4 = (FrameLayout.LayoutParams) pigeon_framelayout4
                .getLayoutParams();
        layoutParams4.leftMargin = 50;
        layoutParams4.topMargin = 100;
        pigeon_framelayout4.setLayoutParams(layoutParams2);

        function_1 = (Button) findViewById(R.id.function_1);
        function_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO : click event

                add_num = add_num + 1;
                lv_plus_view.setText("+" + add_num);
            }
        });

        function_2 = (Button) findViewById(R.id.function_2);
        function_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO : click event
                pigeon_framelayout.setVisibility(View.VISIBLE);
                pigeon_framelayout2.setVisibility(View.VISIBLE);

                pigeon_framelayout3.setVisibility(View.VISIBLE);


//                click_time = click_time+1;
//                if(click_time == 1){
//                    pigeon_framelayout2.setVisibility(View.VISIBLE);
//                }else if(click_time ==2){
//                    pigeon_framelayout2.setVisibility(View.INVISIBLE);
//                    pigeon_framelayout3.setVisibility(View.VISIBLE);
//                }else if(click_time ==3){
//                    pigeon_framelayout3.setVisibility(View.INVISIBLE);
//                    pigeon_framelayout4.setVisibility(View.VISIBLE);
//                }
            }
        });



        function_title = (TextView) findViewById(R.id.function_title);
        function_title.setTextSize(20);

        name = (EditText) findViewById(R.id.name);
        save_name = name.getText().toString();


//        //원본 이미지 Bitmap
//        Bitmap originalImg = BitmapFactory.decodeResource(getResources(), R.drawable.pigeon_1);
////좌우반전 이미지 효과 및 Bitmap 만들기
//        Matrix sideInversion = new Matrix();
//        sideInversion.setScale(-1, 1);
//        Bitmap sideInversionImg = Bitmap.createBitmap(originalImg, 0, 0,
//                originalImg.getWidth(), originalImg.getHeight(), sideInversion, false);
//        enemey_image.setImageBitmap(sideInversionImg);

        enemey_health = (TextView) findViewById(R.id.enemey_health);
        enemey_lv = (TextView) findViewById(R.id.enemey_level);
        enemey_name = (TextView) findViewById(R.id.enemey_name);

        enemey1_pigeon = new Enemey_class(100, "비둘기대왕", 1);
        enemey2_cat = new Enemey_class(200, "길고양이",2);
        enemey3_eagle = new Enemey_class(500, "독수리", 3);

        change_enemey(enemey1_pigeon.health, enemey1_pigeon.name, enemey1_pigeon.enemey_lv);



        pigeon_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO : click event

//                lv = lv + add_num;
//                lv_text.setText(lv + " 레벨");
//                lv_plus_view.setVisibility(View.VISIBLE);
//                new Handler().postDelayed(new Runnable()
//                {
//                    @Override
//                    public void run()
//                    {
//                        //여기에 딜레이 후 시작할 작업들을 입력
//
//                        lv_plus_view.setVisibility(View.INVISIBLE);
//                    }
//                }, 500);// 0.5초 정도 딜레이를 준 후 시작

//                enemey2_cat.health =  enemey2_cat.health - 10;
                attack();
            }
        });
    }//oncreate 끝

    private void attack() {

        if(enemey_image.getX()-pigeon_1.getX()<10){
            now_enemey_health = now_enemey_health - 10;
            enemey_health.setText("체력 : "+ now_enemey_health + "");
        }
        if(now_enemey_health == 0){
            if(now_enemey_lv == 1) {
                change_enemey(enemey2_cat.health, enemey2_cat.name, enemey2_cat.enemey_lv);
            }else if(now_enemey_lv == 2){
                change_enemey(enemey3_eagle.health, enemey3_eagle.name, enemey3_eagle.enemey_lv);
            }
        }
    }

    private void change_enemey(int health, String name,int level){
        now_enemey_health = health;
        now_enemey_lv = level;

        enemey_health.setText("체력 : "+health+ "");
        enemey_name.setText(name);
        enemey_lv.setText("lv : "+level);

        Bitmap originalImg = BitmapFactory.decodeResource(getResources(), R.drawable.pigeon_1);
        if(level == 1) {
            originalImg = BitmapFactory.decodeResource(getResources(), R.drawable.pigeon_1);
        }else if(level == 2){
            originalImg = BitmapFactory.decodeResource(getResources(), R.drawable.cat);
        }else if(level == 3){
            originalImg = BitmapFactory.decodeResource(getResources(), R.drawable.eagle);

        }
//좌우반전 이미지 효과 및 Bitmap 만들기
        Matrix sideInversion = new Matrix();
        sideInversion.setScale(-1, 1);
        Bitmap sideInversionImg = Bitmap.createBitmap(originalImg, 0, 0,
                originalImg.getWidth(), originalImg.getHeight(), sideInversion, false);
        enemey_image.setImageBitmap(sideInversionImg);
    }

    class Enemey_class{
        int health;
        int enemey_lv;
        String name;
        ImageView character_img;
        ImageView Img_effect;

        private Enemey_class(int input_health, String input_name, int input_enemey_lv){
            health = input_health;
            name = input_name;
            enemey_lv = input_enemey_lv;
        }

        void data_setting(){
            health = health - 10;
        }

    }
}
