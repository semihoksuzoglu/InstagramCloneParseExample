package com.semihoksuzoglu.instagramcloneparseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SingUpActivity extends AppCompatActivity {
    EditText usernameText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernameText = findViewById(R.id.sing_up_activity_name_text);
        passwordText = findViewById(R.id.sing_up_activity_password_text);

        ParseUser parseUser = ParseUser.getCurrentUser();
        if(parseUser!=null){
            Intent intent = new Intent(getApplicationContext(), FeedActivity.class);
            startActivity(intent);
        }


    }

    public void singIn(View view) {
        ParseUser.logInInBackground(usernameText.getText().toString(), passwordText.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null) {
                    Toast.makeText(SingUpActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SingUpActivity.this, "Welcome " + user.getUsername(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), FeedActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void singUp(View view) {
        ParseUser user = new ParseUser();
        user.setUsername(usernameText.getText().toString());
        user.setPassword(passwordText.getText().toString());

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null) {
                    Toast.makeText(SingUpActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SingUpActivity.this, "User Created", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), FeedActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
