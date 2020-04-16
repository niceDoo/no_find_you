package com.example.louis.no_find_you;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;


public class Login_1_page extends AppCompatActivity {


    EditText login_email_edit;
    EditText login_password_edit;

    TextView sign_up_tv;

    TextView join_tv;

    private String User_Email;
    private String User_Password;


    private AlertDialog alertDialog;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_1);
//-------------------------------------------------------------------------------------------------- 액티비티 세로로 고정 하는법 (가로 안됨)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        --------------------------------------------------------------------------------------------- 액션바 title / toolbar 없애기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


//         1...... 아이디 텍스트
        login_email_edit = findViewById(R.id.login_email_edit);
//         2...... 비밀번호 텍스트
        login_password_edit = findViewById(R.id.login_password_edit);
//         3...... 로그인 텍스트
        sign_up_tv = findViewById(R.id.sign_up_tv);
//         4...... 회원가입 텍스트
        join_tv = findViewById(R.id.join_tv);
//        5---------아이디 비번 찾기 텍스트




        User_Email = login_email_edit.getText().toString().trim();
        User_Password = login_password_edit.getText().toString().trim();



//---------------------------------------------------------------------------------------------------
//        2....................비밀번호 텍스트
        login_password_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//                비워있음
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                비워있음
            }

            @Override
            public void afterTextChanged(Editable text_null) {

//                패스워드 에디트 텍스트  빈 공간이면  로그인 버튼 색상이 gray이고 한자로도 생기면 보라색으로 변하게 함
                if (text_null.length() == 0){

                    sign_up_tv.setTextColor(Color.GRAY);
                    sign_up_tv.setTextSize(20);

                }else if (text_null.length() > 0){

                    sign_up_tv.setTextColor(getResources().getColor(R.color.purple));
                    sign_up_tv.setTextSize(25);
                }

            }
        });
//---------------------------------------------------------------------------------------------------------
//        3-------------------로그인 텍스트--------------------------------만들어야함
        sign_up_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Id = "louis";
                String password = "1234";

//                아이디
                if (login_email_edit.getText().toString().equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Login_1_page.this);
                    alertDialog = builder.setMessage("이메일은 빈칸 일 수 없습니다.").setPositiveButton("확인",null).create();
                    alertDialog.show();
                     return;

                }else if(!login_email_edit.getText().toString().equals(Id)){

                    AlertDialog.Builder builder = new AlertDialog.Builder(Login_1_page.this);
                    alertDialog = builder.setMessage("가입한 이메일이 아닙니다. 다시 입력해주세요").setPositiveButton("확인",null).create();
                    alertDialog.show();
                     return;
                }

//                비밀번호
                if (login_password_edit.getText().toString().equals("")) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Login_1_page.this);
                    alertDialog = builder.setMessage("비밀번호는 빈칸 일 수 없습니다.").setPositiveButton("확인", null).create();
                    alertDialog.show();
                    return;

                }else if(!login_password_edit.getText().toString().equals(password)){

                    AlertDialog.Builder builder = new AlertDialog.Builder(Login_1_page.this);
                    alertDialog = builder.setMessage("가입한 비밀번호가 아닙니다. 다시 입력해주세요.").setPositiveButton("확인",null).create();
                    alertDialog.show();
                     return;
                }

                Intent intent = new Intent(Login_1_page.this , MainActivity_1_page.class);
                startActivity(intent);



            }
        });
//        4.................회원가입
        join_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(Login_1_page.this , Login_2_sign_up_page.class);

                startActivity(intent);

            }
        });


//         5...... 로그인 유지 체크박스 버튼


























    }// End of onCreate















}// End of Login_1_page


//          if (User_Email.equals(" ")){
//               Toast.makeText(Login_1_page.this,"이메일은 빈칸 일수 없습니다.",Toast.LENGTH_SHORT).show();
//
//          }

//          if (User_Password.equals(" ")){
//              Toast.makeText(Login_1_page.this, "비밀번호는 빈칸 일 수 없습니다.", Toast.LENGTH_SHORT).show();
//          }