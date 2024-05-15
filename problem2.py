'''
Time complexity:
push: O(1)
pop: O(1)
top: O(1)
getMin: O(1)

Space complexity: O(n) where n in total number of pop operations

Did this code successfully run on Leetcode: Yes 
Any problem you faced while coding this : No

'''

class MinStack:

  # initialize a currentMin variable to infinity and a stack containing currentMin value
  def __init__(self):
    self.currentMin = float('inf')
    self.minStack = [ self.currentMin ]

  # if input value less than or equal to currentMin, push the currentMin to stack and set currentMin to the input value
  # then push the input value to stack
  def push(self, val: int) -> None:
    if val <= self.currentMin:
      self.minStack.append(self.currentMin)
      self.currentMin = val
    self.minStack.append(val)

  # pop from top of the stack
  # if the popped value is equal to currentMin, pop another value and update currentMin to the newly popped value
  def pop(self) -> None:
    poppedValue = self.minStack.pop()
    if poppedValue == self.currentMin:
      nextMin = self.minStack.pop()
      self.currentMin = nextMin

  # return the value at the top of the stack
  def top(self) -> int:
    return self.minStack[-1]

  # return the value stored in currentMin variable
  def getMin(self) -> int:
    return self.currentMin

# Your MinStack object will be instantiated and called as such:
obj = MinStack()
print('Push 7')
obj.push(7)

print('Push 3')
obj.push(3)

print('Push 4')
obj.push(4)

print('Push 5')
obj.push(5)

print('top():', obj.top())
print('getMin():', obj.getMin())

print('Push 4')
obj.push(4)

print('Push 8')
obj.push(8)

print('top():', obj.top())
print('getMin():', obj.getMin())

print('Push -4')
obj.push(-4)

print('Push -4')
obj.push(-4)

print('Push 0')
obj.push(0)

print('top():', obj.top())
print('getMin():', obj.getMin())

print('pop()')
obj.pop()

print('top():', obj.top())
print('getMin():', obj.getMin())

print('pop()')
obj.pop()

print('top():', obj.top())
print('getMin():', obj.getMin())

print('pop()')
obj.pop()

print('top():', obj.top())
print('getMin():', obj.getMin())

print('pop()')
obj.pop()

print('top():', obj.top())
print('getMin():', obj.getMin())
