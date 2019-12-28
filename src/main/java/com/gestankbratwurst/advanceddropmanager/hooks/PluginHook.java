package com.gestankbratwurst.advanceddropmanager.hooks;

import lombok.AllArgsConstructor;
import org.bukkit.Bukkit;

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
public enum PluginHook {

  NONE("AdvancedDropManager");

  private final String pluginName;

  // TODO cache result
  public boolean isAvailable() {
    return Bukkit.getPluginManager().getPlugin(pluginName) != null;
  }

}
