package com.example.algorithmstudy.lessons022;

import java.util.*;
class Solution {
    public int[] solution(int[] nums){
        int[] answer = new int[nums.length];
        HashMap<Integer,Integer> map = new HashMap<>();

        //1의 갯수를 구해 {숫자:1의 갯수} map으로 만들기
        for(int num : nums){
            int count = 0;
            char[] chars = Integer.toBinaryString(num).toCharArray();

            for(char c : chars){
                count+=Character.getNumericValue(c);
            }

            map.put(num, count);
        }

        //map을 정렬하기
        answer = map.entrySet()
                .stream()
                .sorted((a, b) -> {
                    //1의 갯수를 기준으로 정렬
                    int compare = a.getValue().compareTo(b.getValue());
                    //1의 갯수가 같다면, 숫자의 크기를 기준으로 정렬
                    if(compare == 0) {
                        return a.getKey().compareTo(b.getKey());
                    }
                    return compare;
                })
                .mapToInt(i->i.getKey())
                .toArray();

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}
