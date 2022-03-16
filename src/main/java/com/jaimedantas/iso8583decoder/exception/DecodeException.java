package com.jaimedantas.iso8583decoder.exception;

public class DecodeException  extends Exception{
    private static final long serialVersionUID = -8764083266128005457L;

    final String message;

    public DecodeException(String message) {
        super(message);
        this.message = message;
    }

}
