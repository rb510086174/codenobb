package com.example.demo.suanfa.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *  字符串 取不重复最长
 * Created By RenBin6 on 2020/9/30 .
 */
public class Solution3 {
    String a = "asdasdq";
    String b = "dasd11";

    public static void main(String[] args) {

    }
    static String longString(String str){
        String result = "";
        //滑动窗口

        int end = -1;
        int answer = 0;
        Set<Character> occ = new HashSet<>();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            if( i != 0){
                //左指针右移
                occ.remove(str.charAt( i - 1));

            }
            while (end + 1 < n && occ.contains(str.charAt( end + 1))){
                //不停移动右指针
                occ.add(str.charAt(end + 1));

                ++end;
            }

            //如果出现重复字符，移动左边指针
            answer = Math.max( answer, end - i + 1);
        }


        return result;
    }
}
