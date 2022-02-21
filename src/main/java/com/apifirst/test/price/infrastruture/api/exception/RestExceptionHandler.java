package com.apifirst.test.price.infrastruture.api.exception;


import com.apifirst.test.price.application.exception.PriceException;
import com.apifirst.test.price.application.exception.PriceNotFoundException;
import com.apifirst.test.price.infrastructure.generate.model.PriceError;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PriceException.class)
    public ResponseEntity<PriceError> genericException(final PriceException exception) {
        final PriceError priceError = new PriceError();
        priceError.setDetail(exception.getLocalizedMessage());
        priceError.setTitle(exception.getMessage());
        priceError.setStatus(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(priceError);
    }

    @ExceptionHandler(PriceNotFoundException.class)
    public ResponseEntity<PriceError> notFoundException(final PriceNotFoundException exception) {
        final PriceError priceError = new PriceError();
        priceError.setDetail(exception.getLocalizedMessage());
        priceError.setTitle(exception.getMessage());
        priceError.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(priceError);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestPart(final MissingServletRequestPartException ex,
                                                                     final HttpHeaders headers,
                                                                     final HttpStatus status,
                                                                     final WebRequest request) {
        final PriceError priceError = new PriceError();
        priceError.setDetail(ex.getMessage());
        priceError.setStatus(status.value());
        priceError.setTitle("Missing params");

        return super.handleExceptionInternal(ex, priceError, headers, status, request);
    }
}
