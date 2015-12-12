package com.android.matt.techchallenge1.app;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

/**
 * Created by Matt on 11/19/2015.
 */
public class LoginCursorAdapter extends ResourceCursorAdapter {

    public LoginCursorAdapter(Context context, int layout, Cursor c, int flags) {
        super(context, layout, c, flags);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView dateTime = (TextView) view.findViewById(R.id.list_item_id);
        dateTime.setText(cursor.getString(cursor.getColumnIndex(
                LoginDataObject.LoginDataEntry.COLUMN_NAME_DATE_TIME)));
    }
}
