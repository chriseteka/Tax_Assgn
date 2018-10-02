
package tax_assgn;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class StatusMarriedFilingSeperately {
    private Scanner input = new Scanner(System.in);
    
    public List<String> SeperatelyMarriedStatusList = new ArrayList<>();
    private String response = "STATUS(MARRIED FILING SEPERATELY): TAX PAYABLE BY YOU IS: ";
    
    public double tax;
    public String rtax;
    DecimalFormat df = new DecimalFormat("'#'##,###,###.00#");
    
    //OBJECTS OF SOME NEEDED CLASSES
    private TaxRates taxRate = new TaxRates();
    private ReExecuteProgram execute = new ReExecuteProgram();
    
    //THIS METHOD WORKS WITH THE CONSOLE
    public double taxPayable()
    {
        System.out.println("ENTER YOUR INCOME: ");
        if(input.hasNextDouble()) //CHECKS IF INPUT IS A VALID NUMBER
        {
            double income = input.nextDouble(); //ASSIGNS THE VALUE ENTERED TO VARIABLE INCOME

            //LEVEL ONE SINGLE EARNER
            if(income > 0 && income <= 25000)
            {
                tax = income * taxRate.levelOne;
                rtax = df.format(tax);
                System.out.println(response + rtax);
                execute.reExecuteProgram();
            }
            //LEVEL TWO SINGLE EARNER
            else if (income > 25000 && income <= 135000)
            {
                double temp_income = 25000;
                double temp_tax = temp_income * taxRate.levelOne;
                tax = (temp_tax) + ((income - temp_income) * taxRate.levelTwo);
                rtax = df.format(tax);
                System.out.println(response + rtax);
                execute.reExecuteProgram();
            }
            //LEVEL THREE SINGLE EARNER
            else if (income > 135000 && income <= 330000)
            {
                double temp_income = 135000;
                double temp_tax = temp_income * taxRate.levelTwo;
                tax = (temp_tax) + ((income - temp_income) * taxRate.levelThree);
                rtax = df.format(tax);
                System.out.println(response + rtax);
                execute.reExecuteProgram();
            }
            //LEVEL FOUR SINGLE EARNER
            else if (income > 330000 && income <= 600000)
            {
                double temp_income = 330000;
                double temp_tax = temp_income * taxRate.levelThree;
                tax = (temp_tax) + ((income - temp_income) * taxRate.levelFour);
                rtax = df.format(tax);
                System.out.println(response + rtax);
                execute.reExecuteProgram();
            }
            //LEVEL FIVE SINGLE EARNER
            else if (income > 600000 && income <= 1000000)
            {
                double temp_income = 600000;
                double temp_tax = temp_income * taxRate.levelFour;
                tax = (temp_tax) + ((income - temp_income) * taxRate.levelFive);
                rtax = df.format(tax);
                System.out.println(response + rtax);
                execute.reExecuteProgram();
            }
            //LEVEL SIX SINGLE EARNER
            else if (income > 1000000)
            {
                double temp_income = 1000000;
                double temp_tax = temp_income * taxRate.levelFive;
                tax = (temp_tax) + ((income - temp_income) * taxRate.levelSix);
                rtax = df.format(tax);
                System.out.println(response + rtax);
                execute.reExecuteProgram();
            }
            //INVALID INPUT ENTERED, DUE TO NEGATIVE INPUT
            else
            {
                System.out.println("ERROR, YOU HAVE INPUTED A NEGATIVE NUMBER");
                System.out.println("");
                System.out.println("____________________________________________");
                Tax_Assgn.beginExecution();
                System.out.println("");
            }
        }
        //INVALID INPUT ENTERED, DUE TO TYPE MISMATCH
        else
        {
            System.out.println("ERROR, YOU HAVE INPUTED AN ALPHABET IN PLACE OF NUMBER");
            Tax_Assgn.beginExecution();
        }
        return tax; 
    }
    
    //THIS METHOD WORKS WITH THE GUI
    public double fixedPayableTax(double income)
    {
        if(income > 0)
        {
            //LEVEL ONE SINGLE EARNER
            if(income > 0 && income <= 25000)
            {
                tax = income * taxRate.levelOne;
                rtax = df.format(tax);
                JOptionPane.showMessageDialog(null, response+rtax, "OUTPUT PANEL", JOptionPane.INFORMATION_MESSAGE);
            }
            //LEVEL TWO SINGLE EARNER
            else if (income > 25000 && income <= 135000)
            {
                double temp_income = 25000;
                double temp_tax = temp_income * taxRate.levelOne;
                tax = (temp_tax) + ((income - temp_income) * taxRate.levelTwo);
                rtax = df.format(tax);
                JOptionPane.showMessageDialog(null, response+rtax, "OUTPUT PANEL", JOptionPane.INFORMATION_MESSAGE);
            }
            //LEVEL THREE SINGLE EARNER
            else if (income > 135000 && income <= 330000)
            {
                double temp_income = 135000;
                double temp_tax = temp_income * taxRate.levelTwo;
                tax = (temp_tax) + ((income - temp_income) * taxRate.levelThree);
                rtax = df.format(tax);
                JOptionPane.showMessageDialog(null, response+rtax, "OUTPUT PANEL", JOptionPane.INFORMATION_MESSAGE);
            }
            //LEVEL FOUR SINGLE EARNER
            else if (income > 330000 && income <= 600000)
            {
                double temp_income = 330000;
                double temp_tax = temp_income * taxRate.levelThree;
                tax = (temp_tax) + ((income - temp_income) * taxRate.levelFour);
                rtax = df.format(tax);
                JOptionPane.showMessageDialog(null, response+rtax, "OUTPUT PANEL", JOptionPane.INFORMATION_MESSAGE);
            }
            //LEVEL FIVE SINGLE EARNER
            else if (income > 600000 && income <= 1000000)
            {
                double temp_income = 600000;
                double temp_tax = temp_income * taxRate.levelFour;
                tax = (temp_tax) + ((income - temp_income) * taxRate.levelFive);
                rtax = df.format(tax);
                JOptionPane.showMessageDialog(null, response+rtax, "OUTPUT PANEL", JOptionPane.INFORMATION_MESSAGE);
            }
            //LEVEL SIX SINGLE EARNER
            else if (income > 1000000)
            {
                double temp_income = 1000000;
                double temp_tax = temp_income * taxRate.levelFive;
                tax = (temp_tax) + ((income - temp_income) * taxRate.levelSix);
                rtax = df.format(tax);
                JOptionPane.showMessageDialog(null, response+rtax, "OUTPUT PANEL", JOptionPane.INFORMATION_MESSAGE);
            }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "YOU MAY HAVE INPUTTED A NEGATIVE VALUE AS INCOME");
            }
            return tax;
    }
    
    //THIS METHOD WORKS WITH BOTH THE GUI AND THE CONSOLE
    public double fixedPayableTaxE(double income)
    {
        if(income > 0 && income <= 10000000)
        {
            //LEVEL ONE SINGLE EARNER
            if(income > 0 && income <= 25000)
            {
                tax = income * taxRate.levelOne;
                rtax = df.format(tax);
            }
            //LEVEL TWO SINGLE EARNER
            else if (income > 25000 && income <= 135000)
            {
                double temp_income = 25000;
                double temp_tax = temp_income * taxRate.levelOne;
                tax = (temp_tax) + ((income - temp_income) * taxRate.levelTwo);
                rtax = df.format(tax);
            }
            //LEVEL THREE SINGLE EARNER
            else if (income > 135000 && income <= 330000)
            {
                double temp_income = 135000;
                double temp_tax = temp_income * taxRate.levelTwo;
                tax = (temp_tax) + ((income - temp_income) * taxRate.levelThree);
                rtax = df.format(tax);
            }
            //LEVEL FOUR SINGLE EARNER
            else if (income > 330000 && income <= 600000)
            {
                double temp_income = 330000;
                double temp_tax = temp_income * taxRate.levelThree;
                tax = (temp_tax) + ((income - temp_income) * taxRate.levelFour);
                rtax = df.format(tax);
            }
            //LEVEL FIVE SINGLE EARNER
            else if (income > 600000 && income <= 1000000)
            {
                double temp_income = 600000;
                double temp_tax = temp_income * taxRate.levelFour;
                tax = (temp_tax) + ((income - temp_income) * taxRate.levelFive);
                rtax = df.format(tax);
            }
            //LEVEL SIX SINGLE EARNER
            else if (income > 1000000)
            {
                double temp_income = 1000000;
                double temp_tax = temp_income * taxRate.levelFive;
                tax = (temp_tax) + ((income - temp_income) * taxRate.levelSix);
                rtax = df.format(tax);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "YOU MAY HAVE INPUTTED A NEGATIVE VALUE AS INCOME");
        }
            return tax;
    }
    
    //THIS METHOD WORKS WITH BOTH THE GUI AND THE CONSOLE, ITA AN ARRAYLIST
    public List<String> addAllSeperatelyMarriedStatusToList()
    {
        SeperatelyMarriedStatusList.add("0 - 25,000");
        SeperatelyMarriedStatusList.add("25,001 - 135,000");
        SeperatelyMarriedStatusList.add("135,001 - 330,000");
        SeperatelyMarriedStatusList.add("330,001 - 600,000");
        SeperatelyMarriedStatusList.add("600,001 - 1,000,000");
        SeperatelyMarriedStatusList.add("1,000,000+");
        return SeperatelyMarriedStatusList;
    }
}
