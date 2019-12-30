package com.gestankbratwurst.advanceddropmanager.commands;

import co.aikar.commands.BukkitCommandManager;
import com.gestankbratwurst.advanceddropmanager.AdvancedDropManager;
import com.gestankbratwurst.advanceddropmanager.drops.DropManager;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;

/*******************************************************
 * Copyright (C) Gestankbratwurst suotokka@gmail.com
 *
 * This file is part of AdvancedDropManager and was created at the 29.12.2019
 *
 * AdvancedDropManager can not be copied and/or distributed without the express
 * permission of the owner.
 *
 */
public class CommandManager {

  public CommandManager(AdvancedDropManager advancedDropManager) {
    this.dropManager = advancedDropManager.getDropManager();
    this.bukkitCommandManager = new BukkitCommandManager(advancedDropManager);
  }

  private final BukkitCommandManager bukkitCommandManager;
  private final DropManager dropManager;

  public void registerCompletion() {
    bukkitCommandManager.getCommandCompletions()
        .registerStaticCompletion("Material", Arrays.stream(Material.values())
            .filter(mat -> mat.isBlock())
            .map(Enum::toString)
            .collect(Collectors.toList()));
    bukkitCommandManager.getCommandCompletions()
        .registerStaticCompletion("Leaves", Arrays.stream(Material.values())
            .filter(mat -> mat.isBlock())
            .filter(mat -> mat.toString().contains("LEAVES"))
            .map(Enum::toString)
            .collect(Collectors.toList()));
    bukkitCommandManager.getCommandCompletions()
        .registerStaticCompletion("EntityType", Arrays.stream(EntityType.values())
            .map(Enum::toString)
            .collect(Collectors.toList()));
    bukkitCommandManager.getCommandCompletions()
        .registerStaticCompletion("FromTo", Arrays.stream(FromTo.values())
            .map(val -> val.name)
            .collect(Collectors.toList()));
    bukkitCommandManager.getCommandContexts().registerContext(FromTo.class, c -> {
      return FromTo.parse(c.getLastArg());
    });
  }

  public void registerCommands() {

  }

  public void registerCompletionAndCommands() {
    this.registerCompletion();
    this.registerCommands();
  }

  private void registerEnum(Enum<?> enumerarion) {
    Object[] entries = enumerarion.getDeclaringClass().getEnumConstants();
  }

}
