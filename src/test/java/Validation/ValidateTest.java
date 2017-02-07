package Validation;
//import org.junit.Test;

//import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by daniel on 23/01/2017.
 */
public class ValidateTest
{
    @Test
    public void vDouble_CORRECT_INPUT()
    {
         assertEquals(Validate.vDouble("1234.00"),true);
    }

    @Test
    public void vDouble_CORRECT_INPUT2()
    {
        assertEquals(Validate.vDouble("1234.0"),true);
    }

    @Test
    public void vDouble_INCORRECT_INPUT()
    {
        assertEquals(Validate.vDouble("1234s.00"),false);
    }

    @Test
    public void vDouble_INCORRECT_INPUT2()
    {
        assertEquals(Validate.vDouble("1234."),false);
    }

    @Test
    public void vDouble_EMPTY()
    {
        assertEquals(Validate.vDouble(""),false);
    }

    @Test
    public void vInt_CORRECT_INPUT()
    {
        assertEquals(Validate.vInt("123"),true);
    }

    @Test
    public void vInt_INCORRECT_INPUT()
    {
        assertEquals(Validate.vInt("1a23"),false);
    }

    @Test
    public void vInt_EMPTY()
    {
        assertEquals(Validate.vInt(""),false);
    }


}
