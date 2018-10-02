package tax_assgn;

import java.util.ArrayList;
import java.util.List;

public class TaxRates {
    
    public List<Double> allTaxRates = new ArrayList<>();
    
    //THE FOLLOWING ARE THE SPECIFIED TAX RATES IN PERCENTAGES:
    //FOR YEAR 2013
    public final double levelOne = 0.1;
    public final double levelTwo = 0.15;
    public final double levelThree = 0.2;
    public final double levelFour = 0.3;
    public final double levelFive = 0.34;
    public final double levelSix = 0.38;
    
    public List<Double> addRatesToList()
    {
       allTaxRates.add(levelOne);
       allTaxRates.add(levelTwo);
       allTaxRates.add(levelThree);
       allTaxRates.add(levelFour);
       allTaxRates.add(levelFive);
       allTaxRates.add(levelSix);
       
       return allTaxRates;
    }
    //ADD MORE RATES SHOULD YOU WANT TO, SPECIFYING IT YEAR
}
