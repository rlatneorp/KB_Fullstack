package ch07.sec10.exam02;

public class AbstractMethodExample {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound();

        Cat cat = new Cat();
        cat.sound();

        // 매개변수의 다형성
        // 위 코드와 동일하게 동작하지만 더 좋은 코드
        animalSound(new Dog());
        animalSound(new Cat());
    }
    // 파라미터로 객체를 주입받아서 다형성을 부여함
    public static void animalSound(Animal animal) {
        animal.sound(); // 재정의된 메소드 호출
    }
}

