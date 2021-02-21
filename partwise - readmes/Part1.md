# Part 1 : [Creating Splash Screen for our App and starting with our Project](https://youtu.be/y6O7-H2OVXY "Part1")

**Create New Project**
***

Step 1:Create `Empty Activity` and Name as ->`SplashActivity.java`
***

Step 2:Go to `activity_splash.xml`and change the `constraint Layout` to  ~~constraint Layout~~ `Relative Layout`
***
Step 3 : Define an **ImageView** inside of `Realtive Layout`(so as to add icon)
>code as follows :
```

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#ffffff"
    tools:context=".SplashActivity">

    <ImageView
        android:layout_width="120dp"
        android:layout_height="120dp"
        android:src="@drawable/carts"
        android:layout_centerInParent="true"/>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="eCommerce App All rights reserved "
        android:layout_centerInParent="true"
        android:layout_alignParentBottom="true"
        android:textColor="#626262"
        android:padding="20dp"/>

</RelativeLayout>
```
***

Step 4:Come to `SplashActivity.java` and we will use `Handler Method` for setting the time of the `Splash Screen`

***Go to `OnCreate Method` and declare as follows***:

>new Handler().postDelayed(new Runnable() {
>@Override
>            public void run() {
>                Intent i = new Intent(SplashActivity.this, MainActivity.class);
>                startActivity(i);
>                finish();
>            }
>        },3000);

**Note**: _3000 is the time in miliseconds which corresponds to 3 sec_

***

Step 5: Coming to `AndroidManifest.xml`

    and change the `Splashctivity` to `Launcher Activity` and `MainActivity` TO `DEFAULT` as follows by changing the Intent Filter as follows
```
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.aips.amit.amite_commerceapp">

    <application
        android:allowBackup="true"
        android:icon="@drawable/carts"
        android:label="@string/app_name"
        android:roundIcon="@drawable/carts"
        android:supportsRtl="true"
        android:theme="@style/Theme.AmitECommerceApp">
        <activity android:name=".SplashActivity"
            android:theme="@style/Theme.AppCompat.NoActionBar">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```

‎‎‎  ‎ ‎‎   ‎ ‎  ‎‎‎‎‎‎‎  ‎ ‎‎‎  ‎ ‎‎   ‎ ‎  ‎ ‎‎‎  ‎ ‎‎   ‎ ‎ ***-------------------------- <ins>PART  1</ins> --------------------------***
