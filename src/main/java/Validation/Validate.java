package Validation;

import java.util.regex.Pattern;

/**
 * Created by daniel on 23/01/2017.
 */
public class Validate
{

    /**
     * Validates if input string is a double using a RegEx
     * @param input string
     * @return true if string is a double and false if otherwise
     */
    public static boolean vDouble(String input)
    {
        return Pattern.matches("[0-9]+(.[0-9][0-9])?", input);
    }
}
