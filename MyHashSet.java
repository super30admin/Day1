//1. 

// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class MyHashSet {
    boolean[] a ;
        public MyHashSet() {
             a = new boolean[1000001];
        }
        
        public void add(int key) {
             a[key] = true;
        }
        
        public void remove(int key) {
            a[key] = false;
        }
        
        public boolean contains(int key) {
            return a[key];
        }
    }

