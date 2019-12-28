package com.gestankbratwurst.advanceddropmanager.drops;

import com.gestankbratwurst.advanceddropmanager.drops.abstraction.IDrop;
import com.gestankbratwurst.advanceddropmanager.io.serialization.ReflectiveJsonAssembler;
import com.google.common.collect.Maps;
import com.google.gson.JsonObject;
import java.util.Map;
import java.util.Map.Entry;
import org.jetbrains.annotations.Nullable;

/*******************************************************
 * Copyright (C) Gestankbratwurst suotokka@gmail.com
 *
 * This file is part of AdvancedDropManager and was created at the 28.12.2019
 *
 * AdvancedDropManager can not be copied and/or distributed without the express
 * permission of the owner.
 *
 */
public class DropManager extends ReflectiveJsonAssembler<IDrop<?>> {

  public DropManager() {
    this.dropMap = Maps.newHashMap();
  }

  private final Map<String, IDrop<?>> dropMap;

  public void addDrop(String dropName, IDrop<?> drop) {
    dropMap.put(dropName, drop);
  }

  @Nullable
  public IDrop getDrop(String dropName) {
    return dropMap.get(dropName);
  }

  public Map<String, JsonObject> serializeDrops() {
    Map<String, JsonObject> serializedMap = Maps.newHashMapWithExpectedSize(dropMap.size());
    for (Entry<String, IDrop<?>> entry : dropMap.entrySet()) {
      IDrop<?> drop = entry.getValue();
      if (drop.checkConstructor()) {
        JsonObject json = super.serialize(drop);
        serializedMap.put(entry.getKey(), json);
      }
    }
    return serializedMap;
  }

  public void deserializeDrops(Map<String, JsonObject> serializeDrops) {
    for (Entry<String, JsonObject> entry : serializeDrops.entrySet()) {
      IDrop<?> drop = this.deserializeCatched(entry.getValue());
      this.addDrop(entry.getKey(), drop);
    }
  }

}
