package com.tradevan.switchgamestore.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "SWITCH_GAME")
public class SwitchGameRecord {

  @Id
  private String gameId;
  private String name;
  private int price;
  private int stock;
}
