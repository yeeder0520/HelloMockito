package com.tradevan.demo.parameterized;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.tradevan.demo.Month;
import com.tradevan.demo.ParameterizedDemo;
import java.util.List;
import java.util.stream.Stream;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ParameterizedDemoTest {

  @InjectMocks
  ParameterizedDemo parameterizedDemo;

  @ParameterizedTest
  @ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE})
  void test_ParameterizedTest_with_int(int number) {
    assertThat(parameterizedDemo.returnMySelf(number)).isEqualTo(number);
  }

  @ParameterizedTest
  @ValueSource(strings = {"a", "b", "c", "d", "e", "f"})
  void test_ParameterizedTest_with_string(String str) {
    assertThat(parameterizedDemo.returnMySelf(str)).isEqualTo(str);
  }

  @ParameterizedTest
  @NullSource
  void test_ParameterizedTest_with_null(String str) {
    assertThat(parameterizedDemo.returnMySelf(str)).isNull();
  }

  @ParameterizedTest
  @EmptySource
  void test_ParameterizedTest_with_empty(String str) {
    assertThat(parameterizedDemo.returnMySelf(str)).isEmpty();
  }

  @ParameterizedTest
  @NullAndEmptySource
  void test_ParameterizedTest_with_null_and_empty(String str) {
    assertThat(parameterizedDemo.returnMySelf(str)).isNullOrEmpty();
  }

  @ParameterizedTest
  @EnumSource(Month.class)
  void test_ParameterizedTest_with_enum(Month month) {
    String monthName = month.getMonthName();
    assertThat(parameterizedDemo.checkMonth(monthName)).isTrue();
  }

  @ParameterizedTest
  @EnumSource(value = Month.class, names = {"APRIL", "JUNE", "SEPTEMBER", "NOVEMBER"})
  void test_ParameterizedTest_with_enum_and_names_are_30_days_month(Month month) {
    String monthName = month.getMonthName();
    assertThat(parameterizedDemo.is30DaysMonth(monthName)).isTrue();
  }

  @ParameterizedTest
  @CsvSource({
      "3,2,5",
      "10,3,13",
      "100,43,143"
  })
  void test_csvSource(
      int input1,
      int input2,
      int expected) {
    assertThat(input1 + input2).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource(value = {
      "3,2,5",
      "10,3,13",
      "100,43,143"
  }, delimiter = '^')
  void test_csvSource_with_delimiter(
      int input1,
      int input2,
      int expected) {
    assertThat(input1 + input2).isEqualTo(expected);
  }

  @ParameterizedTest
  @MethodSource("provideStringsForIsBlank")
  void test_given_null_or_blank_string_should_return_true(String input, boolean expected) {
    assertEquals(expected, Strings.isBlank(input));
  }

  private static Stream<Arguments> provideStringsForIsBlank() {
    return Stream.of(
        Arguments.of(null, true),
        Arguments.of("", true),
        Arguments.of("  ", true),
        Arguments.of("not blank", false)
    );
  }

  @ParameterizedTest
  @MethodSource("provideListTestData")
  void test_given_list_of_integers_should_return_sum_of_all_elements(List<String> inputList, int expectedSize, boolean expected) {
    assertThat(inputList).hasSize(expectedSize);
    assertThat(expected).isTrue();
  }

  private static Stream<Arguments> provideListTestData() {
    return Stream.of(
        Arguments.of(List.of("A", "B"), 2, true),
        Arguments.of(List.of("A", "B", "C", "D"), 4, true)
    );
  }


//  @ParameterizedTest
//  @MethodSource("provideListTestData")
//  void test_given_list_of_integers_should_return_sum_of_all_elements(List<String> inputList) {
//    assertThat(inputList).hasSize(expectedSize);
//    assertThat(expected).isTrue();
//  }
//
//  private static Stream<List> provideListTestData() {
//    return Stream.of(
//        List.of("A", "B"),
//        List.of("A", "B")
//    );
//  }
}
