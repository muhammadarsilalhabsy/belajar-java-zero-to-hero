package com.m19y.learn.jdbc;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class DateTimeTimestampTest {

  @Test
  void testInsertTime() throws SQLException {
  Connection connection = ConnectionUtil.getDataSource().getConnection();

  String sql = "INSERT INTO sample_time (example_date, example_time, example_timestamp) VALUES ( ? , ? , ?)";
  PreparedStatement statement = connection.prepareStatement(sql);

  statement.setDate(1, new Date(System.currentTimeMillis()));
  statement.setTime(2, new Time(System.currentTimeMillis()));
  statement.setTimestamp(3, new Timestamp(System.currentTimeMillis()));

  statement.executeUpdate();

  statement.close();
  connection.close();
  }

  @Test
  void testQueryTime() throws SQLException {
    Connection connection = ConnectionUtil.getDataSource().getConnection();

    String sql = "SELECT * FROM sample_time";
    PreparedStatement statement = connection.prepareStatement(sql);

    ResultSet resultSet = statement.executeQuery();

    while (resultSet.next()){
      Date date = resultSet.getDate("example_date");
      Time time = resultSet.getTime("example_time");
      Timestamp timestamp = resultSet.getTimestamp("example_timestamp");

      System.out.println(resultSet.getInt("id"));
      System.out.println("date => " + date);
      System.out.println("time => " + time);
      System.out.println("timestamp => " + timestamp);
      System.out.println("---------------------------");
    }
    statement.close();
    connection.close();
  }
}
