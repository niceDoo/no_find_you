package com.example.louis.no_find_you;
// --------------------------------------------------------------------Toolbar 사용 할려면 android.support.v7.widget.Toolbar; 임포트 해줘야함


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity_1_page extends AppCompatActivity{

//    1--------툴바
    Toolbar main_1_main_toolbar_custom;
    TextView main_1_toolbar__title_text_view;
    ImageButton main_1_toolbar_image_button;
    ImageButton main_1_toolbar_image_button_person;


//    2--------알림 안내문구
    TextView Notice_1;

//    3---------------------------------------카드뷰 매개변수
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter recycler_Adapter;



//    8-------구글맵 버튼
    TextView main_map_tv;
//    9------- 개인정보 버튼
    TextView main_setting_tv;




    private AlertDialog alertDialog;

    String User_Email;
    String User_Password;
    String User_Id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main_1_page);



//        1---------커스텀 툴바
        main_1_main_toolbar_custom = findViewById(R.id.main_1_main_toolbar_custom);
        main_1_toolbar__title_text_view = main_1_main_toolbar_custom.findViewById(R.id.main_1_toolbar__title_text_view);
        main_1_toolbar_image_button = main_1_main_toolbar_custom.findViewById(R.id.main_1_toolbar_image_button);
        main_1_toolbar_image_button_person = main_1_main_toolbar_custom.findViewById(R.id.main_1_toolbar_image_button_person);



//        2-------- 알림 안내 문구
        Notice_1 = findViewById(R.id.Notice_1);

//        3------- 리사이클 카드뷰
        recyclerView = findViewById(R.id.recycle_view);


//        8------main map 버튼
        main_map_tv = findViewById(R.id.main_map_tv);
//        9------main setting 버튼
        main_setting_tv = findViewById(R.id.main_setting_tv);






//----------------------------------------------------------------------------------------------------
//        1---------커스텀 툴바
        setSupportActionBar(main_1_main_toolbar_custom);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
//-----------------------------------------------------------------------------------------------------
//        2---------알림 안내 문자 문구
        Notice_1.setSelected(true);
//-----------------------------------------------------------------------------------------------------
//        3---------리스트뷰 - 카드뷰 어댑터
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recycler_Adapter = new MainActivity_2_page_RecyclerAdapter();
        recyclerView.setAdapter(recycler_Adapter);







//--------------------------------------------------------------------------------------------------- 버튼 2 -관심 지역 버튼 ------------ 현재 위치 구글맵
//        8--------- 구글맵
        main_map_tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent main_map_textview_Intent = new Intent(MainActivity_1_page.this , MainActivity_9_page_Google_Map_Fragment.class);

                startActivity(main_map_textview_Intent);

                Toast.makeText(MainActivity_1_page.this, "구글지도 맵으로 이동합니다. 현재위치 ", Toast.LENGTH_SHORT).show();
            }
        });


//--------------------------------------------------------------------------------------------------------버튼 5 setting - my profile 액티비티  Login_3_ 에서 가져옴
//        9---------setting 액티비티 버튼
        main_setting_tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent MainActivity_1_page_intent = new Intent(MainActivity_1_page.this , MainActivity_8_page_Profile.class);

                MainActivity_1_page_intent.putExtra("userEmail", User_Email);
                MainActivity_1_page_intent.putExtra("userPassword", User_Password);
                MainActivity_1_page_intent.putExtra("userId" , User_Id);


                startActivity(MainActivity_1_page_intent);
            }
        });



//        받아온 인텐트 / 아이디 이메일 비밀번호
        final Intent MainActivity_3_sign_up_page_intent = getIntent();

        User_Email  = MainActivity_3_sign_up_page_intent.getStringExtra("userEmail");
        User_Password =MainActivity_3_sign_up_page_intent.getStringExtra("userPassword");
        User_Id =MainActivity_3_sign_up_page_intent.getStringExtra("userId");



//-------------------------------------------------------------------------------------------------- Login_3_sign_up_profile_page 에서 넘어온 객체  알림창 띄우기

//        Login_3_sign_up_profile_page 에서 넘어온 객체  알림창 띄우기

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity_1_page.this);

        alertDialog = builder.setTitle("find you 가족이 되신걸 축하드립니다. ")
                .setMessage("이메일 : " + User_Email + '\n' + "비밀번호 : " + User_Password +'\n' + "아이디 :" + User_Id )
                .setPositiveButton("Yes ", null)
                .create();

        alertDialog.show();

































    } // onCreate End

//----------------------------------------------------------------------------------------------------





















}// class End
