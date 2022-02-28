package com.ke.day01;


/**
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SlidingWindow04 {

    public int minSubArrayLen(int target, int[] nums) {
        if (nums[0] >= target) {
            return 1;
        }
        int min = 100001;
        int count = 0;
        int total = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            count++;
            if (total >= target) {
                min = Math.min(min, count);
                if (min == 1) {
                    return 1;
                }
                count = 0;
                total = 0;
                j++;
                i = j;
            }
        }
        if (min == 100001) {
            min = 0;
        }
        return min;
    }

    public static void main(String[] args) {
        SlidingWindow04 window04 = new SlidingWindow04();
        System.out.println(window04.minSubArrayLen(80, new int[]{10,5,13,4,8,4,5,11,14,9,16,10,20,8}));
    }

}
