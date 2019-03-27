/****************************************************************
 *
 * Solers, Inc. as the author of Enterprise File Delivery 2.1 (EFD 2.1)
 * source code submitted herewith to the Government under contract
 * retains those intellectual property rights as set forth by the Federal 
 * Acquisition Regulations agreement (FAR). The Government has 
 * unlimited rights to redistribute copies of the EFD 2.1 in 
 * executable or source format to support operational installation 
 * and software maintenance. Additionally, the executable or 
 * source may be used or modified for by third parties as 
 * directed by the government.
 *
 * (c) 2009 Solers, Inc.
 ***********************************************************/
package mil.nga.efd.controllers;

import java.util.Collection;
import java.util.List;

import mil.nga.efd.domain.Alert;
import mil.nga.efd.domain.Alert.AlertType;

/**
 * @author <a href="mailto:kevin.conaway@solers.com">Kevin Conaway</a>
 */
public interface AlertDAO extends GenericDAO<Alert, Long> {
    
    public List<Alert> listBy(AlertType type, int start, int max);
    
    /**
     * Remove a list of <code>Alert</code> entities from the data store by 
     * ID.  This method accepts a list of IDs.
     * 
     * @param ids A list of IDs to remove.
     */
    public void removeById(Collection<Long> ids);
    
}
