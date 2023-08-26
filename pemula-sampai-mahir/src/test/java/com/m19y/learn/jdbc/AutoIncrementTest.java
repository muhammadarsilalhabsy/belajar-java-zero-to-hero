package com.m19y.learn.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class AutoIncrementTest {

  @Test
  void testAutoIncrementGetGeneratedKeyUsingStatement() throws SQLException {

    Connection connection = ConnectionUtil.getDataSource().getConnection();

    Statement statement = connection.createStatement();;

    String sql = "INSERT INTO comments (email, comment) VALUES ('otong@gmail.com', 'wkwk')";

    statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);

    ResultSet generatedKeys = statement.getGeneratedKeys();
    if(generatedKeys.next()){
      int lastGeneratedKey = generatedKeys.getInt(1);
      System.out.format("last id is -> %d\n", lastGeneratedKey);
    }

    statement.close();
    connection.close();


  }
  @Test
  void testAutoIncrementGetGeneratedKeyUsingPreparedStatement() throws SQLException {

    Connection connection = ConnectionUtil.getDataSource().getConnection();


    String sql = "INSERT INTO comments (email, comment) VALUES (?,?)";
    PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

    statement.setString(1, "Jamrud@gmail.com");
    statement.setString(2, "mate yoo");

    statement.executeUpdate();

    ResultSet generatedKeys = statement.getGeneratedKeys();
    if(generatedKeys.next()){
      int lastGeneratedKey = generatedKeys.getInt(1);
      System.out.format("last id is -> %d\n", lastGeneratedKey);
    }

    statement.close();
    connection.close();


  }

}
