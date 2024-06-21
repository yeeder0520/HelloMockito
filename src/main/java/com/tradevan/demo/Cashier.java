package com.tradevan.demo;

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
      default -> -1;
    };
  }

  public void sayTrashTalkToCashier() {
    cashierLife.beAttacked(1);
    System.out.println("OS:不要理，不要生氣，他是瘋子");
  }

}
