package com.tradevan.switchgamestore.usecase;

import com.tradevan.switchgamestore.bean.SwitchGameRecord;
import com.tradevan.switchgamestore.repository.SwitchGameRepository;

public class SellSwitchGameCartridgeUseCase {

  private final SwitchGameRepository repository;

  public SellSwitchGameCartridgeUseCase(SwitchGameRepository repository) {
    this.repository = repository;
  }

  public String sell(String gameName, int sellCount) {

    SwitchGameRecord stockByGameName = repository.findByName(gameName);

    if (sellCount > stockByGameName.getStock()) {
      return "庫存不足";
    }

    return "售出成功";

  }
}
