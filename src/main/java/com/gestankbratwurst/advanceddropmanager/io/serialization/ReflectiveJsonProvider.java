package com.gestankbratwurst.advanceddropmanager.io.serialization;

import com.google.gson.JsonObject;

/*******************************************************
 * Copyright (C) Gestankbratwurst suotokka@gmail.com
 *
 * This file is part of AdvancedDropManager and was created at the 28.12.2019
 *
 * AdvancedDropManager can not be copied and/or distributed without the express
 * permission of the owner.
 *
 */
public interface ReflectiveJsonProvider<T> {

  public Class<T> getImplementingClass();

  public JsonObject getJsonData();

  public default boolean checkConstructor() {
    try {
      this.getImplementingClass().getConstructor(JsonObject.class);
    } catch (NoSuchMethodException e) {
      return false;
    }
    return true;
  }

}