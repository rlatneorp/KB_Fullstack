package ch15.sec03.exam02;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Member {
    public String name;
    public int age;

    // hashCode 재정의
    @Override
    public int hashCode(){
        return name.hashCode() + age;
    }

    // equals 재정의
    @Override
    public boolean equals(Object obj){
//        obj가 Member 타입일 경우 target이란 이름의 객체로 다운캐스팅해줌
        if(obj instanceof Member target) {
            return target.name.equals(name) && (target.age==age) ;
        } else {
            return false;
        }
    }
}

