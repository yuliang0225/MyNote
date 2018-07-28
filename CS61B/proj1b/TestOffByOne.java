import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static int N = 5;
    static CharacterComparator offByOne = new OffByOne();
    static CharacterComparator offByN = new OffByN(N);


    @Test
    public void testEqualChars(){
        assertFalse(offByOne.equalChars('a','b'));
        assertTrue(offByOne.equalChars('a','a'));
        assertFalse(offByOne.equalChars('a','2'));
        assertTrue(offByOne.equalChars('2','2'));

        assertFalse(offByN.equalChars('a','a'));
        assertTrue(offByN.equalChars('a','f'));
        assertTrue(offByN.equalChars('f','a'));
        assertTrue(offByN.equalChars('1','6'));
        assertTrue(offByN.equalChars('6','1'));
    }



    // Your tests go here.
    //  this class once you've created your CharacterComparator interface and OffByOne class.
}
