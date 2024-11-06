// first we need to decide the size of the primary data structures and 
// secondary data startucures
// the primary data structure to design a hashset should be an array
// but for the secondary data structure we can use multiple
// as we will need the secondary data structure to take the collition
// collition is the scenario when a multiple keys is assigned to same memory block by the hash code
// some collition handling techniques are
// 1. linear probing
// 2. quadratic probing
// 3. BST chaining
// 4. linear chaining
// 5. Double hashing
// we will be using the double hashing technique in this solution

// for the double hashing we will need two array the size of each array should be sqrt(n) so that
// we can create a balance between primary and secondary arrays

class MyHashSet {
public:
    int primaryBuckets;
    int secondaryBuckets;
    bool** storage;

    MyHashSet() {
        this ->primaryBuckets = 1001;
        this ->secondaryBuckets = 1001;
        storage = new bool*[primaryBuckets];
        for(int i = 0 ; i < primaryBuckets;i++)
        {
            storage[i]= nullptr;
        }
    }

    // we will need two hash functions 
    int primaryHashFunction (int key){
        return (key % primaryBuckets);
    }

    int secondaryHashFunction (int key){
        return (key / secondaryBuckets);
    }
    
    void add(int key) {
        // to add the key
        int primaryKey = primaryHashFunction(key);
        if(storage[primaryKey] == NULL)
        {
            storage[primaryKey] = new bool[secondaryBuckets]();
        }
        int secondaryKey = secondaryHashFunction(key);
        storage[primaryKey][secondaryKey] = true;
    }
    
    void remove(int key) {
        // to search for the key
        int primaryKey = primaryHashFunction(key);
        if(storage[primaryKey] == NULL)
        {
            return;
        }
        int secondaryKey = secondaryHashFunction(key);
        storage[primaryKey][secondaryKey] = false;
        return;
    }
    
    bool contains(int key) {
        int primaryKey = primaryHashFunction(key);
        if(storage[primaryKey] == NULL)
        {
            return false;
        }
        int secondaryKey = secondaryHashFunction(key);
        return storage[primaryKey][secondaryKey];
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */