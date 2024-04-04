// Time Complexity : O(1)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


//take vector to store the keys;
class MyHashSet {
public:
    vector<vector<bool>> hash;
    int buckets = 1000;
    int bucketItems = 1000;

    MyHashSet() {
        hash.resize(1000, vector<bool>(1000));
    }
    
    void add(int key) {
        int hash1 = priHashFunc(key);
        int hash2 = secHashFunc(key);
        hash[hash1][hash2]=1;
    }
    
    void remove(int key) {
        int hash1 = priHashFunc(key);
        int hash2 = secHashFunc(key);
        hash[hash1][hash2]=0;
    }
    
    bool contains(int key) {
        int hash1 = priHashFunc(key);
        int hash2 = secHashFunc(key);
        return hash[hash1][hash2];
       
    }
private:
 int priHashFunc(int key) {
    return key % buckets;
 }    
 int secHashFunc(int key) {
    return key / bucketItems;
 }  
};
