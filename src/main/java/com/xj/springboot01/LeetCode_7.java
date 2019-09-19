package com.xj.springboot01;
/*
    题目：------ 整数反转 ------
        给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
    示例：
        输入: 123     输出: 321
        输入: -123    输出: -321
        输入: 120     输出: 21
    解答：

 */
public class LeetCode_7 {
    public static int reverse(int x) {
        int max = 0x7fffffff;
        int res = 0, symbol = 1;//symbol代表符号位
        if (x < 0){
            x = -x;
            symbol = -1;
        }
        while(x > 0){
            if(res > (max-(x%10))/10){//试探一下，res在增加的时候，会不会超过int的最大值
                res = 0;
                break;
            }
            res = res*10 + x%10;
            x = x/10;
        }
        res *= symbol;
        return res;
    }

    public static void main(String[] args) {
        int test1 = 123;
        int test2 = -123;
        int test3 = 120;
        int test = 1534236469;//此用例反转过后，会超过int的最大值限制，此时反转后应该归零
        System.out.println(reverse(test1));
        System.out.println(reverse(test2));
        System.out.println(reverse(test3));
        System.out.println(reverse(test));
    }
}
