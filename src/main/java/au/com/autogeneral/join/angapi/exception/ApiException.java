package au.com.autogeneral.join.angapi.exception;

/**
 * Base class for all API related exceptions
 * 
 * @author rahulnair
 *
 */
public class ApiException extends Exception {

    private static final long serialVersionUID = 1L;

    public ApiException(String msg) {
        super(msg);
    }
}
