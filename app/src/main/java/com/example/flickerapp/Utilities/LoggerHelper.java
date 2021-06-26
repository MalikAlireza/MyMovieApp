package com.example.flickerapp.Utilities;

import android.util.Log;

public class LoggerHelper {

    public static LoggerHelper loggerHelper = new LoggerHelper();

    public void printLog( Class reference, String  message){
        Log.d(reference.getName(), message);
    }

}
