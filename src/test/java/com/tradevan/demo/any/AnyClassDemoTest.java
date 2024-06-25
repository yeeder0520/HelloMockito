package com.tradevan.demo.any;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import com.tradevan.demo.user.UserDto;
import com.tradevan.demo.user.UserRecord;
import com.tradevan.demo.user.UserRepository;
import com.tradevan.demo.user.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AnyClassDemoTest {

  @InjectMocks
  private UserService userService;

  @Mock
  private UserRepository userRepository;

  @Test
  public void test_when_save_any() {
    // given
    UserDto userDto = new UserDto("1", "John", "john@tradevan.com.tw", "123456");
    // when
    userService.saveUser(userDto);
    // then
    verify(userRepository).saveUser(any(UserRecord.class));
  }

  @Test
  public void test_when_get_user_by_id_any() {

    // given
    given(userRepository.getUserById(any(UserRecord.class))).willReturn(UserRecord.builder()
                                                                            .id("1")
                                                                            .name("John")
                                                                            .email("john@tradevan.com.tw")
                                                                            .phone("123456")
                                                                            .build());

    // when
    UserDto userDto = new UserDto("1", "John", "", "");
    UserDto actual = userService.getUserById(userDto);

    // then
    assertThat(actual)
        .hasFieldOrPropertyWithValue("id", "1")
        .hasFieldOrPropertyWithValue("name", "John")
        .hasFieldOrPropertyWithValue("email", "john@tradevan.com.tw")
        .hasFieldOrPropertyWithValue("phone", "123456");
  }

}
