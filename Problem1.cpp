// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: Design HashSet
// Approach: Double Hashing with 2D Array
// Time Complexity: O(1)

class MyHashSet
{
private:
    int bucketSize = 1000;
    int bucketItemsSize = 1000;
    vector<vector<bool>> storage;

public:
    MyHashSet()
    {
        storage.resize(bucketSize);
    }

    int getBucket(int key)
    {
        return key % bucketSize;
    }

    int getBucketItem(int key)
    {
        return key / bucketItemsSize;
    }

    void add(int key)
    {

        int bucket = getBucket(key);
        int bucketItem = getBucketItem(key);

        if (storage[bucket].empty())
        {

            if (bucket == 0)
            {
                storage[bucket].resize(bucketItemsSize + 1, false);
            }
            else
            {
                storage[bucket].resize(bucketItemsSize, false);
            }
        }

        storage[bucket][bucketItem] = true;
    }

    void remove(int key)
    {

        int bucket = getBucket(key);

        if (storage[bucket].empty())
        {
            return;
        }

        int bucketItem = getBucketItem(key);
        storage[bucket][bucketItem] = false;
    }

    bool contains(int key)
    {
        int bucket = getBucket(key);

        if (storage[bucket].empty())
        {
            return false;
        }

        int bucketItem = getBucketItem(key);
        return storage[bucket][bucketItem];
    }
};
