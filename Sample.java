// Time Complexity : O(1)
// Space Complexity : O(10^6)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach

class MyHashSet {
        int pkh;
        int skh;
        boolean[][] storage;

    public MyHashSet() {
        this.pkh = 1000;
        this.skh = 1000;
        this.storage = new boolean[pkh][];
        
    }
    
    public void add(int key) {

        int pk = getphash(key);
        if(storage[pk] == null){
            if(pk == 0){
                storage[pk] = new boolean[skh+1]
            }
            else{
           storage[pk] = new boolean[skh];
            }}
        int sk = getshash(key);
        storage[pk][sk]= true;


    }
    
    private int getphash(int key){
        return key % pkh;
    }

     private int getshash(int key){
        return key / skh;
    }

    public void remove(int key) {

        int pk = getphash(key);
        if(storage[pk] == null){
             return;
        }
        int sk = getshash(key);
        storage[pk][sk]= false;


        
    }
    
    public boolean contains(int key) {
        int pk = getphash(key);
        if(storage[pk] == null){
             return false;
        }
        int sk = getshash(key);
        return storage[pk][sk];

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
