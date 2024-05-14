class MyHashSet {

    //Using double hashing technique
    //Time Complexity - O(1)
    //Space Complexity - O(n)

    int buckets = 1000; //first array size
    int bucketItems = 1000; //secondary array size
    boolean[][] hashSet; // data structure to store values

    public MyHashSet() {

        hashSet = new boolean[buckets][];

    }

    public void add(int key) {
        int bucket = key%buckets; // first hash function
        int bucketItem = key/bucketItems; // 2nd hash function
        //If bucket is not mapped to any key initially
        if(hashSet[bucket] == null) {
            //allocated space for secondary array
            //If it is index 0, allocate one extra space
            if(bucket == 0)
                hashSet[bucket] = new boolean[bucketItems+1];
            else
                hashSet[bucket] = new boolean[bucketItems];
        }

        hashSet[bucket][bucketItem] = true; // update index in secondary array to true

    }

    public void remove(int key) {
        int bucket = key%buckets; // first hash function
        int bucketItem = key/bucketItems; // 2nd hash function

        //if bucket is null, return false
        if(hashSet[bucket] != null)
            hashSet[bucket][bucketItem] = false;
    }

    public boolean contains(int key) {
        int bucket = key%buckets; // first hash function
        int bucketItem = key/bucketItems; // 2nd hash function

        //if bucket is null, return false
        if(hashSet[bucket] == null)
            return false;

        return hashSet[bucket][bucketItem];
    }

    public static void main(String[] args) {

        int key = 1000;
        MyHashSet obj = new MyHashSet();
        obj.add(key);
        obj.remove(key);
        boolean param_3 = obj.contains(key);
        System.out.println(param_3);
    }
}