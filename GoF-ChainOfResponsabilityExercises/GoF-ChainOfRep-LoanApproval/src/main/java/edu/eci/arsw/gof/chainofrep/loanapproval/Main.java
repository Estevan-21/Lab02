/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.gof.chainofrep.loanapproval;

import edu.eci.arsw.gof.chainofrep.loanapproval.model.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hcadavid
 */
public class Main {

    public static void main(String args[]) throws ParseException {

        ApplicationDetails ad = new ApplicationDetails("John", "", "Connor", "1980-01-01",
                "Single", "11101", 0, "Home Improvement Loan", "742 de Evergreen Terrace", 
                "", "Springfield", "CA", 0, 0, 0, 0, "john123@hotmail.com", 
                "Loan description", "IBM", 30000, 10, 2, 
                "Officer", "342 SouthLake Av", "", "Yorktown", 
                "VA", 3242323);
        
        String outcome[]=new String[1];
        
        CarLoan score1= new CarLoan();
        CreditCard score2= new CreditCard();
        DebtConsolidation score3= new DebtConsolidation();
        EducationalLoan score4= new EducationalLoan();
        HomeImprovementLoan score5= new HomeImprovementLoan();
        HouseLoan score6= new HouseLoan();
        
        score1.setNext(score2);
        score2.setNext(score3);
        score3.setNext(score4);
        score4.setNext(score5);
        score5.setNext(score6);
        
        age app1=new age();
        workExp app2=new workExp();
        anualSalary app3=new anualSalary();
        
        if (app1.isApplicationDeclined(ad,outcome)){
            LOG.log(Level.INFO, "Application cannot be considered:{0}", outcome[0]);
        }
        else{            
            String purp = ad.getLoan_Purpose();
            double p = score1.getScore(purp);
            double loaninc_ratio = (ad.getLoan_Amount()) / (ad.getAnn_Sal());
            int des = 0;
            double x = -0.30720295 - (2.42709152 * loaninc_ratio) - (1.61109691 * 0.01 * ad.getWork_Ex_Year())+p*0.212 ;
            double probability = 1 / (1 + Math.exp(-1 * x));
            double score = probability * 666.67;
            
            LOG.log(Level.INFO, "Application score:{0}",score);
        }
        
    }
    
    private static final Logger LOG = Logger.getLogger(Main.class.getName());

}
