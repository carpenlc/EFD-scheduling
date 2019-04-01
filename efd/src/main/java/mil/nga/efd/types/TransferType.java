package mil.nga.efd.types;

import mil.nga.efd.exceptions.UnknownTransferTypeException;

/**
 * Enumeration class identifying the types of transfer available.
 * 
 * @author L. Craig Carpenter
 */
public enum TransferType {
    ADD("ADD"),
    UPDATE("UPDATE"),
    SUPPLY("SUPPLY");
    
    /**
     * The text field.
     */
    private final String text;
    
    /**
     * Default constructor.
     * 
     * @param text Text associated with the enumeration value.
     */
    private TransferType(String text) {
        this.text = text;
    }
    
    /**
     * Getter method for the text associated with the enumeration value.
     * 
     * @return The text associated with the instanced enumeration type.
     */
    public String getText() {
        return this.text;
    }
    
    /**
     * Convert an input String to it's associated enumeration type.  There
     * is no default type, if an unknown value is supplied an exception is
     * raised.
     * 
     * @param text Input text information
     * @return The appropriate TransferType enum value.
     * @throws UnknownTransferTypeException Thrown if the caller submitted a 
     * String that did not match one of the existing HashTypes. 
     */
    public static TransferType fromString(String text) 
            throws UnknownTransferTypeException {
        if (text != null) {
            for (TransferType type : TransferType.values()) {
                if (text.trim().equalsIgnoreCase(type.getText())) {
                    return type;
                }
            }
        }
        throw new UnknownTransferTypeException("Unknown transfer type!  " 
                + "Transfer type requested [ " 
                + text
                + " ].");
}
}
