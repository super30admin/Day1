// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A.



class MyHashSet {
public:
    MyHashSet() {
        hash_set.fill(-1); // default keys to be -1. since requirement mentions key will alwasy be > 0
    }
    
    void add(int key) {
        if(contains(key) == true)
        {
            // Technically this check is not needed, adding for clarity
            // Do nothing. As key alreayd exist.
            // Requirement says do nothing in this case. 
            return;
        }

        hash_set[key] = key;
        
    }
    
    void remove(int key) {

        if(contains(key) == false)
        {
            // Technically this check is not needed, adding for clarity
            // Do nothing. As key doesn't exist.
            // Requirement says do nothing in this case. 
            return;
        }

        hash_set[key] = -1; // replace key with default value
        
    }
    
    bool contains(int key) {

        if(hash_set[key] == -1)
        {
            return false;
        }

        return true;
        
    }
private: 
    std::array<int,1000001> hash_set; // It is given that key will not exceed 10^6. 
};
