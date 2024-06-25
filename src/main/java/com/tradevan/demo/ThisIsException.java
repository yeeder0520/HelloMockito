package com.tradevan.demo;

import lombok.Getter;

@Getter
public class ThisIsException extends RuntimeException {

  private final String errorCode;
  private final int statusCode;

  public ThisIsException(String errorCode, int statusCode) {
    this.errorCode = errorCode;
    this.statusCode = statusCode;
  }
}
