// Creating buckets =1000 and bucketItems =1000 which will help in double hashing

class MyHashSet {
    int buckets;
    int bucketItems;
    boolean storage[][];

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        storage = new boolean[this.buckets][];
    }
// 1st hash function
    int getBuckets(int key) {
        return key % this.buckets;
    }
// 2nd hash function
    int getBucketsItems(int key) {
        return key / this.bucketItems;
    }
// Adding keys to the hashset
    public void add(int key) {
        int buckets = getBuckets(key);
        int bucketItems = getBucketsItems(key);
        if (storage[buckets] == null) {
            if (buckets == 0) {
                storage[buckets] = new boolean[this.bucketItems + 1];
            } else {
                storage[buckets] = new boolean[this.bucketItems];
            }
        }
        storage[buckets][bucketItems] = true;
    }
// Removing keys to the hashset

    public void remove(int key) {
        int buckets = getBuckets(key);
        int bucketItems = getBucketsItems(key);
        if (storage[buckets] == null) {
            return;
        }
        storage[buckets][bucketItems] = false;
    }
// Checking keys in the hashset

    public boolean contains(int key) {
        int buckets = getBuckets(key);
        int bucketItems = getBucketsItems(key);
        if (storage[buckets] == null) {
            return false;
        }
        return storage[buckets][bucketItems];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */