package arisimons.simons.Exceptions;

public class NameFoundException extends Exception{
    public NameFoundException() {
        super();
    }

    public NameFoundException(String message) {
        super(message);
    }

    public NameFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NameFoundException(Throwable cause) {
        super(cause);
    }

    protected NameFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
