package com.gestankbratwurst.advanceddropmanager.drops.abstraction;

import com.gestankbratwurst.advanceddropmanager.drops.impl.DropType;
import com.gestankbratwurst.advanceddropmanager.guis.DropGUI;
import com.gestankbratwurst.advanceddropmanager.guis.abstraction.IIcon;
import com.gestankbratwurst.advanceddropmanager.hooks.IHookDependent;
import com.gestankbratwurst.advanceddropmanager.hooks.PluginHook;
import com.gestankbratwurst.advanceddropmanager.io.serialization.ReflectiveJsonProvider;
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
public interface IDrop<T> extends IIcon, IHookDependent, ReflectiveJsonProvider<T> {

  public void drop(DropLocationContext dropContext);

  public void drop(DropInventoryContext dropContext);

  public DropGUI getEditor();

  public DropType getDropType();

  public default void openEditor(Player player) {
    getEditor().open(player);
  }

  @Override
  public default PluginHook getHookDependency() {
    return PluginHook.NONE;
  }

}