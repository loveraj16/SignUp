package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText user1,pswd1;
    TextView txt;
    Button signin;
    int count=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        user1=(EditText)findViewById(R.id.editTextTextPersonName2);
        pswd1=(EditText)findViewById(R.id.editTextTextPassword2);
        txt=(TextView)findViewById(R.id.textView);
        signin=(Button)findViewById(R.id.button2);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userid1=user1.getText().toString();
                String pwd=pswd1.getText().toString();
                Bundle dataout=getIntent().getExtras();
                String password=dataout.getString(userid1);
                txt.setText(password);

                if(pwd.equals(password)){
                    Toast.makeText(MainActivity2.this,"Login Successful",Toast.LENGTH_LONG).show();
                }else{
                    count--;
                    if(count==0){
                        signin.setEnabled(false);
                    }
                }

            }
        });
    }
}