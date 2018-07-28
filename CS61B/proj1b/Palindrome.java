public class Palindrome {
    /** Given a String, wordToDeque should return a Deque where the characters
     * appear in the same order as in the String.
     * For example, if the word is “persiflage”, then the returned Deque should
     * have ‘p’ at the front, followed by ‘e’, and so forth. */
    public Deque<Character> wordToDeque(String word){
        LinkedListDeque<Character> aDeque = new LinkedListDeque<>();

        for (int i = 0; i < word.length(); i +=1) {
            aDeque.addLast(word.charAt(i));
        }
        return aDeque;
    }
    /**The isPalindrome method should return true if the given word is a palindrome,
     * and false otherwise. A palindrome is defined as a word that is the same whether
     * it is read forwards or backwards. For example “a”, “racecar”, and “noon” are all
     * palindromes. “horse”, “rancor”, and “aaaaab” are not palindromes.
     * Any word of length 1 or 0 is a palindrome. */

    public boolean isPalindrome(String word){
        return isPalindrome(wordToDeque(word));
    }

    public boolean isPalindrome(Deque<Character> word){
        if (word.size() == 1 || word.size() == 0){
            return true;
        }
        return (word.removeFirst() == word.removeLast()) && isPalindrome(word);
    }


    /**The method will return true if the word is a palindrome according to
     * the character comparison test provided by the CharacterComparator passed
     * in as argument cc. */
    public boolean isPalindrome(String word, CharacterComparator cc){
        if (word.length() == 1 || word.length() == 0){
            return true;
        }
        for (int i = 0; i <= word.length()*0.5; i +=1){
            if (!cc.equalChars(word.charAt(i),word.charAt(word.length()-i-1))){
                return false;
            }
        }
        return true;
    }

}
