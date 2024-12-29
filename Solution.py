######## Design a Hash Set ###########

# Time Complexity :  Add -> O(1), Remove -> O(1), Contains -> O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Initially forgot to handle edge case of 10^6 key value.


# Create buckets with size 1000 and sub buckets with size 1001
# Use key % 1000 as the first hash funtion to get the bucket ie column
# Use key / 1001 as the second hash funtion to get the sub bucket ie row

class Hashset:
    def __init__(self):
        self.columns= [None] * 1000
        
    def add(self, key):
        column_num = key % 1000
        if self.columns[column_num] == None:
            self.columns[column_num] = [False]*1001
        row_num = key // 1001
        self.columns[column_num][row_num] = True
        
    def remove(self, key):
        column_num = key % 1000
        if self.columns[column_num] == None:
            return 
        row_num = key // 1001
        self.columns[column_num][row_num]  = False
    
    def contains(self, key):
        column_num = key % 1000
        if self.columns[column_num] == None:
            return False
        row_num = key // 1001
        return self.columns[column_num][row_num]


######## Design a Min Stack Data Structure ###########

# Time Complexity :  Push -> O(1), Pop -> O(1), GetMin -> O(1), Top -> O(1)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Initially faced issue handling duplicate values


# Create a stack such that whenever we encounter a value less than our current min
# we will push the value as well as the current min to the stack and if we encounter
# a value greater than the current min then we simply just push the value
# While poping if the value is less than or equal to our current min we pop twice ie once
# to remove the value and the second time to remove the previous min value stored and update the min value as well.

class MinStack:

    def __init__(self):
        self.stack = []
        self.currMin = float('inf')
    
    def push(self, value):
        if value <= self.currMin:
            self.stack.append(self.currMin)
            self.currMin = value
        self.stack.append(value)
    
    def pop(self):
        if self.stack[-1]> self.currMin:
            return self.stack.pop()
        else:
            value = self.stack.pop()
            self.currMin = self.stack.pop()
            return value
    
    def getMin(self):
        return self.currMin
    
    def top(self):
        return self.stack[-1]
