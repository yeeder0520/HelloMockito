package com.tradevan.demo.any;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import com.tradevan.demo.Calculator;
import com.tradevan.demo.Cashier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AnyDemoTest {

  @InjectMocks
  private Cashier cashier;

  @Mock
  private Calculator calculator;

  @Test
  public void test_multiply_when_any() {
    // given
    int input1 = 2;
    int input2 = 3;
    String operation = "multiply";
    Integer expected = 6;
    given(calculator.multiply(any(), any())).willReturn(6);

    // when
    Integer actual = cashier.useCalculate(operation, input1, input2);

    // then
    assertThat(actual).isEqualTo(expected);
  }

}
