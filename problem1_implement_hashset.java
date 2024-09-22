// Time Complexity : O(1) - Amortized time complexity (Worst case is O(N) but the worst case is rare here, on average it will be O(1)
// Space Complexity : O(N) space complexity where N is the number of elements 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Getting used to Java Syntax (coming from Python)


// Your code here along with comments explaining your approach

class MyHashSet {
    int primaryBuckets;
    int secondaryBuckets;
    boolean[][] storage;

    public MyHashSet() {
        this.primaryBuckets = 1000;
        this.secondaryBuckets = 1000;
        this.storage = new boolean[primaryBuckets][];
    }

    private int getPrimaryHash(int key){
        return key % primaryBuckets;
    }

    private int getSecondaryHash(int key){
        return key / secondaryBuckets;
    }
    
    public void add(int key) {
        int primaryHash = getPrimaryHash(key);
        if(storage[primaryHash] == null){
            if(primaryHash == 0){
                storage[primaryHash] = new boolean[secondaryBuckets+1];//edge case handling
            }
            else{
                storage[primaryHash] = new boolean[secondaryBuckets];
            }
            
        }
        int secondaryHash = getSecondaryHash(key);
        storage[primaryHash][secondaryHash] = true;
    }
    
    public void remove(int key) {
        int primaryHash = getPrimaryHash(key);
        int secondaryHash = getSecondaryHash(key);
        if(storage[primaryHash] != null){
            storage[primaryHash][secondaryHash] = false;
            // return;
        }
        else{
            return;
        }
        
    }
    
    public boolean contains(int key) {
        int primaryHash = getPrimaryHash(key);
        int secondaryHash = getSecondaryHash(key);
        if(storage[primaryHash] == null){
            return false;
        }
        else{
            return storage[primaryHash][secondaryHash]; //no need to check bcz default is false
        }
        
    }
}
