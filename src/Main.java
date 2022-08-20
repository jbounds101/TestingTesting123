import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome("aabbaa"));
    }
    public static boolean isPalindrome(String s) {
        Stack<Character> stack = new Stack<>();
        int midPoint = s.length() / 2;

        // Add the first half of the string
        for (int i = 0; i < midPoint; i++) {
            stack.push(s.charAt(i));
        }

        if (s.length() % 2 == 1) {
            midPoint += 1;
        }

        for (int i = midPoint; i < s.length(); i++) {
            char toCompare = stack.pop();
            if (toCompare != s.charAt(i)) return false;
        }
        return true;
    }

}