// Time Complexity : O(1) for all operations
// Space Complexity :
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Constraint is 0<= key <=1000000. We don't want to create array of size 1000000, since it will be waste of time and space. So we will create array of size 1000 and then create array at each index of array. 
// We will use two hash functions to get index of array and index of array at each index of array. 
// And to avoid collission, we will use 2 different hash functions.

public class MyHashSet {
    int buckets;
    int bucketItems;
    bool[][] storage;

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new bool[buckets][];
    }
    
    public int getBucket(int key)
    {
        return key % buckets;
    }

    public int getBucketItem(int key)
    {
        return key / bucketItems;
    }

    public void Add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket] == null)
        {
            if (bucket == 0)
            {
                storage[bucket] = new bool[this.bucketItems + 1];
            }
            else
            {
            storage[bucket] = new bool[this.bucketItems];
            }
        }
        storage[bucket][bucketItem] = true;
    }
    
    public void Remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket]==null)
        {
            return;
        }      
        storage[bucket][bucketItem] = false;
        
    }
    
    public bool Contains(int key) {
         int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(storage[bucket]==null)
        {
            return false;
        }
        return storage[bucket][bucketItem];        
    }
}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.Add(key);
 * obj.Remove(key);
 * bool param_3 = obj.Contains(key);
 */