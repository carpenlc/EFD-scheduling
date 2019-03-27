package mil.nga.efd.scheduling;

import mil.nga.efd.domain.ContentSet;

public abstract class AbstractContentSetScheduler 
		implements ContentSetSchedulerI {

	/**
	 * Reference to the ContentSet Object for which the scheduled job is 
	 * associated.
	 */
	private ContentSet contentSet;
	
	/**
	 * Default no-arg constructor.
	 */
	public AbstractContentSetScheduler() {}
	
	/**
	 * Getter method for the <code>ContentSet</code> object that is the basis
	 * for the scheduled job. 
	 * 
	 * @return The <code>ContentSet</code> Object associated with the scheduled
	 * job.
	 */
	@Override
	public ContentSet getConfig() {
		return contentSet;
	}
	
	/**
	 * Setter method for the <code>ContentSet</code> object that is the basis
	 * for the scheduled job. 
	 * 
	 * @param contentSet The <code>ContentSet</code> Object associated with the scheduled
	 * job.
	 */
	public void setConfig(ContentSet contentSet) {
		this.contentSet = contentSet;
	}
	
}
