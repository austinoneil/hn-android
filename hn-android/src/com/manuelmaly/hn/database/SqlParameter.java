package com.manuelmaly.hn.database;

public class SqlParameter {
    private String parameterName;
    private SqlParameterType parameterType;

    public SqlParameter(String name, SqlParameterType type) {
        parameterName = name;
        parameterType = type;
    }

    @Override
    public String toString() {
        return String.format("%s %s", parameterName, parameterType);
    }
}
