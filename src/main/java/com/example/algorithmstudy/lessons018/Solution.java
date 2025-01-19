package com.example.algorithmstudy.lessons018;

import java.util.*;
class Solution {
    enum PreState {
        IN, OUT, NONE
    }

    public int[] solution(int[] arrival, int[] state){
        int[] answer = new int[arrival.length];

        Queue<Integer> inQueue = new LinkedList<>();
        Queue<Integer> outQueue = new LinkedList<>();

        //이동한 사람 수 세기
        int count = 0;
        PreState preState = PreState.NONE;
        for(int i = 0 ; count < arrival.length ; i++){
            for(int j = 0 ; j < arrival.length ; j++){
                //i = 현재시간, 현재시간에 도착한 사람은 큐에 넣기
                if(arrival[j] == i){
                    if(state[j] == 0){
                        inQueue.add(j);
                    } else {
                        outQueue.add(j);
                    }
                }
            }

            //직전에 이동이 없었거나, 나갔다면 나가는 사람 먼저
            //이동할 때, 카운트하기 + 현재상태를 직전상태로 저장하기
            if(preState == PreState.NONE || preState == PreState.OUT){
                if(!outQueue.isEmpty()){
                    answer[outQueue.poll()] = i;
                    count++;
                    preState = PreState.OUT;
                } else if(!inQueue.isEmpty()){
                    answer[inQueue.poll()] = i;
                    count++;
                    preState = PreState.IN;
                } else {
                    preState = PreState.NONE;
                }
            } else if(preState == PreState.IN){
                if(!inQueue.isEmpty()){
                    answer[inQueue.poll()] = i;
                    count++;
                    preState = PreState.IN;
                } else if(!outQueue.isEmpty()){
                    answer[outQueue.poll()] = i;
                    count++;
                    preState = PreState.OUT;
                } else {
                    preState = PreState.NONE;
                }
            }

        }

        return answer;
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(Arrays.toString(T.solution(new int[]{0, 1, 1, 1, 2, 3, 8, 8}, new int[]{1, 0, 0, 1, 0, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{3, 3, 4, 5, 5, 5}, new int[]{1, 0, 1, 0, 1, 0})));
        System.out.println(Arrays.toString(T.solution(new int[]{2, 2, 2, 3, 4, 8, 8, 9, 10, 10}, new int[]{1, 0, 0, 0, 1, 1, 0, 1, 1, 0})));
    }
}
