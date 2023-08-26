package com.m19y.learn.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchTest {

  @Test
  void testBatchUsingStatement() throws SQLException {
    Connection connection = ConnectionUtil.getDataSource().getConnection();
    Statement statement = connection.createStatement();

    String sql = "INSERT INTO comments (email, comment) VALUES ('otong@gmail.com','nande nande?')";

    for (int i = 0; i < 500; i++) {
      // di tumpuk kedalam batch
      statement.addBatch(sql);
    }

    // di ekesusi dalam sekali
    statement.executeBatch();

    statement.close();
    connection.close();

  }

  @Test
  void testBatchUsingPreparedStatement() throws SQLException {
    Connection connection = ConnectionUtil.getDataSource().getConnection();

    String sql = "INSERT INTO comments (email, comment) VALUES ( ? , ? )";
    PreparedStatement statement = connection.prepareStatement(sql);

    for (int i = 0; i < 1_000; i++) {

      // clear parameter
      statement.clearParameters();

      // set parameter
      statement.setString(1, "Junaedi@gmail.com");
      statement.setString(2, "arigato");

      // di tumpuk kedalam batch
      statement.addBatch();

      if (i % 100 == 0) {
        // di ekesusi dalam sekali
        statement.executeBatch();

      }
    }


    statement.close();
    connection.close();

  }


}
