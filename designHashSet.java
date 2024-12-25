class MyHashSet {

    //initial attempt
    // just acquire a boolean array of size 1000001 and set the value to true if the key is present
    //this is a simple approach but it is not efficient for large keys
    // boolean[] check;
    // public MyHashSet() {
    //     check =new boolean[1000001];
    // }
    
    // public void add(int key) {
    //     check[key] =true;
    // }
    
    // public void remove(int key) {
    //     check[key] =false;
    // }
    
    // public boolean contains(int key) {
    //     return check[key];
    // }
}

class MyHashSet2 {

    //second attempt after going thorough solutions online
    // using a 2D boolean array to store the presence of the key
    // the first key is the index of the bucket and the second key is the index of the bucket size
    // this is a more efficient approach for large keys

    // ran a test case to check how the secondary key works with numbers 8,18 and 28. They will have the same primary key
    boolean[][] set;
    int buckets;
    int bucketSize;
    public MyHashSet2() {
        buckets = 1001;
        bucketSize = 1000;
        set = new boolean[buckets][];
    }

    public void add(int key) {
        int firstKey = key%buckets;
        int secondKey = key/bucketSize;
        if (set[firstKey] == null){
            set[firstKey] = new boolean[bucketSize];
        }
        set[firstKey][secondKey] = true;
        
    }
    
    public void remove(int key) {
        int firstKey = key%buckets;
        int secondKey = key/bucketSize;
        if (set[firstKey] == null)
        return;
        set[firstKey][secondKey] = false;
    }
    
    public boolean contains(int key) {
        int firstKey = key%buckets;
        int secondKey = key/bucketSize;
        if (set[firstKey] == null)
        return false;
        return set[firstKey][secondKey];

        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */