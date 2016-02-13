package enterprise.automatic_timer_client;

import java.util.List;

import javax.naming.InitialContext;

import enterprise.automatic_timer_client.ejb.RemoteStatelessSessionForTest;


public class AutomaticTimerJavaClient {

    public static void main(String args[]) throws Exception {
        System.out.println("Waiting for the timer to expire");
        Thread.sleep(2000);
        System.out.println("Logged timeouts : " );
        List<String> result = getRecords();
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static List<String> getRecords() {

        try {

            InitialContext ic = new InitialContext();
            RemoteStatelessSessionForTest sless = 
                (RemoteStatelessSessionForTest) ic.lookup("TimerStatelessSessionBeanImpl");
	    return (sless.getRecords());

        } catch(Exception e) {
            e.printStackTrace();
        }

	return null;
    }

}
