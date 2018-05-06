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

//public class LoginActivity extends AppCompatActivity {
//    public ArrayList<User> autorised = new ArrayList<User>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        autorised.add(new User("Yann","aze"));
//        autorised.add(new User("Livio","iop"));
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        Button loginB = (Button)findViewById(R.id.loginButton);
//        final EditText loginForm = (EditText) findViewById(R.id.nameInput);
//        final EditText passwordForm = (EditText) findViewById(R.id.passwordInput);
//
//        loginB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v){
//                User testLogin = new User(loginForm.getText().toString(),passwordForm.getText().toString());
//                for (Iterator<User> i = autorised.iterator(); i.hasNext();) {
//                    User user = i.next();
//                    if( (loginForm.getText().toString().equals(user.login) ) && (passwordForm.getText().toString().equals(user.pw) )) {
//                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                        Bundle extra = new Bundle();
//                        extra.putString("login", loginForm.getText().toString());
//                        intent.putExtras(extra);
//                        startActivity(intent);
//                        return;
//                    }
//                    if ( ! i.hasNext()) {
//                        Toast toast = Toast.makeText(getApplicationContext(),
//                                "Login ou mdp incorrect !", Toast.LENGTH_SHORT); toast.show();
//                    }
//                }
//
//            }
//        });
//    }
//    public static class User{
//        String login;
//        String pw;
//
//        public User(String login, String pw) {
//            this.login = login;
//            this.pw = pw;
//        }
//
//        @Override
//        public String toString() {
//            return "User{" +
//                    "login='" + login + '\'' +
//                    ", pw='" + pw + '\'' +
//                    '}';
//        }
//    }
//}

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.example.yann.classroom_community.BDD1.CompteDAO;

public class LoginActivity extends Activity  {
    private CompteDAO compteDAO;
    Button b1,b2;
    EditText ed1,ed2;

    TextView tx1;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        b1 = (Button)findViewById(R.id.buttonLogin);
        ed1 = (EditText)findViewById(R.id.editTextLogin);
        ed2 = (EditText)findViewById(R.id.editTextLogin2);

        b2 = (Button)findViewById(R.id.buttonLogin2);
        tx1 = (TextView)findViewById(R.id.textViewLogin3);
        tx1.setVisibility(View.GONE);

        compteDAO = new CompteDAO(this);
        compteDAO.open();
        compteDAO.instantiate();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ed1.getText().toString().equals("admin") && ed2.getText().toString().equals("admin")
                //if(compteDAO.connect(ed1.getText().toString(),ed2.getText().toString())) {
                if(true) {
                    Toast.makeText(getApplicationContext(),"Redirecting...",Toast.LENGTH_SHORT).show();
                    Handler handler = new Handler();
                    final Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    Bundle extra = new Bundle();
                    extra.putString("login", "livio");
                    intent.putExtras(extra);
                    startActivity(intent);

                    handler.postDelayed(new Runnable() { public void run() {
                        startActivity(intent);
                    }
                    }, 2000);

                    return;






                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
                    tx1.setVisibility(View.VISIBLE);
                    tx1.setBackgroundColor(Color.RED);
                    counter--;
                    tx1.setText(Integer.toString(counter));

                    if (counter == 0) {
                        b1.setEnabled(false);
                    }
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}


