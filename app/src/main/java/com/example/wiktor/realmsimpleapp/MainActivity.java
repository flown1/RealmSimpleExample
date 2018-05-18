package com.example.wiktor.realmsimpleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    private Realm realm;
    private TextView booksTitlesFields;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        booksTitlesFields = (TextView)findViewById(R.id.booksTitlesFields);
        realm = Realm.getInstance(this);

        addBook("Czysty kod");
        addBook("Podstawy Biblioteki Realm");
        addBook("Wzorce Projektowe w jeżyku Java");

        displayBooks();
    }

    private void addBook(String title){
        realm.beginTransaction();
        MyBook realmModel = realm.createObject(MyBook.class);
        realmModel.setTitle(title);
        realm.commitTransaction();
    }

    private void displayBooks(){
        RealmResults<MyBook> bookModels = realm.where(MyBook.class).findAll();

        StringBuilder sb = new StringBuilder();
        for (MyBook book : bookModels) {
            sb.append(book.getTitle()).append("\n");
        }
        booksTitlesFields.setText(sb);
    }

}
