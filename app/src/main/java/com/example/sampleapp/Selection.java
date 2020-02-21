package com.example.sampleapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.List;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Selection extends AppCompatActivity{


    EditText fname,lname,reg_email,reg_password;
    Button reg,signup ;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_selection);

       signup =findViewById(R.id.signUp);

       signup.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               signupButtonClicked();
           }
       });

          }







private void regButtonClicked(){
    if (TextUtils.isEmpty(fname.getText().toString().trim())){
        fname.setError("Your message");
        return;

    }else{
        //what should be done if all parameters are correct
        //connection to presenter
    }

}
private void signupButtonClicked(){
    {

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.register, null);
        dialog.setView(dialogView);


        fname = dialogView.findViewById(R.id.reg_firstName);
        lname = dialogView.findViewById(R.id.reg_lastName);
        reg_email = dialogView.findViewById(R.id.reg_email);
        reg_password = dialogView.findViewById(R.id.reg_password);
        reg=dialogView.findViewById(R.id.reg_register);

        dialog.show();

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regButtonClicked();
            }
        });


    }


    }





    }
