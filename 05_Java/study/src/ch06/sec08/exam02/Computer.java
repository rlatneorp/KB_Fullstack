package ch06.sec08.exam02;

public class Computer {
    int sum(int ...values){
        int sum = 0;

//          향상된 for문
//        for(int i : values){
//            sum += i;
//        }

        for(int i = 0; i < values.length; i++){
            sum += values[i];
        }
        return sum;
    }
}
