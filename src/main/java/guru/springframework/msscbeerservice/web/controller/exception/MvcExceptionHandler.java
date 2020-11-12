package guru.springframework.msscbeerservice.web.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fernando Lima
 * at 12/11/2020
 **/

@ControllerAdvice
public class MvcExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> validationErrorHandler(ConstraintViolationException ex){
        List<String> errorsList = new ArrayList<>(ex.getConstraintViolations().size());
        ex.getConstraintViolations().forEach(constraintViolation -> errorsList.add(constraintViolation.toString()));
        return new ResponseEntity<>(errorsList, HttpStatus.BAD_REQUEST);
    }

}
