// Time Complexity : O(1) for all operations
// Space Complexity : O(n) as used square root to choose bucket size and bucketItem size
// Did this code successfully run on Leetcode : yes
// Approach  : 
// Decided to do double hashing to avoid collision,
// Took the size of base array as queare root of given int range 
// and nested array as well of same size.
// The nested array will be initiated only when there is a key for that index in the base array.
 

public class MyHashSet {
    public bool [][] storage;
    public int buckets;
    public int bucketItems;
    public int bucket(int key)
    {
        return key%buckets;
    }
    public int bucketItem(int key)
    {
        return key/bucketItems;
    }

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        this.storage = new bool[this.buckets][];
    }
    
    public void Add(int key) {
        int bucket = this.bucket(key);
        if(storage[bucket] == null)
        {
            if(bucket ==0)
            {
                storage[bucket] = new bool [this.bucketItems + 1];
            }
            else
            {
                storage[bucket] = new bool [this.bucketItems];
            }            
        }
        int bucketItem = this.bucketItem(key);
        storage[bucket][bucketItem] = true;
    }
    
    public void Remove(int key) {
        int bucket = this.bucket(key);
        if (storage[bucket] == null)
        {
            return;
        }
        int bucketItem = this.bucketItem(key);
        storage [bucket][bucketItem] = false;
    }
    
    public bool Contains(int key) {
        int bucket = this.bucket(key);
        if (storage[bucket] == null)
        {
            return false;
        }
        int bucketItem = this.bucketItem(key);
        return storage [bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.Add(key);
 * obj.Remove(key);
 * bool param_3 = obj.Contains(key);
 */