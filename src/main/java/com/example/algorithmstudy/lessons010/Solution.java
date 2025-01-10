package com.example.algorithmstudy.lessons010;

import java.util.*;
class Solution {
    public int[] solution(String s){
        int[] answer = new int[5];
        int max = 0;

        char[] chars = s.toCharArray();

        for(char c : chars) {
            max = Math.max(max, ++answer[c - 97]);
        }

        for(int i = 0 ; i < answer.length ; i++ ) {
            answer[i] = Math.abs(answer[i] - max);
        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }
}
