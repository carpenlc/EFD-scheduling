package mil.nga.efd.scheduling;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.listeners.TriggerListenerSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ScheduledJobMonitor extends TriggerListenerSupport {

	/**
	 * Set up the logback system for the class.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(
			ScheduledJobMonitor.class);
	
	/**
	 * Default name for the trigger listener.
	 */
	public static final String DEFAULT_LISTENER_NAME="JobMonitor";
	
	/**
	 * Custom name for the current ScheduledJobMonitor.
	 */
	private String listenerName;
	
	/**
	 * Getter method for the name of the current trigger listener.
	 * @return The listener name.
	 */
	@Override
	public String getName() {
		if ((listenerName == null) || (listenerName.isEmpty())) {
			return DEFAULT_LISTENER_NAME;
		}
		else {
			return listenerName;
		}
	}
	
	/**
	 * Setter method for the listener name.
	 * @param name The listener name.
	 */
	public void setName(String name) {
		listenerName = name;
	}

	/**
	 * Overridden method logging the fact that the trigger completed execution.
	 */
	public void triggerComplete(
			Trigger trigger, 
			JobExecutionContext context, 
			Trigger.CompletedExecutionInstruction triggerInstructionCode) {
		LOGGER.info("Trigger complete.  Completion code [ "
				+ triggerInstructionCode.toString()
				+ " ].");
	}
}
