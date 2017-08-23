/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.gof.chainofrep.fileproc;

import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author hcadavid
 */
public class Main {
    private DataProcessor nxtProc;
    public static void main(String args[]) throws DataLoadException{
        System.out.println("Processing data...");
        XMLProcessor process1 = new XMLProcessor();
        CSVProcessor process2 = new CSVProcessor();
        JSONProcessor process3 = new JSONProcessor();
        TXTProcessor process4 = new TXTProcessor();
        UnknownFormatProcessor unFor = new UnknownFormatProcessor();
        
        process1.setNext(process2);
        process2.setNext(process3);
        process3.setNext(process4);
        process4.setNext(unFor);
        
        process1.loadAndProcessData("mistados.json");
        System.out.println("Done. Execution finished.");
    }
}
