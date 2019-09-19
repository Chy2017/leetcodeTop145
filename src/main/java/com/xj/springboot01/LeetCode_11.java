package com.xj.springboot01;
/*
    题目：------ 盛最多水的容器 ------
        给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
        在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
        找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
    示例：
        输入: [1,8,6,2,5,4,8,3,7]
        输出: 49
    解答：
        双指针，指针i从左向右遍历，指针j从右向左遍历，同时注意剪枝
        1.从后向前遍历的时候，若发现这个高度小于之前的，则不需要计算；
        2.从后向前遍历的时候，若发现这个高度已经大于等于i位置的高度，则不需要继续往前面遍历计算了。
 */
public class LeetCode_11 {
    public static int maxArea(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            for(int j = height.length - 1; j > i; j--){
                if(j < height.length - 1 && height[j] < height[j+1]){
                    // 从后向前遍历的时候，若发现这个高度小于之前的，则不需要计算
                    //（j < height.length - 1）是为了防止数组越界
                    continue;
                }
                res = Math.max(Math.min(height[i],height[j]) * (j-i), res);
                // 从后向前遍历的时候，若发现这个高度已经大于等于i位置的高度，则不需要继续往前面遍历计算了
                if(height[j] >= height[i])
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(test));
    }
}
