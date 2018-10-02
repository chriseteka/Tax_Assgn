package tax_assgn;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class ExceptionalCases 
{
    
    public String formatedMini;
    DecimalFormat df = new DecimalFormat("'#'##,###,###.00#");
    
    Scanner input = new Scanner(System.in);
    private String status;
    private double income;
    private double minimumIncome = 10000;
    
    //OBJECTS OF DECLARED CLASSES
    ReExecuteProgram execute = new ReExecuteProgram();
    StatusSingle single = new StatusSingle();
    StatusMarriedFilingJointly jointlyMarried = new StatusMarriedFilingJointly();
    StatusMarriedFilingSeperately seperatelyMarried = new StatusMarriedFilingSeperately();
    StatusHeadOfHousehold headOfHousehold = new StatusHeadOfHousehold();
    TaxRates taxRates = new TaxRates();
    
    //THIS METHOD WORKS WITH THE CONSOLE, ITS A CASE WHERE FILING STATUS IS 0 AND INCOME IS GIVEN
    public String showStatus()
    {
        System.out.println("ENTER YOUR INCOME: ");
        if(input.hasNextDouble())
        {
            System.out.println("YOU HAVE TO INPUT A FILING STATUS TO PROCEED");
            execute.reExecuteProgram();
        }else
        {
            System.out.println("ERROR, YOU MAY HAVE TYPED IN ALPHABETS IN PLACE OF NUMBERS");
            Tax_Assgn.beginExecution();
        }
        return status;
    }
    
    //THIS WORKS WITH THE CONSOLE, A CASE WHERE THE USER TYPES IN 5 AND HIS INCOME
    public List<Double> showAllTaxPayable()
    {
        List<String> incomeArrayForSingles = new ArrayList<>();
        List<String> incomeArrayForJoint = new ArrayList<>();
        List<String> incomeArrayForSeperate = new ArrayList<>();
        List<String> incomeArrayForHead = new ArrayList<>();
        List<String> intervalsOfOutput = new ArrayList<>();
        
        
        System.out.println("ENTER YOUR INCOME: ");
        if(input.hasNextDouble())
        {
            income = input.nextDouble();
            
            String incomeS = Double.toString(income);
            
            if(incomeS.length() <= 9)//MAKES SURE NOT MORE THAN 7 DIGITS IS ENTERED
            {
                if(income > 0)
                {
                    //LOOP ONLY WHEN INCOME IS GREATER THAN MINIMUMINCOME
                    while(income > minimumIncome)
                    {
                        single.fixedPayableTax(minimumIncome);
                        jointlyMarried.fixedPayableTax(minimumIncome);
                        seperatelyMarried.fixedPayableTax(minimumIncome);
                        headOfHousehold.fixedPayableTax(minimumIncome);
                        incomeArrayForSingles.add(single.rtax);
                        incomeArrayForJoint.add(jointlyMarried.rtax);
                        incomeArrayForSeperate.add(seperatelyMarried.rtax);
                        incomeArrayForHead.add(headOfHousehold.rtax);
                        
                        formatedMini = df.format(minimumIncome);
                        intervalsOfOutput.add(formatedMini);
                        minimumIncome += 10000;
                    }
                    //GET TAX RATES FOR THE INPUTTED INCOME AND ADD IT TO THE END OF THE LIST
                    double inputedIncomeTaxSingle = single.fixedPayableTax(income);
                    formatedMini = df.format(inputedIncomeTaxSingle);
                    incomeArrayForSingles.add(formatedMini);
                    
                    double inputedIncomeTaxJoint = jointlyMarried.fixedPayableTax(income);
                    formatedMini = df.format(inputedIncomeTaxJoint);
                    incomeArrayForJoint.add(formatedMini);
                    
                    double inputedIncomeTaxSeperate = seperatelyMarried.fixedPayableTax(income);
                    formatedMini = df.format(inputedIncomeTaxSeperate);
                    incomeArrayForSeperate.add(formatedMini);
                    
                    double inputedIncomeTaxHead = headOfHousehold.fixedPayableTax(income);
                    formatedMini = df.format(inputedIncomeTaxHead);
                    incomeArrayForHead.add(formatedMini);

                    //ADD INCOME AS LAST ELEMENT IN THE ARRAY INTERVALSOFOUTPUT
                    formatedMini = df.format(income);
                    intervalsOfOutput.add(formatedMini);

                    System.out.println("\t OUTPUT INTERVALS: " + intervalsOfOutput);
                    System.out.println("\t SINGLES: " + incomeArrayForSingles);
                    System.out.println("\t JOINTLY MARRIED: " + incomeArrayForJoint);
                    System.out.println("\t SEPERATELY MARRIED: " + incomeArrayForSeperate);
                    System.out.println("\t HEAD OF HOUSE HOLD: " + incomeArrayForHead);
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
            else
            {
                System.out.println("DIGITS ENTERED IS MORE THAN SEVEN, THIS WOULD CAUSE AN OVERFLOW");
                System.out.println("PLEASE INPUT DIGITS LESS OR EQUAL TO SEVEN");
                System.out.println("");
                Tax_Assgn.beginExecution();
            }
        }
        else
        {
            System.out.println("YOU HAVE ENTERED ALPHABET(S) WHERE A NUMBER IS REQUIRED");
            execute.reExecuteProgram();
        }
            return null;
    }
    
    //THIS WORKS WITH THE BOTH THE GUI AND THE CONSOLE, A CASE WHERE THE USER TYPES IN TWO FILING STATUS, e.g: 2,4 AND HIS INCOME
    public List<Double> computeMultipleInput(int firstInput, int secondInput, double income)
    {
        int firstStatus = firstInput, secondStatus = secondInput;
        if (firstStatus > 0 && secondStatus > 0)
        {
            if(firstStatus <= 4 && secondStatus <= 4)
            {
                if(firstStatus != secondStatus)
                {
                    if(firstStatus == 1)
                    {
                        single.fixedPayableTax(income);
                        System.out.println("STATUS(1): SINGLE, TAX IS: " + single.rtax);
                    }
                    else if(firstStatus == 2)
                    {
                        jointlyMarried.fixedPayableTax(income);
                        System.out.println("STATUS(2): JOINTLY MARRIED, TAX IS: " + jointlyMarried.rtax);
                    }
                    else if(firstStatus == 3)
                    {
                        seperatelyMarried.fixedPayableTax(income);
                        System.out.println("STATUS(3): SEPERATELY MARRIED, TAX IS: " + seperatelyMarried.rtax);
                    }
                    else if(firstStatus == 4)
                    {
                        headOfHousehold.fixedPayableTax(income);
                        System.out.println("STATUS(4): HEAD OF HOUSEHOLD, TAX IS: " + headOfHousehold.rtax);
                    }
                    if(secondStatus == 1)
                    {
                        single.fixedPayableTax(income);
                        System.out.println("STATUS(1): SINGLE, TAX IS: " + single.rtax);
                    }
                    else if(secondStatus == 2)
                    {
                        jointlyMarried.fixedPayableTax(income);
                        System.out.println("STATUS(2): JOINTLY MARRIED, TAX IS: " + jointlyMarried.rtax);
                    }
                    else if(secondStatus == 3)
                    {
                        seperatelyMarried.fixedPayableTax(income);
                        System.out.println("STATUS(3): SEPERATELY MARRIED, TAX IS: " + seperatelyMarried.rtax);
                    }
                    else if(secondStatus == 4)
                    {
                        headOfHousehold.fixedPayableTax(income);
                        System.out.println("STATUS(4): HEAD OF HOUSEHOLD, TAX IS: " + headOfHousehold.rtax);
                    }
//                    execute.reExecuteProgram();
                }
                else if (firstStatus == secondStatus)
                {
                    System.out.println("YOU INPUTTED SAME NUMBERS, PLEASE TRY AGAIN WITH DIFFERENT NUMBERS");
                    System.out.println("");
//                    Tax_Assgn.beginExecution();
                }
            }
                else
            {
                System.out.println("YOU HAVE INPUTTED A PAIR OF NUMBER THAT IS OUT OF RANGE, BOTH NUMBERS MUST BE WITHIN 1 AND 4");
                System.out.println("");
//                Tax_Assgn.beginExecution();
            }
        }
        else
        {
            System.out.println("ERROR, YOU HAVE TO INPUT POSITIVE NUMBERS");
            System.out.println("");
//            Tax_Assgn.beginExecution();
        }
        return null;
    }
    
    //THIS WORKS WITH THE CONSOLE, A CASE WHERE BOTH FILING STATUS AND INCOME ARE BOTH ZEROS
    public List<Double> specialCaseZero(double income)
    {
        if(income == 0)
        {
            taxRates.addRatesToList();
            single.addAllSingleStatusToList();
            jointlyMarried.addAllJointlyMarriedStatusToList();
            seperatelyMarried.addAllSeperatelyMarriedStatusToList();
            headOfHousehold.addAllHeadOfHouseHoldStatusToList();
            System.out.println("");
            System.out.println("TAX RATES: ");
            for(double i : taxRates.allTaxRates)
            {
                System.out.println(i);
            }
            System.out.println("STATUS(SINGLE): ");
            for(String a : single.singleStatusList)
            {
                System.out.println(a);
            }
            System.out.println("STATUS(JOINTLY MARRIED): ");
            for(String b : jointlyMarried.JointlyMarriedStatusList)
            {
                System.out.println(b);
            }
            System.out.println("STATUS(SEPERATELY MARRIED): ");
            for(String c : seperatelyMarried.SeperatelyMarriedStatusList)
            {
                System.out.println(c);
            }
            System.out.println("STATUS(HEAD OF HOUSEHOLD): ");
            for(String d : headOfHousehold.HeadOfHouseholdStatusList)
            {
                System.out.println(d);
            }
            System.out.println("");
            Tax_Assgn.beginExecution();
        }
        return null;
    }
    
    //THIS WORKS WITH THE GUI, FOR CASE WHERE BOTH FILING STATUS AND INCOME ARE ZERO
    public List<Double> specialCaseZeroForGUI(double income)
    {
        tax_assgn.GUI.OutputPage output = new tax_assgn.GUI.OutputPage();
        
        if(income == 0)
        {
            taxRates.addRatesToList();
            single.addAllSingleStatusToList();
            jointlyMarried.addAllJointlyMarriedStatusToList();
            seperatelyMarried.addAllSeperatelyMarriedStatusToList();
            headOfHousehold.addAllHeadOfHouseHoldStatusToList();
            
            for(double i : taxRates.allTaxRates)
            {
                String rates = Double.toString(i);
                output.displayRates.append(rates + "\n\n");
            }
            for(String a : single.singleStatusList)
            {
                output.displaySingles.append(a + "\n\n");
            }
            for(String b : jointlyMarried.JointlyMarriedStatusList)
            {
                output.displayJointly.append(b + "\n\n");
            }
            for(String c : seperatelyMarried.SeperatelyMarriedStatusList)
            {
                output.displaySeperately.append(c + "\n\n");
            }
            for(String d : headOfHousehold.HeadOfHouseholdStatusList)
            {
                output.displayHead.append(d + "\n\n");
            }
            output.setVisible(true);
        }
        if(income > 0)
        {
            JOptionPane.showMessageDialog(null, "YOU HAVE NOT INPUTTED ANY FILING STATUS");
        }
        return null;
    }
    
    //THIS WORKS WITH THE GUI, FOR CASE WHERE A USER TYPES IN 5 AND AN INCOME
    public List<Double> showAllTaxPayableGUI(double income)
    {
        tax_assgn.GUI.outputPage2 output2 = new tax_assgn.GUI.outputPage2();
        
        List<String> incomeArrayForSingles = new ArrayList<>();
        List<String> incomeArrayForJoint = new ArrayList<>();
        List<String> incomeArrayForSeperate = new ArrayList<>();
        List<String> incomeArrayForHead = new ArrayList<>();
        List<String> intervalsOfOutput = new ArrayList<>();

//        String incomeS = Double.toString(income);
        if(income <= 10000000)//MAKES SURE NOT MORE THAN 7 DIGITS IS ENTERED
        {
            if(income > 0)
            {
                //LOOP ONLY WHEN INCOME IS GREATER THAN MINIMUMINCOME
                while(income > minimumIncome)
                {      
                    single.fixedPayableTaxE(minimumIncome);
                    jointlyMarried.fixedPayableTaxE(minimumIncome);
                    seperatelyMarried.fixedPayableTaxE(minimumIncome);
                    headOfHousehold.fixedPayableTaxE(minimumIncome);
                    incomeArrayForSingles.add(single.rtax);
                    incomeArrayForJoint.add(jointlyMarried.rtax);
                    incomeArrayForSeperate.add(seperatelyMarried.rtax);
                    incomeArrayForHead.add(headOfHousehold.rtax);

                    formatedMini = df.format(minimumIncome);
                    intervalsOfOutput.add(formatedMini);
                    minimumIncome += 10000;
                }
                    //GET TAX RATES FOR THE INPUTTED INCOME AND ADD IT TO THE END OF THE LIST
                    double inputedIncomeTaxSingle = single.fixedPayableTaxE(income);
                    formatedMini = df.format(inputedIncomeTaxSingle);
                    incomeArrayForSingles.add(formatedMini);
                    
                    double inputedIncomeTaxJoint = jointlyMarried.fixedPayableTaxE(income);
                    formatedMini = df.format(inputedIncomeTaxJoint);
                    incomeArrayForJoint.add(formatedMini);
                    
                    double inputedIncomeTaxSeperate = seperatelyMarried.fixedPayableTaxE(income);
                    formatedMini = df.format(inputedIncomeTaxSeperate);
                    incomeArrayForSeperate.add(formatedMini);
                    
                    double inputedIncomeTaxHead = headOfHousehold.fixedPayableTaxE(income);
                    formatedMini = df.format(inputedIncomeTaxHead);
                    incomeArrayForHead.add(formatedMini);

                    //ADD INCOME AS LAST ELEMENT IN THE ARRAY INTERVALSOFOUTPUT
                    formatedMini = df.format(income);
                    intervalsOfOutput.add(formatedMini);

                //PRINT VALUES IN THE ARRAY LIST TO THE DISPLAYER
                for(String incomeIntervals : intervalsOfOutput)
                {
                    output2.displayIntervals.append(incomeIntervals + "\n\n");
                }
                for(String singlesIncome : incomeArrayForSingles)
                {
                    output2.displaySingles.append(singlesIncome + "\n\n");
                }
                for(String jointlyMarriedIncome : incomeArrayForJoint)
                {
                    output2.displayJointly.append(jointlyMarriedIncome + "\n\n");
                }
                
                for(String seperatelyMarriedIncome : incomeArrayForSeperate)
                {
                    output2.displaySeperately.append(seperatelyMarriedIncome + "\n\n");
                }
                for(String HeadOfHouseholdIncome : incomeArrayForHead)
                {
                    output2.displayHead.append(HeadOfHouseholdIncome + "\n\n");
                }
                output2.setVisible(true);
            }
            //INVALID INPUT ENTERED, DUE TO NEGATIVE INPUT
            else
            {
                JOptionPane.showMessageDialog(null, "YOU MAY HAVE INPUTTED A NEGATIVE NUMBER");
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "YOU ARE REQUIRED TO INPUT NUMBERS LESS OR EQUAL TO SEVEN DIGIT");
        }
        return null;
    }
    
}
