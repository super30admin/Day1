/**
 * Implemented a hash set using a 2D boolean array (arr) where each element represents whether a particular key is present or not.
 * The Time Complexity for add, remove and contains is O(1)
 * Space Complexity is O(n^2) for tha 2D array.
 */

class MyHashSet {
    boolean[][] arr;
    int primaryArraySize;
    int nestedArraySize;

    public MyHashSet() {
        this.primaryArraySize = 1000;
        this.nestedArraySize = 1000;
        this.arr = new boolean[primaryArraySize][];
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