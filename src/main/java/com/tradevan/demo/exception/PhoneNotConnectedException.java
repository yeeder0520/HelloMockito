package com.tradevan.demo.exception;

import lombok.Getter;

@Getter
public class PhoneNotConnectedException extends RuntimeException {

  private final String errorCode;
  private final int statusCode;

  public PhoneNotConnectedException(String errorCode, int statusCode) {
    this.errorCode = errorCode;
    this.statusCode = statusCode;
  }
}
