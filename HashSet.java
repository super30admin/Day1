// Overall Time Complexity : O(1) . The operations add, remove, contains have time complexity of O(1).
// Overall Space Complexity : O(n) . The space complexity of storing the keys in the hashset.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No issues faced during implementation


// The HashSet uses the technique of double hashing to implement the hashset.
// The boolean 2 dimensional array is used to store the keys in the bucket items and the buckets hold the references to the bucket item list.

public class HashSet {
    private boolean arr[][];
    private int buckets;
    private int  bucket_items;

    private int hashBucket(int key){
        return key%buckets;

    }
    private int hashBucketItems(int key){
        return key/bucket_items;

    }

    public HashSet() {
        this.buckets = 1000;
        this.bucket_items = 1000;
        this. arr = new boolean[buckets][];    
    }
    
    public void add(int key) {
        int bucket = this.hashBucket(key);
        if (arr[bucket] == null){
            if(bucket == 0){
                arr[bucket] = new boolean[bucket_items+1];
            }
            else{
                arr[bucket] = new boolean[bucket_items];
            }
            
        }
        int bucket_item = this.hashBucketItems(key);
        arr[bucket][bucket_item] = true;
        
    }
    
    public void remove(int key) {
        int bucket = this.hashBucket(key);
        if (arr[bucket] == null){
            return;
        }
        int bucket_item = hashBucketItems(key);
        arr[bucket][bucket_item] = false;
    }
    
    public boolean contains(int key) {
        int bucket = this.hashBucket(key);
        if (arr[bucket] == null){
            return false;
        }
        int bucket_item = this.hashBucketItems(key);
        return arr[bucket][bucket_item];
    }
}
