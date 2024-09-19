// Time Complexity : O(1)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class MinStack(object):

    def __init__(self):
        self.stack = []
        self.min = int(sys.maxsize)
        

    def push(self, val): //T.C = O(1)
        """
        :type val: int
        :rtype: None
        """
        if(val <= self.min):
            self.stack.append(self.min)
            self.min = val
        self.stack.append(val)

    def pop(self):   //T.C = O(1)
        """
        :rtype: None
        """
        new_val = self.stack.pop()
        if(new_val == self.min):
            self.min = self.stack.pop()
        

    def top(self): //T.C = O(1)
        """
        :rtype: int
        """
        return self.stack[-1]
        

    def getMin(self): //T.C = O(1)
        """
        :rtype: int
        """
        return self.min

//2 HASHSET
class MyHashSet(object):

    def __init__(self):
        self.primaryBucket = 1000
        self.secondaryBucket = 1000
        self.storage = [None] * self.primaryBucket

    def getPrimaryHashCode(self,key):
        return key % self.primaryBucket
    
    def getSecondaryHashCode(self,key):
        return key // self.secondaryBucket

    def add(self, key): //T.C = O(1)
        """
        :type key: int
        :rtype: None
        """

        primaryIndex = self.getPrimaryHashCode(key)

        if(self.storage[primaryIndex] is None):
            if(primaryIndex == 0):
                self.storage[primaryIndex] = [False] * (self.secondaryBucket+1)
            else:
                self.storage[primaryIndex] = [False] * (self.secondaryBucket)
        secondaryIndex = self.getSecondaryHashCode(key)
        self.storage[primaryIndex][secondaryIndex] = True

        

    def remove(self, key): //T.C = O(1)
        """
        :type key: int
        :rtype: None
        """
        primaryIndex = self.getPrimaryHashCode(key)
        if(self.storage[primaryIndex] is None):
            return
        secondaryIndex = self.getSecondaryHashCode(key)
        self.storage[primaryIndex][secondaryIndex] = False

    def contains(self, key): //T.C = O(1)
        """
        :type key: int
        :rtype: bool
        """
        primaryIndex = self.getPrimaryHashCode(key)
        if(self.storage[primaryIndex] is None):
            return False
        secondaryIndex  = self.getSecondaryHashCode(key)
        return self.storage[primaryIndex][secondaryIndex] 


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)