package org.dvsa.testing.lib.url.exceptions;

public class UninitialisedURLException extends RuntimeException {

    public UninitialisedURLException() {
    }

    public UninitialisedURLException(String message) {
        super(message);
    }

    public UninitialisedURLException(String message, Throwable cause) {
        super(message, cause);
    }
}
