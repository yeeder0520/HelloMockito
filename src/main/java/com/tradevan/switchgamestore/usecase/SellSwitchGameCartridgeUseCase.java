package com.tradevan.switchgamestore.usecase;

import com.tradevan.switchgamestore.repository.SwitchGameRepository;

public class SellSwitchGameCartridgeUseCase {

  private final SwitchGameRepository repository;

  public SellSwitchGameCartridgeUseCase(SwitchGameRepository repository) {
    this.repository = repository;
  }

  public String sell(String gameName, int sellCount) {

    Integer stock = repository.queryStock(gameName);

    if (sellCount > stock) {
      return "庫存不足";
    }

    return "售出成功";

  }
}
