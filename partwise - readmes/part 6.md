# Part - 6
***

In this video we will verify the user entered `email` and also we will match the `passwords` entered in `password` and `confirm password` field , not only that we will also see **how we can register user in Firebase using firebase auth and create their account**.
***

Continuing from the 4th Video , first of all wr will define email pattern

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
# Run the App to get result
---
