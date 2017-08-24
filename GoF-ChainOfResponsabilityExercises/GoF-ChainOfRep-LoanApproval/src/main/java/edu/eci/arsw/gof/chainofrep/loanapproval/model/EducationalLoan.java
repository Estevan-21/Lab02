/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.gof.chainofrep.loanapproval.model;

/**
 *
 * @author Estevan
 */
public class EducationalLoan extends getScoreClass {
    getScoreClass nxtScore;
    public double getScore(String purp) {
        if (purp.equalsIgnoreCase("Car Loan")) {
            return 0.810;
        }
        else {
               nxtScore.getScore(purp);
               return 0.815;
                }
    }
    
    public void setNext(getScoreClass sco){
        nxtScore = sco;
    }
    public getScoreClass getNext(){
        return nxtScore;
    }
}
