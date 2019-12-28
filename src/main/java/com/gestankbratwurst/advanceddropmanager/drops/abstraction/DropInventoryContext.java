package com.gestankbratwurst.advanceddropmanager.drops.abstraction;

import lombok.Data;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/*******************************************************
 * Copyright (C) Gestankbratwurst suotokka@gmail.com
 *
 * This file is part of AdvancedDropManager and was created at the 28.12.2019
 *
 * AdvancedDropManager can not be copied and/or distributed without the express
 * permission of the owner.
 *
 */
public class DropInventoryContext extends DropLocationContext {

  public DropInventoryContext(Location location, Player initiator, Inventory inventory) {
    super(location, initiator);
    this.inventory = inventory;
  }

  @Getter
  private final Inventory inventory;

}
