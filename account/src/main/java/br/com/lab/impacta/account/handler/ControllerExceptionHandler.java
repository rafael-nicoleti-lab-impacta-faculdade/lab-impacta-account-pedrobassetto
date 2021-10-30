package br.com.lab.impacta.account.handler;

import br.com.lab.impacta.account.handler.exception.AccountDontExistsException;
import br.com.lab.impacta.account.handler.exception.AccountWithOutBalanceException;
import br.com.lab.impacta.account.handler.exception.ErrorMessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(AccountDontExistsException.class)
    public ResponseEntity<ErrorMessageResponse> accountNotFoundException(AccountDontExistsException accountDontExistsException) {

        ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse(
                HttpStatus.NOT_FOUND.value(),
                new Date(),
                accountDontExistsException.getMessage(),
                accountDontExistsException.getDescription());

        return new ResponseEntity<>(errorMessageResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AccountWithOutBalanceException.class)
    public ResponseEntity<ErrorMessageResponse> withoutBalanceException(AccountWithOutBalanceException ex, WebRequest request) {
        ErrorMessageResponse message = new ErrorMessageResponse(
                HttpStatus.BAD_REQUEST.value(),
                new Date(),
                ex.getMessage(),
                ex.getDescription());

        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<ErrorMessageResponse> errorGeral(RuntimeException ex){
        ErrorMessageResponse message = new ErrorMessageResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date(),
                ex.getMessage(),
                "Não foi possivel processar sua requisicao"
        ) ;

        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}