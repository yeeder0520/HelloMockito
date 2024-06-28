package com.tradevan.switchgamestore.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SwitchGame {

  private String gameName;
  private int price;
  private int stock;

}
