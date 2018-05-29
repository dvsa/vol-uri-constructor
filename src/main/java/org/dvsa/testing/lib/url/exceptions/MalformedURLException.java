package org.dvsa.testing.lib.url.exceptions;

public class MalformedURLException extends RuntimeException {

    public MalformedURLException() {
    }

    public MalformedURLException(String message) {
        super(message);
    }

    public MalformedURLException(String message, Throwable cause) {
        super(message, cause);
    }

    public MalformedURLException(Throwable cause) {
        super(cause);
    }
}
