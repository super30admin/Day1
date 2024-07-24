// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Took me a long time, to understand the boolean approach and 
//the idea that hashing really would solve the problem of using a very large sized array such as what I used in this program.
// hashing would cut the size of the array drastically.


/**
* Implemented HashSet using a boolean array
* For each key, the object array will return true if the key exists, or false if the key is removed.
* The value will be set as true if the key is added and false, which is default value if value is removed or does not exist.
**/
public class MyHashSet {
    boolean[] obj;

    public MyHashSet() {
        // initializations
        // reason for using 1000001, is because there is index out of bounds exception when 1000000 is used.
        obj = new boolean[1000001];
        
    }
    
    public void add(int key) {
        obj[key] = true;
        
    }
    
    public void remove(int key) {
        obj[key] = false;
        
    }
    
    public boolean contains(int key) {
        return obj[key];
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */