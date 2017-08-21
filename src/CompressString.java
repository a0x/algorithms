public class CompressString {
    /* Compress String
     * This is not from Leetcode, but from a real interview.
     * In the simplest condition, you don't have to worry about the Time and Space Complexity.
     * There is a given string, and the algorithm will return a new string, with each character appear once in the
     * original and the account of its replication.
     *
     * Example: Given string 'aaabbccca', return 'a3b2c3a1'.
    */
    public static void main(String[] args) {
        String input = "aaabbbccdaae";
        String result = compress(input);
        System.out.println("ORIGILAN:\n" + input + "\n");
        System.out.println("COMPRESSED:\n" + result + "\n");
        System.out.println("COUNT_AND_SAY\n" + countAndSay(input) + "\n");
    }

    private static String compress(String original) {
        if (original.length() < 2) return original;
        StringBuilder result = new StringBuilder();
        StringBuilder tmp = new StringBuilder();
        int index;
        char prev, next;
        for (index = 0; index < original.length(); index++) {
            prev = original.charAt(index);
            tmp.append(prev);
            if (index < original.length() - 1) {
                next = original.charAt(index + 1);
                if (prev != next) {
                    result.append(tmp.charAt(0));
                    result.append(tmp.length());
                    tmp.setLength(0);
                }
            }
        }
        result.append(tmp.charAt(0));
        result.append(tmp.length());
        return result.toString();
    }

    // Another way to work this out, inspired by Count and Say Algorithm
    // See Solution.countandSay() in package leetcode for more information.
    private static String countAndSay(String original) {
        StringBuilder curr = new StringBuilder(original);
        StringBuilder result = new StringBuilder();
        int count = 0;
        char say = curr.charAt(0);
        for (int i = 0; i < curr.length(); i++) {
            if (curr.charAt(i) != say) {
                result.append(say).append(count);
                count = 1;
                say = curr.charAt(i);
            } else count++;
        }
        result.append(say).append(count);
        return result.toString();
    }
}