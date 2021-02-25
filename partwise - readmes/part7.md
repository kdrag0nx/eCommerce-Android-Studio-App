# Part 7 : Setting Up the `LoginFragment.java` using `FirebaseAuth`
**Part 1**: Let's start with assigning the `EditText`, `Sign in Button`, `  ProgressBar` values in `SignInFragment.java`
```
private EditText email, password;
private Button signin_btn;
private TextView forgetpass;
private ProgressBar progressBar;
```
***
**Part 2**: Lets Assign it by its Id's:
```
email = view.findViewById(R.id.sign_in_email);
password = view.findViewById(R.id.sign_in_password);
forgetpass = view.findViewById(R.id.sign_in_forget_password);
progressBar = view.findViewById(R.id.progressBar2);
```
***
