/*
    Leetcode problem 705: Design HashSet
    T.C: add() - O(1), remove - O(1), contains - O(1)
    S.C: Θ(1) - Average case (as we are expected to create a hashset to store - 0 <= key <= 10^6)
         O(10^6) - If we consider that all the values between 0 - 10^3 is initialed in the HashSet
    
    Designed the HashSet using Primary Array and Seconday Array
    The Primary array size is selected based on the range of input size (i.e 0 <= key <= 10^6)
    which is sqrt(10^6) = 10^3 and a seconday array of the remaining size 10^3 is initailzed as
    we receive elements from add(key) and the index of the secondary array to store the element
    is based on the Hash Function that is selected.
    Hash Function - Select primary array index -> key % 10^3 and sec array index -> key / 10^3
*/

class MyHashSet {

    boolean[][] storage;
    int buckets;
    int bucketItems;

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        storage = new boolean[buckets][];
    }
    
    private int getBucket(int key) {
        return key % buckets;
    }

    private int getBucketItem(int key) {
        return key / bucketItems;
    }

    public void add(int key) {
        //Index in the primary array - first hash function
        int bucket = getBucket(key);
        //Index in secondary array - second hash function
        int bucketItem = getBucketItem(key);
        //Check if the secondary array is initialized
        //(i.e in this case column of the 2D array)
        if(storage[bucket] == null) {
            if (bucket == 0) {
                storage[bucket] = new boolean[bucketItems + 1];
            } else {
                storage[bucket] = new boolean[bucketItems];
            }
        }
        if (storage[bucket][bucketItem]) {
            return;
        } else {
            storage[bucket][bucketItem] = true;
        }        
    }
    
    public void remove(int key) {
        //Index in the primary array - first hash function
        int bucket = getBucket(key);
        //Index in secondary array - second hash function
        int bucketItem = getBucketItem(key);
        //Check if the secondary array is initialized
        if (storage[bucket] == null) {
            return;
        }
        if (storage[bucket][bucketItem]) {
            storage[bucket][bucketItem] = false;
        } else {
            return;
        }
    }
    
    public boolean contains(int key) {
        //Index in the primary array - first hash function
        int bucket = getBucket(key);
        //Index in secondary array - second hash function
        int bucketItem = getBucketItem(key);
        //Check if the secondary array is initialized
        if (storage[bucket] == null) {
            return false;
        }

        return storage[bucket][bucketItem];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */