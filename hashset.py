# Time Complexity : add - O(1), remove - O(1), contains - O(1)
# Space Complexity : Worst Case - O(n) (if the there is at least one element in every bucket of the PDS
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


# Your code here along with comments explaining your approach
# Implementing hashsets using double hashing technique

class MyHashSet:

    def __init__(self):
        self.table = [None]*1000

    def add(self, key: int) -> None:
        hashVal1 = key % 1000

        if self.table[hashVal1] == None:
            if hashVal1 == 0:
                self.table[hashVal1] = [False] * 1001
            else:
                self.table[hashVal1] = [False] * 1000
        hashVal2 = key // 1000
        self.table[hashVal1][hashVal2] = True

    def remove(self, key: int) -> None:
        hashVal1 = key % 1000
        if self.table[hashVal1] == None:
            return
        hashVal2 = key // 1000
        self.table[hashVal1][hashVal2] = False

    def contains(self, key: int) -> bool:
        hashVal1 = key % 1000
        if self.table[hashVal1] == None:
            return False
        hashVal2 = key // 1000
        if self.table[hashVal1][hashVal2] == True:
            return True
        return False
