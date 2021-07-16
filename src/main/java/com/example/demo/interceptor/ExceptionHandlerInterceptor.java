package com.example.demo.interceptor;

import com.example.demo.exception.EntityAlreadyExistsException;
import com.example.demo.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.http.HttpStatus.*;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerInterceptor {

    Map<HttpStatus, String> exceptionMap = Stream.of(new Object[][] {
            { NOT_FOUND, "Entity not found." },
            { UNPROCESSABLE_ENTITY, "Unprocessable entity" },
            { INTERNAL_SERVER_ERROR, "Server error." }
    }).collect(Collectors.toMap(data -> (HttpStatus) data[0], data -> (String) data[1]));


    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<JsonError> handleEntityNotFound(EntityNotFoundException e) {
        log.info(e.getClass().getName());
        return new ResponseEntity<>(exceptionBody(NOT_FOUND, e), NOT_FOUND);
    }

    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<JsonError> handleGeneralException(EntityAlreadyExistsException e) {
        log.info(e.getClass().getName());
        return new ResponseEntity<>(exceptionBody(UNPROCESSABLE_ENTITY, e), UNPROCESSABLE_ENTITY);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<JsonError> handleGeneralException(Exception e) {
        log.info(e.getClass().getName());
        return new ResponseEntity<>(exceptionBody(INTERNAL_SERVER_ERROR, e), INTERNAL_SERVER_ERROR);
    }

    public JsonError exceptionBody(HttpStatus httpStatus, Exception e){
        return JsonError
                .builder()
                .httpCode(httpStatus.value())
                .description(exceptionMap.get(httpStatus))
                .message(e.getMessage())
                .detail(e.getClass().getSimpleName())
                .build();
    }
}

@Data
@Builder
@AllArgsConstructor
class JsonError{
    int httpCode;
    String description;
    String message;
    String detail;
}
