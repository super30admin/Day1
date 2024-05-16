
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 *
 * Implemented Double hashing method for hashing
 * Time Complexity:
 * O(1) --> add(), remove(), contains()
 *
 * Space Complexity:O(n)
 *
 */
class MyHashSet {
    private static final int BUCKET_ITEM_SIZE = 1000;
    private static final int ARRAY_SIZE = 1000;
    private boolean storage[][];

    public MyHashSet() {
        storage = new boolean[ARRAY_SIZE][];
    }

    public void add(int key) {
        int bucketIndex = getBucketIndex(key);
        int bucketItemIndex = getBucketItemIndex(key);
        if(!contains(key)){
            if(storage[bucketIndex] == null){

                if(bucketIndex == 0){
                    storage[bucketIndex] = new boolean[BUCKET_ITEM_SIZE+1];
                }
                else{
                    storage[bucketIndex] = new boolean[BUCKET_ITEM_SIZE];
                }
            }
            storage[bucketIndex][bucketItemIndex] = true;
        }
    }

    public void remove(int key) {
        if(contains(key)){

            int bucket = getBucketIndex(key);
            int bucketItem = getBucketItemIndex(key);

            storage[bucket][bucketItem] = false;
        }
    }

    public boolean contains(int key) {
        int bucketIndex = getBucketIndex(key);
        int bucketItemIndex = getBucketItemIndex(key);

        if(storage[bucketIndex] == null)
            return false;
        return storage[bucketIndex][bucketItemIndex];
    }
    private int getBucketIndex(int key){
        return key%ARRAY_SIZE;
    }

    private int getBucketItemIndex(int key){
        return key/BUCKET_ITEM_SIZE;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */