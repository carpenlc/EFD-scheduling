package mil.nga.efd.scheduling;

import javax.annotation.PostConstruct;

import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;


/**
 * This class represents a complete re-write of the EFD scheduling subsystem.
 * The original 
 * 
 * @author L. Craig Carpenter
 */
@Component
@Configurable
public class ContentSetSchedulerFactory {

	/** 
	 * Group name for consumer jobs.
	 */
	public static final String CONSUMER_JOB_GROUP = "JOBGROUP.CONSUMER";
	
	/**
	 * Group name for supplier jobs.
	 */
	public static final String SUPPLIER_JOB_GROUP = "JOBGROUP.SUPPLIER";
	
	/**
	 * Set up the logback system for the class.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(
			ContentSetSchedulerFactory.class);
	
	/**
	 * Injected reference to the <code>org.quartz.Scheduler</code>
	 */
	@Autowired
	public Scheduler scheduler;
	
	/**
	 * Default no-arg constructor.
	 */
	public ContentSetSchedulerFactory() {}
	
	@PostConstruct
	public void checkAutowiring() {
		if (scheduler == null) {
			System.out.println("ERROR: Quartz scheduler not injected!");
		}
		else {
			System.out.println("We're good with Quartz.");
		}
		
	}

	
}
