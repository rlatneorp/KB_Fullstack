package ch12.sec03.exam01;

public class Member {
    public String id;

    public Member(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
//        obj가 Member타입일 경우 Member타입으로 다운캐스팅해서 target에 저장
        if(obj instanceof Member target) {
//            target에 아이디와 현재 객체의 id가 동일한지 검사
            if(id.equals(target.id)) {
                return true;
            }
        }
        return false;
    }
}
