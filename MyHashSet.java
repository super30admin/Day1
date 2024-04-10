class MyHashSet {
    private boolean[][] storage;
    private int buckets;
    private int bucketItems;

    public MyHashSet() {
        this.buckets = 1000;
        this.bucketItems = 1000 + 1;
        this.storage = new boolean[buckets][];
    }
    
    private int hash1(int key) {
        return key % this.buckets;
    }
    
    private int hash2(int key) {
        return key / this.bucketItems;
    }
    
    public void add(int key) {
        int bucket = hash1(key);
        int bucketItems = hash2(key);
        if (storage[bucket] == null) {
            storage[bucket] = new boolean[Math.max(bucketItems + 1, this.bucketItems)];
        } else if (bucketItems >= storage[bucket].length) {
            boolean[] temp = storage[bucket];
            storage[bucket] = new boolean[Math.max(bucketItems + 1, this.bucketItems)];
            System.arraycopy(temp, 0, storage[bucket], 0, temp.length);
        }
        storage[bucket][bucketItems] = true;
    }
    
    public void remove(int key) {
        int bucket = hash1(key);
        int bucketItems = hash2(key);
        if (storage[bucket] == null) return;
        storage[bucket][bucketItems] = false;
    }
    
    public boolean contains(int key) {
        int bucket = hash1(key);
        int bucketItem = hash2(key);
        if (storage[bucket] == null) return false;
        return storage[bucket][bucketItem];
    }
}