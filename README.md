Explain your approach in **three sentences only** at top of your code

# Design-1

## Problem 1:(https://leetcode.com/problems/design-hashset/)

class MyHashSet(object):

    def __init__(self):
        self.buckets = 1000
        self.bucketSize = 1001
        self.array = [None for i in range(self.buckets)]
        
    def add(self, key):
        i = self.hash1(key)  
        j = self.hash2(key)  
        if self.array[i] is None:
            self.array[i] = [False for i in range(self.bucketSize)]
        self.array[i][j] = True

    def remove(self, key):
        i = self.hash1(key)
        j = self.hash2(key)
        if self.array[i] is not None:
            self.array[i][j] = False

    def contains(self, key):
        i = self.hash1(key)
        j = self.hash2(key)
        return self.array[i] is not None and self.array[i][j] == True

    def hash1(self, key):  
        return key % self.buckets

    def hash2(self, key): 
        return key // self.bucketSize


# Your MyHashSet object will be instantiated and called as such:
# obj = MyHashSet()
# obj.add(key)
# obj.remove(key)
# param_3 = obj.contains(key)




## Problem 2:
Design MinStack (https://leetcode.com/problems/min-stack/)

class MinStack(object):

    def __init__(self):
        self.mainStack=[]
        self.helperStack=[]
        

    def push(self, val):
        """
        :type val: int
        :rtype: None
        """
        self.mainStack.append(val)
        if(len(self.helperStack)==0):
            self.helperStack.append(val)
        else:
            minVal = min(val,self.getMin())
            self.helperStack.append(minVal)

        

    def pop(self):
        """
        :rtype: None
        """
        if (len(self.mainStack)==0):
            return None
        self.mainStack.pop()
        self.helperStack.pop()
        

    def top(self):
        """
        :rtype: int
        """
        if(len(self.mainStack)==0):
            return None
        return self.mainStack[-1]
        

    def getMin(self):
        """
        :rtype: int
        """
        if(len(self.mainStack)==0):
            return None
        return self.helperStack[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()



