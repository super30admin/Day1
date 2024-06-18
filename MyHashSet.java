
// Time Complexity : Average Case :O(1), Worst Case: O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/* Using list of list as buckets to store the value. Each bucket has hash value  and elements are stored in
the corresponding bucket based on the hash value.
 */

class MyHashSet {

    int numOfBuckets;
    List<List<Integer>> buckets;
    public MyHashSet() {
        numOfBuckets = 1000;
        buckets = new ArrayList<>(numOfBuckets);
        for(int i=0; i< numOfBuckets; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    public List<Integer> getBucket(int key) {
        // Hash value is calculated using modulo of the key with the number of buckets.
        int hash = key % numOfBuckets;
        List<Integer> bucket = buckets.get(hash);
        return bucket;
    }

    public void add(int key) {
        List<Integer> bucket = getBucket(key);
        if(!bucket.contains(key))
            bucket.add(key);
    }

    public void remove(int key) {
        List<Integer> bucket = getBucket(key);
        if(bucket.contains(key))
            bucket.remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        List<Integer> bucket = getBucket(key);
        return bucket.contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */