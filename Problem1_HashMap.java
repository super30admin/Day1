//Time Complexity: O(n/k) -> where n is number of keys; and k is the number of buckets
//Space Complexity: O(n+k) -> where n is number of keys; and k is the number of buckets

class MyHashMap {
    int buckets = 1000;
    int bucketItems = 1000;
    Integer[][] myHashmap = new Integer[buckets][];

    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    //generating hash key to locate the bucket where key is stored
    private int getBucketIdx(int key){
        return key%buckets;
    }
    //to get key
    private int getBucketItemIdx(int key){
        return key/buckets;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int bucketIdx = getBucketIdx(key);
        int bucketItemIdx = getBucketItemIdx(key);
        //if no bucket index present; create
        if(myHashmap[bucketIdx] == null)
            myHashmap[bucketIdx] = new Integer[bucketItems];
        //else assign value to the bucket
        myHashmap[bucketIdx][bucketItemIdx] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int bucketIdx = getBucketIdx(key);
        int bucketItemIdx = getBucketItemIdx(key);
        
        if(myHashmap[bucketIdx] != null && myHashmap[bucketIdx][bucketItemIdx] != null)
            return myHashmap[bucketIdx][bucketItemIdx];
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int bucketIdx = getBucketIdx(key);
        int bucketItemIdx = getBucketItemIdx(key);
        
        if(myHashmap[bucketIdx] != null && myHashmap[bucketIdx][bucketItemIdx] != null)
            myHashmap[bucketIdx][bucketItemIdx] = null;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */