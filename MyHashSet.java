// Time Complexity : O(1) - add, remove, contains
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
public class MyHashSet {
    /**
     *  since key is positive integer upto 10^6, we can use a boolean[]
     *  to know if a key/index exists or not based on the flag value at that index in hashSet array
     */
    boolean[] hashSet;

    /**
     * Constructor to initialize boolean[] hashSet
     * Since key is: 0 <= key <= 10^6, size of boolean[] is (10^6 + 1)
     */
    public MyHashSet() {
        this.hashSet = new boolean[1000001];
    }

    /**
     * Set the index to true based on the key being added
     * Time complexity: O(1) since using an array provides random access based on index
     *
     * @param key key to be added to set
     */
    public void add(int key) {
        this.hashSet[key] = true;
    }

    /**
     * Reset the index to false based on the key being removed
     * Time complexity: O(1) since using an array provides random access based on index
     *
     * @param key key to be removed from set
     */
    public void remove(int key) {
        this.hashSet[key] = false;
    }

    /**
     * If a key exists in boolean[] hashSet, that index is set to true,
     * otherwise it is set to false
     * Time complexity: O(1) since using an array provides random access based on index
     *
     * @param key key to be looked for in the hashSet
     * @return true if exists in the hashSet, false otherwise
     */
    public boolean contains(int key) {
        return this.hashSet[key];
    }
}
