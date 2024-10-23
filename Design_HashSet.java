// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : Formulating the idea of using boolean

class MyHashSet {
    boolean[] b ;
    public MyHashSet() {
     //Creating boolean array of size = key max value
     this.b= new boolean[1000001]; 
    }
    
    public void add(int key) {
        //setting True for the key index
        b[key]=true;
    }
    
    public void remove(int key) {
        //setting False for the key index
        b[key]=false;
    }
    
    public boolean contains(int key) {
        // Returning the value at index Key
        return b[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */