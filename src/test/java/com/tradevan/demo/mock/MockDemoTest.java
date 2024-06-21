package com.tradevan.demo.mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.tradevan.demo.Calculator;
import com.tradevan.demo.Cashier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MockDemoTest {

  @InjectMocks
  Cashier cashier;

  @Mock
  Calculator calculator;

  @Test
  void test_use_calculate_when_operation_is_add_input1_is_2_input2_is_3_then_get_5() {

    // given
    int input1 = 2;
    int input2 = 3;
    String operation = "add";
    Integer expected = 5;
    given(calculator.add(input1, input2)).willReturn(5);

    // when
    Integer actual = cashier.useCalculate(operation, input1, input2);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource({
      "3,2,1",
      "10,3,7",
      "100,43,57"
  })
  void test_use_calculate_when_operation_is_minus_input1_is_2_input2_is_3_then_get_minus_1(
      int input1,
      int input2,
      int expected) {

    // given
    String operation = "minus";
    given(calculator.minus(input1, input2)).willCallRealMethod();

    // when
    Integer actual = cashier.useCalculate(operation, input1, input2);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void test_use_calculate_when_operation_is_multiply_input1_is_2_input2_is_3_then_get_6() {

    // given
    int input1 = 2;
    int input2 = 3;
    String operation = "multiply";
    Integer expected = 6;
    given(calculator.multiply(input1, input2)).willReturn(6);

    // when
    Integer actual = cashier.useCalculate(operation, input1, input2);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void test_use_calculate_when_operation_is_divide_input1_is_6_input2_is_3_then_get_2() {

    // given
    int input1 = 6;
    int input2 = 3;
    String operation = "divide";
    Integer expected = 2;
    given(calculator.divide(input1, input2)).willReturn(2);

    // when
    Integer actual = cashier.useCalculate(operation, input1, input2);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void test_use_calculate_when_operation_is_unknown_then_get_minus_1() {

    // given
    int input1 = 2;
    int input2 = 3;
    String operation = "unknown";
    Integer expected = -1;

    // when
    Integer actual = cashier.useCalculate(operation, input1, input2);

    // then
    assertThat(actual).isEqualTo(expected);
  }

}