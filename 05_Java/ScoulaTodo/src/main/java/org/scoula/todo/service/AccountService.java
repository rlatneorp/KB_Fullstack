package org.scoula.todo.service;

import org.scoula.dao.UserDao;
import org.scoula.dao.UserDaoImpl;
import org.scoula.domain.UserVO;
import org.scoula.todo.PasswordMissmatchException;
import org.scoula.todo.UsernameDuplicateException;

import java.sql.SQLException;
import java.util.Optional;

public class AccountService {
    
    UserDao dao = new UserDaoImpl();
    
    // 회원 가입 기능 구현 메서드
    public void join(){
        try{
            // 유저의 정보를 받아와서 users 테이블에 추가해준다
            UserVO user = getUser();
            dao.create(user);
        } catch (UsernameDuplicateException| PasswordMissmatchException){
            System.out.println(e.getMessage());  
        } catch (Exception e){
            // 지정한 예외 외에 다른 예외 발생 시 Runtime예외로 처리하겠다
            throw new RuntimeException(e);
        }
    }

    public boolean checkDuplicate(String username) throws UsernameDuplicateException, SQLException {
//        유저의 이름으로 해당하는 유저 정보 받아오기(SELECT)
        Optional<UserVO> result = dao.get(username);
        if(result.isPresent()){
//            해당 유저가 존재할 경우 예외 던지기
//            해당 코드로 들어오면 예외 발생 후 함수 종료
            throw new UsernameDuplicateException();
        }
//        중복이 안됐다는 뜻으로 false 리턴
        return false;
    }
}
