package com.tradevan.demo;

import com.tradevan.demo.exception.BatteryNotEnoughException;

public class Calculator {

  public int add(int a, int b) {
    return a + b;
  }

  public int minus(int a, int b) {
    return a - b;
  }

  public int multiply(int a, int b) {
    return a * b;
  }

  public static int divide(int a, int b) {
    return a / b;
  }

  public int getCalculatorBatteryValue() throws BatteryNotEnoughException {
    int battery = 100; //電量
    if (battery == 0) {
      throw new BatteryNotEnoughException("電量不足");
    }
    return battery;
  }
}
