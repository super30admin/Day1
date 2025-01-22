// Hashset

// Time Complexity: O(n) for all operations(checking if exists for add, iterating through for remove and contains)
// Space complexity: O(n)
// Code ran successfully on leetcode

 //Approach: 
// I assumed I can use a dynamic array. Used a vector based implementation by starting with initial size of 10. 
// Since sets does not have duplicates, checked if key already exists before adding. 
// For remove and contains I iterate through to check if already exists. 
// I feel like not efficient as lookup should be O(1)



class MyHashSet {
public:
    vector <int> data; //Assuming we can use dynamic arrays

    MyHashSet() {
        data.reserve(10);
    }
    
    void add(int key) {
        if(!contains(key)){data.push_back(key);}
    }
    
    void remove(int key) {
        for(int i = 0; i < data.size(); i++){
            if(data[i] == key){
                data.erase(data.begin() + i);
                return;
            }
        }
    }
    
    bool contains(int key) {
        for(int i : data){
            if(i == key){return true;}
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