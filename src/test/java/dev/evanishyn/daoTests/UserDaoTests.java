package dev.evanishyn.daoTests;

import dev.evanishyn.daos.userDAOS.UserDao;
import dev.evanishyn.daos.userDAOS.UserDaoPostgres;
import dev.evanishyn.entities.User;
import dev.evanishyn.utilities.enums.AcctType;
import dev.evanishyn.utilities.enums.ConnectionUtil;
import org.junit.jupiter.api.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDaoTests {

    static UserDaoPostgres userDao = new UserDaoPostgres();

    @Disabled
    @BeforeAll
    static void teardown(){
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "drop table acctuser";
            Statement statement = conn.createStatement();
            statement.execute(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Test
    @Order(1)
    void setup_complaint(){
        try(Connection conn = ConnectionUtil.createConnection()){
            String sql = "create table acctuser(\n" +
                    "\tuserid serial primary key,\n" +
                    "\tusername varchar(100) not null,\n" +
                    "\tpass varchar(20) not null,\n" +
                    "\tfName varchar(100) not null,\n" +
                    "\tlname varchar(100) not null,\n" +
                    "\tacctType varchar(20) not null\t--Councilmemb, constituent, \n" +
                    ")";

            Statement st = conn.createStatement();  //Check for null pointer Exception!
            st.execute(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    void create_new_user_dTest(){
        User user = new User(0, "caitevan", "password", "Caitlin", "Evanishyn", AcctType.MEMBER );
        User savedUser = userDao.createNewAccount(user);
        Assertions.assertNotEquals(0, savedUser.getUserId());
    }

    @Test
    @Order(3)
    void get_account_by_username(){
        User user = userDao.getAccountByUsername("caitevan");
        Assertions.assertEquals("Caitlin", user.getfName());
    }

}
