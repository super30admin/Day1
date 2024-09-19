// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class MyHashSet {
    boolean [][]storage;
    int primarybuckets, secondarybuckets;
    public MyHashSet() {
        primarybuckets = 1000;  // 1 million elements divided into 1000x1000
        secondarybuckets = 1000;
        storage= new boolean[primarybuckets][]; // initializing just the primary array to save them
    }
    //functions to get both hash values
    private int getPrimaryHash(int key){
        return key%primarybuckets;
    }
    
    private int getSecondaryHash(int key){
        return key/secondarybuckets;
    }
    public void add(int key) {
        int primaryhash = getPrimaryHash(key);
        int secondaryhash = getSecondaryHash(key);
        if(storage[primaryhash]==null){
            if(primaryhash==0){
                storage[primaryhash] = new boolean[secondarybuckets+1]; // to accomodate number 1million number as we have 1millionand 1 numbers 
            }
            else {
                storage[primaryhash] = new boolean[secondarybuckets];
            }
        }
        storage[primaryhash][secondaryhash] = true;
    }
    
    public void remove(int key) {
        int primaryhash = getPrimaryHash(key);
        int secondaryhash = getSecondaryHash(key);
        if(storage[primaryhash]==null){ //if secondary array is not initialized then no elements are present 
            return;
        }
        storage[primaryhash][secondaryhash] = false;
        return;
    }
    
    public boolean contains(int key) {
        int primaryhash = getPrimaryHash(key);
        int secondaryhash = getSecondaryHash(key);
        if(storage[primaryhash]==null){
            return false;
        }
        return storage[primaryhash][secondaryhash];        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
