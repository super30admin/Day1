"""
This program implements a hashset using double hashing technique in case of collision.
 It performs following 3 operations: add key, remove key and search key.
 Since the problem does not need the value of key, boolean can be used which helps to save space.
"""
class MyHashSet:

    def __init__(self):
        """
        Initialize the hash set with size of primary and secondary array and initialize a array bucket of length
        sqrt of max value of key.
        Takes O(1) time
        Space complexity: O(1000)
        """
        self.primaryBucketSize = 1000
        self.secondaryBucketSize = 1000
        self.arrayBucket = [[] for _ in range(self.primaryBucketSize)]

    def getPrimaryHashcode(self, key):
        """
        :param key: takes a key
        :return:  an integer or the hash code called primary hash code that is the index of the primary array
        in double hashing
        Takes O(1) time
        """
        return key % self.primaryBucketSize

    def getSecondaryHashcode(self, key):
        """
        :param key: takes a key
        :return: an integer or the hash code of key called secondary hash code that is the index of secondary array
        in double hashing
         Takes O(1) time
        """
        return key // self.secondaryBucketSize

    def add(self, key: int) -> None:
        """
        :param key: take a key to be added to hash set.
        (1) Generate the primary hash code
        (2) check if index hash code in primary array is initialized. If not  initialized, initialized it.
        Edge case: for key = pow(10, 6) the hash code is pow(10,6) %  primaryBucketSize = 0. then calculate
        secondary hash code pow(10,6) // primaryBucketSize = pow(10,3) and 1000th index is not present. Thus,
        when creating the bucket at 0th index make its size +1.
        (3) Once  initialized get the secondary hash code and update the value at
        [primary_hash_code][secondary_hash_code]  to True.
        :return: None
         Takes O(1) time
        """
        primary_hash_code = self.getPrimaryHashcode(key)
        if not self.arrayBucket[primary_hash_code]:
            if primary_hash_code == 0:
                self.arrayBucket[primary_hash_code] = [False for _ in range(self.secondaryBucketSize+1)]
            else:
                self.arrayBucket[primary_hash_code] = [False for _ in range(self.secondaryBucketSize)]

        secondary_hash_code = self.getSecondaryHashcode(key)
        self.arrayBucket[primary_hash_code][secondary_hash_code] = True

    def remove(self, key: int) -> None:
        """
        :param key: takes a key to be removed from the hash set.
        calculate the primary and secondary hash codes and check if key present. If key is present, update its value to
        false
        :return: None
         Takes O(1) time
        """
        primary_hash_code = self.getPrimaryHashcode(key)
        if self.arrayBucket[primary_hash_code]:
            secondary_hash_code = self.getSecondaryHashcode(key)
            if self.arrayBucket[primary_hash_code][secondary_hash_code]:
                self.arrayBucket[primary_hash_code][secondary_hash_code] = False

    def contains(self, key: int) -> bool:
        """
        :param key: takes a key to be searched into the hash set.
        Same as remove except the update part.
        :return: boolean, True if the key is present in the hash set else False
        Takes O(1) time
        """
        primary_hash_code = self.getPrimaryHashcode(key)
        if self.arrayBucket[primary_hash_code]:
            secondary_hash_code = self.getSecondaryHashcode(key)
            if self.arrayBucket[primary_hash_code][secondary_hash_code]:
                return True
            else:
                return False

        else:
            return False



# Your MyHashSet object will be instantiated and called as such:
obj = MyHashSet()
obj.add(2)
obj.remove(4)
param_3 = obj.contains(5)
print(param_3)
param_3 = obj.contains(2)
print(param_3)