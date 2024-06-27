package com.tradevan.switchgamestore.api;

import com.tradevan.switchgamestore.bean.SwitchGame;
import com.tradevan.switchgamestore.usecase.GetAllSwitchGamesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GameStoreController {

  private final GetAllSwitchGamesUseCase getAllSwitchGamesUseCase;

  @GetMapping("/game/get/all")
  public ResponseEntity<SwitchGame> getGames() {
    SwitchGame allGames = getAllSwitchGamesUseCase.getAllGames();
    return ResponseEntity.ok(allGames);
  }

}
