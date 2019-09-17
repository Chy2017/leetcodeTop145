package com.xj.springboot01;

import java.util.HashSet;
import java.util.Set;
/*
    题目：
        给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    实例：
        输入: "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    解答：
        滑动窗口法
        使用start和end维护无重复字符串的范围，使用set数据结构，存储零时字符串
        当新加入的字符造成重复的时候，从起始位置开始，从set移除字符，并且start++，
        当新加入的字符不造成重复的时候，set加入该字符，并且end++，并更新窗口最大宽度
        窗口最大宽度，为历史最大宽度和当前宽度中的较大者 Math.max(res, end - start);
 */
public class LeetCode_3 {

    public static int lengthOfLongestSubstring(String s) {
        int res = 0;//保存无重复字符的最大长度
        int start = 0,end = 0;//滑动窗口，起始终止位置
        int length = s.length();
        Set<Character> set = new HashSet<>();
        while(start + res < length && end < length){
            if (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start++));
            }else{
                set.add(s.charAt(end++));
                res = Math.max(res, end - start);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        System.out.println("s1的无重复字符最长为：" + lengthOfLongestSubstring(s1));
        System.out.println("s2的无重复字符最长为：" + lengthOfLongestSubstring(s2));
    }
}
