package org.scoula.todo;

public class PasswordMissmatchException extends Exception{
    public PasswordMissmatchException(){
        super("비밀번호가 맞지 안습니다.");
    }
}