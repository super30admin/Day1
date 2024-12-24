// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Used an array to store the elements. Intialized all indexes with -1 and then stored the position till last element was actually filled. 

public class MyHashSet {

    int[] set;
    int pos = 0; 
    public MyHashSet() {
        set = new int[1000000];
        for (int i = 0; i < set.length; i++) {
            set[i] = -1;
        }
    }
    
    public void add(int key) {
        if (!contains(key)) {
            set[pos++] = key; 
        }
    }
    
    public void remove(int key) {
        for (int i = 0; i < pos; i++) {
            if (set[i] == key) {
                for (int j = i; j < pos - 1; j++) {
                    set[j] = set[j + 1];
                }
                set[--pos] = -1;
                break;
            }
        }
    }
    
    public boolean contains(int key) {
        for (int i = 0; i < pos; i++) { 
            if (set[i] == key) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
