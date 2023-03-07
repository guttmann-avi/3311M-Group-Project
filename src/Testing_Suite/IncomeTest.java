package src.Testing_Suite;
import java.util.Date;

import src.BudgetingSystem.Income;
import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
public class IncomeTest {



    
    @Test
    public void testGetAmount() {
        Income income = new Income(1000.0, "Salary", new Date());
        assertEquals(1000.0, income.getAmount(), 0.0);
    }
    
    @Test
    public void testSetAmount() {
        Income income = new Income(0.0, "Salary", new Date());
        income.setAmount(2000.0);
        assertEquals(2000.0, income.getAmount(), 0.0);
    }
    
    @Test
    public void testGetSource() {
        Income income = new Income(1000.0, "Salary", new Date());
        assertEquals("Salary", income.getSource());
    }
    
    @Test
    public void testSetSource() {
        Income income = new Income(1000.0, "Salary", new Date());
        income.setSource("Bonus");
        assertEquals("Bonus", income.getSource());
    }
    
    @Test
    public void testGetDate() {
        Date date = new Date();
        Income income = new Income(1000.0, "Salary", date);
        assertEquals(date, income.getDate());
    }
    
    @Test
    public void testSetDate() {
        Date date1 = new Date();
        Date date2 = new Date(date1.getTime() + 1000);
        Income income = new Income(1000.0, "Salary", date1);
        income.setDate(date2);
        assertEquals(date2, income.getDate());
    }

}



