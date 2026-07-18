import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome(){
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("z"));

        assertTrue(palindrome.isPalindrome(""));

        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("racecar"));

        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("horse"));

        assertFalse(palindrome.isPalindrome("Noon"));
        assertFalse(palindrome.isPalindrome("Racecar"));
    }

    @Test
    public void testIsPalindromeWithOffByOne(){
        CharacterComparator obo = new OffByOne();

        assertTrue(palindrome.isPalindrome("flake", obo));
        assertTrue(palindrome.isPalindrome("a", obo));  // Single chars are still palindromes!
        assertTrue(palindrome.isPalindrome("", obo));   // Empty string is still a palindrome!

        // 3. Negative Cases (Should be false under Off-By-One rules)
        // "racecar" is a normal palindrome, but NOT an off-by-one palindrome!
        assertFalse(palindrome.isPalindrome("racecar", obo));
        assertFalse(palindrome.isPalindrome("noon", obo));
        assertFalse(palindrome.isPalindrome("zucchini", obo));
    }

}
