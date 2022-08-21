import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String str = longestPalindrome("cbbd");
        System.out.println("done");
    }
    public static String longestPalindrome(String s) {
        String largest = "";
        for (int i = 0; i < s.length(); i++) {
            String current = expandOutwards(s, i);
            if (current.length() > largest.length()) {
                largest = current;
            }
        }
          return largest;
    }

    public static String expandOutwards(String s, int startIndex) {
        boolean oddLooped = false;
        int leftIndexOdd = startIndex - 1;
        int rightIndexOdd = startIndex + 1;
        while ((leftIndexOdd >= 0) && (rightIndexOdd <= (s.length() - 1))) {
            oddLooped = true;
            char leftChar = s.charAt(leftIndexOdd);
            char rightChar = s.charAt(rightIndexOdd);
            if (leftChar != rightChar) {
                break;
            }
            leftIndexOdd--;
            rightIndexOdd++;
        }
        leftIndexOdd++;
        rightIndexOdd--;
        // If oddLooped isn't true, we are an edge, must be the startIndex character

        boolean evenLooped = false;
        int leftIndexEven = startIndex;
        int rightIndexEven = startIndex + 1;
        while ((leftIndexEven >= 0) && (rightIndexEven <= (s.length() - 1))) {
            char leftChar = s.charAt(leftIndexEven);
            char rightChar = s.charAt(rightIndexEven);
            if (leftChar != rightChar) {
                break;
            }
            evenLooped = true;
            leftIndexEven--;
            rightIndexEven++;

        }
        leftIndexEven++;
        rightIndexEven--;
        // If evenLooped isn't true, we must be on the far right character, return that character

        String oddString = Character.toString(s.charAt(startIndex));
        String evenString = Character.toString(s.charAt(startIndex));
        if (oddLooped) {
            oddString = s.substring(leftIndexOdd, rightIndexOdd + 1);
        }
        if (evenLooped) {
            evenString = s.substring(leftIndexEven, rightIndexEven + 1);
        }

        if (oddString.length() >= evenString.length()) {
            return oddString;
        } else return evenString;
    }

}