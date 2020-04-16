package com.example.louis.no_find_you;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class MainActivity_8_page_Profile extends AppCompatActivity {

//    1--------툴바
    Toolbar main_8_setting_toolbar_custom;
    TextView setting_8_toolbar__title_tv;


//    이미지뷰 사진


//    아이디
    TextView setting_get_id_tv;
//    성별
    TextView setting_get_gender_tv;

//    이메일
    TextView setting_get_email_tv;
//    비밀번호
    TextView setting_get_password_tv;


    TextView setting_get_name_tv;
    TextView setting_get_birth_day_tv;
    TextView setting_get_phone_tv;
    TextView setting_get_state_tv;



    String User_Id;
    String user_Gender;
    String User_Email;
    String User_Password;

    private AlertDialog alertDialog;


//---------------------------------------------------------------------------------------------------받아온 인텐트 객체는 위에 있어야 가져옴 맨아래 있으면 가져오질 못함 (이상함)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main_8_page_profile);

// --------받아온 인텐트 / 아이디 이메일 비밀번호
        User_Id = getIntent().getExtras().getString("userId");
        User_Email = getIntent().getExtras().getString("userEmail");
        User_Password = getIntent().getExtras().getString("userPassword");







//        1---------커스텀 툴바
        main_8_setting_toolbar_custom = findViewById(R.id.main_8_setting_toolbar_custom);
        setting_8_toolbar__title_tv = main_8_setting_toolbar_custom.findViewById(R.id.setting_8_toolbar__title_tv);




//        아이디 -------------------------------------------------------------------------------------아이디
        setting_get_id_tv = findViewById(R.id.setting_get_id_tv);
//        성별-----------------------------------------------------------------------------------------
//        setting_get_gender_tv = findViewById(R.id.setting_get_gender_tv);
//        이메일---------------------------------------------------------------------------------------
        setting_get_email_tv = findViewById(R.id.setting_get_email_tv);
//        비밀번호--------------------------------------------------------------------------------------
        setting_get_password_tv = findViewById(R.id.setting_get_password_tv);













//----------------------------------------------------------------------------------------------------
//        1---------커스텀 툴바
        setSupportActionBar(main_8_setting_toolbar_custom);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        setting_8_toolbar__title_tv.setText("My setting");
        setting_8_toolbar__title_tv.setTextSize(45);// 45sp 사이즈






        setting_get_id_tv.setText(User_Id);
        setting_get_email_tv.setText(User_Email);
        setting_get_password_tv.setText(User_Password);






    }// End of onCreate




}
