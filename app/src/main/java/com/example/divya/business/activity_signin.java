package com.example.divya.business;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;



import java.security.Security;
import java.util.Map;

public class activity_signin extends AppCompatActivity {
    private EditText user, password;
    private TextView tv;
    private Button button;
    FirebaseDatabase database;
    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        tv = (TextView) findViewById(R.id.textView4);
        button = (Button) findViewById(R.id.button);
        user = (EditText) findViewById(R.id.editText3);
        password = (EditText) findViewById(R.id.editText5);
        database = FirebaseDatabase.getInstance();
        users = database.getReference().child("Users");
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login();
            }
        });
    }

    public void openActivity2() {
        Intent intent = new Intent(this, activity_signup.class);
        startActivity(intent);
        finish();
    }

    private void login() {
        final String username=user.getText().toString();
        final String passw=password.getText().toString();
        Query query = users.orderByChild("name").equalTo(username);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {


                    for (DataSnapshot user : dataSnapshot.getChildren()) {

                        User usersBean = user.getValue(User.class);

                        if (usersBean.password.equals(passw) ){
                            Intent intent=new Intent(activity_signin.this,activity_first.class);
                            startActivity(intent);
                            Toast.makeText(activity_signin.this, "Login Successful", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(activity_signin.this, "Incorrect Password", Toast.LENGTH_LONG).show();
                        }
                    }
                } else {
                    Toast.makeText(activity_signin.this, "User not found,Do Signup", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        }
    }

