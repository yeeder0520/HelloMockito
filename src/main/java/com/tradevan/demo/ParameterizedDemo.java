package com.tradevan.demo;

import java.util.ArrayList;
import java.util.List;

public class ParameterizedDemo {

  public int returnMySelf(int a) {
    return a;
  }

  public String returnMySelf(String a) {
    return a;
  }

  public boolean checkMonth(String month) {
    List<String> monthList = new ArrayList<>();
    monthList.add("January");
    monthList.add("February");
    monthList.add("March");
    monthList.add("April");
    monthList.add("May");
    monthList.add("June");
    monthList.add("July");
    monthList.add("August");
    monthList.add("September");
    monthList.add("October");
    monthList.add("November");
    monthList.add("December");
    return monthList.contains(month);
  }

  public boolean is30DaysMonth(String month) {
    List<String> monthList = new ArrayList<>();
    monthList.add("April");
    monthList.add("June");
    monthList.add("September");
    monthList.add("November");
    return monthList.contains(month);
  }
}
