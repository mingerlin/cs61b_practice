import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Minger Lin on 12/01/2020
 * Purpose: This test is meant to figure out whether the bug is
 * in Horrible Steve’s code or in Flik enterprise’s library
 */

public class FilkTest {
    @Test
    public void test1(){
        int input1 = 128;
        int input2 = 128;
        boolean result1 = Flik.isSameNumber(input1,input2);
        assertTrue("The bug is on Filk's library", result1);
    }

    @Test
    public void test2(){
        int input1 = 0;
        int input2 = 2;
        boolean result2 = Flik.isSameNumber(input1,input2);
        assertFalse("The bug is on Filk's library", result2);
    }

}
