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
public abstract class getScoreClass {
    getScoreClass nxtScore;
    public abstract double getScore(String purp);
    
    public  void setNext(getScoreClass next){
        nxtScore = next;
    }
    
    public getScoreClass getNext(){
        return nxtScore;
    }       
    
    
}
