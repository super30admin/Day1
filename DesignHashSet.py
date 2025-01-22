"""
Approach (double hashing) --
1. Based on constraints, take the primary array range to be sqrt(10^6)
2. Use mod hash function to get index of the element in primary array
3. For add(), if there's no value present at this index, we initiate a Boolean secondary array of size sqrt(10^6)
4. For the secondary array we use division hash function. why division? -> since if mod is used again, all the elements which were earlier causing collision, will again collide at the same index in secondary array

why secondary array data type is Boolean?
since size is smaller than storing an int

TC - O(1) for add, remove, contains since constant lookup
SC - O(n) since using array of size n
"""


class MyHashSet:

    def __init__(self):
        self.buckets = 1000
        self.bucketItems = [None] * self.buckets

    # primary array hash function
    def getBucket(self, key):
        return key % self.buckets

    # secondary array hash function
    def getBucketItems(self, key):
        return key // self.buckets

    def add(self, key: int) -> None:
        bucket = self.getBucket(key)
        bucketItem = self.getBucketItems(key)

        # edge case when we need to add at 0th index
        # if required to add 1000000. 1000000%1000 = 0 and 1000000//1000 = 1000
        # we have 0 to 999 in the secondary array so for 1000000, we'll get index out of range
        if not self.bucketItems[bucket] and bucket == 0:
            self.bucketItems[bucket] = [False] * (self.buckets + 1)

        # initialize secondary array
        elif not self.bucketItems[bucket]:
            self.bucketItems[bucket] = [False] * self.buckets

        # add the element
        self.bucketItems[bucket][bucketItem] = True

    def remove(self, key: int) -> None:
        bucket = key % self.buckets
        bucketItem = key // self.buckets

        # if secondary array not present, return False
        if not self.bucketItems[bucket]: return False

        # remove item by marking it False
        self.bucketItems[bucket][bucketItem] = False

    def contains(self, key: int) -> bool:
        bucket = key % self.buckets
        bucketItem = key // self.buckets

        # if secondary array not present, return False
        if not self.bucketItems[bucket]: return False

        return self.bucketItems[bucket][bucketItem]

# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)