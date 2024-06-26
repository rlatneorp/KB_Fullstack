package ch12.sec05;

import java.util.StringTokenizer;

public class StringTokenizerExample {
    public static void main(String[] args) {
        // split으로 String 쪼개기
        String data1 = "홍길동&이수홍,박연수";
        // &이거나 , 이면 해당 구분자를 기준으로 쪼갠다
        String[] arr = data1.split("&|,");
        for (String token : arr) {
            System.out.println(token);
        }
        System.out.println();
        // StringTokenizer로 String쪼개기
//        "/"를 기준으로 data2를 쪼갠다
        String data2 = "홍길동/이수홍/박연수";
        StringTokenizer st = new StringTokenizer(data2, "/");
//       hasMoreTokens : 다음 요소가 있는지 boolean값으로 반환해준다
        while (st.hasMoreTokens()) {
//            nextToken : 실제로 다음에 있는 요소를 가져온다
            String token = st.nextToken();
            System.out.println(token);
        }
    }
}
