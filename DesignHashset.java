//Time - O(1)
//Space - O(n) - size of storage array
class DesignHashset {

    boolean[][] storage;
    int bucket, bucketItem;

    public DesignHashset() {
        bucket = 1000+1;
        bucketItem = 1000+1;
        storage = new boolean[bucket][];
    }

    public void add(int key) { //Time - O(1)
        int bucketIndex = getBucketIndex(key);
        int bucketItemIndex = getBucketItemIndex(key);
        if(storage[bucketIndex] == null){
            storage[bucketIndex] = new boolean[bucketItem];
        }
        storage[bucketIndex][bucketItemIndex] = true;
    }

    public void remove(int key) { //Time - O(1)
        int bucketIndex = getBucketIndex(key);
        int bucketItemIndex = getBucketItemIndex(key);
        if(storage[bucketIndex] == null) return;
        else storage[bucketIndex][bucketItemIndex] = false;
    }

    public boolean contains(int key) { //Time - O(1)
        int bucketIndex = getBucketIndex(key);
        int bucketItemIndex = getBucketItemIndex(key);
        if(storage[bucketIndex] == null) return false;
        else return storage[bucketIndex][bucketItemIndex];
    }

    private int getBucketIndex(int key){
        return key % bucket;
    }

    private int getBucketItemIndex(int key){
        return key / bucketItem;
    }
}