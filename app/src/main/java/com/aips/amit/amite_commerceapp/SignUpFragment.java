package com.aips.amit.amite_commerceapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static android.graphics.Color.argb;

public class SignUpFragment extends Fragment {


    public SignUpFragment() {
        // Required empty public constructor
    }

    private TextView alreadyhaveanaccount;
    private FrameLayout parentFrameLayout;
    private EditText email;
    private EditText password;
    private EditText fullname;
    private EditText confpass;

    private ProgressBar progressBar;
    private Button signupbutton;
    private String emailpattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";
    private FirebaseAuth fireb;

    private FirebaseFirestore firestore;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_sign_up, container, false);


        alreadyhaveanaccount = view.findViewById(R.id.tv_already_have_an_account);
        parentFrameLayout = getActivity().findViewById(R.id.register_frame_layout);

        email = view.findViewById(R.id.sign_up_email);
        password = view.findViewById(R.id.sign_up_password);
        fullname = view.findViewById(R.id.sign_up_full_name);
        confpass = view.findViewById(R.id.sign_up_cnf_password);

        progressBar = view.findViewById(R.id.sign_up_progress_bar);

        signupbutton = view.findViewById(R.id.sign_up_btn);

        fireb = FirebaseAuth.getInstance();

        firestore = FirebaseFirestore.getInstance();


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        alreadyhaveanaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragemet(new SigninFragment());
            }
        });

        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEmailandPassword();
            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {
                //
            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {
                //
            }
        });
        fullname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {//
            }
        });
        confpass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {
                //
            }
        });
    }

    private void checkEmailandPassword() {
        if(email.getText().toString().matches(emailpattern))
        {
            if((password.getText().toString()).equals(confpass.getText().toString()))
            {
                progressBar.setVisibility(View.VISIBLE);
                signupbutton.setEnabled(false);
                signupbutton.setTextColor(argb(50,255,255,255));
                fireb.createUserWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Map<Object, String> userdata = new HashMap<>();
                            userdata.put("username", fullname.getText().toString());

                            firestore.collection("User")
                                    .add(userdata)
                                    .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                        @Override
                                        public void onComplete(@NonNull Task<DocumentReference> task) {
                                            if(task.isSuccessful())
                                            {
                                                Toast.makeText(getActivity(), "Registred Succesful", Toast.LENGTH_SHORT).show();
                                                sendUserToHomeAct();
                                            }
                                            else{
                                                Toast.makeText(getActivity(), task.getException().toString(), Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });



                        }
                        else
                        {
                            signupbutton.setEnabled(true);
                            signupbutton.setTextColor(Color.rgb(255,255,255));
                        }
                    }
                });
            }else{
                password.setError("Pass doesnt match");
                password.requestFocus();
            }
        }else{
            email.setError("Email doesnt entered correctly");
            email.requestFocus();
        }
    }

    private void sendUserToHomeAct() {
        Intent i = new Intent(getActivity(),HomeActivity.class);
        startActivity(i);
        getActivity().finish();
    }

    private void checkInputs() {
        if(!TextUtils.isEmpty(email.getText()))
        {
            if(!TextUtils.isEmpty(fullname.getText()))
            {
                if(!TextUtils.isEmpty(password.getText()) && password.length()>=8)
                {
                    if(!TextUtils.isEmpty(confpass.getText()))
                    {
                        signupbutton.setEnabled(true);
                        signupbutton.setTextColor(this.getResources().getColor(R.color.white));
                    }else{
                        signupbutton.setEnabled(false);
                        signupbutton.setTextColor(argb(50,255,255,255));
                    }
                }else{
                    signupbutton.setEnabled(false);
                    signupbutton.setTextColor(argb(50,255,255,255));
                }
            }else{
                signupbutton.setEnabled(false);
                signupbutton.setTextColor(argb(50,255,255,255));
            }
        }else{
            signupbutton.setEnabled(false);
            signupbutton.setTextColor(argb(50,255,255,255));
        }
    }

    private void setFragemet(Fragment fragemet) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(parentFrameLayout.getId(), fragemet);
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slideout_from_right);
        fragmentTransaction.commit();
    }
}