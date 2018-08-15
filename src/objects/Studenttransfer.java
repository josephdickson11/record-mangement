
package objects;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Ibeun Joe Dickson
 */
public class Studenttransfer implements Serializable{

    public String matricNo;
    public String destination;
    public String reason;
    public String faculty;
    public String Dept;
    public Date dateOfrequest;
    public String schlStatusOfReq;
    public String deptStatusOfReq;

    public Studenttransfer(String matricNo, String destination, String reason, String faculty, String Dept, String schlStatusOfReq, String deptStatusOfReq) {
        this.matricNo = matricNo;
        this.destination = destination;
        this.reason = reason;
        this.faculty = faculty;
        this.Dept = Dept;
        this.schlStatusOfReq = schlStatusOfReq;
        this.deptStatusOfReq = deptStatusOfReq;
        dateOfrequest = new Date();

    }

    public String getMatricNo() {
        return matricNo;
    }

    public String getDestination() {
        return destination;
    }

    public String getReason() {
        return reason;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getDept() {
        return Dept;
    }

    public String getSchlStatusOfReq() {
        return schlStatusOfReq;
    }

    public void setSchlStatusOfReq(String schlStatusOfReq) {
        this.schlStatusOfReq = schlStatusOfReq;
    }
    
    public String getDeptStatusOfReq() {
        return deptStatusOfReq;
    }
    
    public void setDeptStatusOfReq(String deptStatusOfReq) {
        this.deptStatusOfReq = deptStatusOfReq;
    }
    public Date getDateOfrequest() {
        return dateOfrequest;
    }
}
