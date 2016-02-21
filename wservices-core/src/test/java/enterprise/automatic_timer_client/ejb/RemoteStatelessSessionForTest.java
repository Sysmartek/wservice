package enterprise.automatic_timer_client.ejb;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface RemoteStatelessSessionForTest {

    public List<String> getRecords();

}
