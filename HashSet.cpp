// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I struggled a bit in finding the right way to declare 2d array and initializing only outer array.
// is there a better way to do this in c++?

#include <iostream>
using namespace std;
class MyHashSet {
    private:
    int size_bucket = 1000;
    int size_item = 1000;
    bool** storage;

    int h1(int key){
        return key%size_bucket;
    }

    int h2(int key) {
        return key/size_item;
    }
public:

    MyHashSet() {
        storage = new bool*[size_bucket];
        for (int i = 0; i < size_bucket; ++i) {
            storage[i] = nullptr;  // Initialize all pointers to nullptr
        }
    }
    
    void add(int key) {
        int bucket_ind = h1(key);
        int item_ind = h2(key);
        if (storage[bucket_ind] == nullptr){
            if(bucket_ind==0) storage[bucket_ind] = new bool[size_item+1]();
            else storage[bucket_ind] = new bool[size_item]();
        }     
        storage[bucket_ind][item_ind] = true;
    }
    
    void remove(int key) {
        int bucket_ind = h1(key);
        int item_ind = h2(key);
        if (storage[bucket_ind] == nullptr) return;
        storage[bucket_ind][item_ind] = false;
    }
    bool contains(int key) {
        int bucket_ind = h1(key);
        int item_ind = h2(key);
        if (storage[bucket_ind] == nullptr) return false;
        return storage[bucket_ind][item_ind];
    }
};

