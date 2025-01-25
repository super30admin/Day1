class MyHashSet {
    boolean items[][];
    int bucket;
    int bucketItems;

    public MyHashSet() {

        this.bucket = 1000;
        this.bucketItems = 1000;
        this.items = new boolean[bucket][];

    }

    private int bucketHash(int key) {
        return key % 1000;
    }

    private int bucketItemsHash(int key) {
        return key / 1000;

    }

    public void add(int key) {
        int bucket = bucketHash(key);
        if (items[bucket] == null) {
            if (bucket == 0)
                items[bucket] = new boolean[bucketItems + 1];
            else
                items[bucket] = new boolean[bucketItems];
        }
        int bucketItem = bucketItemsHash(key);
        items[bucket][bucketItem] = true;
    }

    public void remove(int key) {
        int bucket = bucketHash(key);
        if (items[bucket] == null)
            return;
        int bucketItem = bucketItemsHash(key);
        items[bucket][bucketItem] = false;
    }

    public boolean contains(int key) {
        int bucket = bucketHash(key);
        if (items[bucket] == null)
            return false;
        int bucketItem = bucketItemsHash(key);
        return items[bucket][bucketItem];
    }


    public static void main(String[] args){

    }
}
