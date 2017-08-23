/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.gof.chainofrep.fileproc;

import java.util.logging.Logger;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author hcadavid
 */


public abstract class DataProcessor{
    DataProcessor nxtProc;
    public abstract void loadAndProcessData(String fileName) throws DataLoadException;
    public  void setNext(DataProcessor dataProc){
        nxtProc = dataProc;
    }
    public DataProcessor getNext(){
        return nxtProc;
    }
    public String extension(String fileName){
        return FilenameUtils.getExtension(fileName);
    }
}


