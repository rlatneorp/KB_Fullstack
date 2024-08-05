package org.scoula.dao;

import org.scoula.common.JDBCUtil;
import org.scoula.domain.UserVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    Connection conn = JDBCUtil.getConnection();

    private String USER_LIST = "select * from users where = ?";
    private String USER_CREATE = "insert into users values(?,?,?,?)";
    private String USER_DETAIL_LIST = "select * from users where = ?";
    private String USER_DELETE = "delete from users where id = ?";
    private String USER_UPDATE = "update users set name = ?, role = ? where id = ?";

    private UserVO map(ResultSet rs) throws SQLException {
        UserVO user = new UserVO();
        user.setId(rs.getString("ID"));
        user.setName(rs.getString("NAME"));
        user.setPassword(rs.getString("PASSWORD"));
        user.setRole(rs.getString("ROLL"));
        return user;
    }

    @Override
    public int create(UserVO user) throws SQLException {
        try(PreparedStatement psmt = conn.prepareStatement(USER_CREATE)){
            psmt.setString(1, user.getId());
            psmt.setString(2, user.getPassword());
            psmt.setString(3, user.getName());
            psmt.setString(4, user.getRole());
            return psmt.executeUpdate();
        }
    }

    @Override
    public List<UserVO> getList() throws SQLException {
        List<UserVO> list = new ArrayList<>();
        try(PreparedStatement psmt = conn.prepareStatement(USER_LIST);
        ResultSet rs = psmt.executeQuery()){
            while(rs.next()){
                UserVO user = map(rs);
                list.add(user);
g            }
eeeeeeeeeeeeeeeeee    }

    @Override
    public Optional<UserVO> get(String id) throws SQLException {
        try(PreparedStatement psmt = conn.prepareStatement(USER_DETAIL_LIST)){
            psmt.setString(1, id);
            try(ResultSet rs = psmt.executeQuery()){
                if(rs.next()){
                     return Optional.of(map(rs));
                }
            }q
        }
        return Optional.empty();
    }

    @Override
    public int update(UserVO user) throws SQLException {
        try(PreparedStatement psmt = conn.prepareStatement(USER_UPDATE)){
            psmt.setString(1, user.getName());
            psmt.setString(2, user.getRole());
            psmt.setString(3, user.getId());
            return psmt.executeUpdate();
        }

    }

    @Override
    public int delete(String id) throws SQLException {
        try(PreparedStatement psmt = conn.prepareStatement(USER_DELETE)){
            psmt.setString(1, id);
            return psmt.executeUpdate();
        }
    }
}
