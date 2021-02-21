
  # PART 3
  - Now after degigning Fragments we will come back to `activity main.xml` and put
 `Frame layout` inside of `Constraint layout`with attributes as follows:

 ```
 <FrameLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:layout_editor_absoluteX="194dp"
        android:id="@+id/register_frame_layout"
        tools:layout_editor_absoluteY="306dp">
 ```
***
 - Now coming to `MainActivity.java` :
 define `FrameLayout `variable there :
 >private FrameLayout framelayout;
 ***

 - Now in the `Oncreate` Mthod , find the `FrameLayout` ID as:
 >framelayout = findViewbyId(R.id.register_frame_layout);

 ***

 - Now set Fragments which we created i.e. `SignInFragment` and `SignUpFragment` into MainActivity by :
 `setFragment();` method

 Create this method :
 and code and start`Fragment Transaction `as follows:
 ```
 private void setFragemnt(Fragment fragemnt) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(), fragemnt);
        fragmentTransaction.commit();
    }
 ```
***

 - **Pass the `SignInFragment ` at first because we want people to go to` sign in` screen at first then if he/she don't have an account then they can redirected by clicking `  dont have an account ` to `SignUp `Screen.**

 ***

- so we will redirect people to sign in screen by providing sign in fragment in setFragemnt method:
 >setFragement(new SignInFragment());
 ***

  # Now coming back to `SignInFragment.java` file:
 and remove all the unnecessary lines here and final code after all the line removal will look like :
 ```
 public class SigninFragment extends Fragment {

    public SigninFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

      }
 ```
 ***

 - and we will assign `dont have an account` textview with a variable and find its id :
 > donthaveanaccount = view.findViewById(R.id.tv_dont_have_an_account);

 ***

- Go to onCreate Method and change the return to View because **we will retreieve id's corresponding by view method**

apply the code:
```
View view =  inflater.inflate(R.layout.fragment_signin, container, false);
        donthaveanaccount = view.findViewById(R.id.tv_dont_have_an_account);
        return view;
```
***

- Now we will create a new Method `onViewCreated` and call using `clickListener`

code as follows:
```
@Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        donthaveanaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragement(new SignUpFragment());
            }
        });
    }
```
pass the `setFragement()`; method here as shown above &#8593;

***

- After Creating `setFragemnt()` method start `FragmentTransaction` there code as follows:

```
private void setFragement(Fragment fragement) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(parentframeLayout.getId(),fragement);
        fragmentTransaction.commit();
    }
```
***
 - Pass `frameLayout` in above &#8593; Method; but before that define `frameLayout` in `SignInFragment` as:
 >private FrameLayout frameLayout; _(below public method)_

 Now Assign it in onCreate Method as:
 >frameLayout = getActivity().findViewById(R.id.register_frame_layout);

 ***getActivity() :beause this `SignInFragment `is a `fragement` and not `activity`***

 ***

 - Now coming back to `setFragemnt` method and pass `(new SignUpFragment())`
 because we want user to go to `SignInFragment` when he/she clicks `donthaveanaccount`
 code as follows:
 ```
 public SigninFragment() {
        // Required empty public constructor
    }
    private TextView donthaveanaccount;
    (Added:) private FrameLayout parentframeLayout;

 ```

 ```
 @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_signin, container, false);
        donthaveanaccount = view.findViewById(R.id.tv_dont_have_an_account);
        (Added:)parentframeLayout = getActivity().findViewById(R.id.register_frame_layout);
        return view;

    }
 ```
***
 ```
 @Override
   public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
       super.onViewCreated(view, savedInstanceState);

       donthaveanaccount.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               setFragement(new SignUpFragment());
                                     ↳(Added:)
           }
       });
   }
 ```
***
 ```
 private void setFragement(Fragment fragement) {
       FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
       fragmentTransaction.replace(parentframeLayout.getId(),fragement);
       fragmentTransaction.commit();
   }
 ```
***
 # Run you app and you will find no Animation :
 ## So to create Animation :

 **Go to res ➜ rightclick ➜ Create New Anim Directory ➜ create 4 anim files in that directory ➜ slide_from_right, slide_from_left, slideout_from_right, slideout_from_left**

 Follow the attributes :

 **slide_from_right :**
 ```
 <?xml version="1.0" encoding="utf-8"?>
 <set xmlns:android="http://schemas.android.com/apk/res/android"
     android:duration="250"
     android:interpolator="@android:anim/accelerate_decelerate_interpolator">

     <translate android:fromXDelta="100%"
         android:fromYDelta="0%"
         android:toXDelta="0%"
         android:toYDelta="0%"/>

 </set>
 ```
**slide_from_left :**
```
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:duration="250"
    android:interpolator="@android:anim/accelerate_decelerate_interpolator">

    <translate android:fromXDelta="-100%"
        android:fromYDelta="0%"
        android:toXDelta="-100%"
        android:toYDelta="0%"/>

</set>
```
**slideout_from_left :**
```
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:duration="250"
    android:interpolator="@android:anim/accelerate_decelerate_interpolator">

    <translate android:fromXDelta="100%"
        android:fromYDelta="0%"
        android:toXDelta="0%"
        android:toYDelta="-100%"/>

</set>
```
**slideout_from_right :**
```
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:duration="250"
    android:interpolator="@android:anim/accelerate_decelerate_interpolator">

    <translate android:fromXDelta="0%"
        android:fromYDelta="0%"
        android:toXDelta="0%"
        android:toYDelta="100%"/>

</set>
```
***
- After creating Animations lets assign it to `SignInFragment `and `SignUpFragment` :

**SignInFragment:**
In the ***setFragement()*** method :


 >fragmentTransaction.setCustomAnimations(R.anim.slide_from_right, R.anim.slideout_from_left);(Add this line)

**SignUpFragment:**
In the ***setFragement()*** method :

>fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slideout_from_right);(Add this line)
***

Now Overall `setFragement` method will look like :
`SignInFragment`:
```
private void setFragement(Fragment fragement) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(parentframeLayout.getId(),fragement);
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right, R.anim.slideout_from_left);
        fragmentTransaction.commit();
    }
```
***
`SignUpFragment`:
```
private void setFragemet(Fragment fragemet) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(parentFrameLayout.getId(), fragemet);
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slideout_from_right);
        fragmentTransaction.commit();
    }
```
***
### Overall SignInFragment:
```
package com.aips.amit.amite_commerceapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

public class SigninFragment extends Fragment {

    public SigninFragment() {
        // Required empty public constructor
    }
    private TextView donthaveanaccount;
    private FrameLayout parentframeLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_signin, container, false);
        donthaveanaccount = view.findViewById(R.id.tv_dont_have_an_account);
        parentframeLayout = getActivity().findViewById(R.id.register_frame_layout);
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
    }

    private void setFragement(Fragment fragement) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(parentframeLayout.getId(),fragement);
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right, R.anim.slideout_from_left);
        fragmentTransaction.commit();
    }
}
```
***
###Overall SignUpFragment:
```
package com.aips.amit.amite_commerceapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SignUpFragment extends Fragment {


    public SignUpFragment() {
        // Required empty public constructor
    }

    private TextView alreadyhaveanaccount;
    private FrameLayout parentFrameLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_sign_up, container, false);


        alreadyhaveanaccount = view.findViewById(R.id.tv_already_have_an_account);
        parentFrameLayout = getActivity().findViewById(R.id.register_frame_layout);

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
    }

    private void setFragemet(Fragment fragemet) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(parentFrameLayout.getId(), fragemet);
        fragmentTransaction.setCustomAnimations(R.anim.slide_from_left, R.anim.slideout_from_right);
        fragmentTransaction.commit();
    }
}
```
‎‎   ‎ ‎    ‎   ‎ ‎    ‎   ‎ ‎    ‎   ‎ ‎    ‎   ‎ ‎    ‎   ‎ ‎    ‎   ‎ ‎    ‎   ‎ ‎    ‎   ‎ ‎    ‎   ‎ ‎    ‎   ‎ ‎    ‎    ‎       ***-------------------<ins>PART - III</ins> ------------------***
  ‎ ‎  ‎ ‎‎‎  ‎ ‎‎   ‎ ‎  ‎‎‎‎‎‎‎  ‎ ‎‎‎  ‎ ‎‎   ‎ ‎  ‎ ‎‎‎  ‎ ‎‎   ‎ ‎
