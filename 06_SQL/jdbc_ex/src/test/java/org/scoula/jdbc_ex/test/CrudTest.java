package org.scoula.jdbc_ex.test;

import org.junit.jupiter.api.*;
import org.scoula.jdbc_ex.common.JDBCUtil;

import java.sql.*;

// 테스트 메소드의 실행 순서를 지정해주는 어노테이션
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CrudTest {
    // JDBC 연결 객체를 생성하여 초기화
    Connection conn = JDBCUtil.getConnection();

    // 모든 테스트가 완료된 후 JDBC연결 종료
    @AfterAll
    static void tearDown(){
        JDBCUtil.close();
    }

    @Test
    @DisplayName("새로운 user를 등록한다.")
    @Order(1)
    public void insertUser() throws SQLException{
        // 사용자 정보를 데이터베이스에 삽입하는 SQL쿼리
        String sql = "insert into users(id, password, name, role) values(?,?,?,?)";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            // SQL쿼리에 매개변수 설정
            pstmt.setString(1, "scoula");
            pstmt.setString(2, "scoula3");
            pstmt.setString(3, "스콜라");
            pstmt.setString(4, "USER");
            // SQL 쿼리 실행 및 삽입된 행의 수를 반환
            // insert,update,delete문은 executeUpdate를 사용하며 return값은 int다
            int count = pstmt.executeUpdate();
            // 삽입된 행의 수가 1인지 확인하는 테스트
            Assertions.assertEquals(1, count);
        }
    }

    @Test
    @DisplayName("user 목록을 추출한다.")
    @Order(2)
    public void selectUser() throws SQLException{
       // 모든 사용자 정보는 조회하는 SQL쿼리
        String sql = "select * from users";
        try(Statement stmt = conn.createStatement();
            // select문은 executeQuery를 사용하며 return값은 테이블이다(ResultSet)
            ResultSet rs = stmt.executeQuery(sql);
            ){
            // 결과 집한(ResultSet)에서 데이터를 읽어와서 출력
            // next()로 다음 데이터가 있을 때 까지 while문으로 반복한다
            while(rs.next()){
                System.out.println(rs.getString("name"));
            }
        }
    }
    
    @Test
    @DisplayName("특정 user 검색한다.")
    @Order(3)
    public void selectUserByID() throws SQLException{
        // 검색할 사용자 ID
        String userid = "scoula";
        // 특정 사용자 정보를 조회하는 SQL쿼리
        String sql = "select * from users where id = ?";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            // SQL 쿼리의 매개변수 설정                                                                              
            pstmt.setString(1, userid);
            try(ResultSet rs = pstmt.executeQuery()){
                // 결과 집한(ResultSet)에서 해당 데이터를 하나 읽어와서 출력
                // 결과가 하나이기 때문에 while문이 아니라 if문으로 체크해줌
                if(rs.next()){
                    System.out.println(rs.getString("name"));
                } else {
                    // 사용자가 존재하지 않으면 예외를 발생
                    throw new SQLException("scoula not found");
                }
            }
        }
    }

    @Test
    @DisplayName("특정 user 수정한다.")
    @Order(4)
    public void updateUser() throws SQLException {
        String userid = "scoula";
        String sql ="update users set name= ? where id = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, "스콜라 수정");
            stmt.setString(2, userid);
            int count = stmt.executeUpdate();
            Assertions.assertEquals(1, count);
        }
    }
    @Test
    @DisplayName("지정한 사용자를 삭제한다.")
    @Order(5)
    public void deleteUser() throws SQLException {
        String userid = "scoula";
        String sql ="delete from users where id = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, userid);
            int count = stmt.executeUpdate();
            Assertions.assertEquals(1, count);
        }
    }

}
