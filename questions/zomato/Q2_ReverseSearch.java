import java.util.*;

public class Q2_ReverseSearch {
    static String reverseSearch(List<String> history, String prefix) {
        for (int i = history.size() - 1; i >= 0; i--) {
            if (history.get(i).startsWith(prefix)) {
                return history.get(i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        List<String> history = Arrays.asList("git status", "git add .", "git commit -m 'init'", "git push");
        String input = "git c";
        String result = reverseSearch(history, input);
        System.out.println("Match: " + result);
    }
}