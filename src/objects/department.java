/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.Serializable;

/**
 *
 * @author Ibeun Joe Dickson
 */
public class department implements Serializable{

    public String faculty;
    public String departmentname;
    public String deptabbrv;
    public String HODname;
    public String yearofstudy;
    public String programme;

    public department(String faculty, String departmentname, String deptabbrv, String HODname, String yearofstudy, String programme) {
        this.faculty = faculty;
        this.departmentname = departmentname;
        this.deptabbrv = deptabbrv;
        this.HODname = HODname;
        this.yearofstudy = yearofstudy;
        this.programme = programme;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public String getDeptabbrv() {
        return deptabbrv;
    }

    public void setDeptabbrv(String deptabbrv) {
        this.deptabbrv = deptabbrv;
    }

    public String getHODname() {
        return HODname;
    }

    public void setHODname(String HODname) {
        this.HODname = HODname;
    }

    public String getYearofstudy() {
        return yearofstudy;
    }

    public void setYearofstudy(String yearofstudy) {
        this.yearofstudy = yearofstudy;
    }

}
