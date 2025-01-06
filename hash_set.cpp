// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MyHashSet {
public:
    int bucketSize =1000;
    int bucketItemsSize=1000;
    vector<vector<bool>> storage;
    
    //Initializing size of primary array
    MyHashSet(){
        storage.resize(bucketSize);
    }
    int getBucket(int key){
        return key%bucketSize;
    }
    int getBucketItem(int key){
        return key/bucketItemsSize;
    }
    void add(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        //bucket items does not exist, creating one(creating secondary array) after checking it.
        if(!storage[bucket].size()){
            if(bucket ==0){
                storage[bucket].resize(bucketItemsSize+1,false);
            }
            storage[bucket].resize(bucketItemsSize,false);
        }
        storage[bucket][bucketItem]=true;
    }
    
    void remove(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        //checking if bucket exists before checking bucketItem to avoid undefined index error.
        if(!storage[bucket].size()){
            return;
        }
        else{
            storage[bucket][bucketItem] = false;
        }
    }
    
    bool contains(int key) {
        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);
        if(!storage[bucket].size()){
            return false;
        }
        else{
            if(storage[bucket][bucketItem]){
                return true;
            }
            else{
                return false;
            }
        }
    }   
};

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet* obj = new MyHashSet();
 * obj->add(key);
 * obj->remove(key);
 * bool param_3 = obj->contains(key);
 */