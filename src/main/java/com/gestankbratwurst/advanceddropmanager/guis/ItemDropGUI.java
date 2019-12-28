package com.gestankbratwurst.advanceddropmanager.guis;

import com.gestankbratwurst.advanceddropmanager.drops.abstraction.IDrop;
import com.gestankbratwurst.advanceddropmanager.drops.impl.ItemDrop;
import net.crytec.inventoryapi.api.InventoryContent;
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
public class ItemDropGUI extends DropGUI<ItemDrop> {

  public ItemDropGUI(ItemDrop drop, int size) {
    super(drop, size);
  }

  @Override
  public void init(Player player, InventoryContent content) {

  }

}
