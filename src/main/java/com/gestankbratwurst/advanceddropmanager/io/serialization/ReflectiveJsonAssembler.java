package com.gestankbratwurst.advanceddropmanager.io.serialization;

import com.google.common.base.Preconditions;
import com.google.gson.JsonObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
public class ReflectiveJsonAssembler<T extends ReflectiveJsonProvider<?>> {

  @SuppressWarnings("unchecked")
  public T deserialize(JsonObject json)
      throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
    Class<? extends T> clazz = (Class<? extends T>) Class.forName(json.get("ClassName").getAsString());
    Constructor<? extends T> constructor = clazz.getConstructor(JsonObject.class);
    JsonObject data = json.get("Data").getAsJsonObject();
    T instance = constructor.newInstance(data);
    return instance;
  }

  @Nullable
  @SuppressWarnings("unchecked")
  public T deserializeCatched(JsonObject json) {
    Class<? extends T> clazz = null;
    Constructor<? extends T> constructor = null;

    try {
      clazz = (Class<? extends T>) Class.forName(json.get("ClassName").getAsString());
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    try {
      Preconditions.checkState(clazz != null);
      constructor = clazz.getConstructor(JsonObject.class);
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    }
    JsonObject data = json.get("Data").getAsJsonObject();

    T instance = null;

    try {
      instance = constructor.newInstance(data);
    } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
      e.printStackTrace();
    }

    return instance;
  }

  public JsonObject serialize(T element) {
    JsonObject json = new JsonObject();

    json.addProperty("ClassName", element.getImplementingClass().getName());
    json.add("Data", element.getJsonData());

    return json;
  }

}
