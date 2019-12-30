package com.gestankbratwurst.advanceddropmanager.drops.impl;

import com.gestankbratwurst.advanceddropmanager.drops.abstraction.DropInventoryContext;
import com.gestankbratwurst.advanceddropmanager.drops.abstraction.DropLocationContext;
import com.gestankbratwurst.advanceddropmanager.drops.abstraction.IDrop;
import com.gestankbratwurst.advanceddropmanager.guis.DropGUI;
import com.google.gson.JsonObject;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

/*******************************************************
 * Copyright (C) Gestankbratwurst suotokka@gmail.com
 *
 * This file is part of AdvancedDropManager and was created at the 30.12.2019
 *
 * AdvancedDropManager can not be copied and/or distributed without the express
 * permission of the owner.
 *
 */
public class DropContainer implements IDrop<DropContainer> {

  public DropContainer(JsonObject json) {
    this.identifier = json.get("ID").getAsString();
  }

  public DropContainer(String identifier) {
    this.identifier = identifier;
  }

  @Getter
  private final String identifier;

  @Override
  public void drop(DropLocationContext dropContext) {

  }

  @Override
  public void drop(DropInventoryContext dropContext) {

  }

  @Override
  public DropGUI getEditor() {
    return null;
  }

  @Override
  public DropType getDropType() {
    return null;
  }

  @Override
  public ItemStack getIcon() {
    return null;
  }

  @Override
  public Class<DropContainer> getImplementingClass() {
    return this.getImplementingClass();
  }

  @Override
  public JsonObject getJsonData() {
    JsonObject json = new JsonObject();
    json.addProperty("ID", this.identifier);
    return json;
  }
}
