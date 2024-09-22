// To design this data structure, we will be using array as our basic datastructure. There wuld be two arrays primary and secondary, where primary would be having the addresses of unique hash values of each entry. secondary array is used to handle the collided values and this technique is called double hashing. one hash is modulo and the other is division. 
// Time complexity : all the operations are O(1)
// Tradeoff: We would be creating contiguous blocks of memory which would be of main concern when we would be having a constraint of limited memory. In that scenario linear chaining using linked lists would be a much better option to follow.
// This implementation got successfully submitted in LeetCode.


class HashSet {
    int primaryBuckets;
    int secondaryBuckets;
    boolean[][] storage;

    public HashSet() {
        this.primaryBuckets = 1000;
        this.secondaryBuckets = 1000;
        this.storage = new boolean[primaryBuckets][];// here we are initializing only the primary buckets because we are not certain if we would need secondary buckets for all indices and this would ensure that secondary buckets are created when there are elements to be added at that particular primary index.
        
    }
    
    private int getPrimaryIndex(int key){
        return key%primaryBuckets;
    }
    private int getSecondaryIndex(int key){
        return key/secondaryBuckets;
    }
    
    public void add(int key) {
        if(contains(key)) return;
        int primary = getPrimaryIndex(key);
        if(storage[primary] == null){
            if(primary == 0){
                storage[primary] = new boolean[secondaryBuckets+1];
            }
            else storage[primary] = new boolean[secondaryBuckets];
        }
        int secondary = getSecondaryIndex(key);
        storage[primary][secondary] = true;
    }
    
    public void remove(int key) {
        int primary = getPrimaryIndex(key);
        if(storage[primary] == null){
            return;
        }
        else{
            int secondary = getSecondaryIndex(key);
            storage[primary][secondary] = false;
        }
        
    }
    
    public boolean contains(int key) {
        int primary = getPrimaryIndex(key);
        if(storage[primary]==null){
            return false;
        }
        else{
            int secondary = getSecondaryIndex(key);
            return storage[primary][secondary];
        }
        
    }
}
