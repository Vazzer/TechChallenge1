package com.android.matt.techchallenge1.app;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(savedInstanceState == null){
            Fragment mainActivityFragment = new MainActivityFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment, mainActivityFragment);
            ft.commit();

            DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date dateObj = new Date();

            DatabaseOpenHelper dbHelper = new DatabaseOpenHelper(this.getApplicationContext());

            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put(LoginDataObject.LoginDataEntry.COLUMN_NAME_DATE_TIME, df.format(dateObj));

            long newRowId;
            newRowId = db.insert(LoginDataObject.LoginDataEntry.TABLE_NAME, "null", values);

            db.close();

        }
    }
}
