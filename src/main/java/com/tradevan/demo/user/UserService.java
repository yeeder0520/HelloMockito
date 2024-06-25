package com.tradevan.demo.user;

public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void saveUser(UserDto userDto) {
    UserRecord userRecord = new UserRecord();
    userRecord.setId(userDto.id());
    userRecord.setName(userDto.name());
    userRecord.setEmail(userDto.email());
    userRecord.setPhone(userDto.phone());
    userRepository.saveUser(userRecord);
  }

  public UserDto getUserById(UserDto userDto) {

    UserRecord userRecord = new UserRecord();
    userRecord.setId(userDto.id());

    UserRecord userRecord2 = userRepository.getUserById(userRecord);

    return new UserDto(userRecord2.getId(), userRecord2.getName(), userRecord2.getEmail(), userRecord2.getPhone());
  }

}
