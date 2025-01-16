/*
 * Memory:O(1) as our Max space can be 1000*1000
 * insertion:O(1)
 * removal:O(1)
 * contains:O(1)
 * Did this code successfully run on Leetcode :Yes
 */
class MyHashSet {
    
    private static final int SIZE = 1000;
    private boolean[][] storage;
    
    public MyHashSet() {
        storage = new boolean[SIZE][];
    }

    private int hash1(int key){
        return key%SIZE;
    }   

    private int hash2(int key){
        return key/SIZE;
    }
    public void add(int key) {
        int row = hash1(key);
        int col = hash2(key);
        if(storage[row]==null){
            if(row==0){
                storage[row] = new boolean[SIZE+1]; //TO HANDLE 0
            }
            else{
                storage[row] = new boolean[SIZE];
            }
        }
        storage[row][col] = true;
    }
    
    public void remove(int key) {
        int row = hash1(key);
        int col = hash2(key);
        if(storage[row]!=null){
            storage[row][col] = false;
        }
            
    }
    
    public boolean contains(int key) {
        int row = hash1(key);
        int col = hash2(key);
        if(storage[row]!=null){
            return storage[row][col];
        }
        return false;
    }
    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
        obj.add(10001);
        obj.remove(12432);
        boolean param_3 = obj.contains(10001);
        System.out.print(param_3);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
