package ru.mirea.kabo0222;
import java.util.ArrayList;

class HashTable {
    private ArrayList<ArrayList<Pair>> hashTable;
    private int size;

    public HashTable(int size) {
        this.size = size;
        hashTable = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            hashTable.add(new ArrayList<>());
        }
    }

    private int hashFunc(String key) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash += key.charAt(i);
        }
        return hash % size;
    }

    public void hashtabInit() {
        hashTable.clear();
        for (int i = 0; i < size; i++) {
            hashTable.add(new ArrayList<>());
        }
    }

    public void hashtabAdd(String key, int value) {
        int index = hashFunc(key);
        hashTable.get(index).add(new Pair(key, value));
    }

    public int hashtabLookup(String key) {
        int index = hashFunc(key);
        ArrayList<Pair> pairs = hashTable.get(index);
        for (Pair pair : pairs) {
            if (pair.key.equals(key)) {
                return pair.value;
            }
        }
        return -1;
    }

    public void hashtabDelete(String key) {
        int index = hashFunc(key);
        ArrayList<Pair> pairs = hashTable.get(index);
        for (int i = 0; i < pairs.size(); i++) {
            if (pairs.get(i).key.equals(key)) {
                pairs.remove(i);
                break;
            }
        }
    }
}

class Pair {
    public String key;
    public int value;

    public Pair(String key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class Main {
    public static void main(String[] args) {
        HashTable hashtable = new HashTable(10);

        hashtable.hashtabAdd("ключ1", 10);
        hashtable.hashtabAdd("ключ2", 20);
        hashtable.hashtabAdd("ключ3", 30);
        hashtable.hashtabAdd("ключ4", 40);
        hashtable.hashtabAdd("ключ5", 50);
        hashtable.hashtabAdd("ключ6", 60);
        hashtable.hashtabAdd("ключ7", 70);
        hashtable.hashtabAdd("ключ8", 80);
        hashtable.hashtabAdd("ключ9", 90);
        hashtable.hashtabAdd("ключ10", 100);

        System.out.println(hashtable.hashtabLookup("ключ1"));
        System.out.println(hashtable.hashtabLookup("ключ11"));

        hashtable.hashtabDelete("ключ2");

        System.out.println(hashtable.hashtabLookup("ключ2"));
    }
}