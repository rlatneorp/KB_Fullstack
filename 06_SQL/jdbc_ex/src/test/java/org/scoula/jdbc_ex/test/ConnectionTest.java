package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.scoula.jdbc_ex.common.JDBCUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {
    @Test
    @DisplayName("jdbc_ex 데이터베이스에 접속한다.")
    public void testConnection() throws SQLException, ClassNotFoundException {
        // mySQL JDBC 드라이버를 로드함
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 데이터베이스 연결을 위해 url ,사용자 ID, 비밀번호 설정
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc_ex";
        String id = "jdbc_ex";
        String password = "jdbc_ex";
        
        // DriverManager를 사용해서 데이터베이스 연결 객체를 생성
        Connection conn = DriverManager.getConnection(url, id, password);
        // 연결 성공 메시지 출력
        System.out.println("DB 연결 성공");
        // 데이터베이스 연결 종료
        conn.close();
    }
    
    // 위 테스트 함수와는 다르게 JDBCUtil 부분에 연결을 모듈화함
    // 재사용성과 유지보수하기 좋아짐
    @Test
    @DisplayName("jdbc_ex에 접속한다.(자동 닫기)")
    void getConnection() throws SQLException {
        try(Connection conn = JDBCUtil.getConnection()) {
            System.out.println("DB 연결 성공");
        }
    }
}
