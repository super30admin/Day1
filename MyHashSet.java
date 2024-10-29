// Time Complexity : O(1) for all operations

// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MyHashSet {
    int primaryBucket;
    int secondaryBucket;
    boolean[][] storage;

    public MyHashSet() {
        this.primaryBucket = 1000;
        this.secondaryBucket = 1000;
        this.storage = new boolean[primaryBucket][]; //check point2. However the current space 2 bytes(booolean) * 1000
    }

    public int getPrimaryIndex(int key) {
        return key % primaryBucket;
    }

    public int getSecondaryIndex(int key) {
        return key / secondaryBucket;
    }
    
    public void add(int key) {
        int primaryIndex = getPrimaryIndex(key);
        if(storage[primaryIndex] == null ){
            if(primaryIndex == 0){
                storage[primaryIndex] = new boolean[secondaryBucket+1];
            }else {
                storage[primaryIndex] = new boolean[secondaryBucket];
            } 
        }
        int secondaryIndex = getSecondaryIndex(key);
        storage[primaryIndex][secondaryIndex] = true;
    }
    
    public void remove(int key) {
        int primaryIndex = getPrimaryIndex(key);
        if(storage[primaryIndex] == null){
           return;
        }
        int secondaryIndex = getSecondaryIndex(key);
        storage[primaryIndex][secondaryIndex] = false;
    }
    
    public boolean contains(int key) {
        int primaryIndex = getPrimaryIndex(key);
        if(storage[primaryIndex] == null){
           return false;
        }
        int secondaryIndex = getSecondaryIndex(key);
        return storage[primaryIndex][secondaryIndex];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */