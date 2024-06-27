package com.tradevan.demo.mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.tradevan.demo.Calculator;
import com.tradevan.demo.Cashier;
import com.tradevan.demo.exception.BatteryNotEnoughException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

  @Test
  void test_use_calculate_when_operation_is_add_input1_is_2_input2_is_3_then_get_5_willCallRealMethod() {

    // given
    int input1 = 2;
    int input2 = 3;
    String operation = "add";
    Integer expected = 5;
    given(calculator.add(input1, input2)).willCallRealMethod();

    // when
    Integer actual = cashier.useCalculate(operation, input1, input2);

    // then
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  void test_call_testCalculate_when_calculator_getCalculatorBatteryValue_return_100_then_return_true()
      throws BatteryNotEnoughException {

    // given
    given(calculator.getCalculatorBatteryValue()).willReturn(100);

    // when
    boolean actual = cashier.testCalculate();

    // then
    assertThat(actual).isTrue();
  }

  @Test
  void test_call_testCalculate_when_calculator_getCalculatorBatteryValue_throw_BatteryNotEnoughException_then_return_false()
      throws BatteryNotEnoughException {

    // given
    given(calculator.getCalculatorBatteryValue()).willThrow(new BatteryNotEnoughException("電量不足"));

    // when
    boolean actual = cashier.testCalculate();

    // then
    assertThat(actual).isFalse();
  }

}