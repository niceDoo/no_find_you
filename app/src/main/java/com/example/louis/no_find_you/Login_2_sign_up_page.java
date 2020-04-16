package com.example.louis.no_find_you;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

//  임포트 해줘야 함

public class Login_2_sign_up_page extends AppCompatActivity {

//    1--------툴바
    Toolbar main_1_main_toolbar_custom;
    TextView main_1_toolbar__title_text_view;
    ImageButton main_1_toolbar_image_button;
    ImageButton main_1_toolbar_image_button_person;

    private EditText join_email_edit;
    private EditText join_password_edit;
    private EditText join_password_edit_confirm;

    private Button join_join_button;




    private AlertDialog alertDialog;

    String User_Email;
    String User_Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_login_2_sign_up_page);

//---------------------------------------------------------------------------------------------------  커스텀 toolbar

//        1---------커스텀 툴바
        main_1_main_toolbar_custom = findViewById(R.id.main_1_main_toolbar_custom);
        main_1_toolbar__title_text_view = main_1_main_toolbar_custom.findViewById(R.id.main_1_toolbar__title_text_view);
        main_1_toolbar_image_button = main_1_main_toolbar_custom.findViewById(R.id.main_1_toolbar_image_button);
        main_1_toolbar_image_button_person = main_1_main_toolbar_custom.findViewById(R.id.main_1_toolbar_image_button_person);



        setSupportActionBar(main_1_main_toolbar_custom);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

//        1--------- 이메일
        join_email_edit = findViewById(R.id.join_email_edit);
//        2----------비밀번호
        join_password_edit = findViewById(R.id.join_password_edit);
//        3----------비밀번호 확인
        join_password_edit_confirm = findViewById(R.id.join_password_edit_confirm);
//        3---------- 비밀번호  2번 3번 체크 확인
        final TextView join_password_edit_check_2 = (TextView) findViewById(R.id.join_password_edit_check_2);

//        4----------회원가입 페이지로 이동 버튼
        join_join_button = findViewById(R.id.join_join_button);




//----------------------------------------------------------------------------------------------------
//        1---------커스텀 툴바
        setSupportActionBar(main_1_main_toolbar_custom);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


//--------------------------------------------------------------------------------------------------- 비밀번호 체크 확인
//        3.............비밀번호  2번 3번 체크 확인
        join_password_edit_confirm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (join_password_edit_confirm.getText().toString().equals(join_password_edit.getText().toString())){

                    join_password_edit_check_2.setText("비밀번호가 일치합니다.");
                    join_password_edit_check_2.setTextColor(Color.BLACK);

                }
                if (!join_password_edit_confirm.getText().toString().equals(join_password_edit.getText().toString())){

                    join_password_edit_check_2.setText("비밀번호가 일치하지 않습니다, 다시 입력해주세요");
                    join_password_edit_check_2.setTextColor(Color.RED);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

//--------------------------------------------------------------------------------------------------------2단계 회원가입 페이지 이동 버튼
//        4.............회원가입 페이지로 이동 버튼
        join_join_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (join_email_edit.getText().toString().equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Login_2_sign_up_page.this);
                    alertDialog = builder.setMessage("이메일은 빈칸 일 수 없습니다.").setPositiveButton("확인",null).create();
                    alertDialog.show();
                    return;
                }
                if (join_password_edit.getText().toString().length() == 0){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Login_2_sign_up_page.this);
                    alertDialog = builder.setMessage("비밀번호는 빈칸 일 수 없습니다.").setPositiveButton("확인",null).create();
                    alertDialog.show();
                    return;
                }
                if (join_password_edit_confirm.getText().toString().length() == 0){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Login_2_sign_up_page.this);
                    alertDialog = builder.setMessage("비밀번호는 빈칸 일 수 없습니다.").setPositiveButton("확인",null).create();
                    alertDialog.show();
                    return;
                }
                if (!join_password_edit.getText().toString().equals(join_password_edit_confirm.getText().toString())){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Login_2_sign_up_page.this);
                    alertDialog = builder.setMessage("비밀번호를 다시 수정해주세요 ").setPositiveButton("확인",null).create();
                    alertDialog.show();
                    return;
                }



                Intent Login_2_sign_up_page_intent = new Intent(Login_2_sign_up_page.this , Login_3_sign_up_profile_page.class);


                Login_2_sign_up_page_intent.putExtra("userEmail" , User_Email = join_email_edit.getText().toString());
                Login_2_sign_up_page_intent.putExtra("userPassword" , User_Password = join_password_edit.getText().toString());

                startActivity(Login_2_sign_up_page_intent);


            }
        });



    }// End of onCreate



}

