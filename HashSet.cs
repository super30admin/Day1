#TC: O(1)

public class MyHashSet {

    private bool[][] storage; 
    private int buckets;      
    private int bucketItems;  

    public MyHashSet()
    {
        buckets = 1000; 
        bucketItems = 1000; 
        storage = new bool[buckets][];
    }

    
    private int Bucket(int key)
    {
        return key % buckets;
    }

    private int BucketItem(int key)
    {
        return key / bucketItems;
    }

    public void Add(int key)
    {
        int bucket = Bucket(key);
        if (storage[bucket] == null)
        {
            storage[bucket] = (bucket == 0) ? new bool[bucketItems + 1] : new bool[bucketItems];
        }
        int bucketItem = BucketItem(key);
        storage[bucket][bucketItem] = true;
    }

    public void Remove(int key)
    {
        int bucket = Bucket(key);
        if (storage[bucket] == null) return;
        int bucketItem = BucketItem(key);
        storage[bucket][bucketItem] = false;
    }

    public bool Contains(int key)
    {
        int bucket = Bucket(key);
        if (storage[bucket] == null) return false; 
        int bucketItem = BucketItem(key);
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