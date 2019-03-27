package mil.nga.efd.controllers;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import mil.nga.efd.domain.ContentSet;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Completely re-wrote to remove dependencies on outdated Hibernate.  This 
 * class extends the generic DAO operations to provide methods for each of 
 * the named queries associated with a content set. The queries are
 * performed via hibernate queries.
 * 
 * @author L. Craig Carpenter
 */
@Transactional
@Repository
public class ContentSetDAOImpl 
		extends GenericDAOImpl<ContentSet, Long> 
		implements ContentSetDAO {

	/**
     * Set up the Log4j system for use throughout the class
     */        
    private static final Logger LOGGER = LoggerFactory.getLogger(
    		ContentSetDAOImpl.class);
	
    /**
     * Default no-arg constructor.
     */
    public ContentSetDAOImpl() { }
    
    /**
     * Retrieve a list of all <code>ConsumerContentSet</code> entities from 
     * the target data source.  This method is required by the superclass.
     * 
     * @return A list of all <code>ConsumerContentSet</code> entities in the 
     * data source.
     */
    public List<ContentSet> findAll() {
    	
    	List<ContentSet> results = null;
    	
    	if (em != null) {
    		CriteriaBuilder cb = em.getCriteriaBuilder();
    		CriteriaQuery<ContentSet> cq = cb.createQuery(ContentSet.class);
    		Root<ContentSet> root = cq.from(ContentSet.class);
    		CriteriaQuery<ContentSet> all = cq.select(root);
    		TypedQuery<ContentSet> allQuery = em.createQuery(all);
    		results = allQuery.getResultList();
    	}
    	else {
    		LOGGER.error("The EntityManager object was not injected.  Unable "
				+ "to connect to the target database.  No records selected "
    			+ "from the content_set table.");
    	}
    	return results;
    }
    
    /**
     * Perform hibernate query on the content_set table.
     * 
     * @param name -
     *            The logical name of the supplier content set.
     * @return - A single content set whose logical name matches the parameter 'name'.
     */
    @SuppressWarnings("unchecked")
	public ContentSet getSupplierByName(String name) {
    	
        ContentSet result = null;
        
        if (em != null) {
	    	List<ContentSet> results = em.createNamedQuery(GET_SUPPLIER_BY_NAME)
	    			.setParameter("name", name)
	    			.getResultList();
        	if (!results.isEmpty()) {
        		result = results.get(0);
        		if (LOGGER.isDebugEnabled()) {
        			LOGGER.debug("Found ContentSet by name => [ " 
        					+ name
        					+ " ].");
        		}
            }
        	else {
        		if (LOGGER.isDebugEnabled()) {
        			LOGGER.debug("Unable to find any ContentSet records by "
        					+ "name => [ " 
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
     * Perform hibernate query on the content_set table.
     * 
     * @return A complete list of supplier content sets.
     */
    @SuppressWarnings("unchecked")
    public List<ContentSet> getSupplierSets() {
        List<ContentSet> results = null;
        if (em != null) {
	    	results = em.createNamedQuery(GET_SUPPLIER_SETS)
	    			.getResultList();
	    	if (results.isEmpty()) {
        		if (LOGGER.isDebugEnabled()) {
        			LOGGER.debug("Unable to find any supplier sets.");
        		}
            }
        }
    	else {
    		LOGGER.error("The EntityManager object was not injected.  Unable "
    				+ "to connect to the target database.");
    	}
        return results;
    }
}
