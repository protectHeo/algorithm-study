package com.example.algorithmstudy.lessons024;

import java.util.*;
class Solution {
    public int solution(int[] nums, int k){
        int answer = 0;
        PriorityQueue<Turn> pq = new PriorityQueue<>();

        //미리 정렬
        nums = Arrays.stream(nums).sorted().toArray();
        for(int i = 0; i < nums.length; i+=2){
            //숫자를 보면서 뽑으니까, 결국 두장 중 더 좋은거 가져가기 게임
            //한턴에 뽑히는 숫자간의 차이를 우선순위의 기준으로 한다
            Turn turn = new Turn();
            turn.min = nums[i];
            turn.max = nums[i+1];
            turn.difference = turn.max - turn.min;
            pq.add(turn);
        }

        while(!pq.isEmpty()){
            Turn turn = pq.poll();
            //차이가 가장 큰 턴에서 우선권 사용한다고 가정하기
            if(k > 0) {
                answer += turn.max;
                k--;
            } else {
                answer += turn.min;
            }
        }

        return answer;
    }

    private static class Turn implements Comparable<Turn>{
        int min;
        int max;
        int difference;

        @Override
        public int compareTo(Turn o) {
            return o.difference - difference;
        }
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution(new int[]{7, 8, 5, 12, 3, 1, 3, 1, 1, 12}, 2));
        System.out.println(T.solution(new int[]{8, 2, 12, 12, 12, 12, 2, 2}, 2));
        System.out.println(T.solution(new int[]{3, 7, 12, 3, 3, 5, 7, 8, 9, 11, 23, 4, 6, 7}, 3));
        System.out.println(T.solution(new int[]{12, 34, 56, 23, 22, 34, 55, 45, 24, 23, 45, 55, 55, 23, 11, 12, 23, 12}, 3));
        System.out.println(T.solution(new int[]{14, 15, 20, 11, 10, 20, 20, 12, 9, 22, 27, 25, 30, 19}, 3));
    }
}