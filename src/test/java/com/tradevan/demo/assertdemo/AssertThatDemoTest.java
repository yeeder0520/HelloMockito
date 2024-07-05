package com.tradevan.demo.assertdemo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.tuple;

import com.tradevan.demo.user.UserRecord;
import java.util.List;
import org.junit.jupiter.api.Test;

public class AssertThatDemoTest {

  @Test
  void test_assert_that() {

    List<UserRecord> userRecordList = List.of(
        new UserRecord("1", "John", "1@tradevan.com.tw", "123456"),
        new UserRecord("2", "John2", "2@tradevan.com.tw", "123456")
    );

    assertThat(userRecordList)
        .hasSizeGreaterThanOrEqualTo(2)
        .extracting("id", "name", "email", "phone")
        .containsExactly(
            tuple("1", "John", "1@tradevan.com.tw", "123456"),
            tuple("2", "John2", "2@tradevan.com.tw", "123456")
        );
  }
}
