package com.ejemplo.examen.dto;

public class ResponseBase<T> {

    private int code;
    private String message;
    private T data;

    public ResponseBase() {
    }

    public ResponseBase(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // Getters y Setters

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
