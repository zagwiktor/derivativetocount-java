package pl.polsl.zagorski.model;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;


/**
 * A class responsible for testing the public methods of the model.
 * @author Zagorski Wiktor
 */
public class ModelTest {
    private Derivative model;
    
    @BeforeEach
    public void setUp() {
        model = new Derivative();
    }
        
    static List<Object[]> testData() {
        return List.of(
                new Object[]{List.of(1.0), List.of(0.0)},
                new Object[]{List.of(2.0, 3.0, 4.0), List.of(3.0, 8.0)},
                new Object[]{new ArrayList<Double>(), List.of(0.0)},
                new Object[]{List.of(-2.0), List.of(0.0)},
                new Object[]{List.of(10000000), List.of(0.0)},
                new Object[]{List.of(1.0, 2.0, 3.0, 5.3695), List.of(2.0, 6.0, 16.1085)},
                new Object[]{List.of(0.0, 0.0, 0.0, -89.17, 15.0), List.of(0.0, 0.0, -267.51, 60.00)}
        );
    }
    /**
     * The testCalculateDerivative checks if the function from the model responsible for calculating \
     * the derivative of a polynomial is working correctly.
     * @param coefficients
     * @param expected The desired result.
     */
    @ParameterizedTest
    @MethodSource("testData")
    public void testCalculateDerivative(List<Double> coefficients, List<Double> expected) {
        model.setCoefficients(coefficients);
        List<Double> result = model.calculateDerivative();
        assertEquals(expected, result);
    }
    /**
     * The testAnswerBuilder checks whether the method from the model responsible for transforming a list \
     * containing derivative coefficients into a string format is functioning correctly.
     * @param coef1 The first coefficient needed to calculate the derivative.
     * @param coef2 The second coefficient needed to calculate the derivative.
     * @param coef3 The third coefficient needed to calculate the derivative.
     * @param coef4 The fourth coefficient needed to calculate the derivative.
     * @param expected The desired answer.
     */
    @ParameterizedTest
    @CsvSource({
            "1.0, -2.0, 0.0, 4.0, '-2.0 +12.0x^2 '",
            "0.0, 0.0, 0.0, 0.0, '0.0 '",
            "2.0, 0.0, 3.0, 0.0, '+6.0x^1 '"
    })
    public void testAnswerBuilder(double coef1, double coef2, double coef3, double coef4, String expected) {
        model.setCoefficients(List.of(coef1, coef2, coef3, coef4));
        String result = model.answerBuilder();
        assertEquals(expected, result);
    }
    
}
