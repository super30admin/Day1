// Time Complexity : O(1) for all the functions: add, remove, contains
// Space Complexity : O(n) in the worst case(case where hashset has all 10^6 elements in it)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 
    // I initially had issues with memory and garbage values,
    // missing on initializing boolean pointers and boolean arrays
    // is the reason for these issues.

#define BUCKETS_SIZE 1000
#define BUCKET_ITEMS_SIZE 1000
class MyHashSet {
    bool** buckets;

    // Primary hash function to determine bucket number
    int getBucketNumber(int key)
    {
        return key%BUCKETS_SIZE;
    }

    // Secondary hash function to determine 
    // item number within bucket 
    int getBucketItemNumber(int key)
    {
        return key/BUCKET_ITEMS_SIZE;
    }
public:
    MyHashSet() {
       buckets = new bool*[BUCKETS_SIZE];
       // Initialize boolean pointers
       for (int i=0; i<BUCKETS_SIZE; i++)
       {
        buckets[i] = NULL;
       }
    }
    
    void add(int key) {
        int bucket = getBucketNumber(key);
        int bucketItemNumber = getBucketItemNumber(key);
        if (buckets[bucket] == NULL)
        {
            int size = 0;
            if (bucket == 0)
            {
                // Extra size for bucket 0 because it has 
                // items: 0, 1000, 2000.....10^6 totaling to
                // 10^3
                size = BUCKET_ITEMS_SIZE + 1;
                buckets[bucket] = new bool[BUCKET_ITEMS_SIZE + 1];
            }
            else 
            {
                size = BUCKET_ITEMS_SIZE;
                buckets[bucket] = new bool[BUCKET_ITEMS_SIZE];
            }
            // Initialize Bucket Items Array(Secondary Array) to all false
            for (int i=0; i<size; i++)
                buckets[bucket][i] = false;
        }
        buckets[bucket][bucketItemNumber] = true;
    }
    
    void remove(int key) {
        int bucket = getBucketNumber(key);
        int bucketItemNumber = getBucketItemNumber(key);
        if (buckets[bucket] == NULL)
        {
            return;
        }
        buckets[bucket][bucketItemNumber] = false;
    }
    
    bool contains(int key) {
        int bucket = getBucketNumber(key);
        int bucketItemNumber = getBucketItemNumber(key);
        if (buckets[bucket] != NULL)
        {
            return buckets[bucket][bucketItemNumber];    
        }
        return false;
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */