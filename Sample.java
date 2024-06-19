// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

Hash-set

class MyHashSet:

    def __init__(self):
        self.set1=set()
        #self.counter=0
        

    def add(self, key: int) -> None:
        self.set1.add(key)
        #self.counter=self.counter+1
        

    def remove(self, key: int) -> None:
        if key in self.set1:
            self.set1.remove(key)
            #self.counter=self.counter-1

    def contains(self, key: int) -> bool:
        for i in self.set1:
            if i==key:
                return True
        return False


MIn-Stack

class MinStack:

    def __init__(self):
        self.list1=[]
        self.minlist=[]
        

    def push(self, val: int) -> None:
        self.list1.append(val)
        if len(self.minlist)==0:
            self.minlist.append(val)
        else:
            if val<self.minlist[-1]:
                self.minlist.append(val)
            else:
                self.minlist.append(self.minlist[-1])
        

    def pop(self) -> None:
        self.list1.pop()
        self.minlist.pop()
        

    def top(self) -> int:
        return self.list1[-1]
        

    def getMin(self) -> int:
        return self.minlist[-1]
        


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(val)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()

