package codingTest.firstSt.one;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        int indexd = 0;
        for(int i = 0; i < participant.length; i++){
            for(int j = 0; j < completion.length; j++){
             if(participant[i].equals(completion[j])){
                 indexd = participant[i].indexOf(i);
             }
                answer = participant.replace(participant[i], indexd);
            }
        }
        return answer;
    }
}