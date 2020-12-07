import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class TestOffByN {
    @Test
    public void TestEqualChars1(){
        CharacterComparator offByN1 = new OffByN(1);
        assertTrue(offByN1.equalChars('a', 'b'));
        assertTrue(offByN1.equalChars('r', 'q'));
        assertFalse(offByN1.equalChars('a', 'e'));
        assertFalse(offByN1.equalChars('z', 'a'));
        assertFalse(offByN1.equalChars('a', 'a'));
        assertTrue(offByN1.equalChars('&', '%'));
    }
    @Test
    public void TestEqualChars5(){
        CharacterComparator offByN5 = new OffByN(5);
        assertTrue(offByN5.equalChars('a', 'f'));
        assertTrue(offByN5.equalChars('f', 'a'));
        assertFalse(offByN5.equalChars('f', 'h'));
        assertFalse(offByN5.equalChars('&', '%'));
    }
}
