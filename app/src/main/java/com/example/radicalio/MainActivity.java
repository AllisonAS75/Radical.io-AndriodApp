package com.example.radicalio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText emailId;
    Switch switchColor;
    Button nextActivityBtn;
    LinearLayout currentLayout;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentLayout = (LinearLayout) findViewById(R.id.parent);

        button = findViewById(R.id.btnValidate);
        emailId = findViewById(R.id.editTextTextEmailAddress);
        switchColor = findViewById(R.id.switchColor);
        nextActivityBtn = findViewById(R.id.btnNextActivity);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emailId.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Enter email address", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (emailId.getText().toString().trim().matches(emailPattern)) {
                        Toast.makeText(getApplicationContext(),"Valid email address",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        nextActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myItent = new Intent(MainActivity.this, ImageView.class);
                MainActivity.this.startActivity(myItent);
            }
        });

        switchColor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    currentLayout.setBackgroundColor(Color.CYAN);
                } else {
                    currentLayout.setBackgroundColor(Color.MAGENTA);
                }
            }
        });
    }
}