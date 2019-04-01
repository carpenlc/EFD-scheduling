package mil.nga.efd.services.delivery;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import mil.nga.efd.domain.ConsumerContentSet;


@Component
public class ConsumerContentSetService {
	
	/**
     * Set up the Log4j system for use throughout the class
     */        
    private static final Logger LOGGER = LoggerFactory.getLogger(
    		ConsumerContentSetService.class);
    
	public void registerContentSets(List<ConsumerContentSet> contentSets) {
		if ((contentSets != null) && (contentSets.size() > 0)) {
			for (ConsumerContentSet contentSet : contentSets) {
				
			}
		}
		else {
			LOGGER.warn("The input list of consumer content sets is null or "
					+ "contains no entries.  Nothing to schedule.");
		}
	}
}
