
package tax_assgn;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Tax_Assgn {

    public static void main(String[] args) 
    {
        //THIS STARTS UP THE CONSOLE APPLICATION
//        beginExecution();
        
        //THIS STARTS UP THE GUI APPLICATION
        tax_assgn.GUI.firstPage firstPage = new tax_assgn.GUI.firstPage();
        firstPage.setVisible(true);
    }
    
    //THIS METHOD WORKS WITH THE CONSOLE APPLICATION
    public static void beginExecution()
    {
        Scanner input = new Scanner(System.in);
        
        //OBJECTS OF CLASSES
        StatusSingle single = new StatusSingle();
        StatusMarriedFilingJointly jointlyMarried = new StatusMarriedFilingJointly();
        StatusMarriedFilingSeperately seperatelyMarried = new StatusMarriedFilingSeperately();
        StatusHeadOfHousehold headOfHousehold = new StatusHeadOfHousehold();
        ExceptionalCases exceptionalCase = new ExceptionalCases();
        
         //CHOOSE A STATUS:
        System.out.println("CHOOSE A NUMBER THAT CORESPONDS TO THE FILING STATUS BELOW: ");
        System.out.println("0. QUERY \n1. SINGLE \n2. MARRIED FILING JOINTLY OR QUALIFIED WIDOW(ER): "
                + "\n3. MARRIED FILING SEPERATELY: \n4. HEAD OF HOUSEHOLD: \n5. OTHER CASE: \n6. EXIT \n\nCHOICE: ");
        
        if(input.hasNextInt())
        {
            int selectedChoice = input.nextInt();
            if(selectedChoice == 1)
            {
                single.taxPayable();
            }
            else if(selectedChoice == 2)
            {
                jointlyMarried.taxPayable();
            }
            else if(selectedChoice == 3)
            {
                seperatelyMarried.taxPayable();
            }
            else if(selectedChoice == 4)
            {
                headOfHousehold.taxPayable();
            }
            else if(selectedChoice == 5)
            {
                exceptionalCase.showAllTaxPayable();
            }
            else if(selectedChoice == 0)
            {
                System.out.println("ENTER YOUR INCOME: ");
                double income = input.nextDouble();
                exceptionalCase.specialCaseZero(income);
            }
            else if(selectedChoice == 6)
            {
                System.out.println("EXITING APPLICATION");
                System.exit(0);
            }
            else
            {
                System.out.println("YOU HAVE ENTERED AN INVALID CHOICE");
                System.out.println("");
                Tax_Assgn.beginExecution();
            }
        }
        else if(input.hasNextLine())
        {
            String multipleInput = input.nextLine();
            String refinedMultipleInput = multipleInput.replaceAll("//s", "");
            if(refinedMultipleInput.length() == 3)//THIS HANDLES THE SEQUENCE OF STRING THAT IS PERMITTED IN THE APPLICATION
            {
                char firstRefinedInput = refinedMultipleInput.charAt(0);
                char secondRefinedInput = refinedMultipleInput.charAt(2);
                int firstNum = Integer.parseInt(Character.toString(firstRefinedInput));
                int secondNum = Integer.parseInt(Character.toString(secondRefinedInput));
                
                System.out.println("ENTER YOUR INCOME: ");
                double income = input.nextDouble();

                exceptionalCase.computeMultipleInput(firstNum, secondNum, income);
            }
            else
            {
                System.out.println("YOU ARE REQUIRED TO ENTER PAIRS IN THE FORM \"a,b\" ");
                System.out.println("a: must be between 1 to 4");
                System.out.println("b: must be between 1 to 4");
                System.out.println("");
                Tax_Assgn.beginExecution();
            }
        }
        else
        {
            System.out.println("YOU MAY HAVE ENTERED AN ALPHABET WHERE NUMERIC REPLY IS EXPECTED");
            System.out.println("");
            Tax_Assgn.beginExecution();
        }
    }
    
    
    //THIS METHOD WORKS WITH THE GUI APPLICATION
    public static void beginExecutionGUI(int selectedChoice, double income)
    {
        //OBJECTS OF CLASSES
        StatusSingle single = new StatusSingle();
        StatusMarriedFilingJointly jointlyMarried = new StatusMarriedFilingJointly();
        StatusMarriedFilingSeperately seperatelyMarried = new StatusMarriedFilingSeperately();
        StatusHeadOfHousehold headOfHousehold = new StatusHeadOfHousehold();
        ExceptionalCases exceptionalCase = new ExceptionalCases();
        
        if(selectedChoice >= 0)
        {
            if(selectedChoice == 1)
            {
                single.fixedPayableTax(income);
            }
            else if(selectedChoice == 2)
            {
                jointlyMarried.fixedPayableTax(income);
            }
            else if(selectedChoice == 3)
            {
                seperatelyMarried.fixedPayableTax(income);
            }
            else if(selectedChoice == 4)
            {
                headOfHousehold.fixedPayableTax(income);
            }
            else if(selectedChoice == 5)
            {
                exceptionalCase.showAllTaxPayableGUI(income);
            }
            else if(selectedChoice == 0)
            {
                exceptionalCase.specialCaseZeroForGUI(income);
            }
            else if(selectedChoice == 6)
            {
                int result = JOptionPane.showConfirmDialog(null, "DO YOU WANT TO EXIT THE APPLICATION", "OUTPUT PANEL", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION)
                            System.exit(0);
            }
            else
            {
                System.out.println("YOU HAVE ENTERED AN INVALID CHOICE");
                System.out.println("");
                Tax_Assgn.beginExecution();
            }
        }
        else
        {
            System.out.println("YOU MAY HAVE ENTERED AN ALPHABET WHERE NUMERIC REPLY IS EXPECTED");
            System.out.println("");
            Tax_Assgn.beginExecution();
        }
    }
}
