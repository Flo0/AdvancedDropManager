package com.gestankbratwurst.advanceddropmanager.io;

import com.gestankbratwurst.advanceddropmanager.AdvancedDropManager;
import com.gestankbratwurst.advanceddropmanager.drops.DropManager;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.Map.Entry;

/*******************************************************
 * Copyright (C) Gestankbratwurst suotokka@gmail.com
 *
 * This file is part of AdvancedDropManager and was created at the 28.12.2019
 *
 * AdvancedDropManager can not be copied and/or distributed without the express
 * permission of the owner.
 *
 */
public class IOManager {

  public IOManager(AdvancedDropManager advancedDropManager) {
    mainFolder = advancedDropManager.getDataFolder();
    dropFolder = new File(mainFolder, "drops");
    this.gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    this.dropManager = advancedDropManager.getDropManager();
  }

  private final Gson gson;
  private final File mainFolder;
  private final File dropFolder;
  private final DropManager dropManager;

  public void enable() {
    if (!mainFolder.exists()) {
      mainFolder.mkdirs();
    }
    if (!dropFolder.exists()) {
      dropFolder.mkdirs();
    }

    Map<String, JsonObject> serializedDrops = Maps.newHashMap();

    for (File dropFile : dropFolder.listFiles()) {
      String read = null;
      try {
        read = this.readFile(dropFile);
      } catch (IOException e) {
        e.printStackTrace();
      }
      if (read != null) {
        JsonObject json = gson.fromJson(read, JsonObject.class);
        serializedDrops.put(dropFile.getName(), json);
      }
    }

    this.dropManager.deserializeDrops(serializedDrops);
  }

  public void disable() {
    Map<String, JsonObject> serializedDrops = this.dropManager.serializeDrops();
    for (Entry<String, JsonObject> entry : serializedDrops.entrySet()) {
      File dropFile = new File(this.dropFolder, entry.getKey());
      try {
        this.writeFile(dropFile, gson.toJson(entry.getValue()));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  private String readFile(File file) throws IOException {
    Preconditions.checkArgument(!file.isDirectory());
    StringBuilder builder = new StringBuilder();
    InputStreamReader reader = new InputStreamReader(new FileInputStream(file));
    int read;
    while ((read = reader.read()) != -1) {
      builder.append((char) read);
    }
    reader.close();
    return builder.toString();
  }

  private void writeFile(File file, String value) throws IOException {
    OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file));
    osw.write(value);
    osw.close();
  }

}
