// Time Complexity : for add, remove and contains method TC will be O(1)
// Space Complexity : 1000001 * SC(1)
// Did this code successfully run on Leetcode : Yes, but it is not optimized solution
// Any problem you faced while coding this : I have a query approach 2 take less space because boolean take less space than Integer? I have this query because in some place I found both occupy 4 bytes


// Your code here along with comments explaining your approach
class MyHashSet {
    Integer[] arr;
    public MyHashSet() {
        arr = new Integer[1000001];
        Arrays.fill(arr, 0);
    }
    
    public void add(int key) {
        arr[key] = 1;
    }
    
    public void remove(int key) {
        arr[key] = 0;
    }
    
    public boolean contains(int key) {
        if (arr[key] == 1)
            return true;
        return false;
    }
}

Approach 2

class MyHashSet {
    private boolean[] mp;

    public MyHashSet() {
        mp = new boolean[1000001];
        Arrays.fill(mp, false);
    }

    public void add(int key) {
        mp[key] = true;
    }

    public void remove(int key) {
        mp[key] = false;
    }

    public boolean contains(int key) {
        return mp[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */