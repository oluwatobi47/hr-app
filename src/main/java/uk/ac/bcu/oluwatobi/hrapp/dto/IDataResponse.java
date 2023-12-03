package uk.ac.bcu.oluwatobi.hrapp.dto;

public interface IDataResponse<T> {
    T getData();
    boolean isValid();
    String getMessage();

}
