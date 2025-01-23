// Time Complexity : O(1) for all operations
// Space Complexity : O(n) where n is the number of elements in the hashset
// Did this code successfully run on Leetcode : Yes
// Approach: I am using 2D array where primary array is of size 1000 and secondary array is of size 1000. I am using 2 hash functions to calculate the index of the primary and secondary array. I am using boolean values to store the values in the hashset. If the value is present in the hashset, I am setting the value to true. If the value is removed from the hashset, I am setting the value to false. If the value is not present in the hashset, I am returning false.

class MyHashSet {

    boolean[][] values;
    int buckets;
    int bucketItems;

    public MyHashSet() {
        buckets = 1000;
        bucketItems = 1000;
        values = new boolean[buckets][];
    }

    private int hash1(int key){
        return key%buckets;
    }

    private int hash2(int key){
        return key/bucketItems;
    }

    public void add(int key) {
        int index1 = hash1(key);
        int index2 = hash2(key);

        if(values[index1] == null){
            if(index1 == 0){
                values[index1] = new boolean[bucketItems+1];
            }else{
                values[index1] = new boolean[bucketItems];
            }
        }
        values[index1][index2] = true;
    }

    public void remove(int key) {
        int index1 = hash1(key);
        int index2 = hash2(key);

        if(values[index1] == null){
            return;
        }else{
            values[index1][index2] = false;
        }
    }

    public boolean contains(int key) {
        int index1 = hash1(key);
        int index2 = hash2(key);

        if(values[index1] == null){
            return false;
        }
        return values[index1][index2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */