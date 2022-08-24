package dev.evanishyn.daos.userDAOS;

import dev.evanishyn.entities.User;
import dev.evanishyn.utilities.enums.AcctType;
import dev.evanishyn.utilities.enums.ConnectionUtil;

import java.sql.*;

public class UserDaoPostgres implements UserDao{

    @Override
    public User createNewAccount(User user){
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "insert into acctuser values(default, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getfName());
            ps.setString(4, user.getlName());
            ps.setString(5, AcctType.CONSTITUENT.name());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

            int generateKey = rs.getInt("userid");
            user.setUserId(generateKey);
            return user;

        }catch(SQLException e) {
            e.printStackTrace();
        }
            return null;
        }



    @Override
    public User getAccountByUsername(String username) {
        try(Connection connection = ConnectionUtil.createConnection()){
            String sql = "select * from acctuser where username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            User user = new User();
            user.setUserId(resultSet.getInt("userid"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("pass"));
            user.setfName(resultSet.getString("fname"));
            user.setlName(resultSet.getString("lname"));
            user.setAcctType(AcctType.valueOf(resultSet.getString("accttype")));

            return user;

        }catch (SQLException exception){
            exception.printStackTrace();
        }
        return null;
    }
}
