
# Part 2 : [Designing our Login and Register Fragments]()

|<ins>Login Fragment |<ins>Register Fragment|
|---|---|
|![Image Source](https://github.com/amitkv1212/eCommerce-Android-Studio-App/blob/main/ScreenShots/Login%20Fragement.jpg?raw=true=10*10 "SignInFragment")|![ImageSource](https://github.com/amitkv1212/eCommerce-Android-Studio-App/blob/main/ScreenShots/Register%20Fragment.jpg?raw=true "SignUpFragement")   |


Note here : **`You can copy the Atrributes like width or height , copying the whole code may result into error as the id's defined in this project may vary in your case unless you define the same id's in your case`**



So in the first step we have created a Splash Screen and in this lets design our Activities

Step 1 : Go to the folder where `MainActivity.java ` exists and Create two new Fragments 1.)`Sign In Fragments` & 2.)`Sign Up Fragments`



Now lets design first `SignInFragments` so go to its `.xml ` file and code

- ~~constraintLayout~~ **Frame Layout** am=nd give background color as per your need by defining the attribute
>android:background="#colorcode"

- Now declare `constraintLayout` inside of `FrameLayout` for easier Designing

So inside `constraintLayout` first we will give an `imagebutton` as you can see in the design above picture


## Declare an Close image button for our app icon
***Common for both SignInFragment and SignUpFragement***
```
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
```
## Declare an ImageView for our app icon
***Common for both SignInFragment and SignUpFragement***

Code as follows:
```
<ImageView
            android:id="@+id/imageView"
            android:layout_width="120dp"
            android:layout_height="120dp"
            android:layout_marginTop="4dp"
            android:src="@drawable/carts"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/sign_in_close_btn" />
```

Now define two Editext as we are using email and password field where the user will enter the values

##   ‎ ‎‎‎  ‎ ‎‎   ‎ ‎  ‎ ‎‎‎  ‎ ‎‎   <ins> _*‎SignInFragment Designing Part*_</ins>

**Editext for Email id**:
```
<EditText
            android:id="@+id/sign_in_email"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_marginStart="20dp"
            android:layout_marginTop="20dp"
            android:layout_marginEnd="20dp"
            android:backgroundTint="#902E2929"
            android:ems="10"
            android:hint="Enter Your Email.."
            android:inputType="textEmailAddress"
            android:padding="16dp"
            android:textColor="@color/white"
            android:textColorHint="#902E2929"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.0"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/imageView" />
```

& **EditText for Password:**
```
<EditText
            android:id="@+id/sign_in_password"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_marginStart="16dp"
            android:layout_marginTop="10dp"
            android:layout_marginEnd="16dp"
            android:backgroundTint="#902e2929"
            android:ems="10"
            android:hint="Enter Password.."
            android:inputType="textPassword"
            android:padding="16dp"
            android:textColor="@color/white"
            android:textColorHint="#902e2929"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/sign_in_email" />
```

**Creating a Forget Password TextView**
```
<TextView
            android:id="@+id/sign_in_forget_password"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="16dp"
            android:layout_marginTop="8dp"
            android:text="forgot password?"
            android:textColor="@color/white"
            app:layout_constraintStart_toStartOf="@+id/sign_in_password"
            app:layout_constraintTop_toBottomOf="@+id/sign_in_password" />
```

now **Define a sign in button :**

```
<Button
            android:id="@+id/sign_in_btn"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_marginStart="30dp"
            android:layout_marginTop="80dp"
            android:layout_marginEnd="30dp"
            android:background="@color/CCCC00"
            android:text="Sign in"
            android:textAllCaps="false"
            android:textSize="16sp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.0"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/sign_in_password" />
```

***Create a `divider` and a text View `Or`***

Create `DontHave an account ` TextView
```
<TextView
            android:id="@+id/tv_dont_have_an_account"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Dont have an account?Sign up!"
            app:layout_constraintBottom_toBottomOf="parent"
            android:textColor="@color/white"
            android:textSize="18sp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/textView2" />
```

## ‎‎‎‎‎‎‎  ‎ ‎‎‎  ‎ ‎‎   ‎ ‎  ‎ ‎‎‎  ‎ ‎‎   ‎ ‎ <ins >_*SignUpFragement Designing*_</ins>

**EditText for Email id**

```
<EditText
            android:id="@+id/sign_up_email"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_marginStart="20dp"
            android:layout_marginTop="20dp"
            android:layout_marginEnd="20dp"
            android:backgroundTint="#902E2929"
            android:ems="10"
            android:hint="Enter Your Email.."
            android:inputType="textEmailAddress"
            android:padding="16dp"
            android:textColor="@color/white"
            android:textColorHint="#902E2929"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.0"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/imageView_sign_up" />
```

**EditText for Full Name**
```
<EditText
            android:id="@+id/sign_up_full_name"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_marginTop="12dp"
            android:ems="10"
            android:layout_marginStart="20dp"
            android:layout_marginEnd="20dp"
            android:inputType="textPersonName"
            android:hint="Full Name.."
            android:textColor="@color/white"
            android:padding="16dp"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.502"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/sign_up_email" />
```

**EditText for password**
```
<EditText
            android:id="@+id/sign_up_password"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_marginStart="16dp"
            android:layout_marginTop="68dp"
            android:layout_marginEnd="16dp"
            android:backgroundTint="#902e2929"
            android:ems="10"
            android:hint="Enter Password.."
            android:inputType="textPassword"
            android:padding="16dp"
            android:textColor="@color/white"
            android:textColorHint="#902e2929"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.0"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/sign_up_email" />
```

**Editext for Confirm Password**
```
<EditText
            android:id="@+id/sign_up_cnf_password"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_marginStart="20dp"
            android:layout_marginTop="12dp"
            android:layout_marginEnd="20dp"
            android:ems="10"
            android:hint="Confirm Password.."
            android:inputType="textPassword"
            android:padding="16dp"
            android:textColor="@color/white"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.502"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/sign_up_password" />
```

**Button for Sign Up**
```
<Button
            android:id="@+id/sign_up_btn"
            android:layout_width="0dp"
            android:layout_height="wrap_content"
            android:layout_marginStart="30dp"
            android:layout_marginTop="80dp"
            android:layout_marginEnd="30dp"
            android:background="@color/CCCC00"
            android:text="Sign Up"
            android:textAllCaps="false"
            android:textSize="16sp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintHorizontal_bias="0.0"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/sign_up_password" />
```

**Already Have an Account TextView**
```
<TextView
            android:id="@+id/tv_already_have_an_account"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Already have an account?Sign in!"
            android:textColor="@color/white"
            android:textSize="18sp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintEnd_toEndOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toBottomOf="@+id/textView92" />
```

 ‎‎‎‎‎‎‎  ‎ ‎‎‎  ‎ ‎‎   ‎ ‎  ‎ ‎‎‎  ‎ ‎‎   ‎ ‎  ‎‎‎‎‎‎‎  ‎ ‎‎‎  ‎ ‎‎   ‎ ‎  ‎ ‎‎‎  ‎ ‎‎   ‎ ‎  ‎‎‎‎‎‎‎  ‎ ‎‎‎  ‎ ‎‎   ‎ ‎  ‎ ‎‎‎  ‎ ‎‎   ‎ ‎ ***-------------------<ins>PART - II</ins> ------------------***  ‎‎‎‎‎‎‎  ‎ ‎‎‎  ‎ ‎‎
