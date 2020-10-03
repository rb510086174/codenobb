package com.example.demo.suanfa.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created By RenBin6 on 2020/9/29 .
 */
public class Solution {
    public static int[] twoFind(int[] source, int target){
        int[] result = new int[2];

        Map<Integer,Integer> data = new HashMap<>();
        for (int i = 0; i < source.length; i++) {

            if(data.containsKey(source[i])){
                result[0] = i;
                result[1] = data.get(source[i]);
                return result;
            }
            data.put(target - source[i],i);

        }
        return result;

    }

    public static void main(String[] args) {
        int[] source = new int[]{1,2,4,5,11,21};
        System.out.println(Arrays.toString(twoFind(source,7)));
    }
}
