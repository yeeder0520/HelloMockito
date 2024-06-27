package com.tradevan.switchgamestore.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

  @Bean
  public GetAllSwitchGamesUseCase getAllSwitchGamesUseCase() {
    return new GetAllSwitchGamesUseCase();
  }

}