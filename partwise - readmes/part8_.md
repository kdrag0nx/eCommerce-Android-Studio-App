# Part 8 : Designing of the `forget_password` fragment :
Xml Include:
```
<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/white"
    tools:context=".forget_password">

    <androidx.constraintlayout.widget.ConstraintLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_marginStart="5dp"
        android:layout_marginEnd="5dp"
        android:layout_marginBottom="5dp"
        android:layout_marginTop="5dp"
        android:background="@color/white">


        <ImageView
            android:id="@+id/imageView2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="16dp"
            android:layout_marginTop="16dp"
            android:layout_marginBottom="3dp"
            android:src="@drawable/forgot_password"
            app:layout_constraintBottom_toTopOf="@+id/textView3"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="16dp"
            android:fontFamily="@font/ubuntu"
            android:text="Forgot Password?"
            android:textColor="#626262"
            android:textSize="24sp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />

        <TextView
            android:id="@+id/textView3"
            android:layout_width="366dp"
            android:layout_height="56dp"
            android:layout_marginBottom="20dp"
            android:fontFamily="@font/ubuntu"
            android:text="Enter the Email Adress Associated with your Account.."
            android:textSize="24sp"
            app:layout_constraintBottom_toTopOf="@+id/forget_email"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/imageView2" />

        <EditText
            android:id="@+id/forget_email"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_marginStart="30dp"
            android:layout_marginTop="20dp"
            android:layout_marginEnd="30dp"
            android:layout_marginBottom="2dp"
            android:backgroundTint="@color/Orange"
            android:ems="10"
            android:fontFamily="@font/ubuntu"
            android:hint="Enter Your Email.."
            android:inputType="textEmailAddress"
            android:textColor="@color/Orange"
            android:textColorHint="@color/Orange"
            android:theme="@style/RedProgressbar"
            app:layout_constraintBottom_toTopOf="@+id/linearLayout"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/textView3" />

        <Button
            android:id="@+id/forget_password_button"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_marginStart="50dp"
            android:layout_marginEnd="50dp"
            android:background="@color/Orange"
            android:enabled="false"
            android:fontFamily="@font/ubuntu"
            android:text="Send Password Confirmation"
            android:textAllCaps="false"
            android:textColor="#50ffffff"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.0"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/forget_email"
            app:layout_constraintVertical_bias="0.388" />

        <TextView
            android:id="@+id/mail_sender"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="50dp"
            android:layout_marginTop="44dp"
            android:layout_marginEnd="50dp"
            android:layout_marginBottom="17dp"
            android:fontFamily="@font/ubuntu"
            android:text="Check Your email for reset password link"
            android:textColor="#626262"
            android:textSize="18sp"
            app:layout_constraintBottom_toTopOf="@+id/signin_back"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/forget_password_button" />

        <TextView
            android:id="@+id/signin_back"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="104dp"
            android:layout_marginTop="16dp"
            android:layout_marginEnd="138dp"
            android:layout_marginBottom="25dp"
            android:fontFamily="@font/ubuntu"
            android:text="&lt;&lt; Go to Login!"
            android:textSize="24sp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/mail_sender"
            app:layout_constraintVertical_bias="1.0" />

        <LinearLayout
            android:id="@+id/linearLayout"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="16dp"
            android:layout_marginTop="20dp"
            android:layout_marginEnd="16dp"
            android:layout_marginBottom="30dp"
            android:orientation="horizontal"
            app:layout_constraintBottom_toTopOf="@+id/forget_password_button"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/forget_email">

            <ImageView
                android:id="@+id/email_icon"
                android:layout_width="wrap_content"
                android:layout_height="15dp"
                android:layout_gravity="center"
                android:background="@android:color/transparent"
                android:src="@drawable/ic_baseline_mail_outline_24"
                tools:visibility="gone" />

            <TextView
                android:id="@+id/check_confirmation"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_marginLeft="5dp"
                android:text="Recovery Email Sent Succesfully! Check your Inbox"
                android:textColor="#11A10C"
                tools:visibility="gone" />

        </LinearLayout>

        <ProgressBar
            android:id="@+id/progress_bar_forget_password_screen"
            style="?android:attr/progressBarStyleHorizontal"
            android:layout_width="100dp"
            android:layout_height="wrap_content"
            android:layout_marginBottom="4dp"
            android:visibility="gone"
            android:indeterminate="true"
            android:theme="@style/RedProgressbar"
            app:layout_constraintBottom_toTopOf="@+id/forget_password_button"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/linearLayout"
            tools:visibility="invisible" />
    </androidx.constraintlayout.widget.ConstraintLayout>

</FrameLayout>
```


Now coming back to `Fragment Forget Password.java` file :

First of all initialize the email id and button on which user will click for email to send confirmation Link :
in `onCreateView` method:
> private EditText email;

>private Button forget_buttin;

Initialize both of them in onViewCreated method :
>email = view.findViewById(R.id.forget_email);

>forget_buttin = view.findViewById(R.id.forget_password_button);


Now validate `email`by adding `addTextChangedListener` on it:
```
email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkCorrection();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
```

Create Method `checkCorrection()`:
```
private void checkCorrection()   {
    if(!(TextUtils.isEmpty(email.getText())))
    {
        forget_buttin.setEnabled(true);
        forget_buttin.setTextColor(Color.rgb(255,255,255));
    }else{
        forget_buttin.setEnabled(false);
        forget_buttin.setTextColor(Color.argb(50,255,255,255));
    }
}
```
Now add `ClickListener` on button:
```
forget_buttin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        TransitionManager.beginDelayedTransition(linearLayout_container);
        emailIcon.setVisibility(View.GONE);

        TransitionManager.beginDelayedTransition(linearLayout_container);
        emailIcon.setVisibility(View.VISIBLE);
        horizprog_bar.setVisibility(View.VISIBLE);


        forget_buttin.setEnabled(false);
        forget_buttin.setTextColor(Color.argb(50,255,255,255));
        fireb.sendPasswordResetEmail(email.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {
                            forget_buttin.setEnabled(false);
                            Toast.makeText(getActivity(), "Email sent sucesfully", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(getActivity(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            horizprog_bar.setVisibility(View.GONE);
                            mailcheck_text.setText(task.getException().getMessage());
                            mailcheck_text.setTextColor(getResources().getColor(R.color.red));
                            TransitionManager.beginDelayedTransition(linearLayout_container);
                            mailcheck_text.setVisibility(View.VISIBLE);
                        }

                    }
                });
    }
});
```

set a `ClickListener` on Go back button as well :

```
gob.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        sendUserToLoginFragment(new SigninFragment());
    }
});

```

Create method `sendUserToLoginFragment()`:
```
private void sendUserToLoginFragment(Fragment fragment) {
    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
    fragmentTransaction.replace(parentframeLayout.getId(),fragment);
    fragmentTransaction.commit();
}

```
