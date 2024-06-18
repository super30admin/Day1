/*
 * Design-1 : HashSet
 *
 * Problem 1:(https://leetcode.com/problems/design-hashset/)
 *
 * Time Complexity  : Average case : O(1) : Worst case : O(n), where n is the key
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : -
 * Your code here along with comments explaining your approach :
 *      Brute force approach : Using Vectors
 *          - Creating a vector of size 10e6 with all zeroes, and adding 1 at the index value 
 *            of the element. If present, contains and no need to handle anything.
 *          -  Cons : Cannot handle dataset which would be greater than 10e6.
 *      Optimal approach : Using hashing
 *          - Generate a hash code and place the element at the index returned by the hashing function.
 *          - For handling collisions, use doubly-linked list to hold multiple values at same index.
 */

/*
 * Brute force :
 *
 * class MyHashSet {
    public:
    vector<int> hash;
        
    MyHashSet() {
       hash.resize(1e6+1); 
    }
    
    void add(int key) {
        if (!contains(key)) {
            hash[key] = 1;
        }
    }
    
    void remove(int key) {
        hash[key] = 0;
    }
    
    bool contains(int key) {
        if (hash[key]) return true;
        else return false;
    }
};

 *
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */

#include<iostream>
#include<vector>
#include<list>

using namespace std;

class HashMap {
    public :
        vector<list<int> > hashmap;
        int size;
    
    HashMap() {
        size = 100;
        hashmap.resize(size);
    }

    int hashkey(int key) {
        return key%size;
    }

    list<int>::iterator search(int key) {
        int i = hashkey(key);
        return find(hashmap[i].begin(), hashmap[i].end(), key);
    }

    bool contains(int key) {
        int i = hashkey(key);

        if(search(key) != hashmap[i].end()) {
            return true;
        }

        return false;
    }

    void add(int key) {
        int i = hashkey(key);

        if (!contains(key)) {
            hashmap[i].push_back(key);
        }
    }

    void remove(int key) {
        int i = hashkey(key);

        if(contains(key)) {
            hashmap[i].erase(search(key));
        }
    }
};

int main() {
    HashMap* obj = new HashMap();
    obj->add(2);
    obj->remove(3);
    bool param_3 = obj->contains(2);cout << "Contains 2: " << param_3 << endl; // Expected output: 1 (true)
    obj->add(2);
    cout << "Contains 2: " << obj->contains(2) << endl; // Expected output: 1 (true)
    obj->remove(2);
    cout << "Contains 2: " << obj->contains(2) << endl; // Expected output: 0 (false)
    delete obj;
    return 0;
}

