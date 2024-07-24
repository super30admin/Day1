// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
//Approach: The below approach helps in managing collisions and distribute the hash values efficiently. In primaryBucket the value at the index is the presence of an element, NestedBucket is to handle collisions.

public class DesignHashSet {

    private boolean[][] storage;
    private int primaryBucket;
    private int nestedBuckets;
    public DesignHashSet() {
        this.primaryBucket=1000;
        this.nestedBuckets=1000;
        this.storage = new boolean[primaryBucket][];
    }

    //Get index of the first bucket
    public int bucket(int key){
        return key%primaryBucket;
    }

    //Get index of nestedBucket
    public int nestedBucket(int key){
        return key/nestedBuckets;
    }

    public void add(int key){
        //Get index of the first bucket
        int bucket = bucket(key);
        // Get index of nestedBucket
        int nestedBucket = nestedBucket(key);
        if(storage[bucket]==null){
            if(bucket==0){
                storage[bucket] = new boolean[nestedBuckets + 1];
            }
            storage[bucket] = new boolean[nestedBuckets];
        }
        storage[bucket][nestedBucket]=true;
    }

    public void remove(int key){
        int bucket = bucket(key);
        int nestedBucket = nestedBucket(key);
        //If the initial bucket is empty we can directly return don't have to check for the nested bucket.
        if(storage[bucket]==null){
            return;
        }
        storage[bucket][nestedBucket]=false;
    }

    public boolean contains(int key){
        int bucket = bucket(key);
        int nestedBucket = nestedBucket(key);
        //If the initial bucket is empty we can directly return false as the nested bucket will also be null.
        if(storage[bucket]==null){
            return false;
        }
        return storage[bucket][nestedBucket];
    }
    public static void main(String[] args) {
        DesignHashSet designHashSet = new DesignHashSet();
        designHashSet.add(1);
        designHashSet.add(25);
        designHashSet.contains(25);
        designHashSet.contains(0);
        designHashSet.remove(25);
        designHashSet.contains(25);
        System.out.println("HashSet contains " + designHashSet.contains(25));
    }

}
