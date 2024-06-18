class MyHashSet {
    boolean[] hs;

    public MyHashSet() {
        hs = new boolean[1000001];
    }
    
    public void add(int key) {
        hs[key] = true;
    }
    
    public void remove(int key) {
        hs[key] = false;
    }
    
    public boolean contains(int key) {
        return hs[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */