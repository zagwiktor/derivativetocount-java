package pl.polsl.zagorski.model;

/**
 * A defined interface is needed for using a lambda expression.
 * @author Zagorski Wiktor
 */
@FunctionalInterface
public interface DerativeCoefficientCalc {
    public double multiplication(double a, double b);
}
