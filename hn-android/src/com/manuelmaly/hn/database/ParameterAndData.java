package com.manuelmaly.hn.database;

/**
 * Created by austin on 3/18/16.
 */
public class ParameterAndData {
    public String getParameterName() {
        return parameterName;
    }

    public String getData() {
        return data;
    }

    private String parameterName;
    private String data;

    public ParameterAndData(String parameterName, String data) {
        this.parameterName = parameterName;
        this.data = data;
    }
}
