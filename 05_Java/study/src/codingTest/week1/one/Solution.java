package codingTest.week1.one;

import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
       // 정렬 o(nlogn)
        Arrays.sort(participant);
        Arrays.sort(completion);

        // i 0~n-1 순회
        for(int i = 0; i < completion.length; i++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        return participant[participant.length-1];
    }
}
