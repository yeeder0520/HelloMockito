package com.tradevan.demo.voiddemo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.tradevan.demo.Calculator;
import com.tradevan.demo.Cashier;
import com.tradevan.demo.MyLife;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class VoidMethodDemoTest {

  @InjectMocks
  Cashier cashier;

//  @Mock
//  Calculator calculator;

  @Mock
  MyLife myLife;

  @Test
  void test_say_trash_talk_to_cashier() {

    // given

    // when
    cashier.sayTrashTalkToCashier();

    // then
    verify(myLife,times(1)).beAttacked(1);
  }


}