// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/* Using double Hashing technique to prevent hashing collision.
First Hashing function is a modulus operation and second is a dividend operation.
 */

//Using Array of size 10^6 would lead to waste of space

//Using double hashing technique to prevent hashing conflict
class MyHashSet {
    int buckets; // indices in primary array
    int bucketItems; //indices in secondary array
    boolean[][] storage;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        storage = new boolean[this.buckets][];
    }

    int getBucket(int key)
    {
        return key % this.buckets;  //O(1)
    }

    int getBucketItem(int key)
    {
        return key / this.bucketItems; //using mod will lead to collision
    }

    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket]==null)
        {
            if(bucket== 0)
            {
                storage[bucket] = new boolean[this.bucketItems+1]; //to handle the 10^6 index
            }
            else
            {
                storage[bucket] = new boolean[this.bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket]==null){
            return;
        }
        storage[bucket][bucketItem] = false;

    }

    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket]==null)
        {
            return false;
        }
        return storage[bucket][bucketItem];
    }
}


