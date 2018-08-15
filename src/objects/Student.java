/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Ibeun Joe Dickson
 */
public class Student implements Serializable{

    public String surname;
    public String fisrtname;
    public String middlename;
    public String matno;
    public String faculty;
    public String department;
    public String gender;
    public String DOB;
    private String suspendStatus;

    public Student(String surname, String fisrtname, String middlename,
            String matno, String faculty, String department, String gender, String DOB, String suspendStatus) {
        this.surname = surname;
        this.fisrtname = fisrtname;
        this.middlename = middlename;
        this.matno = matno;
        this.faculty = faculty;
        this.department = department;
        this.gender = gender;
        this.DOB = DOB;
        this.suspendStatus = suspendStatus;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFisrtname() {
        return fisrtname;
    }

    public void setFisrtname(String fisrtname) {
        this.fisrtname = fisrtname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getMatno() {
        return matno;
    }

    public void setMatno(String matno) {
        this.matno = matno;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
    
    public String getSuspendStatus() {
        return suspendStatus;
    }

    public void setSuspendStatus(String suspendStatus) {
        this.suspendStatus = suspendStatus;
    }

}
