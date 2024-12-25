// Time Complexity : O(1) - add, remove, contains
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially using boolean[] was wasting a lot of memory,
// if only a small portion of 10^6 was actually used. Made the solution more optimal space-wise
// by using 2D boolean array and deriving indexes using hash function while taking care of collisions


// Your code here along with comments explaining your approach
public class MyHashSet {
    /**
     *  To save memory, a large key set can be divided into smaller sets
     */
    boolean[][] hashSet;
    int bucketCount;
    int bucketItemCount;

    /**
     * Constructor to initialize boolean[][] hashSet
     * Since key is: 0 <= key <= 10^6, primary bucket can store sqRt(10^6) keys and each bucket can store 10^6 keys
     */
    public MyHashSet() {
        this.bucketCount = 1000; // primary buckets
        this.bucketItemCount = 1000; // Number of items in each bucket
        this.hashSet = new boolean[this.bucketCount][];
    }

    /**
     * Get the bucket slot in primary bucket by using this hash - key % 1000
     *
     * @param key key in the bucket
     * @return modulo to find index in primary bucket
     */
    int getBucketCount(int key) {
        return key % this.bucketCount;
    }

    /**
     * Get the bucket slot in secondary bucket by using this hash - key / 1000
     *
     * @param key key in the bucket
     * @return quotient to find index in secondary bucket
     */
    int getBucketItemCount(int key) {
        return key / this.bucketCount;
    }

    /**
     * Set the index to true based on the key being added by computing the hashes
     * Time complexity: O(1) since using an array provides random access based on index
     *
     * @param key key to be added to set
     */
    public void add(int key) {
        int bucketIndex = getBucketCount(key);
        int bucketItemIndex = getBucketItemCount(key);

        if(this.hashSet[bucketIndex] == null) {
            this.hashSet[bucketIndex] = (bucketIndex == 0) ? new boolean[this.bucketItemCount + 1] : new boolean[this.bucketItemCount];
            // to handle edge case if the bucket is 0th bucket, add 1001 items for that bucket
        }

        this.hashSet[bucketIndex][bucketItemIndex] = true; // mark key as present
    }

    /**
     * Reset the index to false based on the key being removed by computing the hashes
     * Time complexity: O(1) since using an array provides random access based on index
     *
     * @param key key to be removed from set
     */
    public void remove(int key) {
        int bucketIndex = getBucketCount(key);
        int bucketItemIndex = getBucketItemCount(key);

        if (this.hashSet[bucketIndex] != null) {
            this.hashSet[bucketIndex][bucketItemIndex] = false;
        }
    }

    /**
     * If a key exists in boolean[] hashSet, get the value from secondary bucket and return,
     * Time complexity: O(1) since using an array provides random access based on index
     *
     * @param key key to be looked for in the hashSet
     * @return true if exists in the hashSet, false otherwise
     */
    public boolean contains(int key) {
        int bucketIndex = getBucketCount(key);
        int bucketItemIndex = getBucketItemCount(key);

        return this.hashSet[bucketIndex] != null && this.hashSet[bucketIndex][bucketItemIndex];
    }
}
