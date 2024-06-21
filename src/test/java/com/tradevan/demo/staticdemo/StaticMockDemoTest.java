package com.tradevan.demo.staticdemo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.tradevan.demo.Calculator;
import com.tradevan.demo.Cashier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StaticMockDemoTest {

  @InjectMocks
  Cashier cashier;

  @Mock
  Calculator calculator;

  @Test
  void test_static_use_calculate_when_operation_is_divide_input1_is_10_input2_is_2_then_get_5() {

    // given
    int input1 = 10;
    int input2 = 2;
    String operation = "divide";
    Integer expected = 5;
    given(calculator.divide(input1, input2)).willReturn(5);

    // when
    Integer actual = cashier.useCalculate(operation, input1, input2);

    // then
    assertThat(actual).isEqualTo(expected);
  }



}