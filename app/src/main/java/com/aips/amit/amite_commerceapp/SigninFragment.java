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

public class SigninFragment extends Fragment {

    public SigninFragment() {
        // Required empty public constructor
    }
    private TextView donthaveanaccount;
    private FrameLayout parentframeLayout;

    private EditText email, password;
    private Button signin_btn;
    private TextView forgetpass;
    private ProgressBar progressBar;
    private FirebaseAuth fireb;
    private String emailpattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_signin, container, false);
        donthaveanaccount = view.findViewById(R.id.tv_dont_have_an_account);
        parentframeLayout = getActivity().findViewById(R.id.register_frame_layout);

        email = view.findViewById(R.id.sign_in_email);
        password = view.findViewById(R.id.sign_in_password);
        forgetpass = view.findViewById(R.id.sign_in_forget_password);
        progressBar = view.findViewById(R.id.progressBar2);
        fireb = FirebaseAuth.getInstance();
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        donthaveanaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragement(new SignUpFragment());
            }
        });

        signin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEmailandLogin();
            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInput();
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
                checkInput();
            }

            @Override
            public void afterTextChanged(Editable s) {
                //
            }
        });
    }

    private void checkEmailandLogin() {
        if(email.getText().toString().matches(emailpattern))
        {
            progressBar.setVisibility(View.VISIBLE);
            signin_btn.setEnabled(false);
            signin_btn.setTextColor(Color.argb(50,255,255,255));
            fireb.signInWithEmailAndPassword(email.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(getActivity(), "Logged in Succesful", Toast.LENGTH_SHORT).show();
                        sendUserToHomeAct();
                    }else
                    {
                        progressBar.setVisibility(View.INVISIBLE);
                        signin_btn.setEnabled(true);
                        Toast.makeText(getActivity(), task.getException().toString(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }else{
            email.setError("Enter Correct email");
            email.requestFocus();
        }
    }

    private void sendUserToHomeAct() {
        Intent i = new Intent(getActivity(),HomeActivity.class);
        startActivity(i);
        getActivity().finish();
    }

    private void checkInput() {
        if(!TextUtils.isEmpty(email.getText()))
        {
            if(!TextUtils.isEmpty(password.getText()) && password.length()>=8)
            {
                signin_btn.setEnabled(true);
                signin_btn.setTextColor(this.getResources().getColor(R.color.white));
            }else{
                signin_btn.setEnabled(false);
                signin_btn.setTextColor(Color.argb(50,255,255,255));
            }
        }else{
            signin_btn.setEnabled(false);
            signin_btn.setTextColor(Color.argb(50,255,255,255));
        }
    }


    private void setFragement(Fragment fragement) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(parentframeLayout.getId(),fragement);
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right, R.anim.slideout_from_left);
        fragmentTransaction.commit();
    }
}