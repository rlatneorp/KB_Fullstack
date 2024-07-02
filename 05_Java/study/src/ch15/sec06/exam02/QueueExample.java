package ch15.sec06.exam02;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // Queue 컬렉션 생성
        // Queue는 인터페이스이기 때문에 객체 생성 불가
        // LinkedList는 queue의 하위 요소기 때문에 업캐스팅 가능
        Queue<Message> messageQueue = new LinkedList<>();

        // 메시지 넣기
        messageQueue.offer(new Message("sendMail", "홍길동"));
        messageQueue.offer(new Message("sendSMS", "신용권"));
        messageQueue.offer(new Message("sendKakaotalk", "김자바"));

        // 메시지를 하나씩 꺼내어 처리
        while (!messageQueue.isEmpty()) {
//            poll : 큐에서 요소 하나 꺼내기
//            FIFO기 때문에 가장 먼저 넣은 홍길동이 꺼내진다
//            First In, First Out
            Message message = messageQueue.poll();
//             객체의 필드에 접근할때는 .을 사용
            switch(message.command){
                case "sendMail":
//                    message.to는 매번 요소를 돌때마다 달라진다
                    System.out.println(message.to + "님에게 메일을 보냅니다.");
                    break;
                case "sendSMS":
                    System.out.println(message.to + "님에게 SMS를 보냅니다.");
                    break;
                case "sendKakaotalk":
                    System.out.println(message.to + "님에게 카카오톡을 보냅니다.");
                    break;
            }
        }
    }
}
