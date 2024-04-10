// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class designHashSet {
    boolean[][] storage;
    int bucket;
    int bucketItems;
    public designHashSet() {
        this.bucket=1000;
        this.bucketItems=1000;
        this.storage= new boolean[bucket][];
    }
    private int primaryHashFunction(int key){
        return key % bucket;
    }
    private int secHashFunction(int key){
        return key / bucket;
    }
    public void add(int key) {
        int hash1 = primaryHashFunction(key);
        if (storage[hash1] == null){
            if (hash1 == 0){
                storage[hash1] = new boolean[bucketItems+1]; 
            }
            else{
            storage[hash1] = new boolean[bucketItems]; 
            }
        }   
        int hash2 = secHashFunction(key);
        storage[hash1][hash2] = true;
        System.out.println(this.storage);
    }
    
    public void remove(int key) {
        int hash1 = primaryHashFunction(key);
        if (storage[hash1] == null){
            return; 
        }  
        int hash2 = secHashFunction(key);
        storage[hash1][hash2] = false;
    }
    
    public boolean contains(int key) {
        int hash1 = primaryHashFunction(key);
         if (storage[hash1] == null){
            return false;
        }   
        int hash2 = secHashFunction(key);
        return storage[hash1][hash2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */