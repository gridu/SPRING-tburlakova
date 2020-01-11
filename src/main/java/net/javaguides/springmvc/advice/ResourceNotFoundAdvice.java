package net.javaguides.springmvc.advice;

import net.javaguides.springmvc.ApiError;
import net.javaguides.springmvc.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ResourceNotFoundAdvice extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError userNotFoundHandler(UserNotFoundException ex) {
        return new ApiError(HttpStatus.NOT_FOUND, ex.getErrorMessage(), ex.getMessage());
    }
}
