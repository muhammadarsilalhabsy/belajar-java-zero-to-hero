package com.m19y.learn.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementTest {

  @Test
  void testCreateStatement() throws SQLException {

    Connection connection = ConnectionUtil.getDataSource().getConnection();

    Statement statement = connection.createStatement();

    // close connection
    statement.close();
    connection.close();

  }

  @Test
  void testStatementExecuteUpdate() throws SQLException {

    Connection connection = ConnectionUtil.getDataSource().getConnection();

    Statement statement = connection.createStatement();

    String sql = """
            INSERT INTO costumers (id, name, email) VALUES
            ('c0009','udin','udin@gmail.com')
            """;

    int record = statement.executeUpdate(sql);
    System.out.println(record); // dapatkan berapa banyak record yang terkena impact

    // close connection
    statement.close();
    connection.close();

  }

  @Test
  void testStatementExecuteQuery() throws SQLException {

    Connection connection = ConnectionUtil.getDataSource().getConnection();
    Statement statement = connection.createStatement();

    String sql = "SELECT * FROM costumers";

    ResultSet resultSet = statement.executeQuery(sql);

    // close
    resultSet.close();
    statement.close();
    connection.close();

  }
}
