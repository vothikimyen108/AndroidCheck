package com.example.a1851050194_vothikimyen_buoi5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText editName, editPhone, editEmail, editPassword;
    Button btCheck;
    AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        AnhXa();
        String rexgexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\\\d])(?=.*[~`!@#\\\\$%\\\\^&\\\\*\\\\(\\\\)\\\\-_\\\\+=\\\\{\\\\}\\\\[\\\\]\\\\|\\\\;:\\\"<>,./\\\\?]).{8,}";
        awesomeValidation.addValidation(MainActivity.this,R.id.editName,"[a-zA-Z\\s]+",R.string.err_name);
        awesomeValidation.addValidation(MainActivity.this,R.id.editPhone, RegexTemplate.TELEPHONE,R.string.err_phone);
        awesomeValidation.addValidation(MainActivity.this,R.id.editEmail, Patterns.EMAIL_ADDRESS,R.string.err_email);
        awesomeValidation.addValidation(MainActivity.this,R.id.editPassword, rexgexPassword,R.string.err_password);
        btCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(awesomeValidation.validate()){
                    String name = editName.getText().toString();
                    String email = editEmail.getText().toString();
                    String phone = editPhone.getText().toString();
                    String pass = editPassword.getText().toString();
                }else {
                    Toast.makeText(getApplicationContext(),"Every thing fine",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void AnhXa() {
        editName = findViewById(R.id.editName);
        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        editPhone = findViewById(R.id.editPhone);
        btCheck = findViewById(R.id.buttonCheck);
    }
}