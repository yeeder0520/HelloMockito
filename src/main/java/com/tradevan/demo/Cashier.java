package com.tradevan.demo;

import com.tradevan.demo.exception.BatteryNotEnoughException;
import com.tradevan.demo.exception.PhoneNotConnectedException;
import com.tradevan.demo.exception.ThisIsException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Cashier {

  private final Calculator calculator;
  private final CashierLife cashierLife;
  private final CashierAction cashierAction;

  public Cashier(Calculator calculator, CashierLife cashierLife, CashierAction cashierAction) {
    this.calculator = calculator;
    this.cashierLife = cashierLife;
    this.cashierAction = cashierAction;
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

  public boolean checkCalculateBattery() {
    try {
      return calculator.getCalculatorBatteryValue() > 0;
    } catch (BatteryNotEnoughException e) {
      System.out.println("OS:電量不足，請充電");
    }
    return false;
  }

  public void sayTrashTalkToCashier() {
    cashierLife.beAttacked(1);
  }

  public String sayHello(String name) {
    return cashierAction.sayHello(name);
  }

  public String callMyBoyFriendSayILoveYou() throws URISyntaxException, IOException, InterruptedException {

    String urlString = "http://localhost:8088/call-john/i-love-u";

    // 建立一個 HttpClient
    HttpClient client = HttpClient.newHttpClient();

    // 建立一個 HttpRequest
    HttpRequest request = HttpRequest.newBuilder()
        .uri(new URI(urlString))
        .GET()
        .build();

    // 發送請求並接收響應
    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

    // 獲取響應狀態碼
    int responseCode = response.statusCode();
    String responseBody = response.body();

    System.out.println("Response Code: " + responseCode);
    System.out.println("Response Body: " + responseBody);

    if (responseCode != 200) {
      throw new PhoneNotConnectedException("My boyfriend doesn't care about me anymore", 500);
    }

    return responseBody.contains("I love you") ? "happy" : "sad";
  }

}
