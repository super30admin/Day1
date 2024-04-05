#include <array>

#define STORAGE_SIZE 1001
#define BUCKET_SIZE 1000

using namespace std;


class MyHashSet {
private:
    array<array<bool, BUCKET_SIZE>, STORAGE_SIZE> hash_set; 

    int storage_hash_function(int key) {
        return key / (STORAGE_SIZE - 1);
    }

    int bucket_hash_function(int key) {
        return key % BUCKET_SIZE;
    }

public:
    MyHashSet() {
        for (auto& arr : hash_set) {
            arr.fill(false);
        }
    }
    
    void add(int key) {
        int storage_hash = storage_hash_function(key);
        int bucket_hash = bucket_hash_function(key);

        hash_set[storage_hash][bucket_hash] = true;
    }
    
    void remove(int key) {
        int storage_hash = storage_hash_function(key);
        int bucket_hash = bucket_hash_function(key);

        hash_set[storage_hash][bucket_hash] = false;
    }
    
    bool contains(int key) {
        int storage_hash = storage_hash_function(key);
        int bucket_hash = bucket_hash_function(key);

        return hash_set[storage_hash][bucket_hash];
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */