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
public class age  extends AppDeclinedClass{
    AppDeclinedClass nxtApp;
    public boolean isApplicationDeclined(ApplicationDetails application,String[] outcome) throws ParseException{
      int curYear = Calendar.getInstance().get(Calendar.YEAR);
        String dobYear = application.getDob();
        int age = curYear - Integer.parseInt(dobYear.substring(0, 4));
        
        if (age > 65 || age < 18) {
            outcome[0]="Too young or too old";
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
