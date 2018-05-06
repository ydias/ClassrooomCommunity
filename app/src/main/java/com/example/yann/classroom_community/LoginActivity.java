package com.example.yann.classroom_community;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class LoginActivity extends AppCompatActivity {

    // A list of authorised users
    public ArrayList<User> authorised = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Specify the authorised users here
        authorised.add(new User("Yann","aze"));
        authorised.add(new User("Livio","iop"));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginB = (Button)findViewById(R.id.loginButton);
        final EditText loginForm = (EditText) findViewById(R.id.nameInput);
        final EditText passwordForm = (EditText) findViewById(R.id.passwordInput);

        loginB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                User testLogin = new User(loginForm.getText().toString(),passwordForm.getText().toString());
                for (Iterator<User> i = authorised.iterator(); i.hasNext();) {
                    User user = i.next();
                    if( (loginForm.getText().toString().equals(user.login) ) && (passwordForm.getText().toString().equals(user.pw) )) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        Bundle extra = new Bundle();
                        extra.putString("login", loginForm.getText().toString());
                        intent.putExtras(extra);
                        startActivity(intent);
                        return;
                    }
                    if ( ! i.hasNext()) {
                        Toast toast = Toast.makeText(getApplicationContext(),
                                "Login ou mdp incorrect !", Toast.LENGTH_SHORT); toast.show();
                    }
                }

            }
        });
    }

    /**
     * Data structure for a User (Login / Password)
     */
    public static class User{
        String login;
        String pw;

        public User(String login, String pw) {
            this.login = login;
            this.pw = pw;
        }

        @Override
        public String toString() {
            return "User{" +
                    "login='" + login + '\'' +
                    ", pw='" + pw + '\'' +
                    '}';
        }
    }
}


