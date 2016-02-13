package enterprise.automatic_timer_ejb.persistence;

import javax.persistence.*;

//name defaults to the unqualified entity class name.        
//default access is property.
@Entity
@NamedQueries({
    @NamedQuery(name = "LogRecord.countLoggedTimeouts", query = "select count(l) from LogRecord l where l.record NOT LIKE 'Canceling timer%'"),
    @NamedQuery(name = "LogRecord.findAllRecords", query = "select l.record from LogRecord l")
})
public class LogRecord {
    
    @Id 
    @GeneratedValue
    private int id;
    private String record;
    
    public LogRecord(String record) {
        setRecord(record);
    }
    
    public LogRecord() {
    }
    
    public String getRecord() {
        return record;
    }
    public void setRecord(String record) {
        this.record = record;
    }
    
    
}
