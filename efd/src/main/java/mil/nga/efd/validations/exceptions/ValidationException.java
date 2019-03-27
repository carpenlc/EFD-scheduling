package mil.nga.efd.validations.exceptions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Exception thrown by the GenericDAO class that contains a list of validation
 * failures.  This was re-written from the original EFD version.
 * 
 * @author L. Craig Carpenter
 */
public class ValidationException extends RuntimeException {
    
    /**
	 * Eclipse-generated serialVersionUID
	 */
	private static final long serialVersionUID = 4954193005967276676L;
	
	/**
	 * List of validation failure messages.
	 */
	private final List<String> messages;
    
	/**
	 * Initialize the internal message list.
	 */
    public ValidationException() {
        this(new String[] {});
    }
    
    /**
     * Add any messages that were sent to the constructor to the internal
     * list of messages.
     * @param messages Variable list of messages.
     */
    public ValidationException(String... messages) {
        this.messages = new ArrayList<String>();
        if (messages != null) {
            for (String m : messages) {
                this.messages.add(m);
            }
        }
    }
    
    /**
     * Add a new validation failure message to the list.
     * @param message A new validation failure message to be added.
     */
    public void addMessage(String message) {
        messages.add(message);
    }
    
    /**
     * Getter method for the internal message list.
     * @return The list of validation failures.
     */
    public List<String> getMessages() {
        return Collections.unmodifiableList(messages);
    }
    
    /**
     * Convert the list of validation failure messages to a String 
     * representation.
     */
    @Override
    public String getMessage() {
    	StringBuilder sb = new StringBuilder();
    	sb.append("ValidationException: messages => ");
    	if ((messages != null) && (!messages.isEmpty())) {
    		for (String message : messages) {
    			sb.append("[ ");
    			sb.append(message);
    			sb.append(" ]");
    		}
    	}
    	else {
    		sb.append("[ ]");
    	}
        return sb.toString();
    }
}
