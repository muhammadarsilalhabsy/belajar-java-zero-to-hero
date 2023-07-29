package com.m19y.learn.unittest;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.opentest4j.TestAbortedException;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AbortedAndAssumptionTest {

  @Test
  void testAborted() {
    String profile = System.getenv("PROFILE");

    if(!"COK".equals(profile)){
      throw new TestAbortedException("Test ini dibatalkan, because PROFILE != COK");
    }

    // else
    System.out.println("the test is running");

  }

  @Test
  void testAssumption() {
//    assumeTrue(!"COK".equals(System.getenv("PROFILE"))); // running well, because PROFILE != COK
    assumeTrue(!"DEV".equals(System.getenv("PROFILE"))); // will disable, because PROFILE == DEV

    System.out.println("The test is running");
  }
}
