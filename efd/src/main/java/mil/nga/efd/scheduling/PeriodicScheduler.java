package mil.nga.efd.scheduling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class replaces the legacy com.solers class that relied on the java 
 * concurrency libraries for periodically executing jobs for which no cron
 * schedule was defined.
 * 
 * @author L. Craig Carpenter
 *
 */
public class PeriodicScheduler extends AbstractContentSetScheduler {

	/**
	 * Set up the logback system for the class.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(
			PeriodicScheduler.class);
	
	
}
