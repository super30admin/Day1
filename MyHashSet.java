// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
public class MyHashSet {
    // Underlying data structure is array; instead of having one long array we can
    // do a matrix
    boolean[][] buckets;
    int bucketSize = 1000;
    int bucketItemSize = 1000;

    public MyHashSet() {
        buckets = new boolean[bucketSize][]; // Initial values will be null.
    }

    private int primaryHashFunction(int key) {
        return key % bucketSize;
    }

    private int secondaryHashFunction(int key) {
        return key / bucketItemSize;
    }

    public void add(int key) {
        int hash1 = primaryHashFunction(key);
        if (buckets[hash1] == null) {
            if (hash1 == 0) {
                buckets[hash1] = new boolean[bucketItemSize + 1]; // Because there are 10^6 + 1 elements
            } else {
                buckets[hash1] = new boolean[bucketItemSize];
            }

        }
        int hash2 = secondaryHashFunction(key);
        buckets[hash1][hash2] = true;

    }

    public void remove(int key) {

        int hash1 = primaryHashFunction(key);

        if (buckets[hash1] == null)
            return;

        int hash2 = secondaryHashFunction(key);

        buckets[hash1][hash2] = false;

    }

    public boolean contains(int key) {

        int hash1 = primaryHashFunction(key);
        if (buckets[hash1] == null)
            return false;

        int hash2 = secondaryHashFunction(key);

        return buckets[hash1][hash2];

    }
}