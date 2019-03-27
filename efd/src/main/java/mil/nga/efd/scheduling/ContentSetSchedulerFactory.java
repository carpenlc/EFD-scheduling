package mil.nga.efd.scheduling;

import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;


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
	
	
	
	
	
}
