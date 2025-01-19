package com.example.algorithmstudy.lessons017;

import java.util.*;
class Solution {
    public String solution(String s){
        StringBuilder answer = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Stack<Character> answerStack = new Stack<>();

        //입력을 stack에 저장
        char[] chars = s.toCharArray();
        for(char c : chars){
            stack.push(c);
        }

        while(!stack.isEmpty()){
            char currentCharacter = stack.pop();

            //여는괄호일 경우
            if(currentCharacter == '('){
                //몇배로 복사해야할지
                int x = 1;
                //stack에 값이 남아있고, 다음 값이 숫자일 경우 한번 더 뽑아서 배수로 쓰기
                if(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    x = Character.getNumericValue(stack.pop());
                }

                List<Character> list = new ArrayList<>();
                boolean isEnd = false;
                //닫는괄호 만날 때까지 answerStack에서 뽑기
                while(!answerStack.isEmpty() && !isEnd){
                    char ch = answerStack.pop();

                    if(ch == ')'){
                        isEnd = true;
                    } else {
                        list.add(ch);
                    }
                }

                //answerStack에서 뽑은 값을 원래 순서대로
                list = list.reversed();

                //배수만큼 복사해서 answerStack에 다시 넣기
                for(int i = 0 ; i < x ; i++){
                    for(char c : list){
                        answerStack.push(c);
                    }
                }
            } else {
                //여는 괄호가 아닌 나머지인 경우, answerStack에 채우기
                answerStack.push(currentCharacter);
            }
        }

        //answerStack의 내용물을 뽑아서 string으로
        while(!answerStack.isEmpty()){
            answer.append(answerStack.pop());
        }
        
        return answer.toString();
    }

    public static void main(String[] args){
        Solution T = new Solution();
        System.out.println(T.solution("3(a2(b))ef"));
        System.out.println(T.solution("2(ab)k3(bc)"));
        System.out.println(T.solution("2(ab3((cd)))"));
        System.out.println(T.solution("2(2(ab)3(2(ac)))"));
        System.out.println(T.solution("3(ab2(sg))"));
    }
}
