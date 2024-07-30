package org.example.exception;

public class StringUtilException extends RuntimeException {
    public StringUtilException(Exception e) {
        super(e);
    }
}
