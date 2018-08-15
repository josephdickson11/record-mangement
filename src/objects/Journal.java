/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Ibeun Joe Dickson
 */
public class Journal implements Serializable{
    
    private String id, activity, action;
    private Date date;

    public Journal(String activity, String action) {
        this.activity = activity;
        this.action = action;
        id = String.valueOf(mainproject.Mainproject.jMemory.size() + 1);
        
        date = new Date();
    }

    public String getId() {
        return id;
    }

    public String getActivity() {
        return activity;
    }

    public String getAction() {
        return action;
    }

    public Date getDate() {
        return date;
    }
    
    
    
}
