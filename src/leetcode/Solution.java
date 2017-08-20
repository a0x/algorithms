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
}
