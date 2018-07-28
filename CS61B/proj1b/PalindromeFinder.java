/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {

    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("words.txt");
        Palindrome palindrome = new Palindrome();
/**
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word)) {
                System.out.println(word);
            }
        }
*/
        int N = 5;
        CharacterComparator offByN = new OffByN(N);
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word,offByN)) {
                System.out.println(word);
            }
        }


    } //Uncomment this class once you've written isPalindrome. */
}
