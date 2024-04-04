// Time Complexity : ALl functions )(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 *  Create a boolean storage matrix intitialize in constructor
 *  If using Double hansing add botth functions
 * Add - check if the firstHash index is null that means the boolean array attached is empty create one  and  add true.
 * Remove - Check if tthe first hash is empty. If not make false at index found by secondhash
 * Contais - 
 */

 class MyHashSet {
    int bucket;
    int secbuckets;
    boolean[][] buckets;
   

    public MyHashSet() {
        this.bucket = 1000;
        // when the key is 1000000 the the sec hash willbe out of bounds as  it will try to finf the 1000th slot which does not eexist hence incxrease size
        this.secbuckets = 1001;
        // contains pointers to another array right now its null as 
        this.buckets = new boolean[bucket][];

    }
    private int firstHash( int key){
        return key%bucket;
    }
    private int secondHash(int key){
       return key/secbuckets;
    }
    public void add(int key) {
        int hash = firstHash(key);
        if( buckets[hash] == null){
            buckets[hash] = new boolean[secbuckets];
        }
        int secHash = secondHash(key);
        buckets[hash][secHash] = true;
    }
    
    public void remove(int key) {
        int hash = firstHash(key);
        if( buckets[hash] == null){
            return;
        }
        int secHash = secondHash(key);
         if(buckets[hash][secHash] == true){
            buckets[hash][secHash] = false;
         }
    }
    
    public boolean contains(int key) {
        int hash = firstHash(key);
        if( buckets[hash] == null){
            return false;
        }
        int secHash = secondHash(key);
        return buckets[hash][secHash];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */