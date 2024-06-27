package com.tradevan.switchgamestore.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.tradevan.switchgamestore.bean.SwitchGameRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
class SwitchGameRepositoryTest {

  @Autowired
  private SwitchGameRepository switchGameRepository;

  @Test
  @Sql(value = {"classpath:sql/SwitchGameRepositoryTest.sql"})
  void test_findStockByGameName_should_return_() {
    SwitchGameRecord actual = switchGameRepository.findByName("Super Mario 3D World");
    assertThat(actual).hasFieldOrPropertyWithValue("stock", 10);
  }

}