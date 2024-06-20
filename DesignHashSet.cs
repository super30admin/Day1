public class MyHashSet {
    private bool[][] hset;
    private int primaryarrSize = 10000;
    private int secondaryarrSize = 100;
    private int hashfunc1;
    private int hashfunc2;
    
    
    public MyHashSet() {
        this.hset = new bool[primaryarrSize][];
        this.hset[0] = new bool[secondaryarrSize+1];
    }
    
    public void Add(int key) {
        hashfunc1 = key%primaryarrSize;
        hashfunc2 = key/primaryarrSize;
        
        if(hset[hashfunc1] == null){
            hset[hashfunc1] = new bool[secondaryarrSize];
        }
        hset[hashfunc1][hashfunc2] = true;
        return;
    }
    
    public void Remove(int key) {
        hashfunc1 = key%primaryarrSize;
        hashfunc2 = key/primaryarrSize;
        
        if(hset[hashfunc1] == null){
            return;
        }
        hset[hashfunc1][hashfunc2] = false;
        
        return;
    }
    
    public bool Contains(int key) {
         hashfunc1 = key%primaryarrSize;
        hashfunc2 = key/primaryarrSize;
         if(hset[hashfunc1] == null){
            return false;
        }
        
        
        return  hset[hashfunc1][hashfunc2];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.Add(key);
 * obj.Remove(key);
 * bool param_3 = obj.Contains(key);
 */