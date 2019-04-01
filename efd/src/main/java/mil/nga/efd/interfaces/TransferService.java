package mil.nga.efd.interfaces;

import java.util.List;

import mil.nga.efd.events.SynchronizationEvent;

public interface TransferService {


	public void start(SynchronizationEvent event);

    public void stop(SynchronizationEvent event);
    
    public void sendMetrics(long totalRequests, long totalBytes);
    
    public List<TransferStatus> getCurrentTransfers();
}
