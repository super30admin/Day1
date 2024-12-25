public class HashSet {

    int buckets;
    int bucketItems;
    boolean[][] storage;

    public HashSet() {
        this.buckets=1000;
        this.bucketItems = 1000;
        storage = new boolean[this.buckets][];
    }

    int getBucket(int key){
        return key % this.buckets;
    }

    int getBucketItems(int key){
        return key / this.bucketItems;
    }

    public void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
        if(storage[bucket]==null){
            if(bucket == 0){
                storage[bucket] = new boolean[this.bucketItems+1];
            }else{
                storage[bucket] = new boolean[this.bucketItems];
            }
        }
        storage[bucket][bucketItem]=true;

    }

    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
        if(storage[bucket]==null){
            return;
        }
        storage[bucket][bucketItem]=false;

    }

    public boolean contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItems(key);
        if(storage[bucket]==null){
            return false;
        }
        return storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */