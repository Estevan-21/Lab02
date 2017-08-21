
import edu.eci.arsw.gof.chainofrep.loanapproval.model.ApplicationDetails;
import edu.eci.arsw.gof.chainofrep.loanapproval.model.AutomatedLoanEvaluator;
import java.text.ParseException;
import static java.time.Clock.system;
import java.util.Calendar;
import static junit.framework.Assert.*;
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
    @Test
    public void deberiaAporbarPorEdadIntermedia() throws ParseException{
        AutomatedLoanEvaluator ale = new AutomatedLoanEvaluator();
        ApplicationDetails ad = new ApplicationDetails("Old", "John", "Connor", "1980-01-01",
                "Single", "11101", 0, "Home Improvement Loan", "742 de Evergreen Terrace", 
                "", "Springfield", "CA", 0, 0, 0, 0, "john123@hotmail.com", 
                "Loan description", "IBM", 30000, 10, 2, 
                "Officer", "342 SouthLake Av", "", "Yorktown", 
                "VA", 3242323);
        
        String outcome[]=new String[1];
        assertTrue(!ale.isApplicationDeclined(ad,outcome));
    }
    @Test
    public void deberiaNegarPorEdadMenor() throws ParseException{
        AutomatedLoanEvaluator ale = new AutomatedLoanEvaluator();
        ApplicationDetails ad = new ApplicationDetails("Old", "John", "Connor", "2001-01-01",
                "Single", "11101", 0, "Home Improvement Loan", "742 de Evergreen Terrace", 
                "", "Springfield", "CA", 0, 0, 0, 0, "john123@hotmail.com", 
                "Loan description", "IBM", 30000, 10, 2, 
                "Officer", "342 SouthLake Av", "", "Yorktown", 
                "VA", 3242323);
        
        String outcome[]=new String[1];
        assertTrue(ale.isApplicationDeclined(ad,outcome));
    
    }
    @Test
    public void deberiaNegarPorEdadMayor() throws ParseException{
        AutomatedLoanEvaluator ale = new AutomatedLoanEvaluator();
        ApplicationDetails ad = new ApplicationDetails("Old", "John", "Connor", "1951-01-01",
                "Single", "11101", 0, "Home Improvement Loan", "742 de Evergreen Terrace", 
                "", "Springfield", "CA", 0, 0, 0, 0, "john123@hotmail.com", 
                "Loan description", "IBM", 30000, 10, 2, 
                "Officer", "342 SouthLake Av", "", "Yorktown", 
                "VA", 3242323);
        
        String outcome[]=new String[1];
        assertTrue(ale.isApplicationDeclined(ad,outcome));
    }
    @Test
    public void deberiaNegarPorPocaExperiencia() throws ParseException{
        AutomatedLoanEvaluator ale = new AutomatedLoanEvaluator();
        ApplicationDetails ad = new ApplicationDetails("Old", "John", "Connor", "1995-01-01",
                "Single", "11101", 0, "Home Improvement Loan", "742 de Evergreen Terrace", 
                "", "Springfield", "CA", 0, 0, 0, 0, "john123@hotmail.com", 
                "Loan description", "IBM", 30000, 0, 4, 
                "Officer", "342 SouthLake Av", "", "Yorktown", 
                "VA", 3242323);
        
        String outcome[]=new String[1];
        assertTrue(ale.isApplicationDeclined(ad,outcome));

    }
    @Test
    public void deberiaPermitirPorExperiencia() throws ParseException{
        AutomatedLoanEvaluator ale = new AutomatedLoanEvaluator();
        ApplicationDetails ad = new ApplicationDetails("Old", "John", "Connor", "1995-01-01",
                "Single", "11101", 0, "Home Improvement Loan", "742 de Evergreen Terrace", 
                "", "Springfield", "CA", 0, 0, 0, 0, "john123@hotmail.com", 
                "Loan description", "IBM", 30000, 1, 0, 
                "Officer", "342 SouthLake Av", "", "Yorktown", 
                "VA", 3242323);
        
        String outcome[]=new String[1];
        assertTrue(!ale.isApplicationDeclined(ad,outcome));

    }
    @Test
    public void deberiaPermitirPorSalario() throws ParseException{
        AutomatedLoanEvaluator ale = new AutomatedLoanEvaluator();
        ApplicationDetails ad = new ApplicationDetails("Old", "John", "Connor", "1995-01-01",
                "Single", "11101", 0, "Home Improvement Loan", "742 de Evergreen Terrace", 
                "", "Springfield", "CA", 0, 0, 0, 0, "john123@hotmail.com", 
                "Loan description", "IBM", 30000, 1, 0, 
                "Officer", "342 SouthLake Av", "", "Yorktown", 
                "VA", 3242323);
        
        String outcome[]=new String[1];
        assertTrue(!ale.isApplicationDeclined(ad,outcome));

    }
    @Test
    public void deberiaNegarPorSalario() throws ParseException{
        AutomatedLoanEvaluator ale = new AutomatedLoanEvaluator();
        ApplicationDetails ad = new ApplicationDetails("Old", "John", "Connor", "1995-01-01",
                "Single", "11101", 0, "Home Improvement Loan", "742 de Evergreen Terrace", 
                "", "Springfield", "CA", 0, 0, 0, 0, "john123@hotmail.com", 
                "Loan description", "IBM", 9999, 1, 0, 
                "Officer", "342 SouthLake Av", "", "Yorktown", 
                "VA", 3242323);
        
        String outcome[]=new String[1];
        assertTrue(ale.isApplicationDeclined(ad,outcome));

    }
    
}
