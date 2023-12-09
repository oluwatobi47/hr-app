package uk.ac.bcu.oluwatobi.hrapp.core;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uk.ac.bcu.oluwatobi.hrapp.DataValidationException;
import uk.ac.bcu.oluwatobi.hrapp.dto.DataResponse;
import uk.ac.bcu.oluwatobi.hrapp.dto.IDataResponse;

@ControllerAdvice
@RestControllerAdvice
public class RestExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ DataValidationException.class })
    public IDataResponse<?> handleDataValidationException(Exception exception) {
        return new DataResponse<>(false, exception.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({ Exception.class })
    public IDataResponse<?> handleGeneralExceptions(Exception exception) {
        return new DataResponse<>(false, exception.getMessage());
    }

}
