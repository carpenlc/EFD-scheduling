package mil.nga.efd.controllers;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import mil.nga.efd.domain.ConsumerContentSet;


/**
 * Completely re-wrote to remove dependencies on outdated Hibernate/JPA.
 * 
 * This class extends the generic DAO operations to provide methods for each 
 * of the named queries associated with a consumer content set. The queries 
 * are performed via hibernate/JPA queries.
 * 
 * @author L. Craig Carpenter
 */
@Repository
public class ConsumerContentSetDAOImpl 
		extends GenericDAOImpl<ConsumerContentSet, Long>  
		implements ConsumerContentSetDAO {

	/**
     * Set up the Log4j system for use throughout the class
     */        
    private static final Logger LOGGER = LoggerFactory.getLogger(
    		ConsumerContentSetDAOImpl.class);
    
    /**
     * Default no-arg constructor
     */
    public ConsumerContentSetDAOImpl() {}
    
    /**
     * Retrieve a list of all <code>ConsumerContentSet</code> entities from 
     * the target data source.  This method is required by the superclass.
     * 
     * @return A list of all <code>ConsumerContentSet</code> entities in the 
     * data source.
     */
    public List<ConsumerContentSet> findAll() {
    	
    	List<ConsumerContentSet> results = null;
    	
    	if (em != null) {
    		CriteriaBuilder cb = em.getCriteriaBuilder();
    		CriteriaQuery<ConsumerContentSet> cq = cb.createQuery(ConsumerContentSet.class);
    		Root<ConsumerContentSet> root = cq.from(ConsumerContentSet.class);
    		CriteriaQuery<ConsumerContentSet> all = cq.select(root);
    		TypedQuery<ConsumerContentSet> allQuery = em.createQuery(all);
    		results = allQuery.getResultList();
    	}
    	else {
    		LOGGER.error("The EntityManager object was not injected.  Unable "
				+ "to connect to the target database.  No records selected "
    			+ "from the Alert table.");
    	}
    	return results;
    }
	
    /**
     * Perform hibernate query on the consumer_set_info and content_set 
     * tables.
     * 
     * @param name - The logical name of the content set.
     * @return - A single consumer content set whose logical name matches the 
     * parameter 'name'.
     */
    @SuppressWarnings("unchecked")
	public ConsumerContentSet getConsumerByName(String name) {
    	
        ConsumerContentSet result = null;
        
        if (em != null) {
        	List<ConsumerContentSet> results = 
        			em.createNamedQuery(GET_CONSUMER_BY_NAME)
        				.setParameter("name", name)
        				.getResultList();
        	if (!results.isEmpty()) {
        		result = results.get(0);
        		if (LOGGER.isDebugEnabled()) {
        			LOGGER.debug("Found ConsumerContentSet by name => [ " 
        					+ name
        					+ " ].");
        		}
            }
            else {
            	if (LOGGER.isDebugEnabled()) { 
            		LOGGER.debug("No results obtained in search for "
            				+ "ConsumerContentSet by name => [ "
            				+ name
            				+ " ].");
            	}
            }
        }
    	else {
    		LOGGER.error("The EntityManager object was not injected.  Unable "
    				+ "to connect to the target database.");
    	}
        return result;
    }

    /**
     * Perform hibernate query on the consumer_set_info and content_set tables.
     * @return A complete list of consumer content sets.
     */
    @SuppressWarnings("unchecked")
    public List<ConsumerContentSet> getConsumerSets() {
    	List<ConsumerContentSet> results = null;
        if (em != null) {
        	results = em.createNamedQuery(GET_CONSUMER_SETS)
        			.getResultList();
        }
    	else {
    		LOGGER.error("The EntityManager object was not injected.  Unable "
    				+ "to connect to the target database.");
    	}
        return results;
    }
}
