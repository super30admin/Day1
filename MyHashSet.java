// Time Complexity : Add,Remove,Contains: O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Tried initially using array of linkedlists , but got TLE on leetcode


// Your code here along with comments explaining your approach


class MyHashSet {

    int buckets = 1000;
    int bucketItems = 1000;
    boolean[][] storage;
    public MyHashSet() {
        storage = new boolean[this.buckets][];
    }

    public int hash1(int key){
        return key%this.buckets;
    }

    public int hash2(int key){
        return key/this.bucketItems;
    }

    public void add(int key) {
        int index1 = hash1(key);
        int index2 = hash2(key);
        if(storage[index1] == null){
            if(index2 == 1000){
                storage[index1] = new boolean[this.bucketItems+1];
            }else{
                storage[index1] = new boolean[this.bucketItems];
            }
            storage[index1][index2] = true;
            return;
        }
        storage[index1][index2] = true;

    }

    public void remove(int key) {
        int index1 = hash1(key);
        int index2 = hash2(key);
        if(storage[index1] != null){
            if(storage[index1][index2]){
                storage[index1][index2] = false;
            }
        }
        return;
    }

    public boolean contains(int key) {
        int index1 = hash1(key);
        int index2 = hash2(key);
        if(storage[index1] != null){
            return storage[index1][index2];
        }
        return false;
    }
}

