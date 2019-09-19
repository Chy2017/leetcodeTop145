package com.xj.springboot01;
/*
    题目：------ 罗马数字转整数 ------
        字符          数值
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
    例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
    通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
    数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
    同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
        I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
        X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
        C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
        给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
    示例：
        输入: "MCMXCIV"
        输出: 1994
        解释: M = 1000, CM = 900, XC = 90, IV = 4.
    解答：
        从前往后一位一位读取，同时探测下一位，若当前位和下一位构成特殊的六种情况，则减法，其他情况做加法
        执行用时 :5 ms, 在所有 Java 提交中击败了99.67%的用户
        内存消耗 :36.4 MB, 在所有 Java 提交中击败了96.96%的用户
 */
public class LeetCode_12 {
    public static int romanToInt(String s) {
        int res = 0;
        s = s + "_";// 在s后面多加一位，防止i+1的时候下标越界
        for (int i = 0; i < s.length()-1; i++) {
            switch (s.charAt(i)){
                case 'I':
                    switch (s.charAt(i+1)){
                        case 'V':
                        case 'X':
                            res = res - 1;
                            break;
                        default:
                            res = res + 1;
                    }
                    break;
                case 'X':
                    switch (s.charAt(i+1)){
                        case 'L':
                        case 'C':
                            res = res - 10;
                            break;
                        default:
                            res = res + 10;
                    }
                    break;
                case 'C':
                    switch (s.charAt(i+1)){
                        case 'D':
                        case 'M':
                            res = res - 100;
                            break;
                        default:
                            res = res + 100;
                    }
                    break;
                case 'V':
                    res = res + 5;
                    break;
                case 'L':
                    res = res + 50;
                    break;
                case 'D':
                    res = res + 500;
                    break;
                case 'M':
                    res = res + 1000;
                    break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String test1 = "III";
        String test2 = "IV";
        String test3 = "IX";
        String test4 = "LVIII";
        String test5 = "MCMXCIV";
        System.out.println(romanToInt(test1));
        System.out.println(romanToInt(test2));
        System.out.println(romanToInt(test3));
        System.out.println(romanToInt(test4));
        System.out.println(romanToInt(test5));
    }
}
