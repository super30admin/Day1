// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class MyHashSet {

    boolean arr[][]; // data structure in data structure to store to store the set values
    int buckets;    // size of the array of pointers
    int bucketItems; // size of the array of a pointer

    public MyHashSet() {
        // arr = new boolean[1000001];
        this.buckets = 1000; // square root of 1000000
        this.bucketItems = 1000;
        this.arr = new boolean[buckets][]; // initialized an array with the given buckets
    }

    public int bucket(int key){
        return key%buckets; // To get the bucket
    }

    public int bucketItem(int key){
        return key/bucketItems; // To get the subarray space of the bucket
    }

    public void add(int key) {
        // arr[key] = true;
        int bucket = bucket(key);
        if(arr[bucket] == null){
            if(bucket == 0){
                arr[bucket] = new boolean[bucketItems+1];
            }else{
                arr[bucket] = new boolean[bucketItems];
            }
        }
        int bucketItem = bucketItem(key);
        arr[bucket][bucketItem] = true; // add the value to the correct space
    }

    public void remove(int key) {
        // arr[key] = false;
        int bucket = bucket(key);
        if(arr[bucket] == null){
            return;
        }
        int bucketItem = bucketItem(key);
        arr[bucket][bucketItem] = false;    // requested remove space
    }

    public boolean contains(int key) {
        // return arr[key];
        int bucket = bucket(key);
        if(arr[bucket] == null){
            return false;
        }
        int bucketItem = bucketItem(key);
        return arr[bucket][bucketItem]; // return the value from the requested space
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
