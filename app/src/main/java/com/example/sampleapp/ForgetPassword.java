package com.example.sampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sampleapp.R;

public class ForgetPassword extends AppCompatActivity {
    EditText email_editText;
    Button forgetpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        email_editText=findViewById(R.id.forget_email);
        forgetpassword=findViewById(R.id.submit);
        forgetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PickMail();
            }
        });


    }
    //method to pick mail
    private void PickMail(){
        String mail = email_editText.getText().toString();
        Intent intent=new Intent();
        intent.putExtra("MESSAGE",mail);
        setResult(2,intent);
        finish();
    }
}
