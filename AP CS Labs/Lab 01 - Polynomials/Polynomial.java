/**
 * Polynomial class - combines different Monomials effectively
 */
public class Polynomial
{
    Monomial firstTerm;
    Monomial secondTerm;
    Monomial thirdTerm;
    
    /**
     * Default constructor that sets all Monomials to null
     */
    public Polynomial()
    {
        firstTerm = null;
        secondTerm = null;
        thirdTerm = null;
    }

    /**
     * Determines the Monomial to set based on exponent
     * @param coeff the coefficient of the term
     * @param exp the exponent that determines the Monomial initialised - degree 0,1,2
     */
    public void setTerm(double coeff, int exp)
    {
        if(exp==2)
            firstTerm = new Monomial(coeff, exp);
        else if(exp==1)
            secondTerm = new Monomial(coeff, exp);
        else
            thirdTerm = new Monomial(coeff, 0);
    }
    
    /**
     * Evaluates the expression based on the value of x
     * @param x the x that is substituted in the expression
     * @return evaluated value
     */
    public double evaluate(double x)
    {
        double result = firstTerm.coefficient*x*x + secondTerm.coefficient*x + thirdTerm.coefficient;
        return result;
    }
    
    /**
     * Prints out the expression
     * @return the String that represents the expression
     */
    public String toString()
    {
        return firstTerm.coefficient+"x^2 + "+secondTerm.coefficient+"x + "+thirdTerm.coefficient;
    }
}
