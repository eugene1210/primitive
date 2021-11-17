package uz.primitive.utils;

import uz.primitive.exception.NumberNegativeException;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {

    public static Double getDoubleValue(String string, Logger logger) {
        Double value;
        try {
            value = isNegative(Double.parseDouble(string));
        } catch (NullPointerException | NumberFormatException | NumberNegativeException e) {
            logger.log(Level.INFO, e.getMessage(), e);
            throw e;
        }
        return value;
    }

    private static Double isNegative(Double value) {
        if (value < 0) throw new NumberNegativeException("Negative numbers is not allowed.");
        return value;
    }

}
