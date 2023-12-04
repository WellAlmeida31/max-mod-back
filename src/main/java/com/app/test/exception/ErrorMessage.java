package com.app.test.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;

@Getter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {

    private String message;
    private String fieldError;
    private Throwable throwable;
    private String localizedItem;
    public ErrorMessage(String message, Throwable throwable) {
        this.message = message;
        this.throwable = throwable;
    }

    public ErrorMessage(String defaultMessage, String field) {
        this.message = defaultMessage;
        this.fieldError = field;
    }
    public ErrorMessage(FieldError fieldError) {
        this(fieldError.getDefaultMessage(), fieldError.getField());
    }

}
