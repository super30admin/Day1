// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Index out of bound error for key value 1000


class MyHashSet {

    boolean[][] storage; //Creating a 2D array with boolean data type
    int primaryBucket = 1000;
    int secondaryBucket = 1000;

    public MyHashSet() {
        storage = new boolean[primaryBucket][]; //Initializing storage array with only the primary array containing null pointers
    }

    public int primaryHashFunction(int key){
        return key % 1000;
    }

    public int secondaryHashFunction(int key){
        return key / 1000;
    }

    public void add(int key) {
        int hash1 = primaryHashFunction(key);
        int hash2 = secondaryHashFunction(key);

        if(storage[hash1] == null){
            if (hash1 == 0){
                storage[hash1] = new boolean [secondaryBucket + 1]; //Increasing the bucket size by 1 to avoid index out of bound error
            } else{
                storage[hash1] = new boolean [secondaryBucket];
            }
        }

        storage[hash1][hash2] = true;
    }

    public void remove(int key) {
        int hash1 = primaryHashFunction(key);
        int hash2 = secondaryHashFunction(key);

        if(storage[hash1] == null){
            return; //If the key doesn't exist, returns nothing
        }

        storage[hash1][hash2] = false; //If the key exists then sets it as false
    }

    public boolean contains(int key) {
        int hash1 = primaryHashFunction(key);
        int hash2 = secondaryHashFunction(key);

        if(storage[hash1] == null){
            return false; //If the key doesn't exist, returns false
        }

        return storage[hash1][hash2]; ////If the key exists then sets it
    }
}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */