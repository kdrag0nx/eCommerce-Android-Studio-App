#Part 4 : [Adding Firebase to Our App in Android Studio](https://xvideos.com/anal)
- Go to [FirebaseConsole](https://console.firebase.google.com/u/0/?pli=1) and if hadn't signed in , first sign in to `Google` and then proceed with the above link

***

-  Click on `add` button/icon and `Enter Your Project Name` as in my case its `eCommerce App`

***

- Now click on `Continue` on the next Screen as well and in the 3rd screen select `Default Account for Firebase` in the `drop down box` shown and again click on `Continue`

***

- After finishing up , come to Your **Android Studio** and Copy the `application id` mentioned in the top of any of the activities which you have created
***

- `Nickname` and `debug id` is optional , so skipping that click on **`Register`** App

***

- Download the **`GoogleServices.json`** file , copy the `json` file ,now, come to android studio and from the top right corner change the directory from app to project and paste it in App folder created there.

***

Now come to
`build.gradle(Project part)`: add this line in **dependencies**:
>classpath 'com.google.gms:google-services:4.3.5'

`build.gradle(Module part)`: add this line after **dependencies**
>apply plugin: 'com.google.gms.google-services'

Now for all the dependencies :
add theselines:
```
dependencies {

    implementation 'androidx.appcompat:appcompat:1.0.0'
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    testImplementation 'junit:junit:4.+'
    androidTestImplementation 'androidx.test.ext:junit:1.1.1'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.1.0'
    implementation 'com.google.android.material:material:1.0.0'
    implementation 'com.google.firebase:firebase-core:11.8.0'
    implementation 'com.google.firebase:firebase-database:11.8.0'
    implementation 'com.google.firebase:firebase-storage:11.8.0'
    implementation 'com.google.firebase:firebase-auth:11.8.0'
    implementation 'com.google.android.material:material:1.0.0'
    implementation 'com.firebaseui:firebase-ui-database:3.2.2'
    implementation 'com.google.firebase:firebase-firestore:11.8.0'
}
```


**`Overall Build.gradle(Module Part)` coding :**
```
plugins {
    id 'com.android.application'
}

android {
    compileSdkVersion 30
    buildToolsVersion "30.0.3"

    defaultConfig {
        applicationId "com.aips.amit.amite_commerceapp"
        minSdkVersion 22
        targetSdkVersion 30
        versionCode 2021
        versionName '2021.2.19e230+cfg'

        testInstrumentationRunner 'androidx.test.runner.AndroidJUnitRunner'
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
            versionNameSuffix '2021.2.19e230+cfg'
        }
        debug {
            versionNameSuffix '2021.2.19e230+cfg'
        }
    }
    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    flavorDimensions
}

dependencies {

    implementation 'androidx.appcompat:appcompat:1.0.0'
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    testImplementation 'junit:junit:4.+'
    androidTestImplementation 'androidx.test.ext:junit:1.1.1'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.1.0'
    implementation 'com.google.android.material:material:1.0.0'
    implementation 'com.google.firebase:firebase-core:11.8.0'
    implementation 'com.google.firebase:firebase-database:11.8.0'
    implementation 'com.google.firebase:firebase-storage:11.8.0'
    implementation 'com.google.firebase:firebase-auth:11.8.0'
    implementation 'com.google.android.material:material:1.0.0'
    implementation 'com.firebaseui:firebase-ui-database:3.2.2'
    implementation 'com.google.firebase:firebase-firestore:11.8.0'
}
apply plugin: 'com.google.gms.google-services'
```

**`Overall Build.gradle(Project Part)`** **coding :**
```
// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath "com.android.tools.build:gradle:4.1.1"
        classpath 'com.google.gms:google-services:4.3.5'

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}
```
