// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/*
    TC - O(1)
    SC - O(10^6 + 1) ~ O(1)
    Approach - I have used the boolean array with the maximum size mentioned in the problem
    and using the index as the key/element for the manipulation of add, remove and contains to return the result.
*/

class MyHashSet {

    boolean arr[];

    public MyHashSet() {
        arr = new boolean[1000000 + 1];
    }

    public void add(int key) {
        arr[key] = true;
    }

    public void remove(int key) {
        arr[key] = false;
    }

    public boolean contains(int key) {
        return arr[key];
    }
}
