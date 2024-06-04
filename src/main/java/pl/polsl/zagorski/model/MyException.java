package pl.polsl.zagorski.model;

/**
 * A custom exception needed to convey information to the user about an error that occurred.
 * @author Zagorski Wiktor
 */
public class MyException extends Exception{
    public MyException(String message) {
        super(message);
    }
}
