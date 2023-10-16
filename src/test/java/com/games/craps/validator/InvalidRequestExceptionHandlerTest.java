package com.games.craps.validator;

import com.games.craps.entity.ErrorResponse;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class InvalidRequestExceptionHandlerTest {

    @Test
    void validationExceptionForStakeTest() {
        MethodArgumentNotValidException exception = mock(MethodArgumentNotValidException.class);
        BindingResult bindingResult = mock(BindingResult.class);

        FieldError fieldError = new FieldError("gameRequest", "stake", "Stakes must be larger than 0.");

        List<FieldError> fieldErrors = new ArrayList<>();
        fieldErrors.add(fieldError);

        when(exception.getBindingResult()).thenReturn(bindingResult);
        when(bindingResult.getFieldErrors()).thenReturn(fieldErrors);

        InvalidRequestExceptionHandler exceptionHandler = new InvalidRequestExceptionHandler();
        ResponseEntity<ErrorResponse> responseEntity = exceptionHandler.handleValidationException(exception);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

        ErrorResponse errorResponse = responseEntity.getBody();

        assert errorResponse != null;

        assertEquals(1, errorResponse.getMessage().size());
        assertEquals("Stakes must be larger than 0.", errorResponse.getMessage().get(0));
    }

    @Test
    void validationExceptionForTypeOfGameTest() {
        MethodArgumentNotValidException exception = mock(MethodArgumentNotValidException.class);
        BindingResult bindingResult = mock(BindingResult.class);

        FieldError fieldError = new FieldError("gameRequest", "typeOfGame", "Type of game must be: 'craps'.");

        List<FieldError> fieldErrors = new ArrayList<>();
        fieldErrors.add(fieldError);

        when(exception.getBindingResult()).thenReturn(bindingResult);
        when(bindingResult.getFieldErrors()).thenReturn(fieldErrors);

        InvalidRequestExceptionHandler exceptionHandler = new InvalidRequestExceptionHandler();
        ResponseEntity<ErrorResponse> responseEntity = exceptionHandler.handleValidationException(exception);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

        ErrorResponse errorResponse = responseEntity.getBody();

        assert errorResponse != null;

        assertEquals(1, errorResponse.getMessage().size());
        assertEquals("Type of game must be: 'craps'.", errorResponse.getMessage().get(0));
    }

    @Test
    void validationExceptionForStakeAndTypeOfGameTest() {
        MethodArgumentNotValidException exception = mock(MethodArgumentNotValidException.class);
        BindingResult bindingResult = mock(BindingResult.class);


        FieldError fieldErrorStake = new FieldError("gameRequest", "stake", "Stakes must be larger than 0.");
        FieldError fieldErrorTypeOfGame = new FieldError("gameRequest", "typeOfGame", "Type of game must be: 'craps'.");

        List<FieldError> fieldErrors = new ArrayList<>();
        fieldErrors.add(fieldErrorStake);
        fieldErrors.add(fieldErrorTypeOfGame);

        when(exception.getBindingResult()).thenReturn(bindingResult);
        when(bindingResult.getFieldErrors()).thenReturn(fieldErrors);

        InvalidRequestExceptionHandler exceptionHandler = new InvalidRequestExceptionHandler();
        ResponseEntity<ErrorResponse> responseEntity = exceptionHandler.handleValidationException(exception);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

        ErrorResponse errorResponse = responseEntity.getBody();

        assert errorResponse != null;

        assertEquals(2, errorResponse.getMessage().size());
        assertEquals("Stakes must be larger than 0.", errorResponse.getMessage().get(0));
        assertEquals("Type of game must be: 'craps'.", errorResponse.getMessage().get(1));
    }
}
