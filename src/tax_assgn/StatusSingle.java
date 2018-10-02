
package tax_assgn;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class StatusSingle 
{
    private Scanner input = new Scanner(System.in);
    
    public double tax;
    public String rtax;
    DecimalFormat df = new DecimalFormat("'#'##,###,###.00#");
    
    public List<String> singleStatusList = new ArrayList<>();
    
    //OBJECTS OF SOME NEEDED CLASSES
    private TaxRates taxRate = new TaxRates();
    private ReExecuteProgram execute = new ReExecuteProgram();
    private String response = "STATUS(SINGLE): TAX PAYABLE BY YOU IS: \n";
    
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
            else if (income > 135000 && income <= 380000)
            {
                double temp_income = 135000;
                double temp_tax = temp_income * taxRate.levelTwo;
                tax = (temp_tax) + ((income - temp_income) * taxRate.levelThree);
                rtax = df.format(tax);
                System.out.println(response + rtax);
                execute.reExecuteProgram();
            }
            //LEVEL FOUR SINGLE EARNER
            else if (income > 380000 && income <= 650000)
            {
                double temp_income = 380000;
                double temp_tax = temp_income * taxRate.levelThree;
                tax = (temp_tax) + ((income - temp_income) * taxRate.levelFour);
                rtax = df.format(tax);
                System.out.println(response + rtax);
                execute.reExecuteProgram();
            }
            //LEVEL FIVE SINGLE EARNER
            else if (income > 650000 && income <= 1200000)
            {
                double temp_income = 650000;
                double temp_tax = temp_income * taxRate.levelFour;
                tax = (temp_tax) + ((income - temp_income) * taxRate.levelFive);
                rtax = df.format(tax);
                System.out.println(response + rtax);
                execute.reExecuteProgram();
            }
            //LEVEL SIX SINGLE EARNER
            else if (income > 1200000)
            {
                double temp_income = 1200000;
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
            else if (income > 135000 && income <= 380000)
            {
                double temp_income = 135000;
                double temp_tax = temp_income * taxRate.levelTwo;
                tax = (temp_tax) + ((income - temp_income) * taxRate.levelThree);
                rtax = df.format(tax);
                JOptionPane.showMessageDialog(null, response+rtax, "OUTPUT PANEL", JOptionPane.INFORMATION_MESSAGE);
            }
            //LEVEL FOUR SINGLE EARNER
            else if (income > 380000 && income <= 650000)
            {
                double temp_income = 380000;
                double temp_tax = temp_income * taxRate.levelThree;
                tax = (temp_tax) + ((income - temp_income) * taxRate.levelFour);
                rtax = df.format(tax);
                JOptionPane.showMessageDialog(null, response+rtax, "OUTPUT PANEL", JOptionPane.INFORMATION_MESSAGE);
            }
            //LEVEL FIVE SINGLE EARNER
            else if (income > 650000 && income <= 1200000)
            {
                double temp_income = 650000;
                double temp_tax = temp_income * taxRate.levelFour;
                tax = (temp_tax) + ((income - temp_income) * taxRate.levelFive);
                rtax = df.format(tax);
                JOptionPane.showMessageDialog(null, response+rtax, "OUTPUT PANEL", JOptionPane.INFORMATION_MESSAGE);
            }
            //LEVEL SIX SINGLE EARNER
            else if (income > 1200000)
            {
                double temp_income = 1200000;
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
    
    //THIS METHOD WORKS WITH BOTH GUI AND CONSOLE
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
            else if (income > 135000 && income <= 380000)
            {
                double temp_income = 135000;
                double temp_tax = temp_income * taxRate.levelTwo;
                tax = (temp_tax) + ((income - temp_income) * taxRate.levelThree);
                rtax = df.format(tax);
            }
            //LEVEL FOUR SINGLE EARNER
            else if (income > 380000 && income <= 650000)
            {
                double temp_income = 380000;
                double temp_tax = temp_income * taxRate.levelThree;
                tax = (temp_tax) + ((income - temp_income) * taxRate.levelFour);
                rtax = df.format(tax);
            }
            //LEVEL FIVE SINGLE EARNER
            else if (income > 650000 && income <= 1200000)
            {
                double temp_income = 650000;
                double temp_tax = temp_income * taxRate.levelFour;
                tax = (temp_tax) + ((income - temp_income) * taxRate.levelFive);
                rtax = df.format(tax);
            }
            //LEVEL SIX SINGLE EARNER
            else if (income > 1200000)
            {
                double temp_income = 1200000;
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
    
    //THIS WORKS WITH BOTH: ITS AN ARRAYLIST
    public List<String> addAllSingleStatusToList()
    {
        singleStatusList.add("0 - 25,000");
        singleStatusList.add("25,001 - 135,000");
        singleStatusList.add("135,001 - 380,000");
        singleStatusList.add("380,001 - 650,000");
        singleStatusList.add("650,001 - 1,200,000");
        singleStatusList.add("1,200,000+");
        return singleStatusList;
    }
}
