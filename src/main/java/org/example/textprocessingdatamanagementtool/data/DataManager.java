package org.example.textprocessingdatamanagementtool.data;//package org.example.textprocessingdatamanagementtool.data;

import java.util.*;

public class DataManager<T> {

    private List<T> arrayList;
    private Set<T> hashSet;
    private Map<T, T> hashMap;

    public DataManager() {
        arrayList = new ArrayList<>();
        hashSet = new HashSet<>();
        hashMap = new HashMap<>();
    }

    // List operations
    public void addToList(T item) {
        arrayList.add(item);
    }

    public void updateList(int index, T item) {
        if (index >= 0 && index < arrayList.size()) {
            arrayList.set(index, item);
        }
    }

    public void deleteFromList(int index) {
        if (index >= 0 && index < arrayList.size()) {
            arrayList.remove(index);
        }
    }

    public void clearList() {
        arrayList.clear();
    }

    public boolean findInList(T item) {
        return arrayList.contains(item);
    }

    public List<T> getArrayList() {
        return arrayList;
    }

    // Set operations
    public void addToSet(T item) {
        hashSet.add(item);
    }

    public void updateSet(T oldItem, T newItem) {
        if (hashSet.contains(oldItem)) {
            hashSet.remove(oldItem);
            hashSet.add(newItem);
        }
    }

    public void deleteFromSet(T item) {
        hashSet.remove(item);
    }

    public void clearSet() {
        hashSet.clear();
    }

    public boolean findInSet(T item) {
        return hashSet.contains(item);
    }

    public Set<T> getHashSet() {
        return hashSet;
    }

    // Map operations
    public void addToMap(T key, T value) {
        hashMap.put(key, value);
    }

    public void updateMap(T key, T value) {
        if (hashMap.containsKey(key)) {
            hashMap.put(key, value);
        }
    }

    public void deleteFromMap(T key) {
        hashMap.remove(key);
    }

    public void clearMap() {
        hashMap.clear();
    }

    public boolean findInMap(T key) {
        return hashMap.containsKey(key);
    }

    public Map<T, T> getHashMap() {
        return hashMap;
    }
}

