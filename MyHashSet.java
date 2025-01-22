/**
 Implemented a hash set using a 2D boolean array (arr) where each element represents whether a particular key is present or not
 */

class MyHashSet {
    boolean[][] arr;
    int primaryArraySize;
    int nestedArraySize;

    public MyHashSet() {
        primaryArraySize = 1000;
        nestedArraySize = 1000;
        arr = new boolean[primaryArraySize][];
    }

    private int primaryIndex(int key) {
        return key % primaryArraySize;
    }

    private int nestedIndex(int key) {
        return key / nestedArraySize;
    }

    public void add(int key) {
        int primaryIndex = primaryIndex(key);
        if (arr[primaryIndex] == null) {
            if (primaryIndex == 0) {
                arr[primaryIndex] = new boolean[nestedArraySize + 1];
            } else {
                arr[primaryIndex] = new boolean[nestedArraySize];
            }
        }

        arr[primaryIndex(key)][nestedIndex(key)] = true;
    }

    public void remove(int key) {
        if (arr[primaryIndex(key)] != null) {
            arr[primaryIndex(key)][nestedIndex(key)] = false;
        }
    }

    public boolean contains(int key) {
        int primaryIndex = primaryIndex(key);

        if (arr[primaryIndex] != null) {
            return arr[primaryIndex][nestedIndex(key)];
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */