package mil.nga.efd.exceptions;

/**
 * Custom exception thrown if the underlying transport is not available.
 * 
 * @author L. Craig Carpenter
 */
public class TransportUnavailableException extends RuntimeException {

	/**
	 * Eclipse-generated serialVersionUID.
	 */
	private static final long serialVersionUID = -1642669904973965618L;

	/** 
	 * Default no-arg constructor.
	 */
	public TransportUnavailableException() {
        super();
    }
	
	/**
	 * Alternate constructor allowing client to supply both a custom message
	 * and Exception.
	 * @param message Custom exception message.
	 * @param cause Exception cause.
	 */
    public TransportUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }

	/**
	 * Alternate constructor allowing client to supply a custom exception 
	 * message.
	 * @param message Custom exception message.
	 */
    public TransportUnavailableException(String message) {
        super(message);
    }

	/**
	 * Alternate constructor allowing client to supply the Exception cause.
	 * @param cause Exception cause.
	 */
    public TransportUnavailableException(Throwable cause) {
        super(cause);
    }
    
}
