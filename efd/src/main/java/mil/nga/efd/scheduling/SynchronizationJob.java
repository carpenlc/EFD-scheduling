package mil.nga.efd.scheduling;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mil.nga.efd.domain.ConsumerContentSet;
import mil.nga.efd.interfaces.TransferService;
import mil.nga.efd.services.TransferServiceImpl;



/**
 * 
 * @author L. Craig Carpenter
 *
 */
public class SynchronizationJob implements Job {

	/**
     * Set up the Log4j system for use throughout the class
     */        
    private static final Logger LOGGER = LoggerFactory.getLogger(
    		SynchronizationJob.class);
    
	private final ConsumerContentSet config; 
	private final TransferService    transferService;

	
	protected SynchronizationJob(SynchronizationJobBuilder builder) {
		this.config          = builder.config;
		this.transferService = builder.transferService;
	}
	
	
	
	/**
	 * 
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		
		//JobDataMap map = new JobDataMap();
		//map.put("job-name", new SynchronizationJob());
		//JobBuilder.newJob().usingJobData(map).build();
	}

	
	public static class SynchronizationJobBuilder {
		
		private ConsumerContentSet config;
		private TransferService    transferService;
		
		/**
		 * Setter method for the <code>ConsumerContentSet</code> 
		 * configuration data.
		 * @param config The <code>ConsumerContentSet</code> configuration
		 * data.
		 */
		public SynchronizationJobBuilder withContentSet(ConsumerContentSet config) {
			this.config = config;
			return this;
		}
		
		/**
		 * Setter method for the <code>TransferService</code> 
		 * configuration data.
		 * @param config The <code>TransferService</code> configuration
		 * data.
		 */
		public SynchronizationJobBuilder withTransferService(TransferService transferService) {
			this.transferService = transferService;
			return this;
		}
		
		/**
		 * Create a concrete <code>SynchronizationJob</code> object.
		 * @return Concrete <ode>SynchronizationJob</code> object.
		 * @throws IllegalStateException Thrown if all required state data is 
		 * not defined.
		 */
		public SynchronizationJob build() throws IllegalStateException {
			if (config == null) {
				throw new IllegalStateException("IllegalStateException: "
						+"Required ConsumerContentSet data not supplied.");
			}
			if (transferService == null) {
				transferService = new TransferServiceImpl.TransferServiceBuilder()
						.contentSetName(config.getSupplierName())
						.host(config.getSupplierAddress())
						.port(config.getSupplierPort())
						.build();
			}
			return new SynchronizationJob(this);
		}
		
	}
}
