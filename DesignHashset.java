// Time Complexity : add() - O(1), remove() - O(1), contains() - O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class MyHashSet {
  int buckets;
  int bucketItems;
  boolean[][] storage;

  // Constructor.
  public MyHashSet() {
    buckets = 1000;
    bucketItems = 1000;
    storage = new boolean[buckets][];
  }

  // Primary hash function.
  int getBucket(int key) {
    return key % buckets;
  }

  // Secondary hash function.
  int getBucketItem(int key) {
    return key / bucketItems;
  }

  // To add a key, set the position to true.
  public void add(int key) {
    int bucket = getBucket(key);
    int bucketItem = getBucketItem(key);
    if(storage[bucket]==null){
      // Edge Case for 10^6 which will have primary index as 0 and secondary index as 1000.
      if(bucket == 0) {
        storage[bucket] = new boolean[bucketItems + 1];
      }else {
        storage[bucket] = new boolean[bucketItems];
      }

    }
    storage[bucket][bucketItem] = true;
  }

  // If key exists, to remove it, set it to false otherwise return.
  public void remove(int key) {
    int bucket = getBucket(key);
    int bucketItem = getBucketItem(key);
    if(storage[bucket]==null) {
      return;
    }
    storage[bucket][bucketItem] = false;
  }

  // Return true if key exists otherwise false.
  public boolean contains(int key) {
    int bucket = getBucket(key);
    int bucketItem = getBucketItem(key);
    if(storage[bucket]==null) return false;
    return storage[bucket][bucketItem];
  }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */