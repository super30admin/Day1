# Time Complexity : 
    # addition: O(1)
    # remove: O(1)
    # contains: O(1) 
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No Problems, I implemented the same problem with separate chaining as well.

# Your code here along with comments explaining your approach:
# - using double hashing to handle collisions
# - the size of the lists is the square root of the max value possible
# - increasing the length of the bucket at index 0, to accommodate 10^3
# - if a bucket is none, then it means no element already added to that index
# - if we get an index through our first hash function, then we initialize the second list at that index and compute the second index


class MyHashSet(object):

    def getBucket(self,key):
        return key % self.buckets
    
    def getBucketList(self,key):
        return key // self.bucketItems
   
    def __init__(self): 
        self.buckets = 1000
        self.storage = [None] * self.buckets
        self.bucketItems = 1000

    def add(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket = self.getBucket(key) # computing the index using the hash function
        bucketItem = self.getBucketList(key)

        if self.storage[bucket] is None:
            if bucket == 0:
                # adding one more bucketItem to accommodate 1000
                self.storage[bucket] = [False] * (self.bucketItems + 1)
            else:
                # no element exists, so we will initialize a list here, default value False
                self.storage[bucket] = [False] * self.bucketItems
        
        # second list already exists at this index
        # will change the value to True at that index
        self.storage[bucket][bucketItem] = True

    def remove(self, key):
        """
        :type key: int
        :rtype: None
        """
        bucket = self.getBucket(key) # computing the index using the hash function
        bucketItem = self.getBucketList(key)

        if self.storage[bucket] is None:
            # element does not exist
            return
        
        self.storage[bucket][bucketItem] = False

    def contains(self, key):
        """
        :type key: int
        :rtype: bool
        """
        bucket = self.getBucket(key) # computing the index using the hash function
        bucketItem = self.getBucketList(key)
    
        if self.storage[bucket] is None:
            return False

        # true if the value exists, false if not
        return self.storage[bucket][bucketItem]
         
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)