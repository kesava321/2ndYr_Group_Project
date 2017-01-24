package Validation;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by daniel on 23/01/2017.
 */
public class ValidateTest
{
    @Test
    public void validateDouble_CORRECT_INPUT()
    {
         assertEquals(Validate.vDouble("1234.00"),true);
    }

    @Test
    public void validateDouble_INCORRECT_INPUT()
    {
        assertEquals(Validate.vDouble("1234s.00"),false);
    }

}
