public class Palindrome {


    public Deque<Character> wordToDeque(String word){
        Deque<Character> charDeque = new LinkedListDeque<>();

        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            charDeque.addLast(c);
        }
        return charDeque;

    }

    public boolean isPalindrome(String word){
        Deque<Character> d = wordToDeque(word);
        return isPalindromeHelper(d);
    }

    private boolean isPalindromeHelper(Deque<Character> d){
        if (d.size() <= 1){
            return true;
        }
        char first = d.removeFirst();
        char last = d.removeLast();

        if (first == last){
            return isPalindromeHelper(d);
        }
        return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> d = wordToDeque(word);
        return isPalindromeHelper(d, cc);
    }

    private boolean isPalindromeHelper(Deque<Character> d, CharacterComparator cc){
        if (d.size() <= 1){
            return true;
        }
        char first = d.removeFirst();
        char last = d.removeLast();

        if (cc.equalChars(first, last)){
            return isPalindromeHelper(d, cc);
        }
        return false;
    }
}
