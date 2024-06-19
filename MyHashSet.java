class MyHashSet {

    int[] keySet = new int[5];
    public MyHashSet() {
        keySet = new int[5];
    }

    public void add(int key) {
        this.keySet[key] = key;
    }

    public void remove(int key) {
        this.keySet[key] = Integer.MIN_VALUE;
    }

    public boolean contains(int key) {
        boolean exists = false;
        for(int i=0;i<this.keySet.length;i++) {
            if(this.keySet[i] == i && i == key) {
                exists  =true;
                break;
            }
        }
        return exists;
    }
}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */