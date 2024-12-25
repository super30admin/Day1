// Time Complexity : O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here along with comments explaining your approach

class MyHashSet
{
public:
    vector<vector<bool>> bucket;
    int size = 1000;
    MyHashSet()
    {
        bucket.resize(size);
    }

    // 1st hash function
    int getBucket(int val)
    {
        return val % size;
    }

    // 2nd hash function
    int getBucketItem(int val)
    {
        return val / size;
    }

    void add(int key)
    {
        // validate if the bucket is required to be created
        if (bucket[getBucket(key)].empty())
        {
            bucket[getBucket(key)].resize(size);
            bucket[getBucket(key)][getBucketItem(key)] = true;
        }
        else
        {
            bucket[getBucket(key)][getBucketItem(key)] = true;
        }
    }

    void remove(int key)
    {
        // validae if the bucket exists and update using the item to false using 2nd hash function
        if (!bucket[getBucket(key)].empty())
        {
            bucket[getBucket(key)][getBucketItem(key)] = false;
        }
    }

    bool contains(int key)
    {
        // validate if the bucket is not empty and the value exists
        if (!bucket[getBucket(key)].empty() && bucket[getBucket(key)][getBucketItem(key)] == true)
        {
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