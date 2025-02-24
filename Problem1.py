# Problem 1 : Design HashSet
# Time Complexity :
'''
For add and remove function- O(size)
For contains function- O(1)
'''
# Space Complexity : O(szie^2)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
class ListNode:
    def __init__(self, key):
        self.key = key
        self.next = None

class MyHashSet:

    def __init__(self):
        # variable to store the size of the second array
        self.size = 1000
        # matrix of booelan to store the value
        self.matrix = [[] for _ in range(1000)]
        # variable for hashmax when key is 1000000
        self.hashmax = False
    
    # Hash Function 1
    def hash1(self, key: int) -> int:
        return key % self.size
    
    # Hash Function 2
    def hash2(self, key: int) -> int:
        return key // self.size

    def add(self, key: int) -> None:
        # check if the key is less than 10000000
        if key < 1000000:
            # calculate both the hash function 
            index1 = self.hash1(key)
            index2 = self.hash2(key)
            # check if we have second array and if we don't have then we create the second array
            if not self.matrix[index1]:
                self.matrix[index1]= [False] * self.size
            # set the value True indicating the key is present in the hash set
            self.matrix[index1][index2] = True
        # if the key is 1000000 then set special variable as true
        else:
            self.hashmax = True


    def remove(self, key: int) -> None:
        # check if the key is less than 10000000
        if key < 1000000:
            # calculate both the hash function 
            index1 = self.hash1(key)
            index2 = self.hash2(key)
            #  # check first if there is matrix[index1] and matrix[index1][index2] and if it is present then set the value as false
            if self.matrix[index1] and self.matrix[index1][index2] == True:
                # set the value False indicating the key is present in the hash set
                self.matrix[index1][index2] = False
        # if the key is 1000000 then set special variable as false
        if key == 1000000:
            self.hashmax = False

    def contains(self, key: int) -> bool:
        # return the value hashmax if the key is 1000000
        if key == 1000000:
            if self.hashmax:
                return self.hashmax
            return False
        # calculate both the hash function 
        index1 = self.hash1(key)
        index2 = self.hash2(key)
        # check first if there is matrix[index1] and matrix[index1][index2]
        if self.matrix[index1] and self.matrix[index1][index2]:
            return self.matrix[index1][index2]
        return False

        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)