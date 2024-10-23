//705. Design HashSet - https://leetcode.com/problems/design-hashset/description/

//Time Complexity: for all operations is O(1)
//Space Complexity: O(1)

class MyHashSet {

    int primaryIndex = 1000; //square root of the number gives the index values
    int secondaryIndex = 1001; //to handle an edge case if the number to store is 1000, as the index will be 0-999,
    // add an extra space to handle 1000

    boolean[][] storage = new boolean[primaryIndex][];

    private int hash(int key){
        return key % primaryIndex;
    }

    private int nestedHash(int key){
        return key / secondaryIndex;
    }
    /** Initialize data structure here. */
    public MyHashSet() {
        this.primaryIndex = primaryIndex;
        this.secondaryIndex = secondaryIndex;
        this.storage = storage;
    }
    /** Add key into the HashSet */
    public void add(int key) {
        int index = hash(key);
        int nestedIndex = nestedHash(key);

        if(storage[index]==null){
            storage[index]=new boolean[secondaryIndex];
        }
        storage[index][nestedIndex]=true;
    }
    /** Remove key from the HashSet */
    public void remove(int key) {
        int index = hash(key);
        int nestedIndex = nestedHash(key);
        if(storage[index]!=null){
            storage[index][nestedIndex]=false;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = hash(key);
        int nestedIndex = nestedHash(key);
        // if storage is not empty -> true
        if(storage[index]!= null && storage[index][nestedIndex]){
            return true;
        }
        return false;

    }
}