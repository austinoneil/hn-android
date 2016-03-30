package com.manuelmaly.hn.database;

import android.database.sqlite.SQLiteDatabase;

import java.sql.Connection;

/**
 * Created by austin on 3/18/16.
 */
public class HackerNewsDatabase {
    Connection connection;

    private SQLiteDatabase database;

    private HackerNewsDatabase(String databaseName) {
        database = SQLiteDatabase.openOrCreateDatabase(databaseName, null);
    }

    public void initialize(String tableName, SqlParameter[] parameters) {

        createTableIfNotExists(tableName, parameters);
    }

    private void createTableIfNotExists(String tableName, SqlParameter[] columns) {
        database.rawQuery("CREATE TABLE IF NOT EXISTS ?(?);", new String[]{tableName, sqlParameterSet(columns)});
    }

    private String sqlParameterSet(SqlParameter[] parameters) {
        String parameterSetString = "";
        for(int i=0; i<parameters.length; i++) {
            parameterSetString += parameters[i];
            if(i != parameters.length - 1) {
                parameterSetString += ",";
            }
        }
        return parameterSetString;
    }

    public static HackerNewsDatabase openOrCreateDatabase(String databaseName) {
        return new HackerNewsDatabase(databaseName);
    }
}