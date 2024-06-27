package com.tradevan.demo;

public class CashierAction {

  private static final String init;

  static {
    init = "init";
    System.out.println("execute static block");
  }

  public String sayHello(String name) {
    System.out.println("init = " + init);
    System.out.println("Hello " + name);
    return "Hello " + name;
  }

}
