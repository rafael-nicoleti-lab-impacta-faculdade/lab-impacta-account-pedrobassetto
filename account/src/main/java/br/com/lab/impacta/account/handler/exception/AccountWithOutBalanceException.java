package br.com.lab.impacta.account.handler.exception;

public class AccountWithOutBalanceException extends RuntimeException{

    private String description;

    public AccountWithOutBalanceException() {super();}

    public AccountWithOutBalanceException(String message, String description) {
        super(message);

        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
