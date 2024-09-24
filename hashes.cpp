class MyHashSet {

private:
    static const int SIZE = 1000001;
    bool hashSet[SIZE];
public:
    MyHashSet() {
        for (int i =0; i < SIZE; i++){
            hashSet[i] = false;
        }
    }
    
    void add(int key) {
        hashSet[key] = true;
    }
    
    void remove(int key) {
        hashSet[key] = false;
    }
    
    bool contains(int key) {
        return hashSet[key];
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */
