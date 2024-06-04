package pl.polsl.zagorski.model;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * The Derivative class contains a method for calculating the derivative coefficients and correctly formatting the response.
 * @author Zagorski Wiktor
 */
public class Derivative extends Polynomial implements DerativeCalculator{   
    
    /**
     *  The method is responsible for calculating the coefficients of the computed derivative.
     * @return  An array containing the coefficients of the computed derivative.
     */
    @Override
    public List<Double> calculateDerivative() {
        int degree = coefficients.size() - 1;
        List<Double> derivative = new ArrayList<>();
        if (coefficients.size() > 1) {
            DerativeCoefficientCalc operation = (i, coefficient) -> coefficient * (i + 1);
            for (int i = 0; i < degree; i++) {
                derivative.add(operation.multiplication(i, coefficients.get(i + 1)));
            }
        } else {
            derivative.add(0.0);
        }
    return derivative;
    }
 
    /**
     *  The method responsible for constructing a string that contains the computed derivative.
     * @return  String containing the derivative.
     */
    public String answerBuilder() {
        List<Double> derivative = calculateDerivative();
        String result = IntStream.range(0, derivative.size())
            .mapToObj(i -> {
                Double coefficient = derivative.get(i);
                String factor;
                if (i == 0 & coefficient == 0.0){
                    factor = "";
                    return factor;
                }
                if (i == 0) {
                    factor = coefficient + " ";
                    return factor;
                } else {
                    if (coefficient > 0) {
                        factor = "+" + coefficient + "x^" + i + " ";
                    } else if (coefficient == 0.0) {
                        factor = "";
                    } else {
                        factor = coefficient + "x^" + i + " ";
                    }
                    return factor;
                }
            })
            .collect(Collectors.joining());
        if (result.equals("")){
            result = "0.0 ";
        } 
        return result;
    }
}
