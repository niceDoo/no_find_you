package com.example.louis.no_find_you;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


//-------------------------------------------------------------------------------------------------------------- no find you
//-------------------------------------------------------------------------------------------------------------- 회원가입 시켜라  요청을 보내는  Register Request 클래스
public class Login_2_sign_up_page_Register_Request extends StringRequest{

    final static private String URL = "http://wasso.co.kr";
    private Map<String,String> parameters;



    public Login_2_sign_up_page_Register_Request( String userEmail, String userPassword, String userPassword_again, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        parameters = new HashMap<>();

        parameters.put("userEmail",userEmail);
        parameters.put("userPassword",userPassword);
        parameters.put("userPassword_again",userPassword_again);

    }

    @Override
    public Map<String, String> getParams() {

        return parameters;
    }
}
