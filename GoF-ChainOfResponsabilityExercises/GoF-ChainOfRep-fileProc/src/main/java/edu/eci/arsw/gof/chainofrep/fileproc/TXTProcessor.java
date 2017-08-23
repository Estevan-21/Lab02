/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.gof.chainofrep.fileproc;

/**
 *
 * @author hp
 */
public class TXTProcessor extends DataProcessor {
    DataProcessor nxtProc;
    public void loadAndProcessData(String fileName) throws DataLoadException{
        if (extension(fileName).equals("txt")){
            System.out.println("Processing TXT...");
        } else{
            nxtProc.loadAndProcessData(fileName);
        }
    }
    public void setNext(DataProcessor dataProc){
        nxtProc = dataProc;
    }
    public DataProcessor getNext(){
        return nxtProc;
    }
}
