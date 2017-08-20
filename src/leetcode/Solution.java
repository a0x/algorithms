package leetcode;

class Solution {

    /* Two Sum
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * Example:
         Given nums = [2, 7, 11, 15], target = 9,
         Because nums[0] + nums[1] = 2 + 7 = 9,
         return [0, 1].
     */
    static int[] twoSum(int[] nums, int target) {
        int[] ary_index = {-1, -1};
        if (nums.length < 2) return ary_index;
        int sum, a, b;
        for (int i = 0; i < nums.length - 1; i++) {
            a = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                b = nums[j];
                sum = a + b;
                if (sum == target) {
                    System.out.println("TARGET: " + target + " SUM: " + sum);
                    ary_index[0] = i;
                    ary_index[1] = j;
                    break;
                }
            }
        }
        return ary_index;
    }

    /* Reverse Integer
     * Example1: x = 123, return 321
     * Example2: x = -123, return -321
     * The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
     */
    static int reverse(int x) {
        if (x < 10 && x > -10) return x;
        long lx = (long)x;
        if (lx > (long)Integer.MIN_VALUE && lx < (long)Integer.MAX_VALUE) {
            StringBuilder str = new StringBuilder(Integer.toString(Math.abs(x)));
            StringBuilder y = str.reverse();
            if (x < 0) y.insert(0, '-');
            long ly = Long.parseLong(y.toString());
            if (ly > (long)Integer.MIN_VALUE && ly < (long)Integer.MAX_VALUE)
                return Integer.parseInt(y.toString());
        }
        return 0;
    }

    /* Palindrome Number
     * Determine whether an integer is a palindrome. Do this without extra space.
     */
    static boolean isPalindrome(int x) {
        long tmp = (long)x;
        if (tmp < 0) return false;
        else if (tmp > (long)Integer.MAX_VALUE) return false;
        else {
            String x_str = Integer.toString(x);
            int N = x_str.length();
            for (int i = 0; i < N/2; i++)
                if (x_str.charAt(i) != x_str.charAt(N-1-i))
                    return false;
            return true;
        }
    }

    /* Roman to Integer
     * Given a roman numeral, convert it to an integer.
     * Input is guaranteed to be within the range from 1 to 3999.
     */
    static int romanToInt(String s) {
        int[] nums = new int[s.length()];
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'M':
                    nums[i] = 1000;
                    break;
                case 'D':
                    nums[i] = 500;
                    break;
                case 'C':
                    nums[i] = 100;
                    break;
                case 'L':
                    nums[i] = 50;
                    break;
                case 'X':
                    nums[i] = 10;
                    break;
                case 'V':
                    nums[i] = 5;
                    break;
                case 'I':
                    nums[i] = 1;
                    break;
            }
        }
        for(int i = 0; i < s.length()-1; i++) {
            if (nums[i] < nums[i+1]) sum -= nums[i];
            else                     sum += nums[i];
        }
        sum += nums[nums.length-1];
        return sum;
    }
}
