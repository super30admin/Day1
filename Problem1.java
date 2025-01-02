// Time Complexity : O(1)
// Space Complexity : O(10^6)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// S30 ID: Sawan Chakraborty_RN69DEC2024
class MyHashSet {

    int buckets; 
    int bucketItems; 
    boolean storage[][];

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        storage = new boolean[this.buckets][];
    }

    int getBucket(int key){
        return key % this.buckets; // getting buck index
    }

    int getBucketItem(int key){
        return key / this.bucketItems; // getting bucketitem index
    }
    
    public void add(int key) {
        int bucket=getBucket(key);
        int bucketItem=getBucketItem(key);
        if(storage[bucket] == null){
            if(bucket==0){
                storage[bucket]= new boolean[this.bucketItems+1]; // for 10^6 end case
            }
            else{
            storage[bucket]= new boolean[this.bucketItems]; // rest of the case
            }
        }
        storage[bucket][bucketItem]=true;
    }
    
    public void remove(int key) {
        int bucket=getBucket(key);
        int bucketItem=getBucketItem(key);
        if(storage[bucket] == null){ // key not present
        return;
        }
        storage[bucket][bucketItem]=false;
    }
    
    public boolean contains(int key) {
        int bucket=getBucket(key);
        int bucketItem=getBucketItem(key);
        if(storage[bucket] == null){
        return false;
        }
        return storage[bucket][bucketItem]; // return true or false
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

// Your code here along with comments explaining your approach
