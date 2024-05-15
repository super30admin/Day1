//Time Complexity - O(1)
//Space Complexity - O(1)
// Did this code successfully run on Leetcode : Yes

class MyHashSet {

    int buckets;
    int bucketItems;
    boolean[][] storage;
    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        storage = new boolean[buckets][];
    }

    public int hashFunction1(int key){
        return key % buckets;
    }
    public int hashFunction2(int key){
        return key / bucketItems;
    }
    
    public void add(int key) {

    int bucket  = hashFunction1(key);
    int bucketItem = hashFunction2(key);
     if(storage[bucket] == null)
     {
        if(bucket == 0){
            storage[bucket] = new boolean[bucketItems + 1]; //edge case when we take 10^6
        }
        else{
            storage[bucket] = new boolean[bucketItems];

        }
        
     }
     storage[bucket][bucketItem] = true;
    }
    
    public void remove(int key) {
        int bucket  = hashFunction1(key);
        int bucketItem = hashFunction2(key);
        if(storage[bucket] == null)
        {
            return;
        }
        storage[bucket][bucketItem] = false;
    }
    
    public boolean contains(int key) {
        int bucket  = hashFunction1(key);
        int bucketItem = hashFunction2(key);
        if(storage[bucket] == null)
        {
            return false;
        }
        return storage[bucket][bucketItem];
    }
}




