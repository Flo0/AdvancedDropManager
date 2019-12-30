package com.gestankbratwurst.advanceddropmanager.commands;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.Nullable;

/*******************************************************
 * Copyright (C) Gestankbratwurst suotokka@gmail.com
 *
 * This file is part of AdvancedDropManager and was created at the 30.12.2019
 *
 * AdvancedDropManager can not be copied and/or distributed without the express
 * permission of the owner.
 *
 */
@AllArgsConstructor
public enum FromTo {

  FROM("from"),
  TO("to");

  protected final String name;

  @Nullable
  public static FromTo parse(String entry) {
    for (FromTo value : FromTo.values()) {
      if (entry.equalsIgnoreCase(value.name)) {
        return value;
      }
    }
    return null;
  }

}
