package uk.ac.bcu.oluwatobi.hrapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Model representation for all api responses from the HR App Service
 * */
public class DataResponse<T> implements IDataResponse<T>, Serializable {
    private T data;
    private boolean valid;
    private String message;

    public DataResponse(T data){
        this.data = data;
        this.valid = true;
        this.message = "success";
    }

    public DataResponse(T data, boolean valid) {
        this.data = data;
        this.valid = valid;
    }

    public DataResponse(T data, boolean valid, String message) {
        this.data = data;
        this.valid = valid;
        this.message = message;
    }

    public DataResponse(boolean valid, String message){
        this.valid = valid;
        this.message = message;
    }

    @Override
    @JsonProperty("data")
    public T getData() {
        return data;
    }

    @Override
    @JsonProperty("valid")
    public boolean isValid() {
        return this.valid;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
