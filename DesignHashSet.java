/*

Time Complexity: 0(1)
Space Complexity: 0(size)(size) worst case.
Approach: Used double hashing technique to solve this problem.
Run on LeetCode: Yes

*/
class MyHashSet {

    // data members
    private boolean[][] hashSet;
    private int size; //key limit is 100,000

    // intialize the constructor
    public MyHashSet() {

        // initialize primary array only, initialized with NULL value
        // leave secondary array as blank

        this.size = 1000;
        this.hashSet = new boolean[size][];
    }

    // initialize hash function
    private int hashFunction1(int key){
        // take module
        return key%this.size;
    }

    private int hashFunction2(int key){
        // take division
        return key/this.size;
    }
    public void add(int key) {
        int idx1 = this.hashFunction1(key);
        // check if idx1 is NULL
        if (this.hashSet[idx1] == null){
            // initialize a secondary array at this position
            // case -- idx1 = 0
            if (idx1 == 0){
                // store key = 100,000 at 1001 index
                this.hashSet[idx1] = new boolean[this.size + 1];
            }
            else{
                this.hashSet[idx1] = new boolean[this.size];
            }
        }
        int idx2 = this.hashFunction2(key);

        // mark the entry as TRUE
        this.hashSet[idx1][idx2] = true;

        return;
    }
    
    public void remove(int key) {
        int idx1 = this.hashFunction1(key);

        // base-case
        if (this.hashSet[idx1] == null){
            return;
        }

        int idx2 = this.hashFunction2(key);
        this.hashSet[idx1][idx2] = false; // mark the value as false
        //remember the notes discussion
        return;
    }
    
    public boolean contains(int key) {
        int idx1 = this.hashFunction1(key);

        // base-case
        if (this.hashSet[idx1] == null){
            return false;
        }

        int idx2 = this.hashFunction2(key);

        if (this.hashSet[idx1][idx2] == false){
            return false;
        }
        return true;
    }
}
