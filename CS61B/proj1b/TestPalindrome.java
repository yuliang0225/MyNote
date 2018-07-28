import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    /** Test testWordToDeque */
    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } /*Uncomment this class once you've created your Palindrome class. */
    static int N = 5;
    static OffByOne ofo = new OffByOne();
    static OffByN ofn = new OffByN(N);
    /** Test isPalindrome */
    @Test
    public void testisPalindrome(){
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("Cat"));
        assertFalse(palindrome.isPalindrome("Afxfa"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("C"));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));

        assertFalse(palindrome.isPalindrome("cat",ofo));
        assertFalse(palindrome.isPalindrome("Cat",ofo));
        assertFalse(palindrome.isPalindrome("Afxfa",ofo));
        assertTrue(palindrome.isPalindrome("noon",ofo));
        assertTrue(palindrome.isPalindrome("C",ofo));
        assertTrue(palindrome.isPalindrome("a",ofo));
        assertTrue(palindrome.isPalindrome("",ofo));

//        assertFalse(palindrome.isPalindrome("cat",ofn));
//        assertFalse(palindrome.isPalindrome("Cat",ofn));
//        assertFalse(palindrome.isPalindrome("Afxfa",ofn));
//        assertTrue(palindrome.isPalindrome("noon",ofn));
//        assertTrue(palindrome.isPalindrome("C",ofn));
//        assertTrue(palindrome.isPalindrome("a",ofn));
//        assertTrue(palindrome.isPalindrome("",ofn));


    }

}
