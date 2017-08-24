/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.gof.chainofrep.loanapproval.model;

import java.text.ParseException;

/**
 *
 * @author Estevan
 */
public abstract class AppDeclinedClass {
    AppDeclinedClass app;
    public abstract boolean isApplicationDeclined(ApplicationDetails application,String[] outcome) 
            throws ParseException;
    
    
    public  void setNext(AppDeclinedClass data){
        app = data;
    }
    
    public AppDeclinedClass getNext(){
        return app;
    }
    
}
