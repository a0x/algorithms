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
}
