class MyHashMap {
    int buckets;
    int bucketItems;
    private int[][] storage;

    public MyHashMap() {
        this.buckets = 1000;
        this.bucketItems = 1000;
        storage = new int[this.buckets][this.bucketItems];
    }

    public int getBucket(int key) {
        return key % this.buckets;
    }

    public int getBucketItem(int key) {
        return key / this.bucketItems;
    }

    public void put(int key, int value) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        System.out.println("bucketItem:"+bucket+",bucketItem:"+bucketItem);
        if (storage[bucket] == null) {
            if (bucket == 0) {
                storage[bucket] = new int[this.bucketItems + 1];
            } else {
                storage[bucket] = new int[this.bucketItems];
            }
        }
        storage[bucket][bucketItem] = value;
    }

    public int get(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket] != null) {
            return storage[bucket][bucketItem];
        }
        return -1;
    }

    public void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if (storage[bucket] != null) {
            storage[bucket][bucketItem] = -1;
        }
    }
}