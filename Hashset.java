// Time Complexity : O(1) for add, remove, contains
// Space Complexity : O(1) as we dont consider storage initializing in constructor, if we consider constructor inititilization then O(primaryBucketSize + secondaryBucketSize)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// Implementing Hashset using Double hashing method.
// Here I am using array is my basic data structure and adding 2 hash functions
// first hash function is used to find the index of the first bucket
// secondary hash function is used for finding the unique index in secondary bucket.
class Hashset {
    boolean[][] storage;
    int buckets;
    int bucketItems;

    /**
     * Initializing constructor
     * setting buckets with initial size as 1000
     * setting secondary bucket size as 1000
     * initialling primary array with size
     */
    public Hashset() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new boolean[buckets][];
    }

    /**
     * Hash function to return unique index of the primary bucket
     * @param key
     * @return
     */
    public int getPrimaryHash(int key) {
        return key % buckets;
    }

    /**
     * Hash function to return unique index of the secondary bucket
     * @param key
     * @return
     */
    public int getSecondaryHash(int key) {
        return key / bucketItems;
    }

    /**
     * Getting primary hash index, if it is null, then creating secondary array for that index
     * if it is not null, get secondary index and set value as true to storage[hash1][hash2]
     * Time Complexity : O(1)
     * @param key
     */
    public void add(int key) {
        int hash1 = getPrimaryHash(key);
        if(storage[hash1] == null) {
            // to prevent array index for 1000000th record, setting 0th array secondary array to 1000+1
            if(hash1 == 0) {
                storage[hash1] = new boolean[bucketItems+1];
            }else {
                storage[hash1] = new boolean[bucketItems];
            }
        }
        int hash2 = getSecondaryHash(key);
        storage[hash1][hash2] = true;
    }

    /**
     *  * Time Complexity : O(1)
     * get primary hash, if value is null at primaryHash, the return
     * else get secondary hash and set storage[hash1][hash2] to false
     * @param key
     */
    public void remove(int key) {
        int hash1 = getPrimaryHash(key);
        if(storage[hash1] == null) {
            return ;
        }
        int hash2 = getSecondaryHash(key);
        storage[hash1][hash2] = false;
    }

    /**
     *  * Time Complexity : O(1)
     * get primary hash, if value is null at primaryHash, the return false
     * else get secondary hash and return storage[hash1][hash2]
     * @param key
     */
    public boolean contains(int key) {
        int hash1 = getPrimaryHash(key);
        if(storage[hash1] == null) {
            return false;
        }
        int hash2 = getSecondaryHash(key);
        return storage[hash1][hash2];
    }
}
