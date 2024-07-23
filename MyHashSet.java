// Problem 705: Design HashSet
// Time Complexity : O(1) (add, remove, contains)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
I have used boolean array.
If we look at the question, contains method is boolean, and we need to return boolean value only.
So, instead of storing values directly, we can store boolean value like when adding a value we can insert true and for remove false.
*/

class MyHashSet {
    private final int cap = 1000001;
    private boolean[] set;

    public MyHashSet() {
        set = new boolean[cap];
    }

    public void add(int key) {
        set[key] = true;
    }

    public void remove(int key) {
        set[key] = false;
    }

    public boolean contains(int key) {
        return set[key];
    }
}
