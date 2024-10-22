//brute
// Time Complexity : O(1)
// Space Complexity : O(n)  //size of vect
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this :no
//approach
// we will create a vector and a size int and now will set the size acc to the range ie 10^6
//now in add if the element is the present we will mark that key as 1
// in remove we will assign the key as 0
//contains will give the value at that index
class MyHashSet {
public:
    vector<int>m;
    int siz;
    MyHashSet() {
        siz = 1e6+1;
        m.resize(siz);
    }
    
    void add(int key) {
        m[key] =1;
    }
    
    void remove(int key) {
        m[key] =0;
    }
    
    bool contains(int key) {
        return m[key];
    }
};