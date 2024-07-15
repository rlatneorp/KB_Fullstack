import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class JUnitTest {
    // 필수는 아니지만 테스트이름을 구분지을 때 사용
    @DisplayName("1+2는 3이다")
    // 해당 메서드가 테스트 메서드라는 걸 알려줌
    @Test
    public void junitTest(){
        int a = 1;
        int b = 2;
        int sum = 3;
    // assertEquals : 기대값과 예상값을 비교해서 테스트 성공 여부 결정
        Assertions.assertEquals(a+b, sum);
    }
}
