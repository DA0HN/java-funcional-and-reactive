package org.da0hn.collections.functinal;

public class Entry<K, V> {

  public K key;
  public V value;
  public Entry<K, V> next;

  public Entry(final K key, final V value) {
    this.key = key;
    this.value = value;
    this.next = null;
  }

  public Entry() {

  }

}
