package com.manuelmaly.hn.database;

public enum SqlParameterType {
    VARCHAR {
        @Override
        public String toString() {
            return "VARCHAR";
        }
    },
    INTEGER {
        @Override
        public String toString() {
            return "INTEGER";
        }
    }
}
