package Validation;

import java.util.regex.Pattern;

/**
 * Created by daniel on 23/01/2017.
 */
public class Validate
{

    /**
     * Validates if input is a doulbe
     * @param input
     * @return
     */
    public boolean vDouble(String input)
    {
        return Pattern.matches("^[0-9]re?.[0-9]$", input);
    }
}
