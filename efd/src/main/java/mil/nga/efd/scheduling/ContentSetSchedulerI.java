package mil.nga.efd.scheduling;

import mil.nga.efd.domain.ContentSet;

public interface ContentSetSchedulerI {

	/**
	 * Getter method for the <code>ContentSet</code> object that is the basis
	 * for the scheduled job. 
	 * 
	 * @return The <code>ContentSet</code> Object associated with the scheduled
	 * job.
	 */
	public ContentSet getConfig();
}
