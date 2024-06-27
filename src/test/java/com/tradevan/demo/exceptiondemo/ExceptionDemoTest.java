package com.tradevan.demo.exceptiondemo;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.tradevan.demo.Cashier;
import com.tradevan.demo.exception.ThisIsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ExceptionDemoTest {

  @InjectMocks
  Cashier cashier;

  @Test
  void test_use_calculate_when_operation_is_play_should_throw_IllegalArgumentException() {

    // given
    int input1 = 2;
    int input2 = 3;
    String operation = "亂按";

    // version 1
    assertThatThrownBy(() -> cashier.useCalculate(operation, input1, input2))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("請不要亂按 : " + operation);

    // version 2
//    assertThatExceptionOfType(IllegalArgumentException.class)
//        .isThrownBy(() -> cashier.useCalculate(operation, input1, input2))
//        .withMessage("請不要亂按 : " + operation);
  }

  @Test
  void test_use_calculate_when_operation_is_throw_should_throw_ThisIsException() {

    // given
    int input1 = 2;
    int input2 = 3;
    String operation = "throw";

    assertThatThrownBy(() -> cashier.useCalculate(operation, input1, input2))
        .isInstanceOf(ThisIsException.class)
        .hasFieldOrPropertyWithValue("errorCode", "ERROR_01")
        .hasFieldOrPropertyWithValue("statusCode", 500);
  }

}
