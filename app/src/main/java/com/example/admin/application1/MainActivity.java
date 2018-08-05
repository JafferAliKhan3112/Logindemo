package com.example.admin.application1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected EditText edt1,edt2,edt3;
    protected Button but1;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();

    }

    public void addListenerOnButton(){

        Button but1 = findViewById(R.id.signup);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edt1 = findViewById(R.id.uname);
                EditText edt2 = findViewById(R.id.psswd);
                EditText edt3 = findViewById(R.id.psswd1);
                String usn = edt1.getText().toString().trim();
                String pwd = edt2.getText().toString().trim();
                String pwdag = edt3.getText().toString().trim();
                if(pwd.equals(pwdag)) {
                    Intent push = new Intent(MainActivity.this, ScreenOne.class);
                    push.putExtra("username", usn);
                    push.putExtra("password", pwd);
                    push.putExtra("passwordagain", pwdag);
                    startActivity(push);
                } else {
                    Toast.makeText(MainActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }
}
