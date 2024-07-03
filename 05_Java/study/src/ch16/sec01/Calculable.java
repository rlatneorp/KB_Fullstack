package ch16.sec01;

//추상 메서드를 하나만 가지고 있는 인터페이스를 함수형 인터페이스로 사용 가능
// 컴파일시 추상 메소드를 체크한다
@FunctionalInterface
public interface Calculable {
    void calculate(int x, int y);
}
