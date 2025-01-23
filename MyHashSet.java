// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class MyHashSet {

    boolean arr[][]; // pointers
    int buckets;
    int bucketItems;

    public MyHashSet() {
        // arr = new boolean[1000001];
        this.buckets = 1000; // square root of 1000000
        this.bucketItems = 1000;
        this.arr = new boolean[buckets][]; // initialize the pointer with the bucket size
    }

    public int bucket(int key){
        return key%buckets; // hashing % to get the bucket
    }

    public int bucketItem(int key){
        return key/bucketItems; // hashing / to get the space in the bucket
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
        arr[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        // arr[key] = false;
        int bucket = bucket(key);
        if(arr[bucket] == null){
            return;
        }
        int bucketItem = bucketItem(key);
        arr[bucket][bucketItem] = false;
    }

    public boolean contains(int key) {
        // return arr[key];
        int bucket = bucket(key);
        if(arr[bucket] == null){
            return false;
        }
        int bucketItem = bucketItem(key);
        return arr[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */