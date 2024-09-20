// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
//The MyHashSet uses a 2D boolean array as the underlying storage, 
//with a two-step hashing mechanism to manage collisions effectively. 
//The primary and secondary hash functions map a key to a specific bucket, 
//allowing fast access to each element. Memory is allocated dynamically to optimize space, 
//and all operations (Add, Remove, Contains) are performed in constant time.

public class MyHashSet {
    int primaryBuckets;
    int secondaryBuckets;
    Boolean[][] storage;

    public MyHashSet() {
        primaryBuckets = 1000;
        secondaryBuckets = 1000;
        this.storage = new Boolean[primaryBuckets][];
   }

   private int getPrimaryHash(int key){
    return key % primaryBuckets;
    }

    private int getSecondaryHash(int key){
        return key / secondaryBuckets;
    }
    
    public void Add(int key) {
        int primaryHash = getPrimaryHash(key);
        if(storage[primaryHash] == null){
            if(primaryHash == 0){
                storage[primaryHash] = new Boolean[secondaryBuckets + 1];
            }else{
                storage[primaryHash] = new Boolean[secondaryBuckets];
            }
        }
        int secondaryHash = getSecondaryHash(key);
        storage[primaryHash][secondaryHash] = true;
    }
    
    public void Remove(int key) {
        int primaryHash = getPrimaryHash(key);
        if(storage[primaryHash] == null) return;
        int secondaryHash = getSecondaryHash(key);
        storage[primaryHash][secondaryHash] = false;
    }
    
    public bool Contains(int key) {
        int primaryHash = getPrimaryHash(key);
        if(storage[primaryHash] == null){
            return false;
        }
        int secondaryHash = getSecondaryHash(key);
        return storage[primaryHash][secondaryHash];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.Add(key);
 * obj.Remove(key);
 * bool param_3 = obj.Contains(key);
 */