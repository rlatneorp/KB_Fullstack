package org.scoula.jdbc_ex.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    static Connection conn = null;
    
    //정적 초기화 블럭을 사용해서 JDBC 드라이버를 로드하고 데이터베이스 연결 설정
    static{
       try{
           Properties properties = new Properties();
           properties.load(JDBCUtil.class.getResourceAsStream("/application.properties"));
           String driver = properties.getProperty("driver");
           String url = properties.getProperty("url");
           String id = properties.getProperty("id");
           String password = properties.getProperty("password");

           Class.forName(driver);
           conn = DriverManager.getConnection(url, id, password);
       } catch (Exception e){
           // 예외 발생 시 스택 트레이스 출력
           e.printStackTrace();
       }
    }

    public static Connection getConnection(){
        return conn;
    }

    public static void close(){
        try {
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
