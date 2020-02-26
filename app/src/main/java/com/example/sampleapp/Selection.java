package com.example.sampleapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sampleapp.db.AppDatabase;
import com.example.sampleapp.db.PersonInfo;
import com.example.sampleapp.db.PersonInfoDao;

import java.util.List;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Selection extends AppCompatActivity{

        final private String TAG="";
    public static AppDatabase appDatabase;
    private EditText f_name,l_name,reg_email,reg_password,login_email,login_password;
    Button reg,signup,login ;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_selection);

       signup =findViewById(R.id.signUp);
       login= findViewById(R.id.login);
       //login fields
       login_email = findViewById(R.id.email);
       login_password = findViewById(R.id.password);


       signup.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               signupButtonClicked();
           }
       });

       login.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               loginClicked();
           }
       });

   }
   private void loginClicked(){
      String email =login_email.getText().toString().trim();
      String password =login_password.getText().toString().trim();


      AppDatabase db = Room.databaseBuilder(getApplicationContext(),
               AppDatabase.class, "persons").allowMainThreadQueries().build();


      //validating user
      //db.personInfoDao().findByEmail(email,password);

       if(db.personInfoDao().findByEmail(email,password ) != null){

         Toast.makeText(this,"success",Toast.LENGTH_SHORT).show();

       }else{


           Toast.makeText(this,"failed",Toast.LENGTH_SHORT).show();

       }


   }

 private void regButtonClicked() {

     final String fn = f_name.getText().toString().trim();
     final String ln = l_name.getText().toString().trim();
     final String rm = reg_email.getText().toString().trim();
     final String rp = reg_password.getText().toString().trim();

     if (
             TextUtils.isEmpty(f_name.getText().toString().trim()) &&
                     TextUtils.isEmpty(l_name.getText().toString().trim()) &&
                     TextUtils.isEmpty(reg_email.getText().toString().trim()) &&
                     TextUtils.isEmpty(reg_password.getText().toString().trim())
     ) {
         f_name.setError("required");
         l_name.setError("required");
         reg_email.setError("required");
         reg_password.setError("required");
         return;

     } else {
         //what should be done if all parameters are correct

         //db.AppDatabase.insertAll( );

          appDatabase = Room.databaseBuilder(getApplicationContext(),
                 AppDatabase.class, "persons").allowMainThreadQueries().build();

       //  PersonInfoDao personInfoDao = db.personInfoDao();

         PersonInfo personInfo = new PersonInfo();
         personInfo.setFname(fn);
         personInfo.setLname(ln);
         personInfo.setEmail(rm);
         personInfo.setPassword(rp);

         appDatabase.personInfoDao().insert(personInfo);


         Toast.makeText(this,"added",Toast.LENGTH_SHORT).show();

         //clear edit text
         f_name.setText("");
         l_name.setText("");
         reg_email.setText("");
         reg_password.setText("");





     }

    }

    private void signupButtonClicked () {
        {
              //EditText f_name,l_name,reg_email,reg_password;

            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            LayoutInflater inflater = getLayoutInflater();
            View dialogView = inflater.inflate(R.layout.register, null);
            dialog.setView(dialogView);

            f_name = dialogView.findViewById(R.id.reg_firstName);
            l_name = dialogView.findViewById(R.id.reg_lastName);
            reg_email = dialogView.findViewById(R.id.reg_email);
            reg_password = dialogView.findViewById(R.id.reg_password);
            reg = dialogView.findViewById(R.id.reg_register);

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
