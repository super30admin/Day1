// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : Stuggled to understand the logic in java as I'm unaware if the language 

// Your code here along with comments explaining your approach:

class MyHashSet {
    //Declaring the variables needed.
    int primaryBuckets;
    int secondaryBuckets;
    boolean[][] storage;

    public MyHashSet() {
       //Initialising the declared variables.
       this.primaryBuckets=1000;
       this.secondaryBuckets=1000;
       this.storage = new boolean[primaryBuckets][];   
    }
    private int getPrimaryHash(int key){
        //Implementing primary hash function.
        return key % primaryBuckets;
    }
    private int getSecondaryHash(int key){
        //Implementing secondary hash function.
        return key / secondaryBuckets;
    }
    public void add(int key) {
        int primaryHash = getPrimaryHash(key); //Storing the index of key produced by hash fucntion into a variable.
        if (storage[primaryHash]==null){ // Checking if the index to which the key is pointing is null.
            if(primaryHash == 0){ //Edge case: If the index points to 0 then the size of bucket needs to be changed.
                storage[primaryHash] = new boolean[primaryBuckets+1];
            }
            else{                 //If not then a new array for that particular index of size same as primaryBuckets is created.
                storage[primaryHash] = new boolean[primaryBuckets];
            }
        }
        int secondaryHash = getSecondaryHash(key); //Storing the index of key produced by hash fucntion into a variable.
        storage[primaryHash][secondaryHash] = true; //Appending the key.
    }
    public void remove(int key) {
        int primaryHash = getPrimaryHash(key);
        if (storage[primaryHash]==null) return; //If the key to be removed is pointing to null then the record doesn't exist in the hashset.
        int secondaryHash = getSecondaryHash(key);
        storage[primaryHash][secondaryHash] = false;//If it exists then that index in the secondaryhash is replaced with false.
    }
    
    public boolean contains(int key) {
        int primaryHash = getPrimaryHash(key);
        if (storage[primaryHash]==null) return false; //If the key to be searched is pointing to null then the record doesn't exist in the hashset.
        int secondaryHash = getSecondaryHash(key);
        return storage[primaryHash][secondaryHash];//If it exists then the key is returned.
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */