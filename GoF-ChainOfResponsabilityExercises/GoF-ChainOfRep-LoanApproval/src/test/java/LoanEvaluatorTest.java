
import edu.eci.arsw.gof.chainofrep.loanapproval.model.ApplicationDetails;
import edu.eci.arsw.gof.chainofrep.loanapproval.model.AutomatedLoanEvaluator;
import edu.eci.arsw.gof.chainofrep.loanapproval.model.age;
import edu.eci.arsw.gof.chainofrep.loanapproval.model.anualSalary;
import edu.eci.arsw.gof.chainofrep.loanapproval.model.workExp;
import java.text.ParseException;
import static java.time.Clock.system;
import java.util.Calendar;
import static junit.framework.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hcadavid
 */
public class LoanEvaluatorTest {
    static AutomatedLoanEvaluator ale;
    static ApplicationDetails ad;
    static String outcome[];
    
    @BeforeClass
    public static void config(){
        outcome = new String[1];
        ale = new AutomatedLoanEvaluator();
        ad = new ApplicationDetails("Old", "John", "Connor", "1980-01-01",
                "Single", "11101", 0, "Home Improvement Loan", "742 de Evergreen Terrace", 
                "", "Springfield", "CA", 0, 0, 0, 0, "john123@hotmail.com", 
                "Loan description", "IBM", 30000, 10, 2, 
                "Officer", "342 SouthLake Av", "", "Yorktown", 
                "VA", 3242323); 
        
        
        
    }  
    @Before
    public  void reConfig(){
        outcome[0] ="";
    }
    @Test
    public void deberiaAporbarPorEdadIntermedia() throws ParseException{
        ad.setDob("1995-01-01");
        ad.setWork_Ex_Year(1);
        ad.setWork_Ex_Mon(0);
        ad.setAnn_Sal(40000);      
        assertFalse(ale.isApplicationDeclined(ad,outcome));
    }
    
    @Test
    public void deberiaNegarPorEdadMenor() throws ParseException{
        ad.setDob("2001-01-01");        
        assertTrue(ale.isApplicationDeclined(ad,outcome));
    }
    
    @Test
    public void deberiaNegarPorEdadMayor() throws ParseException{
        ad.setDob("1951-01-01");
        assertTrue(ale.isApplicationDeclined(ad,outcome));
    }
    
    @Test
    public void deberiaNegarPorPocaExperiencia() throws ParseException{
        ad.setWork_Ex_Mon(4);
        ad.setWork_Ex_Year(0);
        assertTrue(ale.isApplicationDeclined(ad,outcome));
    }   
    @Test
    public void deberiaPermitirPorExperiencia() throws ParseException{
        ad.setDob("1995-01-01");
        ad.setWork_Ex_Year(1);
        ad.setWork_Ex_Mon(0);
        assertFalse(ale.isApplicationDeclined(ad,outcome));
    }    
    @Test
    public void deberiaPermitirPorSalario() throws ParseException{
        ad.setAnn_Sal(40000);
        assertFalse(ale.isApplicationDeclined(ad,outcome));
    }
    
    @Test
    public void deberiaNegarPorSalario() throws ParseException{
        ad.setAnn_Sal(9999);
        assertTrue(ale.isApplicationDeclined(ad,outcome));
    }
    
    
    @Test
    public void comprobandoScore1() throws ParseException{
        ad.setDob("1995-01-01");
        ad.setLoan_Purpose("Credit Card");
        ad.setAnn_Sal(9999);
        ad.setWork_Ex_Year(1);
        ad.setWork_Ex_Mon(0);
        assertEquals(310.4725170160689,ale.getScore(ad));
    }
    
    @Test
    public void comprobandoScore2() throws ParseException{
        ad.setDob("1995-01-01");
        ad.setLoan_Purpose("Car Loan");
        ad.setAnn_Sal(9999);
        ad.setWork_Ex_Year(1);
        ad.setWork_Ex_Mon(0);                     
        assertEquals(309.10138911302874,ale.getScore(ad));        
    }

    @Test
    public void comprobandoScore3() throws ParseException{
        ad.setDob("1995-01-01");
        ad.setLoan_Purpose("Debt Consolidation");
        ad.setAnn_Sal(9999);
        ad.setWork_Ex_Year(1);
        ad.setWork_Ex_Mon(0);  
        assertEquals(308.85537511089655,ale.getScore(ad));     
    }
        
    @Test
    public void comprobandoScore4() throws ParseException{
        ad.setDob("1995-01-01");
        ad.setLoan_Purpose("Educational Loan");
        ad.setAnn_Sal(9999);
        ad.setWork_Ex_Year(1);
        ad.setWork_Ex_Mon(0);              
        assertEquals(308.117495029021,ale.getScore(ad));
    }
 
    @Test
    public void comprobandoScore5() throws ParseException{
        ad.setDob("1995-01-01");
        ad.setLoan_Purpose("Home Improvement Loan");
        ad.setAnn_Sal(9999);
        ad.setWork_Ex_Year(1);
        ad.setWork_Ex_Mon(0);          
        assertEquals(309.5231890083958,ale.getScore(ad));
    }  
    @Test
    public void comprobandoScore6() throws ParseException{
        ad.setDob("1995-01-01");
        ad.setLoan_Purpose("House Loan");
        ad.setAnn_Sal(9999);
        ad.setWork_Ex_Year(1);
        ad.setWork_Ex_Mon(0);       
        assertEquals(308.4336993429769,ale.getScore(ad));
    }
    
}
