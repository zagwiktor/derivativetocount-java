package pl.polsl.zagorski.model;
import java.util.ArrayList;
import java.util.List;
/**
 * The Polynomial class represents a polynomial and has an argument "coefficients" that contains its coefficients.
 * @author Zagorski Wiktor
 */
public class Polynomial {
    public List<Double> coefficients = new ArrayList<>();

    /**
     * A method for setting coefficients.
     * @param coefficients 
     */
    public void setCoefficients(List<Double> coefficients) {
        this.coefficients = coefficients;
    }
    /**
     * A method providing coefficients.
     * @return A list containing the coefficients of a polynomial.
     */
    public List<Double> getCoefficients() {
        return coefficients;
    }
}
