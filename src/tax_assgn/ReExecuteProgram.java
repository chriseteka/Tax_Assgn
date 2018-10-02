
package tax_assgn;

import java.util.Scanner;

//THIS CLASS AS A WHOLE WORKS WITH THE CONSOLE, NO BUSINESS WITH THE GUI
public class ReExecuteProgram 
{
    private Scanner input = new Scanner(System.in);
    private String space = "__________________________________________________";
    private String Question = "DO YOU WANT TO RE-RUN THIS PROGRAM? (ENTER YES OR NO): ";
    private String reply;
    
    public void reExecuteProgram()
    {
        System.out.println(space);
            System.out.println(Question);
            reply = input.nextLine();
            if(reply.toLowerCase().contains("yes"))
            {
                System.out.println(space);
                Tax_Assgn.beginExecution();
            }
            else if(reply.toLowerCase().contains("no"))
            {
                System.out.println("THANK YOU FOR USING OUR SERVICE");
                System.exit(0);
            }
            else
            {
                System.out.println("INVALID INPUT ENTERED, RESTART THE APPLIICATION WHEN YOU ARE SERIOUS");
                System.exit(0);
            }
    }
}
