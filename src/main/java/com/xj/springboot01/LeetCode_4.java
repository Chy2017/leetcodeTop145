package com.xj.springboot01;
/*
    题目：
        给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
        请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
        你可以假设 nums1 和 nums2 不会同时为空。
    实例：
        nums1 = [1, 3] ，nums2 = [2] ，则中位数是 2.0
        nums1 = [1, 2] ，nums2 = [3, 4] ，则中位数是 (2 + 3)/2 = 2.5
    解答：
        无论如何，中位数是第(len1+len2+1)/2小的数n1和第(len1+len2+2)/2小的数n2的平均数（可自行验证）
        这样求中位数的问题就转化为了：实现“在两个有序（递增）数组中查找第k小元素”
        由于时间复杂度要求的是 O(log(m + n))，我们必须采用“二分法”来实现
 */
public class LeetCode_4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        int n1 = (len1 + len2 + 1) / 2;
        int n2 = (len1 + len2 + 2) / 2;
        return (getKth(nums1, 0, nums2, 0, n1) + getKth(nums1, 0, nums2, 0, n2)) / 2.0;
    }
    // 在两个有序（递增）数组中二分查找第k小的元素，参数为：（数组1，数组1起始位置，数组2，数组2起始位置，要查第几小的数）
    private static int getKth(int[] nums1, int start1, int[] nums2, int start2, int k){
        // 特殊情况1：当某个数组查找的起始位置大于等于该数组长度时，说明这个数组中的所有数已经被淘汰，则只需要在另一个数组查找第k小的即可。
        if(start1 > nums1.length-1) return nums2[start2 + k - 1];
        if(start2 > nums2.length-1) return nums1[start1 + k - 1];
        // 特殊情况2：如果 k=1时，则找到两个数组起始位置中最小的那个即可。
        if(k == 1) return Math.min(nums1[start1], nums2[start2]);

        // 分别在两个数组中查找第k/2小的元素，若存在（即数组没有越界），标记为找到的值；若不存在，标记为整数最大值
        int nums1Mid = start1 + k/2 - 1 < nums1.length ? nums1[start1 + k/2 - 1] : Integer.MAX_VALUE;
        int nums2Mid = start2 + k/2 - 1 < nums2.length ? nums2[start2 + k/2 - 1] : Integer.MAX_VALUE;

        // 将已经确定的k/2个更小的元素排除掉，在剩下的部分中查找第(k-k/2)小的元素，递归下去
        if(nums1Mid < nums2Mid)
            return getKth(nums1, start1 + k/2, nums2, start2, k-k/2);
        else
            return getKth(nums1, start1, nums2, start2 + k/2, k-k/2);
    }
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 5, 6, 13, 24, 30};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
