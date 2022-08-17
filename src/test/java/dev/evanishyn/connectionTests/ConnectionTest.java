package dev.evanishyn.connectionTests;

import dev.evanishyn.utilities.enums.ConnectionUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

public class ConnectionTest {
    @Test
    void connection_available(){
        Connection connection = ConnectionUtil.createConnection();
        System.out.println(connection);
        Assertions.assertNotNull(connection);
    }

}
