

Explain your approach in **three sentences only** at top of your code

# Design-1

## Problem 1:(https://leetcode.com/problems/design-hashset/)

Used a 2D array to design a hashset. Stored boolean values to reduce space complexity.

Time Complexity: O(1)
Space Complexity: O(N)

class MyHashSet {

    boolean[][] mySet;
    public int[] hash(int key) {
        int index1 = key % 1000;
        int index2 = key / 1000;
        return new int[]{index1, index2};
    }

    public MyHashSet() {
        mySet = new boolean[1001][];
    }
    
    public void add(int key) {
        int[] indices = hash(key);
        if(mySet[indices[0]] == null) {
            mySet[indices[0]] = new boolean[1001];
        }
        mySet[indices[0]][indices[1]] = true;  
    }
    
    public void remove(int key) {
        int[] indices = hash(key);
        if(mySet[indices[0]] != null) {
            mySet[indices[0]][indices[1]] = false;
        }
    }
    
    public boolean contains(int key) {
        int[] indices = hash(key);
        if(mySet[indices[0]] == null) {
            return false;
        }
        return mySet[indices[0]][indices[1]]; 
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

## Problem 2:
Design MinStack (https://leetcode.com/problems/min-stack/)




