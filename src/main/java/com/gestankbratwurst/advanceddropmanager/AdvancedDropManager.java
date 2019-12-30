package com.gestankbratwurst.advanceddropmanager;

import com.gestankbratwurst.advanceddropmanager.commands.CommandManager;
import com.gestankbratwurst.advanceddropmanager.drops.DropManager;
import com.gestankbratwurst.advanceddropmanager.io.IOManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class AdvancedDropManager extends JavaPlugin {

  @Getter
  private DropManager dropManager;
  @Getter
  private IOManager ioManager;
  @Getter
  private CommandManager commandManager;

  @Override
  public void onEnable() {
    dropManager = new DropManager();
    ioManager = new IOManager(this);
    ioManager.enable();
    commandManager = new CommandManager(this);
    commandManager.registerCompletionAndCommands();
  }

  @Override
  public void onDisable() {
    ioManager.disable();
  }

}