package enterprise.automatic_timer_ejb;

import java.util.Date;
import java.util.List;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.ejb.Timer;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import enterprise.automatic_timer_ejb.persistence.LogRecord;

@Stateless(mappedName = "TimerStatelessSessionBeanImpl")
public class TimerStatelessSessionBeanImpl implements RemoteStatelessSession {

    @PersistenceContext 
    EntityManager em;

    @Schedule(second="*/3", minute="*", hour="*", info="Automatic Timer Test")
    public void test_automatic_timer(Timer t) {
        long count = (Long)em.createNamedQuery("LogRecord.countLoggedTimeouts").getSingleResult();

        System.out.println("Call # " + (count + 1));
        if (count > 10) {
            throw new IllegalStateException("Too many timeouts received: " + count);
        } else if (count == 10) {
            LogRecord lr = new LogRecord("Canceling timer " + t.getInfo() + " at " + new Date());
            em.persist(lr);
            t.cancel();
            System.out.println("Done");
        } else {
            LogRecord lr = new LogRecord("" + t.getInfo() + " timeout received at " + new Date());
            em.persist(lr);
        }
    }

    public List<String> getRecords() {
        return (List<String>)em.createNamedQuery("LogRecord.findAllRecords").getResultList();
    }
}
