package ch15.sec02.exam01;

import lombok.*;

// 필드 전부를 가지고 있는 생성자 만들기
@AllArgsConstructor
// 기본 생성자를 만든다
//@NoArgsConstructor
//@Getter
//@Setter
// @Data 는 Getter,Setter,toString,NoArgsConstructor,HashCode,Equals 가 포함된다
@Data
public class Board {
    private String subject;
    private String content;
    private String writer;
}
