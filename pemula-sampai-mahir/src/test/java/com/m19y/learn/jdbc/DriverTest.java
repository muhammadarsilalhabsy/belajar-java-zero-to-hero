package com.m19y.learn.jdbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DriverTest {

  @Test
  void testRegister() {

    try {
      // buat drivernya
      Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();

      // registrasi drivernya
      DriverManager.registerDriver(mysqlDriver);
    } catch (SQLException e) {
      Assertions.fail(e);
    }
  }
}
