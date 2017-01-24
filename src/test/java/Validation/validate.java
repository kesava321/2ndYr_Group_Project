package Validation;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by daniel on 23/01/2017.
 */
public class validate
{
    @Test
    public void validateDouble_PASS()
    {
         Validate v = new Validate();
         assertEquals(v.vDouble("1.00"),true);
    }

}
