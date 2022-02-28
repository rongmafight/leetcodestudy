package com.ke.day01;

/**
 * 滑动窗口思想：
 * 一左一右两个指针，先移动右指针直到满足条件，再移动左指针，直到条件不满足，再移动右指针，以此类推！
 */
public class SlidingWindowTemplate {

    /**
     * 给定一个含有n个正整数的数组和一个正整数 target 。
     *
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int length = nums.length;
        int left = 0;
        int right = 0;
        int window = 0;
        while (right < length) {
            do {
                window += nums[right];
                right++;
            } while (right < length && window < target);

            while (window >= target) {
                min = Math.min(min, right - left);
                window -= nums[left];
                left++;
            }
        }
        if (min == Integer.MAX_VALUE) {
            min = 0;
        }
        return min;
    }

    public static void main(String[] args) {
        SlidingWindowTemplate template = new SlidingWindowTemplate();
        System.out.println(template.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
    }
}
