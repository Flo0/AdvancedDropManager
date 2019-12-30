package com.gestankbratwurst.advanceddropmanager.drops.impl;

import com.gestankbratwurst.advanceddropmanager.drops.abstraction.DropInventoryContext;
import com.gestankbratwurst.advanceddropmanager.drops.abstraction.DropLocationContext;
import com.gestankbratwurst.advanceddropmanager.drops.abstraction.IDrop;
import com.gestankbratwurst.advanceddropmanager.guis.DropGUI;
import com.gestankbratwurst.advanceddropmanager.guis.ItemDropGUI;
import com.google.gson.JsonObject;
import net.crytec.libs.commons.utils.UtilInv;
import net.crytec.libs.commons.utils.UtilPlayer;
import org.bukkit.Location;
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
public class ItemDrop implements IDrop<ItemDrop> {

  public ItemDrop(JsonObject jsonObject) {
    // TODO replace with single
    this.itemStack = UtilInv.itemStackArrayFromBase64(jsonObject.get("Item").getAsString())[0];
  }

  public ItemDrop() {
    this.itemStack = new ItemStack(Material.STONE);
  }

  private final ItemStack itemStack;

  @Override
  public void drop(DropLocationContext dropContext) {
    Location dropLoc = dropContext.getLocation();
    dropLoc.getWorld().dropItem(dropLoc, itemStack.clone());
  }

  @Override
  public void drop(DropInventoryContext dropContext) {
    dropContext.getInventory().addItem(itemStack.clone()).values().forEach(left -> drop((DropLocationContext) dropContext));
  }

  @Override
  public DropGUI getEditor() {
    return new ItemDropGUI(this, 3);
  }

  @Override
  public DropType getDropType() {
    return DropType.ITEM_DROP;
  }

  @Override
  public ItemStack getIcon() {
    return this.itemStack;
  }

  @Override
  public Class<ItemDrop> getImplementingClass() {
    return this.getImplementingClass();
  }

  @Override
  public JsonObject getJsonData() {
    JsonObject json = new JsonObject();
    // TODO replace with single
    String base64Item = UtilInv.itemStackArrayToBase64(new ItemStack[]{this.itemStack});
    json.addProperty("Item", base64Item);
    return json;
  }
}
