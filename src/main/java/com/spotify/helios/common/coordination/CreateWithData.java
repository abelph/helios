package com.spotify.helios.common.coordination;

import com.netflix.curator.framework.api.transaction.CuratorTransaction;

import java.util.Arrays;

class CreateWithData implements ZooKeeperOperation {

  private final String path;
  private final byte[] data;

  CreateWithData(final String path, final byte[] data) {
    this.path = path;
    this.data = data;
  }

  @Override
  public void register(final CuratorTransaction transaction) throws Exception {
    transaction.create().forPath(path, data);
  }

  @Override
  public String toString() {
    return "CreateWithData{" +
           "path='" + path + '\'' +
           ", data=" + Arrays.toString(data) +
           '}';
  }
}
