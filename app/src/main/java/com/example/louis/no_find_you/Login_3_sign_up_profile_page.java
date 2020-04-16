package com.example.louis.no_find_you;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class Login_3_sign_up_profile_page extends AppCompatActivity {

//    1--------툴바
    Toolbar main_1_main_toolbar_custom;
    TextView main_1_toolbar__title_text_view;
    ImageButton main_1_toolbar_image_button;
    ImageButton main_1_toolbar_image_button_person;



//    1----아이디
    EditText profile_id_edit;
    TextView profile_id_edit_check;
//    2-----생년월일
    EditText profile_birthday_edit;
    TextView profile_birthday_edit_2;
    TextView profile_birthday_edit_check;
//    3-----랭귀지 언어 설정 ????



//    4------- 라디오 그룹
    RadioGroup profile_GenderGroup;
    RadioButton gender_male_radio_check;
    RadioButton gender_female_radio_check;

//    5------버튼
    Button profile_completion_button;

    private AlertDialog alertdialog;

    String User_Email;
    String User_Password;
    String User_Id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_login_3_sign_up_profile_page);



//        1---------커스텀 툴바
        main_1_main_toolbar_custom = findViewById(R.id.main_1_main_toolbar_custom);
        main_1_toolbar__title_text_view = main_1_main_toolbar_custom.findViewById(R.id.main_1_toolbar__title_text_view);
        main_1_toolbar_image_button = main_1_main_toolbar_custom.findViewById(R.id.main_1_toolbar_image_button);
        main_1_toolbar_image_button_person = main_1_main_toolbar_custom.findViewById(R.id.main_1_toolbar_image_button_person);




//--------------------------------------------------------------------------------------------------
//        첫번째 이미지 뷰


//-------------------------------------------------------------------------------------------------- 아이디
//        1--------아이디 / 아이디
        profile_id_edit = findViewById(R.id.profile_id_edit);
        profile_id_edit_check = findViewById(R.id.profile_id_edit_check);

//        2---------생년월일 / 생년월일
        profile_birthday_edit = findViewById(R.id.profile_birthday_edit);
        profile_birthday_edit_check = findViewById(R.id.profile_birthday_edit_check);

//        3---------- / 중복 텍스트뷰
        EditText c = (EditText) findViewById(R.id.profile_language_edit);
        TextView profile_language_edit_check = (TextView) findViewById(R.id.gender_male_radio_check);

//        4-----------라디오그룹 / 라디오버튼 /
        profile_GenderGroup = findViewById(R.id.genderGroup);

        gender_male_radio_check = findViewById(R.id.gender_male_radio_check);
        gender_female_radio_check = findViewById(R.id.gender_female_radio_check);

//       5-----------프로파일 완료 버튼 completion
        profile_completion_button = findViewById(R.id.profile_completion_button);





//----------------------------------------------------------------------------------------------------
//        1---------커스텀 툴바
        setSupportActionBar(main_1_main_toolbar_custom);
        getSupportActionBar().setDisplayShowTitleEnabled(false);



//--------------------------------------------------------------------------------------------------
        profile_completion_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent Login_3_sign_up_profile_page_intent = new Intent(Login_3_sign_up_profile_page.this , MainActivity_1_page.class);


                Login_3_sign_up_profile_page_intent.putExtra("userEmail",User_Email);
                Login_3_sign_up_profile_page_intent.putExtra("userPassword",User_Password);

                Login_3_sign_up_profile_page_intent.putExtra("userId",User_Id = profile_id_edit.getText().toString());


                startActivity(Login_3_sign_up_profile_page_intent);

                Toast.makeText(Login_3_sign_up_profile_page.this, "User_Id :" + User_Id, Toast.LENGTH_SHORT).show();


            }
        });

//-------------------------------------------------------------------------------------------------- Login_2_sign_up_page  에서 받아온 이메일 패스워드 인텐트 --
//       받아온 이메일 패스워드 인텐트 --- 넘겨주기
        Intent login_2_sign_up_page_intent = getIntent();

        User_Email = login_2_sign_up_page_intent.getStringExtra("userEmail");             // Login_2_sign_up_page 에서 가져옴
        User_Password = login_2_sign_up_page_intent.getStringExtra("userPassword");       // Login_2_sign_up_page 에서 가져옴













    }// onCreate End




}


//    알림창 확인 , 취소 버튼으로 적용할 경우
//-------------------------------------------------------------------------------------------------- 알림창 확인 , 취소 버튼으로 적용할 경우

//        AlertDialog.Builder alert_confirm = new AlertDialog.Builder(MyActivity.this);
//        alert_confirm.setMessage("프로그램을 종료 하시겠습니까?").setCancelable(false).setPositiveButton("확인",
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        // 'YES'
//                    }
//                }).setNegativeButton("취소",
//                new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        // 'No'
//                        return;
//                    }
//                });
//        AlertDialog alert = alert_confirm.create();
//        alert.show();
