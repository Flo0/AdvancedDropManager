package com.gestankbratwurst.advanceddropmanager.drops.abstraction;

import lombok.Data;
import org.bukkit.Location;
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
@Data
public class DropLocationContext {

  private final Location location;
  private final Player initiator;

}