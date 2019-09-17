package com.xj.springboot01;

import java.util.Arrays;
import java.util.HashMap;
/*
    题目：
        给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
    实例：
        给定 nums = [2, 7, 11, 15], target = 9
        因为 nums[0] + nums[1] = 2 + 7 = 9
        所以返回 [0, 1]
    解答：
        我们令：nums数组元素所对应的值为key，nums数组元素的下标为value
        那我们遍历nums的时候，nums数组元素进入hashmap之前应该检查是否有（target - nums数组元素）已经在库中
        若有，则输出这两个 nums数组元素 对应的value（即题目要求的下标）
        若没有，则按照（nums数组元素所对应的值为key，nums数组元素的下标为value）入库
*/
public class LeetCode_1 {

    public static int[] twoSum(int[] nums, int target){

        HashMap<Integer,Integer> m = new HashMap<>();
        int ans[] = {-1, -1};
        for (int i = 0; i < nums.length; i++){
            if (m.containsKey(target - nums[i])) {
                ans[0] = m.get(target - nums[i]);
                ans[1] = i;
                break;
            }
            m.put(nums[i],i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 13;
        int[] ans = twoSum(nums, target);
        if (ans[0] == -1) {
            System.out.println("没有找到符合条件的两个数！");
        }else{
            System.out.println(Arrays.toString(ans));
        }
    }

}
