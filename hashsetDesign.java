/*
Time Complexity -->
add --> O(1)
remove --> O(1)
contains --> O(1)

Space Complexity --> 
O(1) since we are using 1000*1000 space at worst case
 */
class MyHashSet {

    boolean[][] storage;
    int bucket;
    int bucketItem;

    public MyHashSet() {
        this.bucketItem = 1000;
        this.bucket = 1000;
        this.storage = new boolean[this.bucket][];

    }

    public int getbucket(int key) {
        return key % 1000;
    }

    public int getbucketItem(int key) {
        return key / 1000;
    }

    public void add(int key) {
        int bucketVal = getbucket(key);
        int bucketItemVal = getbucketItem(key);
        if (this.storage[bucketVal] == null) {
            if (bucketVal == 0) {
                this.storage[bucketVal] = new boolean[bucketItem + 1];
            } else {
                this.storage[bucketVal] = new boolean[bucketItem];
            }

        }//if

        this.storage[bucketVal][bucketItemVal] = true;

    }//method

    public void remove(int key) {

        int bucketVal = getbucket(key);
        int bucketItemVal = getbucketItem(key);
        if (this.storage[bucketVal] == null) {
            return;
        }

        this.storage[bucketVal][bucketItemVal] = false;

    }

    public boolean contains(int key) {

        int bucketVal = getbucket(key);
        int bucketItemVal = getbucketItem(key);
        if (this.storage[bucketVal] == null) {
            return false;
        }
        return this.storage[bucketVal][bucketItemVal];

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
