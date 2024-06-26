package com.tradevan.demo.argumentcaptor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import com.tradevan.demo.user.UserDto;
import com.tradevan.demo.user.UserRecord;
import com.tradevan.demo.user.UserRepository;
import com.tradevan.demo.user.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ArgumentCaptorDemoTest {

  @InjectMocks
  private UserService userService;

  @Mock
  private UserRepository userRepository;

  @Captor
  private ArgumentCaptor<UserRecord> userRecordCaptor;

  @Test
  void test_argument_captor() {

    //given
    UserDto userDto = new UserDto("1", "John", "john@tradevan.com.tw", "123456");

    //when
    userService.saveUser(userDto);

    //then
    verify(userRepository).saveUser(userRecordCaptor.capture());
    UserRecord actual = userRecordCaptor.getValue();
//    assertThat(actual.getId()).isEqualTo("1");
//    assertThat(actual.getName()).isEqualTo("John");
//    assertThat(actual.getEmail()).isEqualTo("john@tradevan.com.tw");
//    assertThat(actual.getPhone()).isEqualTo("123456");

//    assertThat(actual).usingRecursiveComparison()
//        .isEqualTo(userDto);

    assertThat(actual).usingRecursiveComparison()
        .ignoringFields("id")
        .isEqualTo(userDto);

  }

}
