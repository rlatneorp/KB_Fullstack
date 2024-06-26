package ch12.sec03.exam05;

import lombok.Data;
import lombok.NonNull;

@Data // @RequiredArgsConstructor, @Getter, @Setter, @EqualsAndHashCode, @ToString 합친 것

public class Member2 {
    private String id;
    // NonNull : null 이면 안 되는 필수 항목, 따라서
    // @RequiredArgsConstructor에 의해 해당 필드를 포함하는 생성자가 만들어진다
    @NonNull
    private String name;
    private int age;
}
