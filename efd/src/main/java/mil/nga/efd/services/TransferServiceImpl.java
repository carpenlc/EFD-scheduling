package mil.nga.efd.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mil.nga.efd.events.SynchronizationEvent;
import mil.nga.efd.interfaces.TransferService;
import mil.nga.efd.interfaces.TransferStatus;

public class TransferServiceImpl implements TransferService {

	/**
     * Set up the Log4j system for use throughout the class
     */        
    private static final Logger LOGGER = LoggerFactory.getLogger(
    		TransferServiceImpl.class);
    
	private final String contentSetName;
	private final String host;
	private final int    port;
	
	/**
	 * Protected constructor enforcing the builder creation pattern.
	 * @param builder The builder object.
	 */
	protected TransferServiceImpl(TransferServiceBuilder builder) {
		host            = builder.host;
		contentSetName  = builder.contentSetName;
		port            = builder.port;
	}
	
	/**
	 * Getter method for the content set name associated with this 
	 * <code>TransferServiceImpl</code> object.
	 * @return The name of the content set.
	 */
	public String getContentSetName() {
		return contentSetName;
	}
	
	/**
	 * Getter method for the host associated with this 
	 * <code>TransferServiceImpl</code> object.
	 * @return The name of the target host.
	 */
	public String getHost() {
		return host;
	}
	
	/**
	 * Getter method for the port on the host associated with this 
	 * <code>TransferServiceImpl</code> object.
	 * @return The name of the port on the target host.
	 */
	public int getPort() {
		return port;
	}
	
	
	@Override
	public void start(SynchronizationEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop(SynchronizationEvent event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendMetrics(long totalRequests, long totalBytes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TransferStatus> getCurrentTransfers() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	/**
	 * Overridden toString method converting internal members to a String.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("TransferServiceImpl: Content set name => [ ");
		sb.append(getContentSetName());
		sb.append(" ], host => [ ");
		sb.append(getHost());
		sb.append(" ], port => [ ");
		sb.append(getPort());
		sb.append(" ].");
		return sb.toString();
	}
	
    /**
     * Internal static class implementing the Builder creation pattern for 
     * new <code>TransferService</code>objects.  
     * 
     * @author L. Craig Carpenter
     */
	public static class TransferServiceBuilder {
		
		private String host;
		private String contentSetName;
		private int    port = -1;
		
		/**
		 * Setter method for the content set name.
		 * @param contentSetName The content set name.
		 */
		public TransferServiceBuilder contentSetName(String contentSetName) {
			this.contentSetName = contentSetName;
			return this;
		}
		
		/**
		 * Setter method for the target host name.
		 * @param host The target host name.
		 */
		public TransferServiceBuilder host(String host) {
			this.host = host;
			return this;
		}
		
		/**
		 * Setter method for the target port.
		 * @param host The target port.
		 */
		public TransferServiceBuilder port(int port) {
			this.port = port;
			return this;
		}
		
		/**
		 * Private internal method used to ensure the required internal
		 * members are set before supplying the caller with the concrete
		 * object.
		 * 
		 * @param obj Candidate <code>TransferServiceImpl</code> object.
		 * @throws IllegalStateException Thrown if any required internal 
		 * members are not set.
		 */
		private void validateObject(TransferServiceImpl obj) 
				throws IllegalStateException {
			if ((obj.host == null) || 
					(obj.host.isEmpty())) {
				throw new IllegalStateException(
						"IllegalStateException: "
						+ "Supplier address not defined.");
			}
			if ((obj.contentSetName == null) || 
					(obj.contentSetName.isEmpty())) {
				throw new IllegalStateException(
						"IllegalStateException: "
						+ "Supplier name not defined.");
			}
			if (obj.port < 0) {
				throw new IllegalStateException("IllegalStateException: "
						+ "Port is out of range!  value => [ "
						+ port
						+ " ].");
			}
		}
		
		/**
		 * Create a concrete <ode>TransferServiceImpl</code> object.
		 * @return Concrete <ode>TransferServiceImpl</code> object.
		 * @throws IllegalStateException Thrown if all required state data is 
		 * not defined.
		 */
		public TransferServiceImpl build() {
			TransferServiceImpl obj = new TransferServiceImpl(this);
			validateObject(obj);
			return obj;
		}
	}
}
