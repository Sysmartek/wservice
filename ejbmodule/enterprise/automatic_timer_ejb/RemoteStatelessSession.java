package enterprise.automatic_timer_ejb;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface RemoteStatelessSession {

    public List<String> getRecords();

}
