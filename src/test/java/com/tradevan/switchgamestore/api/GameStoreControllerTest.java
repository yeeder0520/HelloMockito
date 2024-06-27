package com.tradevan.switchgamestore.api;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.tradevan.switchgamestore.bean.SwitchGame;
import com.tradevan.switchgamestore.usecase.GetAllSwitchGamesUseCase;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(GameStoreController.class)
class GameStoreControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private GetAllSwitchGamesUseCase getAllSwitchGamesUseCase;

  @Test
  void test_getGames_should_be_success() throws Exception {

    SwitchGame switchGame = new SwitchGame();
    switchGame.setGameName("Super Mario 3D World");

    given(getAllSwitchGamesUseCase.getAllGames()).willReturn((switchGame));

    mockMvc.perform(get("/game/get/all"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.gameName", Is.is("Super Mario 3D World")));

  }

}