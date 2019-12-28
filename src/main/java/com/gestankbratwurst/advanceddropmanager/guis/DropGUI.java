package com.gestankbratwurst.advanceddropmanager.guis;

import com.gestankbratwurst.advanceddropmanager.drops.abstraction.IDrop;
import net.crytec.inventoryapi.SmartInventory;
import net.crytec.inventoryapi.api.InventoryProvider;
import org.bukkit.entity.Player;

/*******************************************************
 * Copyright (C) Gestankbratwurst suotokka@gmail.com
 *
 * This file is part of AdvancedDropManager and was created at the 28.12.2019
 *
 * AdvancedDropManager can not be copied and/or distributed without the express
 * permission of the owner.
 *
 */
public abstract class DropGUI<T extends IDrop> implements InventoryProvider {

  public DropGUI(T drop, int size) {
    this.drop = drop;
    this.size = size;
  }

  protected final IDrop drop;
  private final int size;

  public void open(Player player) {
    SmartInventory.builder().provider(this).size(size).title(drop.getDropType().getDisplayName()).build().open(player);
  }

}