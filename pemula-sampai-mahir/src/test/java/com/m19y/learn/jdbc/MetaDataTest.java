package com.m19y.learn.jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class MetaDataTest {

  @Test
  void testDatabase() throws SQLException {

    Connection connection = ConnectionUtil.getDataSource().getConnection();

    DatabaseMetaData metaData = connection.getMetaData();
    System.out.println(metaData.getDatabaseProductName()); // database name
    System.out.println(metaData.getDatabaseProductVersion()); // database version

    // get table from database (show tables)
    ResultSet dbSkripsi = metaData.getTables("db_skripsi", null, null, null);

    while(dbSkripsi.next()){
      String tableName = dbSkripsi.getString("TABLE_NAME");
      System.out.println("table :" + tableName);
    }

    connection.close();

  }

  @Test
  void testParameterMetaData() throws SQLException {

    Connection connection = ConnectionUtil.getDataSource().getConnection();

    String sql = "INSERT INTO comments (email, comment) VALUES (? , ?)";

    PreparedStatement preparedStatement = connection.prepareStatement(sql);

    ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();

    System.out.println(parameterMetaData.getParameterCount());

    Assertions.assertEquals(2, parameterMetaData.getParameterCount());
    preparedStatement.close();
    connection.close();


  }

  @Test
  void testResultSetMetaData() throws SQLException {

    Connection connection = ConnectionUtil.getDataSource().getConnection();

    String sql = "SELECT * FROM comments";

    Statement statement = connection.createStatement();

    ResultSet resultSet = statement.executeQuery(sql);

    ResultSetMetaData metaData = resultSet.getMetaData();

    System.out.println(metaData.getColumnCount());
    for (int i = 1; i <= metaData.getColumnCount(); i++) {
      System.out.println("Column Name: " + metaData.getColumnName(i));
      System.out.println("Type number mode: " + metaData.getColumnType(i)); // this type from (java.sql.Types)
      System.out.println("Type name mode: " +metaData.getColumnTypeName(i));
      System.out.println("================\n");
    }



    resultSet.close();
    statement.close();
    connection.close();


  }
}
