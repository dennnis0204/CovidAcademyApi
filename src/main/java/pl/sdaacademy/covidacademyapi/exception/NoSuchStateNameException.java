package pl.sdaacademy.covidacademyapi.exception;

public class NoSuchStateNameException extends RuntimeException {
    public NoSuchStateNameException(String errorMessage) {
        super(errorMessage);
    }
}
