package com.m19y.learn.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLInjectionTest {

  @Test
  void testSQLInjection() throws SQLException {
    Connection connection = ConnectionUtil.getDataSource().getConnection();

    Statement statement = connection.createStatement();

    // assume input dari user
    String username = "admin'; #";
    String password = "salah";


    String sql = "SELECT * FROM admin WHERE username = '" + username + "' AND password = '" + password + "'";


    ResultSet resultSet = statement.executeQuery(sql);


    if(resultSet.next()){
      // success login
      System.out.println("Success login with username " + resultSet.getString("username"));
    }else {
      // gagal login
      System.out.println("gagal login");
    }

    // close
    resultSet.close();
    statement.close();
    connection.close();

  }
}
