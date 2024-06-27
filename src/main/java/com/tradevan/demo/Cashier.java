package com.tradevan.demo;

import com.tradevan.demo.exception.BatteryNotEnoughException;
import com.tradevan.demo.exception.ThisIsException;

public class Cashier {

  private final Calculator calculator;
  private final CashierLife cashierLife;

  public Cashier(Calculator calculator, CashierLife cashierLife) {
    this.calculator = calculator;
    this.cashierLife = cashierLife;
  }

  public Integer useCalculate(String operation, int input1, int input2) {
    return switch (operation) {
      case "add" -> calculator.add(input1, input2);
      case "minus" -> calculator.minus(input1, input2);
      case "multiply" -> calculator.multiply(input1, input2);
      case "divide" -> Calculator.divide(input1, input2);
      case "throw" -> throw new ThisIsException("ERROR_01", 500);
      default -> throw new IllegalArgumentException("請不要亂按 : " + operation);
    };
  }

  public boolean testCalculate() {
    try {
      return calculator.getCalculatorBatteryValue() > 0;
    } catch (BatteryNotEnoughException e) {
      System.out.println("OS:電量不足，請充電");
    }
    return false;
  }

  public void sayTrashTalkToCashier() {
    cashierLife.beAttacked(1);
    System.out.println("OS:不要理，不要生氣，他是瘋子");
  }

}
