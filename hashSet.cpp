// Time Complexity : O(1)
// Space Complexity : O(n) - number of elements inserted in the hashSet
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

// Created a vector that has total 10^6 size.
class MyHashSet {
    vector<int> hash;
public:
    // Constructor to declare size of array and initialize all values to 0
    MyHashSet(): hash(1000001, 0) {
    }
    
    // set the index element to 1 of the key
    void add(int key) {
        hash[key] = 1;
    }
    
    // set the index element to 0
    void remove(int key) {
        hash[key] = 0;
    }
    
    // if the index element is 1 then return true else return 0
    bool contains(int key) {
        if (hash[key] == 1) {
            return true;
        }

        return false;
    }
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */