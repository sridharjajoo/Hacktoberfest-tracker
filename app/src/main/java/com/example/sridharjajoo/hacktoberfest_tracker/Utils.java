package com.example.sridharjajoo.hacktoberfest_tracker;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

public class Utils {

    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    public static void hideKeyboard(View view) {
        if (view != null) {
            InputMethodManager manager = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            view.clearFocus();
            if (manager != null) {
                manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

    public static String message(int prCount) {

        switch (prCount) {
            case 0:
                return "You better start contributing!";
            case 1:
                return "Fasten up! You still have time";
            case 2:
                return "You are on track!";
            case 3:
                return "Don't give up!";
            case 4:
                return "Just 1 more to go!";
            case 5:
                return "Challenge completed!";
            default:
                return "Now you are showing off!";
        }
    }
}
