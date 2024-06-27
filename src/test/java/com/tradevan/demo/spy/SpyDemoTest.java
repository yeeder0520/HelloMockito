package com.tradevan.demo.spy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.tradevan.demo.Cashier;
import com.tradevan.demo.CashierAction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SpyDemoTest {

  @InjectMocks
  Cashier cashier;

  @Spy
  CashierAction cashierAction;

  @Test
  void test_say_hello_do_not_need_given() {

    String name = "Mockito";

    String actual = cashier.sayHello(name);

    assertThat(actual).isEqualTo("Hello Mockito");
  }

  @Test
  void test_say_hello_when_use_given_should_be_successful() {

    given(cashierAction.sayHello("Mockito")).willReturn("Hello TDD");

    String name = "Mockito";
    String actual = cashier.sayHello(name);

    assertThat(actual).isEqualTo("Hello TDD");
  }

}