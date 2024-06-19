// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
class MyHashSet {

    private final boolean[][] storage;

    public MyHashSet() {
        this.storage = new boolean[1000][]; // initialize base array
    }

    public int getBucket(int key) {
        return key % 1000;
    }

    public int getBucketIndex(int key) {
        return key / 1000;
    }

    public void add(int key) {
        int row = getBucket(key);
        int col = getBucketIndex(key);
        if (storage[row] == null) {
            if (row == 0) {
                storage[row] = new boolean[1001];  //edge case
            } else {
                storage[row] = new boolean[1000];   //initialize secondary array
            }
        }
        storage[row][col] = true;

    }

    public void remove(int key) {
        int row = getBucket(key);
        int col = getBucketIndex(key);
        if (storage[row] != null) {
            storage[row][col] = false;
        }
    }

    public boolean contains(int key) {
        int row = getBucket(key);
        int col = getBucketIndex(key);
        if (storage[row] == null) {
            return false;
        }
        return storage[row][col];

    }
}