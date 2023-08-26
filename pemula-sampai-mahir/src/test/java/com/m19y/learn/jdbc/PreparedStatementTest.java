package com.m19y.learn.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class PreparedStatementTest {

  @Test
  void testSQLInjectionPreparedStatement() throws SQLException {
    Connection connection = ConnectionUtil.getDataSource().getConnection();

    // assume input dari user
    String username = "admin";
    String password = "admin";

    String sql = "SELECT * FROM admin WHERE username = ? AND password = ? ";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);

    // set parameter
    preparedStatement.setString(1, username);
    preparedStatement.setString(2, password);

    ResultSet resultSet = preparedStatement.executeQuery();


    if(resultSet.next()){
      // success login
      System.out.println("Success login with username " + resultSet.getString("username"));
    }else {
      // gagal login
      System.out.println("gagal login");
    }

    // close
    resultSet.close();
    preparedStatement.close();
    connection.close();

  }
}
