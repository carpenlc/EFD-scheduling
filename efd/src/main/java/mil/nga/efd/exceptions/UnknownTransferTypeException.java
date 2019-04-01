package mil.nga.efd.exceptions;

/**
 * Exception thrown if a unknown transfer type is requested.
 * 
 * @author L. Craig Carpenter
 */
public class UnknownTransferTypeException extends Exception {

	/**
	 * Eclipse-generated serialVersionUID
	 */
	private static final long serialVersionUID = -2034295324635257287L;

	/** 
     * Default constructor requiring a message String.
     * @param msg Information identifying why the exception was raised.
     */
    public UnknownTransferTypeException(String msg) {
        super(msg);
    }
	
}
