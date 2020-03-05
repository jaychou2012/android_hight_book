package com.google.instrumenttest;

import android.text.TextUtils;

import java.util.regex.Pattern;

public class EmailValidator {
    public static final Pattern EMAIL_PATTERN = Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" +
                    "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                    ")+"
    );

    public static boolean isValidEmail(CharSequence email) {
        if (email == null) {
            return false;
        }
        if (email.toString().trim().length()==0) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }

}
