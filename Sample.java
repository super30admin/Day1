// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


//Create Hashset
class MyHashSet {
  //Craete array of boolean to indicate whether item is present in an Hashset or not
  //Storing true/false at an index in an array.
  //Ex if 7 is present in HashSet, arr[7] will set as true else set as false;
  //Time complexity o(1) and Space complexity o(1)
    boolean[] arr = new boolean[10000001];

    public MyHashSet() {
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

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
