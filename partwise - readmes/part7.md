# Part 7 : [Setting Up the `LoginFragment.java` using `FirebaseAuth`](https://youtu.be/9jt4Lf2B0I8 "part 7)
**Part 1**: Let's start with assigning the `EditText`, `Sign in Button`, `  ProgressBar` and `Close Button` values in `SignInFragment.java`
```
private EditText email, password;
private Button signin_btn;
private TextView forpass;
private ProgressBar progressBar;
private ImageButton close_btn;
```
***
**Part 2**: Lets Assign it by its Id's:
```
email = view.findViewById(R.id.sign_in_email);

        password = view.findViewById(R.id.sign_in_password);

        forpass = view.findViewById(R.id.sign_in_forgot_password);

        progressBar = view.findViewById(R.id.signin_progress_bar);

        signin_btn = view.findViewById(R.id.sign_in_btn);

        close_btn = view.findViewById(R.id.sign_in_close_btn);
```
***
**Part 3** : We will check whether the user has entered `email` or not and also matching with its _pattern_ or not.

Set a TextChanged Listener on user entered email:
>email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
}
@Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInput();// **Create this method**
            }
@Override
            public void afterTextChanged(Editable s) {
}
        });


and set a `addTextChangedListener` on `password` as well:
>password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
}
@Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInput(); // **Same Method as defined in email**
            }
@Override
            public void afterTextChanged(Editable s) {
}
        });


Part 4 : **We will create above Method i.e. `checkInput()`** in `SignInFragment.java`

```
private void checkInput() {
        if(!TextUtils.isEmpty(email.getText()))
        {
            if(!TextUtils.isEmpty(password.getText()))
            {
                signin_btn.setEnabled(true);
                signin_btn.setTextColor(Color.rgb(255,255,255));
            }else{
                signin_btn.setEnabled(false);
                signin_btn.setTextColor(Color.argb(50,255,255,255));
            }
        }else{
            signin_btn.setEnabled(false);
            signin_btn.setTextColor(Color.argb(50,255,255,255));
        }
    }
```

Part 5 : Now set a `ClickListener` on `signin` button in `onViewCreated` Method

```
signin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEmailandPassword();
            }
        });
```
***
***Create Method `checkEmailandPassword()` but before that declare `FirebaseAuth` in SignInFragment.java so as to sign in user using `Firebase`***
>private FirebaseAuthfireb;

In the `onCreateView` Method declare :
>fireb = FirebaseAuth.getInstance();
***

Part 6 : Create Method `checkEmailandPassword()` in `SignInFragment.java` and `SignIn` using `Firebase` as :
```
private void checkEmailandPassword() {
        if(email.getText().toString().matches(emailPattern))
        {
            if(password.length()>=8)
            {

                progressBar.setVisibility(View.VISIBLE);
                signin_btn.setEnabled(false);
                signin_btn.setTextColor(Color.argb(50,255,255,255));
                fireb.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(getActivity(), "Sign In Succesful", Toast.LENGTH_SHORT).show();
                            sendUserToHOMEaCTIVITY();
                        }else{
                            progressBar.setVisibility(View.INVISIBLE);
                            signin_btn.setEnabled(true);
                            signin_btn.setTextColor(Color.rgb(255,255,255));
                            String message = task.getException().toString();
                            Toast.makeText(getActivity(), "Error"+message, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        }else{
                password.setError("Password length is less than 8");
                password.requestFocus();
        }
        }else{
            email.setError("Enter Valid email ");
            email.requestFocus();
        }
    }
```

Overall `SignInFragment.java`:
```
package com.aips.amit.amite_commerceapp;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
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
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SigninFragment extends Fragment {

    public SigninFragment() {
    }

    private TextView donthaveanaccount;
    private FrameLayout parentframeLayout;

    private EditText email;
    private EditText password;

    private TextView forpass;

    private ProgressBar progressBar;

    private Button signin_btn;

    private ImageButton close_btn;

    private FirebaseAuth fireb;
    private FirebaseUser firebaseUser;
    private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";

    @Override
    public void onStart() {
        super.onStart();
        if(firebaseUser ==null)
        {
            //
        }
        else{
            sendUserToHOMEaCTIVITY();
            Toast.makeText(getActivity(), "Welcome sir/mam", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_signin, container, false);
        donthaveanaccount = view.findViewById(R.id.tv_dont_have_an_account);
        parentframeLayout = getActivity().findViewById(R.id.register_frame_layout);

        email = view.findViewById(R.id.sign_in_email);

        password = view.findViewById(R.id.sign_in_password);

        forpass = view.findViewById(R.id.sign_in_forgot_password);

        progressBar = view.findViewById(R.id.signin_progress_bar);

        signin_btn = view.findViewById(R.id.sign_in_btn);

        close_btn = view.findViewById(R.id.sign_in_close_btn);

        fireb = FirebaseAuth.getInstance();

        firebaseUser = fireb.getCurrentUser();

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        donthaveanaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new SignUpFragment());
            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInput();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInput();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        signin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEmailandPassword();
            }
        });

        forpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendUserToForgetPassFragment(new forget_password());
            }
        });
    }

    private void sendUserToForgetPassFragment(forget_password forget_password) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right, R.anim.slideout_from_left);
        fragmentTransaction.replace(parentframeLayout.getId(),forget_password);
        fragmentTransaction.commit();
    }

    private void checkEmailandPassword() {
        if(email.getText().toString().matches(emailPattern))
        {
            if(password.length()>=8)
            {

                progressBar.setVisibility(View.VISIBLE);
                signin_btn.setEnabled(false);
                signin_btn.setTextColor(Color.argb(50,255,255,255));
                fireb.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(getActivity(), "Sign In Succesful", Toast.LENGTH_SHORT).show();
                            sendUserToHOMEaCTIVITY();
                        }else{
                            progressBar.setVisibility(View.INVISIBLE);
                            signin_btn.setEnabled(true);
                            signin_btn.setTextColor(Color.rgb(255,255,255));
                            String message = task.getException().toString();
                            Toast.makeText(getActivity(), "Error"+message, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        }else{
                password.setError("Password length is less than 8");
                password.requestFocus();
        }
        }else{
            email.setError("Enter Valid email ");
            email.requestFocus();
        }
    }

    private void sendUserToHOMEaCTIVITY() {
        Intent i = new Intent(getActivity(),HomeActivity.class);
        startActivity(i);
        getActivity().finish();
    }

    private void checkInput() {
        if(!TextUtils.isEmpty(email.getText()))
        {
            if(!TextUtils.isEmpty(password.getText()))
            {
                signin_btn.setEnabled(true);
                signin_btn.setTextColor(Color.rgb(255,255,255));
            }else{
                signin_btn.setEnabled(false);
                signin_btn.setTextColor(Color.argb(50,255,255,255));
            }
        }else{
            signin_btn.setEnabled(false);
            signin_btn.setTextColor(Color.argb(50,255,255,255));
        }
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right, R.anim.slideout_from_left);
        fragmentTransaction.replace(parentframeLayout.getId(),fragment);
        fragmentTransaction.commit();
    }
}
```

Overall `SignInFragment.xml`:
```
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/Orange"
    tools:context=".SigninFragment">

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <ImageButton
            android:id="@+id/sign_in_close_btn"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:background="@android:color/transparent"
            android:padding="16dp"
            android:src="@drawable/ic_baseline_clear_24"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="1.0"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

        <ImageView
            android:id="@+id/imageView"
            android:layout_width="120dp"
            android:layout_height="120dp"
            android:layout_marginTop="4dp"
            android:src="@drawable/carts"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.498"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/sign_in_close_btn" />

        <EditText
            android:id="@+id/sign_in_email"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_marginStart="16dp"
            android:layout_marginTop="8dp"
            android:layout_marginEnd="16dp"
            android:backgroundTint="#70ffffff"
            android:ems="10"
            android:hint="Enter Your Email.."
            android:inputType="textEmailAddress"
            android:textColor="@color/white"
            android:padding="16dp"
            android:textColorHint="#70ffffff"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/imageView" />

        <EditText
            android:id="@+id/sign_in_password"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_marginStart="16dp"
            android:layout_marginTop="8dp"
            android:layout_marginEnd="16dp"
            android:backgroundTint="#70ffffff"
            android:ems="10"
            android:textColor="@color/white"
            android:hint="Enter Your Password.."
            android:inputType="numberPassword"
            android:padding="16dp"
            android:textColorHint="#70ffffff"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/sign_in_email" />

        <TextView
            android:id="@+id/sign_in_forgot_password"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="8dp"
            android:layout_marginTop="8dp"
            android:text="Forgot Password?"
            android:textColor="@color/white"
            app:layout_constraintStart_toStartOf="@+id/sign_in_password"
            app:layout_constraintTop_toBottomOf="@+id/sign_in_password" />

        <Button
            android:id="@+id/sign_in_btn"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_marginStart="50dp"
            android:layout_marginTop="24dp"
            android:layout_marginEnd="50dp"
            android:text="Sign in"
            android:enabled="false"
            android:textSize="16sp"
            android:backgroundTint="#FFA500"
            android:textColor="#50ffffff"
            android:textAllCaps="false"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/sign_in_password" />

        <TextView
            android:id="@+id/textView2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="or"
            android:textColor="@color/white"
            app:layout_constraintBottom_toTopOf="@+id/tv_dont_have_an_account"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/sign_in_btn" />

        <TextView
            android:id="@+id/tv_dont_have_an_account"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginBottom="24dp"
            android:text="Don't have an account?Sign up!"
            android:textColor="@color/white"
            android:textSize="20dp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent" />

        <View
            android:id="@+id/divider"
            android:layout_width="100dp"
            android:layout_height="1dp"
            android:layout_marginStart="67dp"
            android:layout_marginTop="29dp"
            android:layout_marginEnd="224dp"
            android:layout_marginBottom="26dp"
            android:background="@color/white"
            app:layout_constraintBottom_toTopOf="@+id/tv_dont_have_an_account"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/sign_in_btn" />

        <View
            android:layout_width="100dp"
            android:layout_height="1dp"
            android:layout_marginStart="224dp"
            android:layout_marginTop="29dp"
            android:layout_marginEnd="67dp"
            android:layout_marginBottom="26dp"
            android:background="@color/white"
            app:layout_constraintBottom_toTopOf="@+id/tv_dont_have_an_account"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/sign_in_btn" />

        <ProgressBar
            android:id="@+id/signin_progress_bar"
            style="?android:attr/progressBarStyle"
            android:layout_width="30dp"
            android:layout_height="30dp"
            android:visibility="invisible"
            app:layout_constraintBottom_toTopOf="@+id/sign_in_btn"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/sign_in_password" />

    </androidx.constraintlayout.widget.ConstraintLayout>

</FrameLayout>
```
