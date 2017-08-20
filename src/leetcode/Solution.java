package leetcode;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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

    /* Integer to Roman
     * Given an integer, convert it to a roman numeral.
     * Input is guaranteed to be within the range from 1 to 3999.
     */
    static String intToRoman(int num) {
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] M = {"", "M", "MM", "MMM"};
        if (num <= 0) return null;
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }

    /* Longest Common Prefix
     * Write a function to find the longest common prefix string amongst an array of strings.
     */
    static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 ) return "";
        if (strs.length == 1) return strs[0];

        String commonString = new String();

        // Find out the min length in strs
        int[] tmp = new int[strs.length];
        for (int i = 0; i < strs.length; i++){
            tmp[i] = strs[i].length();
        }
        Arrays.sort(tmp);
        int min_str_length = tmp[0];
        String[] prefix_ary = new String[strs.length];

        for (int i = 0; i < min_str_length; i++) {
            // Fill in prefix_ary once per letter, the length of it is exactly the length of strs
            for (int j = 0; j < strs.length; j++) {
                prefix_ary[j] = strs[j].substring(0, i+1);
            }
            // If prefix_ary is all the same, pick up one into commonString, then goes to another round
            if (sameString(prefix_ary)) commonString = prefix_ary[0];
        }
        return commonString;
    }

     private static boolean sameString(String[] strs) {
        if (strs.length < 2) return false;
        boolean flag = true;
        for (int i = 0; i < strs.length; i++) {
            if (!strs[0].equals(strs[i])) flag = false;
        }
        return flag;
    }

    /* Valid Parentheses
     * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
     */
    boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if      (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }

    /* Remove Element
     * Given an array and a value, remove all instances of that value in place and return the new length.
     * Do not allocate extra space for another array, you must do this in place with constant memory.
     * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
     * Example:
     *      Given input array nums = [3,2,2,3], val = 3
     *      Your function should return length = 2, with the first two elements of nums being 2.
     */
    static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /* Remove Duplicates from Sorted Array
     * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
     * Do not allocate extra space for another array, you must do this in place with constant memory.
     * For example,
     * Given input array nums = [1,1,2],
     * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
     */

    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for(int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

    /* Implement strStr()
     * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     */
    static int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) return 0;
        if (haystack.length() < needle.length()) return -1;

        int i = -1;
        int length = haystack.length() - needle.length() + 1;
        for (int j = 0; j < length; j++) {
            if (haystack.substring(j, j+needle.length()).equals(needle)) {
                i = j;
                break;
            }
        }
        return i;
    }

    /* Merge Two Sorted Lists
     * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
     */
    static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /* Merge Sorted Array
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     * Note:
     * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements
     * from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
     */
    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        for (int k = m + n - 1; k >= 0; k--) {
            if (i < 0)                    nums1[k] = nums2[j--];
            else if (j < 0)               nums1[k] = nums1[i--];
            else if (nums1[i] < nums2[j]) nums1[k] = nums2[j--];
            else                          nums1[k] = nums1[i--];
        }
        StdOut.println(Arrays.toString(nums1));
    }

    /* Search Insert Position
     * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
     * You may assume no duplicates in the array.
     * Here are few examples.
     *  [1,3,5,6], 5 → 2
     *  [1,3,5,6], 2 → 1
     *  [1,3,5,6], 7 → 4
     *  [1,3,5,6], 0 → 0
     */
    static int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

    public static void main(String[] args) {
    }
}