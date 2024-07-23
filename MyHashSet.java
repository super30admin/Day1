// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : seleting boolean array datatype instead of int

class MyHashSet {

    boolean[] hash;

    public MyHashSet() {
        hash = new boolean[1000001];
    }
    
    public void add(int key) {
        hash[key] = true;
    }
    
    public void remove(int key) {
        hash[key] = false;
    }
    
    public boolean contains(int key) {
        return hash[key];
    }
}