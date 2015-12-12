package com.android.matt.techchallenge1.app;

import android.provider.BaseColumns;

/**
 * Created by Matt on 11/19/2015.
 */
public final class LoginDataObject {

    public LoginDataObject(){}

    public static abstract class LoginDataEntry implements BaseColumns {
        public static final String TABLE_NAME = "logins_table";
        public static final String COLUMN_NAME_DATE_TIME = "datetime";

    }
}
