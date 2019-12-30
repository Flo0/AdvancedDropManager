package com.gestankbratwurst.advanceddropmanager.drops;

import com.gestankbratwurst.advanceddropmanager.drops.abstraction.IDrop;
import com.gestankbratwurst.advanceddropmanager.drops.impl.DropContainer;
import com.gestankbratwurst.advanceddropmanager.io.serialization.ReflectiveJsonAssembler;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonObject;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
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
public class DropManager extends ReflectiveJsonAssembler<DropContainer> {

  public DropManager() {
    this.dropMap = Maps.newHashMap();
    this.idMap = Maps.newHashMap();
  }

  private final Map<String, DropContainer> dropMap;
  private final Map<String, SortedSet<String>> idMap;

  public void addDrop(String dropName, DropContainer drop, String identifier) {
    dropMap.put(dropName, drop);
    if (!idMap.containsKey(identifier)) {
      idMap.put(identifier, Sets.newTreeSet());
    }
    idMap.get(identifier).add(dropName);
  }

  @Nullable
  public DropContainer getDrop(String dropName) {
    return dropMap.get(dropName);
  }

  public Map<String, JsonObject> serializeDrops() {
    Map<String, JsonObject> serializedMap = Maps.newHashMapWithExpectedSize(dropMap.size());
    for (Entry<String, DropContainer> entry : dropMap.entrySet()) {
      DropContainer drop = entry.getValue();
      if (drop.checkConstructor()) {
        JsonObject json = super.serialize(drop);
        serializedMap.put(entry.getKey(), json);
      }
    }
    return serializedMap;
  }

  public void deserializeDrops(Map<String, JsonObject> serializeDrops) {
    for (Entry<String, JsonObject> entry : serializeDrops.entrySet()) {
      DropContainer drop = this.deserializeCatched(entry.getValue());
      this.addDrop(entry.getKey(), drop, drop.getIdentifier());
    }
  }

}
