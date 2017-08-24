/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.gof.chainofrep.loanapproval.model;

import java.text.ParseException;
import java.util.Calendar;

/**
 *
 * @author Estevan
 */
public class anualSalary extends AppDeclinedClass{
    AppDeclinedClass nxtApp;
    public boolean isApplicationDeclined(ApplicationDetails application,String[] outcome) throws ParseException{             
        if (application.getAnn_Sal() < 10000) {
            outcome[0]="Too little income";
            return true;
        }
        else{
            nxtApp.isApplicationDeclined(application, outcome);
            return false;
        }
        
    }
        
    public void setNext(AppDeclinedClass app){
        nxtApp = app;
    }
    
    
    public AppDeclinedClass getNext(){
        return nxtApp;
    }
}
