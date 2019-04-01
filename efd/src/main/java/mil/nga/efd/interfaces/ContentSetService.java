package mil.nga.efd.interfaces;

import java.util.List;

import mil.nga.efd.domain.ConsumerContentSet;
import mil.nga.efd.domain.ContentSet;
import mil.nga.efd.validations.exceptions.ValidationException;

public interface ContentSetService {
	    
    /**
     * @return A list of consumer and supplier content sets
     */
    List<ContentSet> getContentSets();
    
    /**
     * @return A list of supplier content sets
     */
    List<ContentSet> getSuppliers();
    
    /**
     * @return A list of consumer content sets
     */
    List<ConsumerContentSet> getConsumers();
    
    /**
     * @param id
     * @return The content set with the given id or null if it doesn't exist
     */
    <T extends ContentSet> T get(Long id);
    
    /**
     * Save the given content set data.  If the data does not exist, it will be
     * created
     * 
     * @param contentSet
     * @return The id of the content set
     * @throws ValidationException
     */
    Long save(ContentSet contentSet) throws ValidationException;
    
    /**
     * Delete the given content set
     * 
     * @param contentSet
     */
    void remove(Long id);
    
    /**
     * Enable the given content set
     * @param id
     */
    void enable(Long id);
    
    /**
     * Disable the given content set
     * @param id
     */
    void disable(Long id);

}
