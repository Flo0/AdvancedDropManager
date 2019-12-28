package com.gestankbratwurst.advanceddropmanager.drops.impl;

import com.gestankbratwurst.advanceddropmanager.guis.abstraction.IIcon;
import java.util.function.Supplier;
import lombok.AllArgsConstructor;
import net.crytec.libs.commons.utils.item.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/*******************************************************
 * Copyright (C) Gestankbratwurst suotokka@gmail.com
 *
 * This file is part of AdvancedDropManager and was created at the 28.12.2019
 *
 * AdvancedDropManager can not be copied and/or distributed without the express
 * permission of the owner.
 *
 */
@AllArgsConstructor
public enum DropType implements IIcon {

  ITEM_DROP(() -> "Item drop", new ItemBuilder(Material.STONE).build());

  private final Supplier<String> displayNameSupplier;
  private final ItemStack iconItem;

  public String getDisplayName() {
    return displayNameSupplier.get();
  }

  @Override
  public ItemStack getIcon() {
    return iconItem;
  }

}
