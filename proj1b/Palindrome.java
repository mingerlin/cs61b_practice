public class Palindrome{
    /*  Return a Deque where the characters appear in
    the same order as in the String */
    public Deque<Character> wordToDeque(String word){
        Deque<Character> toReturn = new ArrayDeque<>();
        for (int i=0; i<word.length(); i+=1) {
            char c = word.charAt(i);
            toReturn.addLast(c);
        }
        return toReturn;
    }

//    /* Return true if the given word is a palindrome, and false otherwise*/
//    public boolean isPalindrome(String word) {
//        if (word == null) {
//            return false;
//        }
//        if (word.length()==0 || word.length()==1) {
//            return true;
//        }else {
//            Deque<Character> wtd = wordToDeque(word);
//            while (wtd.removeFirst() == wtd.removeLast()) {
//                if (wtd.size() == 0 || wtd.size() == 1) {
//                    return true;
//                }
//            }
//            return false;
//        }
//    }

    /* Return true if the given word is a palindrome, and false otherwise
    * using recursion */
    public boolean isPalindrome(String word) {
        if (word == null) {
            return false;
        }
        if (word.length()==0 || word.length()==1) {
            return true;
        }else {
            return isPalindromeH(wordToDeque(word));
        }
    }

    /* helper method for isPalindrome */
    private boolean isPalindromeH(Deque<Character> d) {
        if (d.size() == 0 || d.size() == 1) {
            return true;
        }
        if (d.removeFirst() == d.removeLast()) {
            return isPalindromeH(d);
        }else {
            return false;
        }
    }

    /* return true if the word is a palindrome according to the character
     comparison test provided by the CharacterComparator object passed in
     as the argument cc */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        if (word == null) {
            return false;
        }
        if (word.length()==0 || word.length()==1) {
            return true;
        }else {
            return isPalindromeH2(wordToDeque(word), cc);
        }
    }

    /* helper method for isPalindrome with CharacterComparator */
    private boolean isPalindromeH2(Deque<Character> d, CharacterComparator cc) {
        if (d.size() == 0 || d.size() == 1) {
            return true;
        }
        if (cc.equalChars(d.removeFirst(), d.removeLast())) {
            return isPalindromeH2(d, cc);
        }else {
            return false;
        }
    }
}
