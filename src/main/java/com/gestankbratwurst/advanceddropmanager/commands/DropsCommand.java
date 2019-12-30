package com.gestankbratwurst.advanceddropmanager.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandCompletion;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import co.aikar.commands.annotation.Values;
import com.gestankbratwurst.advanceddropmanager.AdvancedDropManager;
import lombok.AllArgsConstructor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

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
@CommandAlias("drops")
public class DropsCommand extends BaseCommand {

  private final AdvancedDropManager advancedDropManager;

  @Default
  public void onDefault(Player sender) {
    PluginDescriptionFile descriptionFile = advancedDropManager.getDescription();
    sender.sendMessage("§e[ ----- §f" + descriptionFile.getName() + "§e ----- ]");
    sender.sendMessage("§eVersion: §f" + descriptionFile.getVersion());
    sender.sendMessage("");
    sender.sendMessage("§eAutocompletion enabled.");
  }

  @Subcommand("edit block")
  @CommandCompletion("@Material")
  public void onEditBlock(Player sender, @Values("@Material") Material material) {

  }

  @Subcommand("edit mob")
  @CommandCompletion("@EntityType")
  public void onEditMob(Player sender, @Values("@EntityType") EntityType entityType) {

  }

  @Subcommand("edit fishing")
  public void onEditFishing(Player sender) {

  }

  @Subcommand("edit leaves")
  @CommandCompletion("@Leaves")
  public void onEditLeaves(Player sender, @Values("@Leaves") Material leafMaterial) {

  }

  // TODO custom completion via identifier
  @Subcommand("edit custom")
  public void onEditCustom(Player sender, String customName) {

  }

  @Subcommand("spawn block")
  @CommandCompletion("@Material")
  public void onSpawnBlock(Player sender, @Values("@Material") Material block) {

  }

  @Subcommand("spawn mob")
  @CommandCompletion("@EntityType")
  public void onSpawnMob(Player sender, @Values("@EntityType") EntityType type) {

  }

  @Subcommand("spawn fishing")
  public void onSpawnFishing(Player sender) {

  }

  @Subcommand("spawn leaves")
  @CommandCompletion("@Leaves")
  public void onSpawnLeaves(Player sender, @Values("@Leaves") Material leafMaterial) {

  }

  @Subcommand("spawn custom")
  public void onSpawnCustom(Player sender, String customName) {

  }

  @Subcommand("copy block")
  @CommandCompletion("@Material @FromTo @Material")
  public void onCopyBlock(Player sender, @Values("@Material") Material mat1, @Values("@FromTo") FromTo fromTo,
      @Values("@Material") Material mat2) {

  }

  @Subcommand("copy mob")
  @CommandCompletion("@EntityType @FromTo @EntityType")
  public void onCopyMob(Player sender, @Values("@EntityType") EntityType ent1, @Values("@FromTo") FromTo fromTo,
      @Values("@EntityType") EntityType ent2) {

  }

  @Subcommand("replace block")
  @CommandCompletion("@Material @FromTo @Material")
  public void onReplaceBlock(Player sender, @Values("@Material") Material mat1, @Values("@FromTo") FromTo fromTo,
      @Values("@Material") Material mat2) {

  }

  @Subcommand("replace mob")
  @CommandCompletion("@EntityType @FromTo @EntityType")
  public void onReplaceyMob(Player sender, @Values("@EntityType") EntityType ent1, @Values("@FromTo") FromTo fromTo,
      @Values("@EntityType") EntityType ent2) {

  }

}