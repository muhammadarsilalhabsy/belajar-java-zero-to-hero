package com.m19y.learn.jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {


  @BeforeAll
  static void beforeAll() {
    try {
      Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
      DriverManager.registerDriver(mysqlDriver);
    } catch (SQLException e) {
      Assertions.fail(e);
    }
  }

  @Test
  void testConnection() {
    String url = "jdbc:mysql://localhost:3307/belajar_database?serverTimezone=Asia/Makassar";
    String user = "root";
    String password = "root";

    try {
      Connection connection = DriverManager.getConnection(url, user, password);

      System.out.println("Success Connnect Database");
    } catch (SQLException e) {
      Assertions.fail(e);
    }
  }

  @Test
  void testCloseConnection() {
    String url = "jdbc:mysql://localhost:3307/belajar_database?serverTimezone=Asia/Makassar";
    String user = "root";
    String password = "root";

    try {
      Connection connection = DriverManager.getConnection(url, user, password);

      System.out.println("Success Connect Database");
      connection.close();
      System.out.println("Success Close Connection Database");
    } catch (SQLException e) {
      Assertions.fail(e);
    }
  }

  @Test
  void testCloseConnectionUsingTryWithResource() {
    String url = "jdbc:mysql://localhost:3307/belajar_database?serverTimezone=Asia/Makassar";
    String user = "root";
    String password = "root";

    // auto di close sama AutoClosable
    try (Connection connection = DriverManager.getConnection(url, user, password)){
      System.out.println("Success Connect Database");

    } catch (SQLException e) {
      Assertions.fail(e);
    }
  }














}
