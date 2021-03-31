public class Monomial
{
    //coefficient of a term
    double coefficient; 
    
    //power of the variable like x^2 [2 is exponent]
    int exponent;
    
    /**
     * Constructor to initialise coefficient and exponent
     * @param coefficient the coefficient of the term
     * @param exponent the exponent of the variable term
     */
    public Monomial(double coefficient, int exponent)
    {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }
}
