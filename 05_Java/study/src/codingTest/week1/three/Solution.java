package codingTest.week1.three;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public ArrayList<Integer> solution(int[] sequence, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int e = 0;
        Arrays.stream(sequence).sorted();
        for(int s : sequence){
            e = k - sequence[s];
            int indexE = e - 1;
            int indexS = s - 1;
            list.add(indexE);
            list.add(indexS);
        }
        return list;
    }
}