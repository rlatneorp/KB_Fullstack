package ch07.sec09;

public class InstanceofExample {
    public static void personInfo(Person person){
        System.out.println("name: " + person.name);
        person.walk();

        // person이 참조하는 객체가 Student 타입인지 확인
//        if(person instanceof Student){
//            Student student = (Student) person;
        // Student 객체만 가지고 있는 필드 및 메소드 사용
        // person에서는 사용 불가 : 부모가 자식꺼 쓰려면 캐스팅 해줘야함
//            System.out.println("studentNo: " + student.studentNo);
//            student.study();
//        }

        // 위 코드와 동일, 자바12 버젼부터 사용 가능한 코드
        // person이 참조하는 객체가 Student 타입일 경우
        // student 변수에 대입 (타입 변환 발생)
        if(person instanceof Student student){
            System.out.println("studentNo: " + student.studentNo);
            student.study();
        }
    }

    public static void main(String[] args) {
        // Person 객체를 매개값으로 제공하고 personInfo()메서드 호출
        Person p1 = new Person("홍길동");
        // Person객체는 Student 타입이 아니기 때문에 if문에 들어가지 않는다
        personInfo(p1);

        System.out.println();
        // Student 객체를 매개값으로 제공하고 personInfo() 메서드 호출
        Person p2 = new Student("김길동", 10);
        personInfo(p2);
    }
}
