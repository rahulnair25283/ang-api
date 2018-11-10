package au.com.autogeneral.join.angapi.exception;

/**
 * Used when a requested resource is not found
 * 
 * @author rahulnair
 *
 */
public class NotFoundException extends ApiException {

    private static final long serialVersionUID = 1L;

    public NotFoundException(String msg) {
        super(msg);
    }
}
