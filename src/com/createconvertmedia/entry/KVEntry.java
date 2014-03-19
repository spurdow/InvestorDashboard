package com.createconvertmedia.entry;

import java.util.Map;

public class KVEntry<K , V> implements Map.Entry<K, V> {
    private final K key;
    private V value;

    public KVEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        V old = this.value;
        this.value = value;
        return old;
    }}
