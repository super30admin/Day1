// Time Complexity :O(1) for all functions
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


public class MyHashSet {
    boolean[][] hashset;
    int primaryBucketItems;
    int secondaryBucketItems;

    public MyHashSet() {
        this.primaryBucketItems = 1000;//divide primary and secondary array size equally.
        this.secondaryBucketItems = 1000;
        this.hashset = new boolean[primaryBucketItems][];// setting primary array as null
    }

    private int primaryHashFunction(int key) {
        return key % primaryBucketItems;

    }

    private int secondaryHashFunction(int key) {
        return key / primaryBucketItems;

    }

    public void add(int key) {
        int priHashVal = primaryHashFunction(key);// primary array index
        if (hashset[priHashVal] == null) {
            if (priHashVal == 0) {
                hashset[priHashVal] = new boolean[secondaryBucketItems + 1];
            } else {
                hashset[priHashVal] = new boolean[secondaryBucketItems];// creating secondary array.initially all are
                                                                        // false.
            }

        }
        int secHashVal = secondaryHashFunction(key);// secondary array index
        hashset[priHashVal][secHashVal] = true;// setting array inside primary array, ie secondary array value as "T"
    }

    public void remove(int key) {
        int priHashVal = primaryHashFunction(key);
        if (hashset[priHashVal] == null) {// primary array is null that means No secondary array.so no such value.
            return;
        } else {
            int secHashVal = secondaryHashFunction(key);
            hashset[priHashVal][secHashVal] = false;// setting secondary array location as false;
        }
    }

    public boolean contains(int key) {
        int priHashVal = primaryHashFunction(key);
        if (hashset[priHashVal] == null) {// primary array is null that means No secondary array.
            return false;
        } else {// go to secondary bucket and see value as True or false
            int secHashVal = secondaryHashFunction(key);
            return hashset[priHashVal][secHashVal];

        }
    }

}
