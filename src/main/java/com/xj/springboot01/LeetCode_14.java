package com.xj.springboot01;
/*
    题目：------ 最长公共前缀 ------
        编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，返回空字符串 ""。
    示例：
        输入: ["flower","flow","flight"]  输出: "fl"
        输入: ["dog","racecar","car"]     输出: ""
    解答：
        执行用时 :1 ms, 在所有 Java 提交中击败了99.92%的用户
        内存消耗 :37.5 MB, 在所有 Java 提交中击败了76.68%的用户
 */
public class LeetCode_14 {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        int minlength = strs[0].length();//记录最短字符串长度，公共前缀不会长于最短字符串
        //找到最短字符串长度
        for (int i = 1; i < strs.length; i++) {
            if (minlength > strs[i].length()) {
                minlength = strs[i].length();
            }
        }
        // 在i个字符串中对比，判断当前curr这个字符是否相同，不相同则返回curr的值
        // 每完成一个字符的比较，则curr++
        int curr = 0;
        for (; curr < minlength; curr++) {
            for (int i = 0; i < strs.length - 1; i++) {
                if (strs[i].charAt(curr) != strs[i + 1].charAt(curr)) {
                    return strs[0].substring(0,curr);
                }
            }
        }
        return strs[0].substring(0,curr);
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
