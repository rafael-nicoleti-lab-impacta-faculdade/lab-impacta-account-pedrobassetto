package br.com.lab.impacta.account.handler.exception;

public class AccountDontExistsException extends RuntimeException {

    private String description;

    public AccountDontExistsException() {super();}

    public AccountDontExistsException(String message, String description) {
        super(message);

        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}