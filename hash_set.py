
""" 
Time Complexity : add/remove/contains - O(1)
Space Complexity : add/remove/contains - O(1) - Amortized
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
"""

class MyHashSet:
    # limit = 1,000,0000
    def __init__(self):
        self.totalBuckets = 1000
        self.totalBucketItems = 1000
        self.storage = [0] * self.totalBucketItems

    # hash
    def findBucketNumber(self, key:int) -> int:
        return key % self.totalBuckets 

    def findBucketItemIdx(self, key:int) -> int:
        return key // self.totalBucketItems

    def add(self, key:int) -> None: 
        bucketNumber = self.findBucketNumber(key)
        if self.storage[bucketNumber] == 0:
            if bucketNumber == 0:
                # 1 additional spot
                self.storage[bucketNumber] = [0] * (self.totalBucketItems + 1)
            else:
                self.storage[bucketNumber] = [0] * self.totalBucketItems
        bucketItemIdx = self.findBucketItemIdx(key)
        # print('Key: ', key, 'Add: ', bucketNumber, bucketItemIdx, self.storage[bucketNumber][bucketItemIdx])
        self.storage[bucketNumber][bucketItemIdx] = True

    def remove(self, key:int) -> None: 
        bucketNumber = self.findBucketNumber(key)
        if self.storage[bucketNumber] == 0: 
            return None
        bucketItemIdx = self.findBucketItemIdx(key)
        # print('Key: ', key, 'Remove: ', bucketNumber, bucketItemIdx, self.storage[bucketNumber][bucketItemIdx])
        self.storage[bucketNumber][bucketItemIdx] = False
            

    def contains(self, key:int) -> bool:
        bucketNumber = self.findBucketNumber(key)
        if self.storage[bucketNumber] == 0:
            return False
        bucketItemIdx = self.findBucketItemIdx(key)
        # print('Key: ', key, 'Contains: ', bucketNumber, bucketItemIdx, self.storage[bucketNumber][bucketItemIdx])
        return self.storage[bucketNumber][bucketItemIdx]
