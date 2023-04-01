package kian.springframework.mymsscbeerservice.web.controller.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kian
 * @created 4/1/2023 - 4:36 PM
 */
@ControllerAdvice
public class MvcExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public List<String> handleViolationError(ConstraintViolationException ex) {
        List<String> errorList = new ArrayList<>(ex.getConstraintViolations().size());

        ex.getConstraintViolations().forEach(constraintViolation -> errorList.add(constraintViolation.toString()));

        return errorList;
    }
}
