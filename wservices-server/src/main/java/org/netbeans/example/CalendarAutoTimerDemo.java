package org.netbeans.example;

import java.util.Date;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Startup;
import javax.ejb.Timer;

@Singleton
@LocalBean
public class CalendarAutoTimerDemo {

    @Schedule(second="55", minute="*", hour="*")
    public String execute(Timer timer) {
        System.out.println("Executing ...");
        System.out.println("Execution Time : " + new Date());
        System.out.println("____________________________________________");  
        
        return "Execution Time : " + new Date();
        
    }
}