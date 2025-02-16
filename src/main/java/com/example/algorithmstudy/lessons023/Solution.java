package com.example.algorithmstudy.lessons023;

import java.util.*;
class Solution {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length / 2];

        //미리 정렬하기
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-1; i++){
            //2배수는 -1로 치환하기 때문에, 0보다 작으면 넘어가기
            if(nums[i] < 0){
                continue;
            }

            for(int j = 1; j < nums.length; j++){
                //셀프비교는 넘어가기
                if(i==j){
                    continue;
                }

                //2배수는 -1로 치환하기
                if(nums[i]*2 == nums[j]){
                    nums[j] = -1;
                }
            }
        }

        //-1 제외하기
        answer = Arrays.stream(nums).filter(i -> i != -1).toArray();

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}
