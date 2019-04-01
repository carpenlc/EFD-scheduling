package mil.nga.efd.exceptions;

/**
 * Custom exception thrown from the Transport subsystem.
 * 
 * @author L. Craig Carpenter
 */
public class TransportLifeCycleException extends RuntimeException {

	/**
	 * Eclipse-generated serialVersionUID
	 */
	private static final long serialVersionUID = 7796643832894298839L;

	/** 
	 * Default no-arg constructor.
	 */
	public TransportLifeCycleException() {
        super();
    }

	/**
	 * Alternate constructor allowing client to supply both a custom message
	 * and Exception.
	 * @param message Custom exception message.
	 * @param cause Exception cause.
	 */
    public TransportLifeCycleException(String message, Throwable cause) {
        super(message, cause);
    }

	/**
	 * Alternate constructor allowing client to supply a custom exception 
	 * message.
	 * @param message Custom exception message.
	 */
    public TransportLifeCycleException(String message) {
        super(message);
    }

	/**
	 * Alternate constructor allowing client to supply the Exception cause.
	 * @param cause Exception cause.
	 */
    public TransportLifeCycleException(Throwable cause) {
        super(cause);
    }
	
}
