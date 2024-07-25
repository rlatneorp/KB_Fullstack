package org.scoula.todo.context;

import lombok.Getter;
import lombok.Setter;
import org.scoula.domain.UserVO;

@Getter
@Setter
public class Context {
//    로그인한 사용자 정보, null 이면 로그아웃 상태
    private UserVO user;
    // context 하나만 생성할 수 있도록 싱글톤 패턴 적용
    private Context(){}
    private static Context context = new Context();
    public static Context getContext(){
        return context;
    }

}


