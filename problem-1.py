# Time Complexity :

# getBucket: O(1)
# getBucketIndex: O(1)
# add: O(1)
# remove: O(1)
# contain: O(1)

# space complexity : O(n)

# Approach :

# since keys can be 10^6 , take sqrt of 10^6 == 10^3, and assign this to bucket size and bucket items size
# In case of a add operation, check if the bucket is empty or not, if empty, first assign a array to that bucket, and then based on the bucketIndex assign it a index in the secondary array
# In case of a remove operation, return nothing if that bucket is empty, else based on the bucket and bucket item index just make it False
# In case of a contains operation, return nothing if bucket is empty, else return true if the key is equal to the array at the index of bucket and bucket item index

class MyHashSet:

    def __init__(self):
        self.bucket = 1000
        self.bucketItem = 1000
        self.storage = [None]*self.bucket

    def getBucket(self, key):

        return key % self.bucket

    def getBucketIndex(self, key):

        return key // self.bucketItem

    def add(self, key: int) -> None:

        bucketValue = self.getBucket(key)
        bucketIndex = self.getBucketIndex(key)

        if (self.storage[bucketValue] == None):
            if (bucketValue == 0):
                self.storage[bucketValue] = [False] * (self.bucketItem + 1)
            else:
                self.storage[bucketValue] = [False] * self.bucketItem

        self.storage[bucketValue][bucketIndex] = True

    def remove(self, key: int) -> None:

        bucket = self.getBucket(key)
        bucketIndex = self.getBucketIndex(key)

        if (self.storage[bucket] == None):
            return

        self.storage[bucket][bucketIndex] = False

    def contains(self, key: int) -> bool:
        bucket = self.getBucket(key)
        bucketIndex = self.getBucketIndex(key)

        if (self.storage[bucket] == None):
            return False

        if (self.storage[bucket][bucketIndex] == True):
            return True


obj = MyHashSet()
obj.add(3)
# obj.remove(3)
param_3 = obj.contains(3)
print(param_3)
