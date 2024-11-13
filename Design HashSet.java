//TC- O(1)
//implementing hashmap with double mapping

class MyHashSet {
    int primaryBuckets;
    int secondaryBuckets;
    boolean[][] storage;

    public MyHashSet() {
        this.primaryBuckets = 1000;
        this.secondaryBuckets = 1000;
        this.storage = new boolean[primaryBuckets][]; //only initialize for primary buckets to save space intially will all null
        
    }
    
    private int getPrimaryHash(int key){
        return key % primaryBuckets;
    }

    private int getsecondaryHash(int key){
        return key / secondaryBuckets;
    }
    public void add(int key) {
        int primaryHash = getPrimaryHash(key);
        if(storage[primaryHash] == null){
            if(primaryHash == 0){//handling edge case when key is 1000
                storage[primaryHash] = new boolean[secondaryBuckets + 1];
            }
            else{
                storage[primaryHash] = new boolean[secondaryBuckets];
            }
        }
        int secondaryHash = getsecondaryHash(key);
        storage[primaryHash][secondaryHash] = true;
        
    }
    
    public void remove(int key) {
        int primaryHash = getPrimaryHash(key);
        if(storage[primaryHash] == null) return;
        int secondaryHash = getsecondaryHash(key);
        storage[primaryHash][secondaryHash] = false;
        
    }
    
    public boolean contains(int key) {
        int primaryHash = getPrimaryHash(key);
        if(storage[primaryHash] == null) return false;
        int secondaryHash = getsecondaryHash(key);
        return storage[primaryHash][secondaryHash];
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */