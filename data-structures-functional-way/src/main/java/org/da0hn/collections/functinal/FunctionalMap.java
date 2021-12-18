package org.da0hn.collections.functinal;

public class FunctionalMap<K, V> {

  private final Entry<K, V>[] entries;
  private final int size;

  public FunctionalMap(final int size) {
    this.size = size;
    this.entries = new Entry[size];

    for(int i = 0; i < size; i++) {
      this.entries[i] = new Entry<>();
    }
  }

  private FunctionalMap(final Entry<K, V>[] entries, final int size) {
    this.size = size;
    this.entries = entries;
  }

  public FunctionalMap<K, V> put(final K key, final V value) {
    final int hash = this.getHash(key);

    final Entry<K, V> existingEntry = this.entries[hash];

    if(this.isDuplicate(key)) {
      existingEntry.value = value;
    }

    final Entry<K, V> newEntry = new Entry<>(key, value);

    this.entries[hash] = newEntry;

    newEntry.next = existingEntry;

    return new FunctionalMap<>(this.entries, this.size);
  }

  private boolean isDuplicate(final K key) {
    boolean duplicate = false;

    var entry = this.entries[this.getHash(key)];

    while(entry != null) {
      if(key.equals(entry.key)) {
        duplicate = true;
      }
      entry = entry.next;
    }
    return duplicate;
  }

  public Integer getHash(final K key) {
    return key.hashCode() % this.size;
  }

  public V getValue(final K key) {
    V value = null;
    final int hash = this.getHash(key);
    var entry = this.entries[hash];
    while(entry.next != null) {
      if(key.equals(entry.key)) {
        value = entry.value;
        break;
      }
      entry = entry.next;
    }
    return value;
  }

}
