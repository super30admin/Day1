#I've used buckets approach to form a list of buckets and a modulus function to get the index.
#Stored index and if it's not there then only add, if it's there then only remove or do nothing.
#Time complexity is O(n) for all of the functions since we are parsing the array to search for the index.
#Space complexity is O(buckets+keys)

#This code succesfully ran in Leetcode
#Wonder how to resolve the collisions in the future when the key already exists and I have to add a value again

class MyHashSet:

    def __init__(self):
        self.size = 1000
        self.buckets = [[] for _ in range(self.size)]

    def hash(self, key:int) -> int:
        return key%self.size

    def add(self, key: int) -> None:
        index = self.hash(key)
        if key not in self.buckets[index]:
            self.buckets[index].append(key)

    def remove(self, key: int) -> None:
        index = self.hash(key)
        if key in self.buckets[index]:
            self.buckets[index].remove(key)

    def contains(self, key: int) -> bool:
        index = self.hash(key)
        return key in self.buckets[index]