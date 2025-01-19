package com.example.algorithmstudy.lessons016;

import java.util.*;
class Solution {
    public int solution(int[] nums){
        int maxLength = 0;
        int currentLength = 1;

        //중복제거
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        nums = set.stream().sorted().mapToInt(Integer::intValue).toArray();

        //이전값과 비교
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1]+1){
                currentLength++;
                if(currentLength > maxLength){
                    maxLength = currentLength;
                }
            } else {
                currentLength = 1;
            }
        }

        return maxLength;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}
