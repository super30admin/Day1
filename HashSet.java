public class HashSet {
    private boolean [][] storage;
    private int bucket;
    private int bucketitems;

    private int bucket (int key){
        return key % bucket;
    }
    private int bucketitems (int key) {
        return key / bucketitems;
    }
    public HashSet() {
        this.bucket = 1000;
        this.bucketitems = 1000;
        this.storage = new boolean[bucket][];
    }
    
    public void add(int key) {
        int bucket = bucket(key);
        if(storage[bucket] == null){
            if(bucket == 0){
                storage[bucket] = new boolean[bucketitems + 1];
            }else{
                storage[bucket] = new boolean[bucketitems];
            }
        }
        int bucketitems = bucketitems(key);
        storage[bucket][bucketitems] = true;
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        if(storage[bucket]==null) return;
        int bucketitems = bucketitems(key);
        storage[bucket][bucketitems] = false;

    }
    
    public boolean contains(int key) {
        int bucket = bucket(key);
        if(storage[bucket]==null) return false;
        int bucketitems = bucketitems(key);
        return storage[bucket][bucketitems];
    }
    public static void main(String[] args) {
        HashSet myHashSet = new HashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(1); // return True
        myHashSet.contains(3); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(2); // return True
        myHashSet.remove(2);   // set = [1]
        myHashSet.contains(2); // return False, (already removed)
    }
}
