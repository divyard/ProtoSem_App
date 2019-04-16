package com.example.divya.business;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.ProviderQueryResult;
import com.google.firebase.database.FirebaseDatabase;

public class activity_signup extends AppCompatActivity {
    private EditText username,email,password;
    private Button button;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    public boolean a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        username=(EditText) findViewById(R.id.editText);
        email=(EditText) findViewById(R.id.editText2);
        password=(EditText) findViewById(R.id.editText3);
        button=(Button) findViewById(R.id.button);
        progressBar = (ProgressBar)findViewById(R.id.progressBar3) ;
        progressBar.setVisibility(View.GONE);
        mAuth=FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }

        });
    }



    private void registerUser(){
        final String name=username.getText().toString().trim();
        final String emailid=email.getText().toString().trim();
        final String pass=password.getText().toString().trim();

        if(name.isEmpty()) {
            Toast.makeText(this,"Please enter username",Toast.LENGTH_LONG).show();

            return;
        }
        if(emailid.isEmpty()) {
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();

            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(emailid).matches()){
            Toast.makeText(this,"Please enter a valid email",Toast.LENGTH_LONG).show();

            return;
        }


        if(pass.isEmpty()) {
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();

            return;
        }

        if(pass.length()<6)
        {
            Toast.makeText(this,"Password should be atleast 6 characters long",Toast.LENGTH_LONG).show();

            return;
        }



            mAuth.fetchProvidersForEmail(emailid).addOnCompleteListener(new OnCompleteListener<ProviderQueryResult>() {
                public  void onComplete(@NonNull Task <ProviderQueryResult> task){
                    boolean check = !task.getResult().getProviders().isEmpty();

                    if(check)
                    {
                        Toast.makeText(activity_signup.this,"This email has been registered already",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        progressBar.setVisibility(View.VISIBLE);
                        mAuth.createUserWithEmailAndPassword(emailid, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful())
                                {
                                    User user=new User(
                                            name,
                                            emailid,
                                            pass
                                    );
                                    FirebaseDatabase.getInstance().getReference("Users")
                                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        public void onComplete(@NonNull Task<Void> task) {
                                            progressBar.setVisibility(View.GONE);
                                            if (task.isSuccessful()) {
                                                Toast.makeText(activity_signup.this, "Registration Successfull", Toast.LENGTH_SHORT).show();
                                                Intent intent=new Intent(activity_signup.this,activity_signin.class);
                                                startActivity(intent);

                                            }
                                            else
                                            {
                                                Toast.makeText(activity_signup.this, "Registration Failed,Try Again", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                                }else{
                                    Toast.makeText(activity_signup.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                }

                            }
                        });
                    }


                }
            });







    }




}
