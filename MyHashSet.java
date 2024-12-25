/**
 * Time Complexity
 * Add: O(1)
 * Remove: O(1)
 * Contains: O(1)
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 */

// Your code here along with comments explaining your approach

class MyHashSet {

  // Declare a 2D array. Using 1st array, buckets, we get the hash to find index
  // of the key.
  // Using 2nd array, bucketItems, we get the hash to find index of the key.
  // We use boolean array since we only need to find out if the key element exists
  // in the hashset or not.
  // We don't need to store actual values.
  int buckets = 1000;
  int bucketItems = 1000;
  boolean[][] storage;

  public MyHashSet() {
    // initialize array, buckets
    storage = new boolean[buckets][];
  }

  // First hash using modulo operator which will give us a bucket within range
  // 0...999
  int getBucket(int key) {
    return key % buckets;
  }

  // Second hash using division operator to avoid collision
  int getBucketItem(int key) {
    return key / bucketItems;
  }

  public void add(int key) {
    int bucket = getBucket(key); // get hash index of bucket
    int bucketItem = getBucketItem(key); // get hash index of bucketItem
    if (storage[bucket] == null) { // check if the array within the bucket exists
      if (bucket == 0) { // To accomodate 10^6 value which is included as part of given constraint.
        storage[bucket] = new boolean[bucketItems + 1];
      } else { // we initialize bucketItem array within range 0...999
        storage[bucket] = new boolean[bucketItems];
      }
    }
    storage[bucket][bucketItem] = true; // based on the hash Indexes, update the flag to true. We
  }

  public void remove(int key) {
    int bucket = getBucket(key); // get hash index of bucket
    int bucketItem = getBucketItem(key); // get hash index of bucketItem
    if (storage[bucket] == null) { // If the bucketItem array is not initialized, it seems the element doesn't
                                   // exist. So simply return
      return;
    }
    storage[bucket][bucketItem] = false; // No matter what the value stored at [bucket][bucketItem] we update it to
                                         // false to remove the key.
  }

  public boolean contains(int key) {
    int bucket = getBucket(key); // get hash index of bucket
    int bucketItem = getBucketItem(key); // get hash index of bucketItem
    if (storage[bucket] == null) { // If the bucketItem array is not initialized, it seems the element doesn't
                                   // exist. So return false
      return false;
    }
    return storage[bucket][bucketItem]; // Return the value stored at [bucket][bucketItem]
  }
}