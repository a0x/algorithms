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
}