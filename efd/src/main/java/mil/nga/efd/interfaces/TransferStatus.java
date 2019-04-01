package mil.nga.efd.interfaces;

import mil.nga.efd.types.TransferType;

public interface TransferStatus {
	
    public double getPercentComplete();
    public long getBytesRequested();
    public long getBytesTransferred();
    public String getFileName();
    public TransferType getTransferType();
    
}
