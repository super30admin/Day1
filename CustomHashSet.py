# // Time Complexity : O(1) we are using the index and not looping
# // Space Complexity : 
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Not able to find the approach to dynamically assign the second/nested array.


# // Your code here along with comments explaining your approach
#Used double hashing technique but leet code description and solution uses the chaining option. Double hasing technique is O(1) then why leet code is using the log(N) approach.


import numpy as np

class MyHashSet:

    def __init__(self):
        self.primarysize = 1000  # Define a primary array size
        self.nestedsize = 1000  # Define a nested array size
        self.storagearray =np.full((1000,10001), None) 
    
    #Defining the fist hashing function mod
    def modulusPrimaryArray(self, key: int):
        return key%self.primarysize

    #Defining the second hashing function divide
    def divideNestedArray(self, key: int):
        return int(key/self.nestedsize)
        
    #It is O(1) since we are giving the index and not looping.
    def add(self, key: int) -> None:
        primary = self.modulusPrimaryArray(key)
        nested = int(self.divideNestedArray(key))
        
        self.storagearray[primary][nested] = True
        
        
    #It is O(1) since we are giving the index and not looping.
    def remove(self, key: int) -> None:
        primary = self.modulusPrimaryArray(key)
        nested = int(self.divideNestedArray(key))                
        self.storagearray[primary][nested] = None        
        return self.storagearray[primary][nested]
        
    #It is O(1) since we are giving the index and not looping.
    def contains(self, key: int) -> bool:
        primary = self.modulusPrimaryArray(key)
        nested = int(self.divideNestedArray(key))    
        
        return self.storagearray[primary][nested]
        


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)
