package mil.nga.efd.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mil.nga.efd.controllers.ConsumerContentSetDAO;
import mil.nga.efd.controllers.ContentSetDAO;
import mil.nga.efd.domain.ConsumerContentSet;
import mil.nga.efd.domain.ContentSet;
import mil.nga.efd.interfaces.ContentSetService;
import mil.nga.efd.services.delivery.ConsumerContentSetService;
import mil.nga.efd.services.delivery.SupplierContentSetService;
import mil.nga.efd.validations.exceptions.ValidationException;

@Component
public class ContentSetServiceImpl implements ContentSetService {

	@Autowired
	private ConsumerContentSetDAO consumerContentSets;
	
	@Autowired
	private ContentSetDAO supplierContentSets;
	
	@Autowired
	private SupplierContentSetService supplierManager;
	
	@Autowired
	private ConsumerContentSetService consumerManager;
	
	
	/**
	 * Default no-arg constructor.
	 */
	public ContentSetServiceImpl() {} 
	
	/**
	 * The initialization method retrieves the supplier and consumer content
	 * sets and then initializes the associated content manager objects.
	 */
	@PostConstruct
	public void initialize() {
		consumerManager.registerContentSets(consumerContentSets.getConsumerSets());
		supplierManager.registerContentSets(supplierContentSets.getSupplierSets());
		
		System.out.println("ContentSetServiceImpl instantiated.");
	}

	@Override
	public List<ContentSet> getContentSets() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContentSet> getSuppliers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConsumerContentSet> getConsumers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends ContentSet> T get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long save(ContentSet contentSet) throws ValidationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void enable(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disable(Long id) {
		// TODO Auto-generated method stub
		
	}
}
