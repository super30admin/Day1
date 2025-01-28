// Time Complexity : O(1) time complexity
// Space Complexity :


// Your code here along with comments explaining your approach
class MyHashSet {
    int buckets = 1000;
    int bucketItems = 1001; // to handle last element
    boolean [][] storage = new boolean[buckets][];

    public int bucket(int value){
        return value%buckets;
    }

    public int bucketItem(int value){
        return value/buckets;
    }

    /** Initialize your data structure here. */

    public MyHashSet() {

    }

    public void add(int value ) {

        int bucket = bucket(value);

        int bucketItem = bucketItem(value);

        if(storage[bucket] == null){

            storage[bucket] = new boolean[bucketItems];

        }

        storage[bucket][bucketItem] = true;

    }

    public void remove(int value) {

        int bucket = bucket(value);

        int bucketItem = bucketItem(value);

        if(storage[bucket] != null){

            storage[bucket][bucketItem] = false;

        }

    }

    /** Returns true if this set contains the specified element */

    public boolean contains(int value) {

        int bucket = bucket(value);

        int bucketItem = bucketItem(value);

        return storage[bucket] != null && storage[bucket][bucketItem];

    }

}

/**

 * Your MyHashSet object will be instantiated and called as such:

 * MyHashSet obj = new MyHashSet();

 * obj.add(key);

 * obj.remove(key);

 * boolean param_3 = obj.contains(key);

 */

