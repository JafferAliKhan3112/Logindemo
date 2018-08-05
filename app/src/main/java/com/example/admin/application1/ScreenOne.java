package com.example.admin.application1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ScreenOne extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen1);
        getData();
    }

    public void getData() {
        TextView txt = findViewById(R.id.cd);
        TextView txt1 = findViewById(R.id.cd1);
        Intent i = getIntent();
        final String user = i.getStringExtra("username");
        final String psswd = i.getStringExtra("password");
        txt.setText("Your Username is: " + user);
        txt1.setText("Your Password is: " + psswd);
        final CheckBox cb = findViewById(R.id.terms);
        Button but2 = findViewById(R.id.subs);
        final EditText Email = findViewById(R.id.email);

        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cb.isChecked()) {
                    Intent intent = new Intent(ScreenOne.this, ScreenTwo.class);
                    String mail = Email.getText().toString().trim();
                    intent.putExtra("mailid", mail);
                    startActivity(intent);
                } else {
                    Toast.makeText(ScreenOne.this, "Please accept the terms & conditions", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
