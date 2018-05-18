package com.example.wiktor.realmsimpleapp;

import io.realm.RealmObject;

public class MyBook extends RealmObject {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

}
