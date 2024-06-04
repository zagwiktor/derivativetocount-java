package pl.polsl.zagorski.controller;
import java.util.ArrayList;
import java.util.List;
import pl.polsl.zagorski.model.MyException;

/**
 * A class responsible for retrieving the data needed to build a polynomial.
 * @author Zagorski Wiktor
 */
public class PolynominalController {

    /**
     * The method responsible for appropriately transforming the coefficients entered by the user.
     * @param coefficientsStrArg Coefficients provided by the user.
     * @return List with transformed coefficients.
     * @throws pl.polsl.zagorski.model.MyException 
     */
    public List<Double> passInArguments(String coefficientsStrArg) throws MyException{
        List<Double> coefficientsGui = new ArrayList<>();
        String coefficientsInput = coefficientsStrArg;
        String[] coefficientsStr = coefficientsInput.split(" ");
        for (String coefficientStr : coefficientsStr){
                try {
                    coefficientsGui.add(Double.valueOf(coefficientStr));
                } catch (NumberFormatException e) {
                    throw new MyException("Invalid input, please type in correct coefficients");
                }
        }
        return coefficientsGui;
    }
}