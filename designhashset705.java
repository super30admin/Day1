class MyHashSet {
    /*
    Time Complexity : O(1)
    Space Complexity : O(N) N = 1000000 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this : No
    */
    boolean[][] set;

    public MyHashSet() {
        set = new boolean[1001][1001];
    }
    
    public void add(int key) {
        int position = getPosition(key);
        int bucket = getBucket(key);
        if(set[position]==null){
            set[position] = new boolean[1001];
        }
        set[position][bucket] = true;
        
    }
    
    public void remove(int key) {
        int position = getPosition(key);
        int bucket = getBucket(key);
        if(set[position]==null){
            return;
        }
        set[position][bucket]=false;
        
    }
    
    public boolean contains(int key) {
        int position = getPosition(key);
        int bucket = getBucket(key);
        if(set[position]==null){
            return false;
        }
        return set[position][bucket];
    }

    public int getPosition(int val){
        return val /1000;
    }
    public int getBucket(int val){
        return val % 1000;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */