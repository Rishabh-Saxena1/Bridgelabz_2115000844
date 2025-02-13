import java.util.*;
class CustomHashMap<K, V> {
    private static final int SIZE = 16;
    private LinkedList<Entry<K, V>>[] map;

    static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        map = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            map[i] = new LinkedList<>();
        }
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode() % SIZE);
    }

    public void put(K key, V value) {
        int index = getIndex(key);
        for (Entry<K, V> entry : map[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        map[index].add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = getIndex(key);
        for (Entry<K, V> entry : map[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = getIndex(key);
        map[index].removeIf(entry -> entry.key.equals(key));
    }

    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> hashMap = new CustomHashMap<>();
        hashMap.put("One", 1);
        hashMap.put("Two", 2);
        hashMap.put("Three", 3);

        System.out.println(hashMap.get("Two"));
        hashMap.remove("Two");
        System.out.println(hashMap.get("Two"));
        System.out.println(hashMap.containsKey("One"));
    }
}
