package com.xj.springboot01;
/*
    题目：------ 最长回文字串 ------
        给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
    示例：
        输入: "babad"     输出: "bab"   注意: "aba" 也是一个有效答案。
        输入: "cbbd"      输出: "bb"
    解答：
        记录两个指针，start和end
        start外层循环，每个循环从队头开始向后遍历；
        end内层循环，每个循环从队尾向前遍历；
        当在比之前更长的字符串中，找到了回文字符串时，更新起始位置palindromeStart，和最大长度max
 */
public class LeetCode_5 {
    public static String longestPalindrome(String s) {
        int start = 0, end;//工作指针
        int palindromeStart = 0;//记录最长回文的起始位置
        int max = 0;//记录最长回文的长度
        while(start < s.length()){//start每个循环从0开始向后遍历
            end = s.length()-1;//end每个循环从队尾向前遍历
            while(end >= start + max){//这里很关键：只有符合这个条件，找出的才是比之前更长的回文串
                if (!isPalindrome(s, start, end)) {//不是回文的时候
                    end--;
                }else{
                    palindromeStart = start;
                    max = end - start + 1;
                    break;
                }
            }
            start++;
        }
        return s.substring(palindromeStart, palindromeStart + max);
    }

    private static boolean isPalindrome(String s, int start, int end){
        if(s.length() <= 0 || start > end || end > s.length()-1)
            return false;
        for (int i = 0; i <= (end - start)/2 ; i++) {
            if (s.charAt(start + i) != s.charAt(end - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // 验证longestPalindrome() “最长回文子串”
        String s1 = "abccdfdcesd";
        String s2 = "daabcdefedcbaabac";
        System.out.println(longestPalindrome(s1));
        System.out.println(longestPalindrome(s2));

        // 验证isPalindrome() “是否是回文字符串”
        String s3 = "xabccbadddd";
        String s4 = "abcd";
        System.out.println(isPalindrome(s3,1,6));
        System.out.println(isPalindrome(s4,0,3));
    }
}
