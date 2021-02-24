# PART 5 : [COMPLETING WITH REGISTERATION PROCESS](https://youtu.be/olw9sGE0AGo)

In this video we will verify the user entered `email` with emailPattern and also we will match the `passwords` entered in `password` and `confirm password`with minumum of 8 characters field , not only that we will also see **how we can register user in Firebase using firebase auth and create their account**.
***


Step 1 : Create a new Activity (say `HomeActivity.java`) to send User after Successful Registration to our App.
***

Step 2 : Coming to `SignUpFragment.java` and declare below `public signInFragment(){
  //constructor
  }`
```
    private TextView alreadyhaveanaccount;
    private FrameLayout parentFramelayout;
    private EditText signup_email;
    private EditText signup_passwrd;
    private EditText username;
    private EditText confpassword;

    private ImageButton closebtn;
    private Button signup_btn;

    private ProgressBar progressBar;
```
***
Step 3 : Assign with their Ids in `onCreateView` Method:
```
        alreadyhaveanaccount = view.findViewById(R.id.tv_already_have_an_account);

        parentFramelayout = getActivity().findViewById(R.id.register_frame_layout);

        signup_email = view.findViewById(R.id.sign_up_email);
        signup_passwrd = view.findViewById(R.id.sign_up_password);
        username = view.findViewById(R.id.sign_up_name);
        confpassword = view.findViewById(R.id.sign_up_confirm_password);

        signup_btn = view.findViewById(R.id.sign_up_btn);
        closebtn = view.findViewById(R.id.sign_up_close_btn);

        progressBar = view.findViewById(R.id.sign_up_progress_bar);
```
***

Step 4 :Now in the `OnViewCreated()` Method, set a `OnClickListener`
as follows:
```
signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //to do
            }
        });
```
***

Step 5 : Lets Disable the button because we want to confirm whether the user has inputted correct value or not !!

- coming to `SignUpFragment.xml` file,
so lets define first enabled attribute
>android:enabled = "false"

>android:textColor="#50ffffff"

here **50** : `Transparency`
***
Step 6 : Now coming back to `SignUpFragment.java` and check for `userinputs` are correct or not by adding a `addTextChangedListener` to the `EditText` !!
```
signup_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //this will be called when user hasnt inputted anything**dont need tis**
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {
                //this will be called when user has already filled the value */*/dont need this*/
            }
        });
username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //..
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {
                //..
            }
        });
signup_passwrd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {
                //.
            }
        });
confpassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //.
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {
                //.
            }
        });
```

**NOTE :** **We dont require to give inputs or assign methods to `afterTextChanged` and `beforeTextChanged` because those two methods will remain unacessible**


Step 7 : Create Method `checkInputs()`:

```
private void checkInputs() {
       if(!TextUtils.isEmpty(signup_email.getText()))
       {
           if(!TextUtils.isEmpty(username.getText()))
           {
               if(!TextUtils.isEmpty(signup_passwrd.getText()) && signup_passwrd.length()>=8)
               {
                   if(!TextUtils.isEmpty(confpassword.getText()))
                   {
                       signup_btn.setEnabled(true);
                       signup_btn.setTextColor(Color.rgb(255,255,255));
                   }else{
                       signup_btn.setEnabled(false);
                       signup_btn.setTextColor(argb(50,255,255,255));
                   }
               }else
                   {
                       signup_btn.setEnabled(false);
                       signup_btn.setTextColor(argb(50,255,255,255));
               }
           }
           else{
               signup_btn.setEnabled(false);
               signup_btn.setTextColor(argb(50,255,255,255));
           }
       }
       else
           {
               signup_btn.setEnabled(false);
               signup_btn.setTextColor(argb(50,255,255,255));
       }
   }
```
***
***
***
  Now lets first define our `emailPattern` so as we can match userentered `email` with our `emailPattern`
>private String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";

- Now coming to `OnViewCreated` Method:

set `signup_btn` -> `click Listener`
Code :
```
signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkEmailPassword();
            }
        });
```

- Create New Method: **`checkEmailPassword`**

and check for `email` for matching its **`pattern`**
code:

```
if(signup_email.getText().toString().matches(emailPattern)){

}else{

}
```

- Now check for password confirmation: if the email is confirmed then:
```
if(signup_email.getText().toString().matches(emailPattern))
        {
            if(signup_passwrd.getText().toString().equals(confpassword.getText().toString()))
            {
            }else{

            }else{

            }
```

- and if `password` and `email` pattern matches with its correspondence

then go ahead and ***`Register or create account using firebase`*** and making use of `progress bar `
code:
```
private void checkEmailPassword() {

        if(signup_email.getText().toString().matches(emailPattern))
        {
            if(signup_passwrd.getText().toString().equals(confpassword.getText().toString()))
            {

                progressBar.setVisibility(View.VISIBLE);
                signup_btn.setEnabled(false);
                signup_btn.setTextColor(Color.argb(50,255,255,255));
                fireb.createUserWithEmailAndPassword(signup_email.getText().toString(),signup_passwrd.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(getActivity(), "Registered Sucessful", Toast.LENGTH_SHORT).show();
                            semdUserToHomeActivity();
                        }
                        else
                        {
                            signup_btn.setEnabled(true);
                            signup_btn.setTextColor(Color.rgb(255,255,255));
                            progressBar.setVisibility(View.INVISIBLE);
                            String message = task.getException().toString();
                            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }else{
                confpassword.setError("Password did not match");
                confpassword.requestFocus();
            }
        }else{
            signup_email.setError("Enter Valid Email..!");
            signup_email.requestFocus();
        }
}
```
---
# Run the App to check Registration of User to your app

Next will be on ***Login***
---
