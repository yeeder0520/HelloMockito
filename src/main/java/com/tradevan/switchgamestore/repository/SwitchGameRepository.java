package com.tradevan.switchgamestore.repository;

import com.tradevan.switchgamestore.bean.SwitchGameRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SwitchGameRepository extends JpaRepository<SwitchGameRecord, String> {

  SwitchGameRecord findByName(String gameName);

}
