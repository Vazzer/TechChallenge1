package com.android.matt.techchallenge1.app;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Matt on 11/18/2015.
 */
public class RecordsListFragment extends ListFragment {

    public RecordsListFragment(){
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                         Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_view, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        DatabaseOpenHelper dbHelper = new DatabaseOpenHelper(getContext());

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String query = "SELECT * FROM " + LoginDataObject.LoginDataEntry.TABLE_NAME
                + " ORDER BY " + LoginDataObject.LoginDataEntry.COLUMN_NAME_DATE_TIME
                + " ASC";

        Cursor c = db.rawQuery(query, null);

        LoginCursorAdapter adapter = new LoginCursorAdapter(
                this.getContext(), R.layout.list_item, c, 0);

        this.setListAdapter(adapter);

        db.close();
    }
}
