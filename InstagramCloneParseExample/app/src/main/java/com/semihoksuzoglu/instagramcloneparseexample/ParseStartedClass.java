package com.semihoksuzoglu.instagramcloneparseexample;

import android.app.Application;

import com.parse.Parse;

public class ParseStartedClass extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("")
                .server("")
                .clientKey("")
                .build());
    }
}
