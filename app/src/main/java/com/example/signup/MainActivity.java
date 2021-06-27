package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText user,pwd;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText)findViewById(R.id.editTextTextPersonName);
        pwd=(EditText)findViewById(R.id.editTextTextPassword);
        signup=(Button)findViewById(R.id.button);

        String regp1="[^a-zA-Z0-9]";

        Pattern p1=Pattern.compile(regp1);
        Pattern p2=Pattern.compile("(?=.*[a-z])");
        Pattern p3=Pattern.compile("(?=.*[A-Z])");
        Pattern p4=Pattern.compile("(?=.*[0-9])");

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uid= user.getText().toString();
                String password= pwd.getText().toString();

                Matcher m1=p1.matcher(password);
                Matcher m2=p2.matcher(password);
                Matcher m3=p3.matcher(password);
                Matcher m4=p4.matcher(password);

                Boolean isSpecialChar=m1.find();
                Boolean isLowerAlpha=m2.find();
                Boolean isCapAlpha=m3.find();
                Boolean isDigit=m4.find();

                int pwdlen=password.length();

                if(isSpecialChar && isLowerAlpha && isCapAlpha && isDigit && pwdlen>=8)
                {
                    Intent srcIntent=new Intent(MainActivity.this,MainActivity2.class);
                    Bundle bundle=new Bundle();
                    bundle.putString(uid,password);
                    srcIntent.putExtras(bundle);
                    startActivity(srcIntent);

                }else{
                    Toast.makeText(MainActivity.this,"pwd must consists of Capital,small,num and special chars",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}